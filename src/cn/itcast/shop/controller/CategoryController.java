package cn.itcast.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.shop.model.Category;
import cn.itcast.shop.model.PageModel;

@RequestMapping("/category")
@Controller
public class CategoryController extends BaseController {
	
	@RequestMapping("/insert")
	public String insert(Category category){
		categoryService.insert(category);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Object query(){
		return categoryService.query();
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public int update(Category category){
		return categoryService.update(category);
	}
	
	@RequestMapping("/queryForPage")
	@ResponseBody  // 添加相应的json包
	public Object queryForPage(PageModel pageModel){
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows",categoryService.queryForPage(pageModel));
		resultMap.put("total", categoryService.queryCount(pageModel.getKeyword()));
		// 由于显示层是easy ui 因此所有的数据都要返回 json格式
		return resultMap;
	}
	
	@RequestMapping("/deleteByIds")
	@ResponseBody  // 添加相应的json包, 接受js的数组,js要先转化为字符串形式,在提交
	public Object deleteByIds(String ids){
		return categoryService.deleteByIds(ids.split(","));
	}
}
