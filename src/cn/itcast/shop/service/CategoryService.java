package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	// 查询热点或者非热点类别
	public List<Integer> queryByHot(boolean isHot);
}
