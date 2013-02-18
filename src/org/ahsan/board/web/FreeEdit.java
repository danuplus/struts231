package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FreeEdit implements Action, Preparable, ModelDriven<Free>, SessionAware {
	private int page;
	private Free article;
	private Map<String, Object> session;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public Free getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Free();
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(session.containsKey("no") && ((Integer)session.get("no")).intValue() == article.getNo()) {
			session.remove("no");
			FreeDao dao = FreeDao.getInstance();
			dao.editArticle(article);
			
			return "success";
		} else {
			return "failure";
		}
	}
	
}
