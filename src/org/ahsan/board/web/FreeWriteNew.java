package org.ahsan.board.web;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FreeWriteNew implements Action, Preparable, ModelDriven<Free> {

	private Free article;

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
		FreeDao dao = FreeDao.getInstance();
		dao.addArticle(article);
		return "success";
	}
	
}
