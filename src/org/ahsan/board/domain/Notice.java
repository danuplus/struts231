package org.ahsan.board.domain;

import java.util.Date;

public class Notice {
	private int no;
	private String title;
	private String notice;
	private String writer;
	private String password;
	private Date wdate;
	private int ref;
	
	public Notice() {}
	public Notice(int no, String title, String notice, String writer,
			String password, Date wdate, int ref) {
		super();
		this.no = no;
		this.title = title;
		this.notice = notice;
		this.writer = writer;
		this.password = password;
		this.wdate = wdate;
		this.ref = ref;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", notice=");
		builder.append(notice);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", password=");
		builder.append(password);
		builder.append(", wdate=");
		builder.append(wdate);
		builder.append(", ref=");
		builder.append(ref);
		builder.append("]");
		return builder.toString();
	}
}
