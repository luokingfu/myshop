package cn.itcast.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.model.Sorder;
import cn.itcast.shop.model.User;
import cn.itcast.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
