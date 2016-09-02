package cn.itcast.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.CategoryDao;
import cn.itcast.shop.model.Category;
/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	
	public CategoryDaoImpl(){
		super();
	}

	@Override
	public List<Integer> queryByHot(boolean isHot) {
		return getSession().selectList(Category.class.getName() + ".queryByHot", isHot);
	}
}
