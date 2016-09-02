package cn.itcast.shop.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Account;
import cn.itcast.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService,UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		return accountDao.loadUserByUsername(login);
	}
}
