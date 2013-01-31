package org.ahsan.board.web;

import org.ahsan.board.dao.NoticeDao;
import org.ahsan.board.domain.Notice;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class NoticeWrite implements Action, Preparable, ModelDriven<Notice> {

	private Notice article;

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
		NoticeDao dao = NoticeDao.getInstance();
		dao.addArticle(article);
		
		return "success";
	}
}
