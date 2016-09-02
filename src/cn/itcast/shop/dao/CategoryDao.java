package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.model.Category;
/*
 *  此接口只需要定义自身的业务逻辑方法
 * */
public interface CategoryDao extends BaseDao<Category> {

//	public void insert(Category category);
	// 查询热点或者非热点类别
	public List<Integer> queryByHot(boolean isHot);
}
