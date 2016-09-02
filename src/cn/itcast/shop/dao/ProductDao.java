package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.model.Product;
/*
 *  此接口只需要定义自身的业务逻辑方法
 * */
public interface ProductDao extends BaseDao<Product> {


	public List<Product> queryByCid(int cid);
}
