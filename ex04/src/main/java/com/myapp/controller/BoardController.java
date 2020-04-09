package com.myapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.domain.BoardVO;
import com.myapp.domain.Criteria;
import com.myapp.domain.PageDTO;
import com.myapp.domain.Weather;
import com.myapp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public void getRegister() {

	}

	@PostMapping("/register")
	public String register(BoardVO board) {
		service.register(board);
		return "redirect:/board/list";
	}

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<BoardVO> list = service.getList(cri);
		model.addAttribute("list", list);

		int total = service.getTotal(cri);
		int rowNo = total - ((cri.getPageNum() - 1) * cri.getAmount());

		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("rowNo", rowNo);
	}

	@GetMapping("/get")
	public void get(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.get(bno);
		service.viewcnt(bno);
		model.addAttribute("board", board);
	}

	@GetMapping("/modify")
	public void modify(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
	}

	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		service.modify(board);

		return "redirect:/board/list" + cri.getListLink();
	}

	@PreAuthorize("principal.username == #writer")
	@PostMapping("/delete")
	public String modify(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr,
			String writer) {
		service.delete(bno);

		return "redirect:/board/list" + cri.getListLink();
	}

	@GetMapping("/weather")
	public void weather(Model model) throws IOException, ParseException {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		List<Weather> list = new ArrayList<Weather>();
		String[] nxArr = { "60", "98", "89", "55", "58", "67", "102", "73", "92", "69", "63", "95" };
		String[] nyArr = { "127", "76", "90", "124", "74", "100", "84", "134", "131", "106", "89", "77" };
		String[] areaArr = { "서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "대전광역시", "울산광역시", "강원도 춘천시", "강원도 강릉시" , "충청북도 청주시", "전라북도 전주시", "경상남도 김해시" };
		for (int i = 0; i < nxArr.length; i++) {
			// 주소 시작
			String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?";
			// 키
			String serviceKey = "Yn8%2FPR5eWWfGMC0X0rU4VC%2FtWulCckYAHJAS35gKt509OwFvunCBy%2B6VA7KuB71YvbzdoH4CXRcgHElYH2DySg%3D%3D";

			int baseDate = Integer.parseInt(dateFormat.format(date)) - 1; // 날짜

			String baseTime = "2300"; // 시간
			String type = "JSON"; // 데이터타입
			String numOfRows = "153"; // 데이터의 양

			StringBuilder apiBuilder = new StringBuilder(apiUrl);
			apiBuilder.append("serviceKey=" + serviceKey);
			apiBuilder.append("&numOfRows=" + numOfRows);
			apiBuilder.append("&dataType=" + type);
			apiBuilder.append("&base_date=" + baseDate);
			apiBuilder.append("&base_time=" + baseTime);
			apiBuilder.append("&nx=" + nxArr[i]);
			apiBuilder.append("&ny=" + nyArr[i]);
//		System.out.println(apiBuilder.toString());

			URL url = new URL(apiBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			String result = sb.toString();
//		System.out.println(result);

			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);
			JSONObject parse_response = (JSONObject) obj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");
			JSONObject parse_items = (JSONObject) parse_body.get("items");

			JSONArray parse_item = (JSONArray) parse_items.get("item");
			String category;
			JSONObject weather;
			String day = "";
			String time = "";
			Double tmn = null;
			Double tmx = null;
			String pop = "";
			String reh = "";
			for (int j = 0; j < parse_item.size(); j++) {
				weather = (JSONObject) parse_item.get(j);
				Object fcstValue = weather.get("fcstValue");
				Object fcstDate = weather.get("fcstDate");
				Object fcstTime = weather.get("fcstTime");
				category = (String) weather.get("category");
				// 출력
				if (!day.equals(fcstDate.toString())) {
					day = fcstDate.toString();
				}
				if (!time.equals(fcstTime.toString())) {
					time = fcstTime.toString();
//				System.out.println(day + "  " + time);
				}
//			System.out.print("\tcategory : " + category);
//			System.out.print(", fcst_Value : " + fcstValue);
//			System.out.print(", fcstDate : " + fcstDate);
//			System.out.println(", fcstTime : " + fcstTime);
				if (Integer.parseInt(fcstDate.toString()) == baseDate + 1) {
					if (category.toString().equals("TMN")) {
						tmn = Double.parseDouble(fcstValue.toString());
//					System.out.println("TMN SET");
					}
					if (category.toString().equals("TMX")) {
						tmx = Double.parseDouble(fcstValue.toString());
//					System.out.println("TMX SET");
					}
					if (fcstTime.toString().equals("0600")) {
						if (category.equals("POP")) {
							pop = fcstValue.toString();
//						System.out.println("POP SET");
						}
						if (category.toString().equals("REH")) {
							reh = fcstValue.toString();
//						System.out.println("REH SET");
						}
					}
				}
			}
			Weather wt = new Weather(areaArr[i], Integer.toString(baseDate + 1), pop, reh, tmn, tmx);
//		System.out.println("--------------");
//		System.out.println(wt.getArea());
//		System.out.println(wt.getDate());
//		System.out.println(wt.getPop());
//		System.out.println(wt.getReh());
//		System.out.println(wt.getTmn());
//		System.out.println(wt.getTmx());
			list.add(wt);
		}
		model.addAttribute("weather", list);
	}

}
