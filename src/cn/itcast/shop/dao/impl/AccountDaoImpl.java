package cn.itcast.shop.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.AccountDao;
import cn.itcast.shop.model.Account;

/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	@Override
	public Account loadUserByUsername(String login) {
		return getSession().selectOne(
				Account.class.getName() + ".loadUserByUsername", login);
	}

}
