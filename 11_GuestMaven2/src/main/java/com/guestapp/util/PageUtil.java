package com.guestapp.util;

public class PageUtil {
	private int startpage, endpage, currentPage, totpage, pageblock;
	private String field, word;

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotpage() {
		return totpage;
	}

	public void setTotpage(int totpage) {
		this.totpage = totpage;
	}

	public int getPageblock() {
		return pageblock;
	}

	public void setPageblock(int pageblock) {
		this.pageblock = pageblock;
	}

	public String getField() {
		return field == null ? "" : field.trim();
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getWord() {
		return word == null ? "" : word.trim();
	}

	public void setWord(String word) {
		this.word = word;
	}

}
