package org.ahsan.board.domain;

import java.util.Date;

public class Freply {
	private int no;
	private String writer;
	private String password;
	private String memo;
	private Date wdate;
	private int ref_no;
	
	public Freply() {}
	public Freply(int no, String writer, String password, String memo,
			Date wdate, int ref_no) {
		super();
		this.no = no;
		this.writer = writer;
		this.password = password;
		this.memo = memo;
		this.wdate = wdate;
		this.ref_no = ref_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getRef_no() {
		return ref_no;
	}
	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}
	
}
