package cn.itcast.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/account")
@Controller
public class AccountController extends BaseController {
	
	@RequestMapping("/query")
	@ResponseBody
	public Object query(){
		return accountService.query();
	}
}
