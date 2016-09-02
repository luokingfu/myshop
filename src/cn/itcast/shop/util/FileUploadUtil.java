package cn.itcast.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/*
 * 实现文件上传的工具类
 * */
@Component("fileUpload")
public class FileUploadUtil {
	
	private String basePath;
	
	@Value("#{public.basePath}")  //注入字符串值
	public void setBasePath(String basePath) {
		System.out.println("basePath:" + basePath);
		this.basePath = basePath;
	}
	
	// 获取文件的扩展名
	private String getExtName(MultipartFile file){
		return FilenameUtils.getExtension(file.getOriginalFilename());
	}
	
	// 根据UUID生成新的文件名
	private String createNewName(MultipartFile file){
		return UUID.randomUUID().toString() + "." + getExtName(file);
	}
	
	// 实现文件上传的功能,并且返回新文件名
	public String uploadFile(MultipartFile file){
		String newName = this.createNewName(file);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(basePath,newName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return newName;
	}
	
	public String[] findBankName(String folderPath){
		return new File(folderPath).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".gif");
			}
		});
	}
	
	public static void main(String[] args) {
		File file=new File("C:/bank");
		String[] list = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
//				System.out.println("当前目录为:" +dir);
//				System.out.println("当前文件名为:" + name);
				return name.endsWith(".gif");
			}
		});
		System.out.println("----输出如下------");
		for(String temp:list){
			System.out.println(temp);
		}
	}
}
