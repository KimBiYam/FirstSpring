package com.myboard.util;

import org.springframework.stereotype.Component;

@Component
public class PageUtil {

	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		String src = "javascript:getData(";
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		StringBuilder sb = new StringBuilder();
		sb.append("<ul class='pagination' style='justify-content: center;'>");
		// 이전
		if (startPage > pageBlock) {
			sb.append("<li class='page-item'> <a class='page-link' href=");
			sb.append(src);
			sb.append((startPage - pageBlock));
			sb.append(",'" + field + "'");
			sb.append(",'" + word + "')");
			sb.append(">이전</a></li>");
		}
		// 페이지 출력
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				sb.append("<li class='page-item'>");
				sb.append("<a class='page-link disabled'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'> <a class='page-link' href=");
				sb.append(src);
				sb.append(i);
				sb.append(",'" + field + "'");
				sb.append(",'" + word + "')");
				sb.append(">" + i + "</a></li>");
			}

		}
		// 다음
		if (endPage < pageCount) {
			sb.append("<li class='page-item'> <a class='page-link' href=");
			sb.append(src);
			sb.append((startPage + pageBlock));
			sb.append(",'" + field + "'");
			sb.append(",'" + word + "')");
			sb.append(">다음</a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}

}
