package cn.itcast.shop.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.itcast.shop.model.Forder;

public class ForderSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("-----------第一次访问项目的时候执行,且执行一次------------");
		event.getSession().setAttribute("forder", new Forder());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
//		event.getSession().invalidate();
	}

}
