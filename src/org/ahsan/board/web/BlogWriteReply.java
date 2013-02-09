package org.ahsan.board.web;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Breply;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BlogWriteReply implements Action, ModelDriven<Breply>, Preparable {

	private int parent_no;
	private int page;
	private Breply reply;
	
	public int getParent_no() {
		return parent_no;
	}
	public void setParent_no(int parent_no) {
		this.parent_no = parent_no;
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
		reply = new Breply();
	}
	@Override
	public Breply getModel() {
		// TODO Auto-generated method stub
		return reply;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BlogDao dao = BlogDao.getInstance();
		dao.addReply(parent_no, reply);
		return "success";
	}
	
}
