package org.ahsan.board.web;

import org.ahsan.board.dao.InquireDao;
import org.ahsan.board.domain.Inquire;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InquireWrite implements Action, Preparable, ModelDriven<Inquire> {
	private Inquire article;

	@Override
	public Inquire getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Inquire();
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		InquireDao dao = InquireDao.getInstance();
		
		// 원글 등록
		article.setGroup_no(0);
		article.setSequence_in_group(0);
		article.setIndent_in_group(0);
		article.setRef_no(0);
		
		dao.addArticle(article);
		return "success";
	}
}
