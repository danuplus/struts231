package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Blog;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class BlogCheckPassword implements Action, SessionAware {
	private int no;
	private int page;
	private String job;
	private int rno;
	private String password;
	private Map<String, Object> session;
	private Blog article;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Blog getArticle() {
		return article;
	}
	public void setArticle(Blog article) {
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
		BlogDao dao = BlogDao.getInstance();
		if(job.equals("edit") && dao.checkArticlePassword(no, password)) {
			session.put("no", no);
			article = dao.getArticleByNo(no);
			return "edit";
			
		} else if(job.equals("remove") && dao.checkArticlePassword(no, password)) {
			dao.removeArticle(no);
			return "remove_article";
			
		} else if(job.equals("repl") && dao.checkReplPassword(rno, password)) {
			dao.remveReply(no, rno);
			return "remove_repl";
			
		} else {
			return "fail";
		}
	}
	
}
