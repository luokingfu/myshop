package cn.itcast.shop.dao;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;

public interface UrlDao {

	// 通过URL获取相应的权限和角色集合
	public Collection<ConfigAttribute> getRoleSet(String url);
	
	// 获取所有的 URL与角色集合的映射关系
	public void getUrlJoinRoleSet();
}
