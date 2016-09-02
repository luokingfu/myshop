package cn.itcast.shop.dao;

import java.util.List;

import cn.itcast.shop.model.Sorder;
/*
 *  此接口只需要定义自身的业务逻辑方法
 * */
public interface SorderDao extends BaseDao<Sorder> {

	public List<Sorder> sole(int number,String start,String end);
}
