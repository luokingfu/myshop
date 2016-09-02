package cn.itcast.shop.dao;

import cn.itcast.shop.model.Account;

/*
 *  此接口只需要定义自身的业务逻辑方法
 * */
public interface AccountDao extends BaseDao<Account> {

	public Account loadUserByUsername(String login);
}
