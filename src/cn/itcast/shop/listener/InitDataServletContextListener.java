package cn.itcast.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.shop.util.FileUploadUtil;
import cn.itcast.shop.util.ProductTimerTask;
/*
 * 此监听器在项目启动的时候用来加载初始化数据
 * */
public class InitDataServletContextListener implements ServletContextListener {
	
	private ApplicationContext context;
//	private CategoryService categoryService;
//	private ProductService productService;
	private ProductTimerTask productTimerTask;
	private FileUploadUtil fileUpload;

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		// 获取文件操作的工具类
		fileUpload=(FileUploadUtil)context.getBean("fileUpload");
		// 获取线程任务
		productTimerTask=(ProductTimerTask)context.getBean("productTimerTask");
		// 把ServletContext交给  productTimerTask
		productTimerTask.setApplication(event.getServletContext());
		// 设置定时器,时间任务
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		String path=event.getServletContext().getRealPath("/") + "images/bank";
		System.out.println("path:" + path);
		// 启动的时候加载银行的图标
		event.getServletContext().setAttribute("bankNames", fileUpload.findBankName(path));
	}

}
