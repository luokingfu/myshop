package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	// 把购物项添加都购物车中,并且判断重复
	public Forder addSorder(Forder forder,Sorder sorder);
	// 更新购物项的数量,返回新的购物车
	public Forder alterSorder(Forder forder,Sorder sorder);
	// 吧product转化为sorder
	public Sorder productToSorder(Sorder sorder,Product product);
	
	public List<Sorder> sole(int number,String start,String end);
}
