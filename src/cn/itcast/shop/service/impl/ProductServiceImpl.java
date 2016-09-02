package cn.itcast.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Product;
import cn.itcast.shop.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryByCid(int cid) {
		return productDao.queryByCid(cid);
	}

}
