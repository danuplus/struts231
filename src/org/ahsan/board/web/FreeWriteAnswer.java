package org.ahsan.board.web;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FreeWriteAnswer implements Action, ModelDriven<Free>, Preparable {
	private int pno;
	private int page;
	private Free article;
	
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Free();
	}
	@Override
	public Free getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FreeDao dao = FreeDao.getInstance();
		dao.addChildArticle(pno, article);
		
		return "success";
	}
	
}
