package cn.itcast.shop.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.ForderDao;
import cn.itcast.shop.model.Forder;
/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao {
	
}
