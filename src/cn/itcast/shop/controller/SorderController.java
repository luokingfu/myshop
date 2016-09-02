package cn.itcast.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.shop.dao.SorderDao;
import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.model.Sorder;

@RequestMapping("/sorder")
@Controller
public class SorderController extends BaseController {
	
	// 依赖HttpSession
	@Resource
	private HttpSession session;
	
	@RequestMapping("/add")  // 把购物项添加到Session中购物车中,此操作是业务逻辑操作,不需要访问数据库
	public String add(Sorder sorder){ // 传入的是商品的ID
		if(session.getAttribute("forder")==null){
			session.setAttribute("forder", new Forder());
		}
		System.out.println(sorder.getNumber() + "," + sorder.getProduct().getId());
		Product product = productService.get(sorder.getProduct().getId());
		Forder forder=(Forder)session.getAttribute("forder");
		sorder=sorderService.productToSorder(sorder,product);
		// 把购物项添加都购物车中,并且判断重复,返回新的购物车
		forder=sorderService.addSorder(forder, sorder);
		// 计算新的购物总价格,并且返回
		forder.setTotal(forderService.cluTotal(forder));
		// 吧新的购物车存储到session中
		session.setAttribute("forder", forder);
		// 跳转到购物车显示页面
		return "redirect:/shopCart.jsp";
	}
	
	@RequestMapping("/alter")
	@ResponseBody  // 返回具体的内容,而不是页面. 如果return 是一个对象,则自动转化为JSON格式 ,如果返回的是字符串,则流格式
	public String alter(Sorder sorder) throws Exception{
//		Integer.parseInt("xxxx");
		Forder forder=sorderService.alterSorder((Forder)session.getAttribute("forder"), sorder);
		forder.setTotal(forderService.cluTotal(forder));
//		Thread.sleep(3000);
		System.out.println("=========");
		return forder.getTotal().toString();
	}
	
	@RequestMapping("/sole")
	@ResponseBody  
	public Object sole(int number,String start,String end) throws Exception{
		System.out.println(number + "," + start + "," + end);
		return sorderService.sole(number,start,end);
	}
}
