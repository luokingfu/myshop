package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.model.PageModel;


/*
 * 此接口: 定义公共的方法
 * */
public interface BaseDao<T> {
	
	public void insert(T model);
	
	public T get(int id);
	
	public int deleteByIds(String[] ids);
	
	public int update(T model);
	// 分页查询
	public List<T> queryForPage(PageModel pageModel);
	// 查询所有的数据
	public List<T> query();
	// 查询总记录数
	public int queryCount(String keyword);
}
