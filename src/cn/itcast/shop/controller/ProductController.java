package cn.itcast.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.shop.model.PageModel;
import cn.itcast.shop.model.Product;

@RequestMapping("/product")
@Controller
public class ProductController extends BaseController {

	@RequestMapping("/queryForPage")
	@ResponseBody  // 添加相应的json包
	public Object queryForPage(PageModel pageModel){
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows",productService.queryForPage(pageModel));
		resultMap.put("total", productService.queryCount(pageModel.getKeyword()));
		// 由于显示层是easy ui 因此所有的数据都要返回 json格式
		return resultMap;
	}
	
	@RequestMapping("/insert")
	@ResponseBody  //添加相应的json包
	public int insert(Product product,MultipartFile file){
		// 实现文件上传操作
		product.setPic(fileUpload.uploadFile(file));
		productService.insert(product);
		return 1;
	}
	
	@RequestMapping("/get")
	public String get(int id,Map<String, Object> modelMap){
		modelMap.put("product", productService.get(id));
		return "forward:/detail.jsp";
	}
}
