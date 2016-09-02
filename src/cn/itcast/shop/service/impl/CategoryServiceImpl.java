package cn.itcast.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Category;
import cn.itcast.shop.service.CategoryService;
//16:27:ac:a5:76:28:2d:36:63:1b:56:4d:eb:df:a6:48d
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	public CategoryServiceImpl(){
		super();
	}

	@Override
	public List<Integer> queryByHot(boolean isHot) {
		return categoryDao.queryByHot(isHot);
	}
}
