package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.InquireDao;
import org.ahsan.board.domain.Inquire;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class InquireCheckPassword implements Action, SessionAware {
	private int no;
	private int page;
	private String job;
	private String password;
	private Inquire article;
	private Map<String, Object> session;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Inquire getArticle() {
		return article;
	}
	public void setArticle(Inquire article) {
		this.article = article;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		InquireDao dao = InquireDao.getInstance();
		
		if(job.equals("edit") && dao.checkPassword(no, password)) {
			article = dao.getArticleByNo(no);
			session.put("no", no);
			return "edit";
		} else if(job.equals("remove") && dao.checkPassword(no, password)) {
			dao.removeArticle(no);
			return "remove";
		} else {
			return "fail";
		}
	}
	
}
