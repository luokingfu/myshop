package cn.itcast.shop.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.itcast.shop.model.Account;
/*
 * 此监听器用来监听session中属性的变化,当session中任意一个属性出现了"新增,删除,替换" 则会执行相应的方法
 * */
public class SecurityContextListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 判断操作的属性名称是否为: SPRING_SECURITY_CONTEXT
		if(event.getName().equals("SPRING_SECURITY_CONTEXT")){			
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication authentication = context.getAuthentication();
			Account account = (Account)authentication.getPrincipal();
			event.getSession().setAttribute("account", account);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// event.getSession().removeAttribute("user");  session在退出的时候已经销毁
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		if(event.getName().equals("SPRING_SECURITY_CONTEXT")){
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication authentication = context.getAuthentication();
			Account account = (Account)authentication.getPrincipal();
			event.getSession().setAttribute("account", account);
		}
	}

}
