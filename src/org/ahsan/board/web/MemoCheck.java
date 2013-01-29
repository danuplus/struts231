package org.ahsan.board.web;

public class MemoCheck {
	private int no;
	private int page;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public String execute() throws Exception {
		return "success";
	}
}
