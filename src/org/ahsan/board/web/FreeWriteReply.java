package org.ahsan.board.web;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Freply;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FreeWriteReply implements Action, ModelDriven<Freply>, Preparable {
	private int pno;
	private int page;
	private Freply reply;
	public int getPno() {
		return pno;
	}
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
		reply = new Freply();
	}
	@Override
	public Freply getModel() {
		// TODO Auto-generated method stub
		return reply;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FreeDao dao = FreeDao.getInstance();
		dao.addReply(pno, reply);
		return "success";
	}
	
}
