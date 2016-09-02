package cn.itcast.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import cn.itcast.shop.model.Product;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ProductService;
/*
 * 实现首页数据的加载操作
 * */
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask {
	
	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;

	private ServletContext application;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("-----run------");
		// 声明大集合,List 此集合用来存储 商品集合
		List<List<Product>> bigList=new ArrayList<List<Product>>();
		// 1: 查询热点类别,获取热点类别的ID
		for(int cid:categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(cid));
		}
		// 3：存储到application内置对象中
		application.setAttribute("bigList", bigList);
	}
	
	public static void main(String[] args) {
		new Timer(false).schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("-------");
			}
		},0,2000);
	}

}
