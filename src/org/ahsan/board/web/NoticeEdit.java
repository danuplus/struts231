package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.NoticeDao;
import org.ahsan.board.domain.Notice;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class NoticeEdit implements Action, Preparable, ModelDriven<Notice>, SessionAware {

	private Map<String, Object> session;
	private Notice article;
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Notice();
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(session.containsKey("no")) {
			if(article.getNo() == ((Integer)session.get("no")).intValue()) {
				NoticeDao dao = NoticeDao.getInstance();
				dao.editArticle(article);
				session.remove("no");
				return "success";
			} else {
				return "fail";
			}
		} else {
			return "fail";
		}
	}
	
}
