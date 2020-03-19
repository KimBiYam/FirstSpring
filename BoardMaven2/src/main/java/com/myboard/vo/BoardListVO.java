package com.myboard.vo;

import java.util.List;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<MyBoardVO> getList() {
		return list;
	}

	public void setList(List<MyBoardVO> list) {
		this.list = list;
	}

	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

}
