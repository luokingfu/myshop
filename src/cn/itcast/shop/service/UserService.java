package cn.itcast.shop.service;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.model.Sorder;
import cn.itcast.shop.model.User;

public interface UserService extends BaseService<User> {
	// 实现用户登陆的判断功能
	public User login(User user);
}
