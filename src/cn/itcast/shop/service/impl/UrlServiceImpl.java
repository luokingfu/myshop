package cn.itcast.shop.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.itcast.shop.model.PageModel;
import cn.itcast.shop.model.Url;
import cn.itcast.shop.service.UrlService;

public class UrlServiceImpl extends BaseServiceImpl<Url> implements UrlService,
		FilterInvocationSecurityMetadataSource {

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
