package cn.itcast.shop.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.UserDao;
import cn.itcast.shop.model.User;
/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(User user) {
		return getSession().selectOne(user.getClass().getName() + ".login", user);
	}
	
}
