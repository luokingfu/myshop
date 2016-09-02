package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	// 更新热点类别ID查询推荐商品
	public List<Product> queryByCid(int cid);
}
