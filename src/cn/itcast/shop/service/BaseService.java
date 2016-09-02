package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.model.PageModel;

public interface BaseService<T> {

	public void insert(T model);

	public T get(int id);
	
	public int update(T model);
	
	public int deleteByIds(String[] ids);
	// 分页查询
	public List<T> queryForPage(PageModel pageModel);

	// 查询总记录数
	public int queryCount(String keyword);
	
	// 查询所有记录
	public List<T> query();
}
