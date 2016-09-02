package cn.itcast.shop.model;

import java.io.Serializable;

public class PageModel implements Serializable {

	private static final long serialVersionUID = 61617338103134520L;

	private int page;
	
	private int rows;
	
	private String keyword;
	
	public PageModel() {
		super();
	}
	public PageModel(String keyword,int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}
