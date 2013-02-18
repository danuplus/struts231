package org.ahsan.board.web;

import com.opensymphony.xwork2.Action;

public class FreeCheck implements Action {
	private int no;
	private int page;
	private String job;
	private int rno;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
}
