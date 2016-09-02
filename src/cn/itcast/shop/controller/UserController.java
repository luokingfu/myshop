package cn.itcast.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.shop.model.User;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {
	
	@Resource
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(User user){
		user = userService.login(user);
		// 自己实现登陆功能
		if(user!=null){
			session.setAttribute("user", user);
			// 登陆成功,根据session中是否有goURL来决定跳转的地址
			String goURL = (String)session.getAttribute("goURL");
			if(goURL!=null){
				return "redirect:" + goURL;
			}else{
				return "redirect:/index.jsp";
			}
		}else{
			// 继续登陆
			return "redirect:/login.jsp";
		}
	}
}
