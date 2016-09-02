package cn.itcast.shop.dao;

import cn.itcast.shop.model.User;
/*
 *  此接口只需要定义自身的业务逻辑方法
 * */
public interface UserDao extends BaseDao<User> {

	public User login(User user);
}
