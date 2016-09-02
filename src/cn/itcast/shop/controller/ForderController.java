package cn.itcast.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.User;

@RequestMapping("/forder")
@Controller
public class ForderController extends BaseController {
	
	// 依赖HttpSession
	@Resource
	private HttpSession session;
	
	@RequestMapping("/insert")  // 把购物项添加到Session中购物车中,此操作是业务逻辑操作,不需要访问数据库
	public String insert(Forder forder){
		// 获取session中的forder, user
		Forder oldForder=(Forder)session.getAttribute("forder");
		forder.setUser((User)session.getAttribute("user"));
		forder.setSorderList(oldForder.getSorderList());
		forder.setTotal(oldForder.getTotal());
		forderService.insert(forder);  // 此时forder中存储了所有的购物信息
		// 数据由临时状态转化持久状态,因此session中的购物车需要删除
		session.removeAttribute("forder");
		// 后面的页面需要显示订单的相关信息. 可以把完整的信息在存储到session中
		session.setAttribute("oldForder",forder);
		return "redirect:/users/bank.jsp";
	}

}
