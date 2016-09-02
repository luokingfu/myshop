package cn.itcast.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.ProductDao;
import cn.itcast.shop.model.Product;
/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
	
	public ProductDaoImpl(){
		super();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		return getSession().selectList(Product.class.getName() + ".queryByCid", cid);
	}
}
