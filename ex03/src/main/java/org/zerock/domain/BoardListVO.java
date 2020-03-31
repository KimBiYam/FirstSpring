package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardListVO {
	
	private List<BoardVO> list;
	private String pageHtml;
	private int rowNo;

}
