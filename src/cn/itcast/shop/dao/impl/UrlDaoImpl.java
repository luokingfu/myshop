package cn.itcast.shop.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.UrlDao;
import cn.itcast.shop.model.Url;

@Repository("urlDao")
public class UrlDaoImpl extends BaseDaoImpl<Url> implements UrlDao {
	
	private Map<String,Collection<ConfigAttribute>> urlJoinRoleMap=new HashMap<String,Collection<ConfigAttribute>>();

	@Override
	public Collection<ConfigAttribute> getRoleSet(String url) {
		// TODO Auto-generated method stub
		return urlJoinRoleMap.get(url);
	}

	@Override  // 获取所有的URL和相应的 Role集合
	@PostConstruct
	public void getUrlJoinRoleSet() {
		List<Url> urlList = getSession().selectList(Url.class.getName() + ".getUrlJoinRoleSet");
		for(Url url:urlList){
			urlJoinRoleMap.put(url.getAddress(), url.getPermission().getRoleSet());
		}
		System.out.println(urlJoinRoleMap);
	}

}
