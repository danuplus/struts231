package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.NoticeDao;
import org.ahsan.board.domain.Notice;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class NoticeCheckPassword implements Action, SessionAware {
	private int no;
	private int page;
	private String job;
	private String password;
	private Notice article;
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
	public Notice getArticle() {
		return article;
	}
	public void setArticle(Notice article) {
		this.article = article;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		NoticeDao dao = NoticeDao.getInstance();
		
		if(dao.checkPassword(no, password) && job.equals("remove")) {
			dao.removeArticle(no);
			return "remove";
		} else if(dao.checkPassword(no, password) && job.equals("edit")) {
			session.put("no", no);
			article = dao.getArticleByNo(no);
			return "edit";
		} else{
			return "fail";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
