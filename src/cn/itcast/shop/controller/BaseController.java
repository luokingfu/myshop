package cn.itcast.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.shop.service.AccountService;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ForderService;
import cn.itcast.shop.service.PayService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.service.SorderService;
import cn.itcast.shop.service.UserService;
import cn.itcast.shop.util.FileUploadUtil;
import cn.itcast.shop.util.SendEmail;
import cn.itcast.shop.util.SendMessage;



@RequestMapping("/base")
@Controller
public class BaseController {
	
	private String keyword;
	 
	@Resource   // 所有的Service都是单例模式
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected FileUploadUtil fileUpload;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected UserService userService;
	@Resource
	protected PayService payService;
	@Resource
	protected SendMessage sendMessage;
	@Resource
	protected SendEmail sendEmail;
	
	@RequestMapping("/goURL")
	public String goURL(String folder,String file){
		return "forward:/WEB-INF/" + folder + "/" + file + ".jsp";
	}
	
	/*
	 *  所谓线程安全,就是在并发访问的时候, 出现了数据不安全问题, 在单例的Bean 才要考虑线程安全的问题
	 * */
	
	@RequestMapping("/write")
	public String write(@RequestParam(value="demo") String temp){
		System.out.println("temp:" + temp);
		keyword=temp;
		System.out.println("keyword:" + keyword);
		return "forward:/temp.jsp";
	}
	
	@RequestMapping("/read")
	public String read(){
		System.out.println("keyword:" + keyword);
		return "forward:/temp.jsp";
	}
	
	
}
