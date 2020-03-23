package com.myboard.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoardListVO {
	private int count;
	private List<MyBoardVO> list;
	private String pageHtml;
	private int rowNo;

	public BoardListVO(int count, List<MyBoardVO> list, String pageHtml, int rowNo) {
		this.count = count;
		this.list = list;
		this.pageHtml = pageHtml;
		this.rowNo = rowNo;
	}

}
