package cn.itcast.shop.dao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 过滤器,监听器,拦截器(Struts) 都是系统启动的时候实例化,关闭的的时候销毁,其中过滤器与拦截器的工作流程相同, 监听器的启动优先级别比过滤器要高
 * */
public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 判断当前session中是否有用户信息
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getSession().getAttribute("user") == null) {
			// 存储当前客户要去的地址
			String goURL = req.getServletPath();
			String param = req.getQueryString();
			if (param != null) {
				goURL = goURL + "?" + param;
			}
			req.getSession().setAttribute("goURL", goURL);
			// System.out.println("path:" + req.getRequestURL());
			// System.out.println("path:" + req.getRequestURI());
			// System.out.println("请求的参数:" + req.getQueryString());
			// 非法访问,跳转到登陆页面
			req.getSession().setAttribute("error", "请先登陆");
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			// 跳转下个过滤器,如果没有则跳转到目标页面
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("-----UserFilter init()-------");
	}

}
