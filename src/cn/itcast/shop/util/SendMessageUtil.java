package cn.itcast.shop.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

@Component("sendMessage")
public class SendMessageUtil implements SendMessage {
	
	@Override
	public void sendMessage(String order,String phone){
		// 根据 httpclient发送短息信息
		// 打开的浏览器
		HttpClient httpClient=new HttpClient();
		// 创建Post请求
		PostMethod post=new PostMethod("http://utf8.sms.webchinese.cn/");
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		// 设置发送请求的参数
		post.setParameter("Uid", "java_0604");
		post.setParameter("Key", "3783e4c41df1671e837b");
		post.setParameter("smsMob", phone);
		post.setParameter("smsText", "订单" + order + "已经支付成功,谢谢!");
		// 提交/发送请求, 返回HTTP状态码
		int code=0;
		try {
			code = httpClient.executeMethod(post);
			System.out.println("返回的状态码为:" + code);
			System.out.println("返回的数据:" + post.getResponseBodyAsString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			// 释放连接
			post.releaseConnection();
		}
	}

	public static void main(String[] args) throws Exception {
//		// 根据 httpclient发送短息信息
//		// 打开的浏览器
//		HttpClient httpClient=new HttpClient();
//		// 创建Post请求
//		PostMethod post=new PostMethod("http://utf8.sms.webchinese.cn/");
//		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//		// 设置发送请求的参数
//		post.setParameter("Uid", "java_0604");
//		post.setParameter("Key", "3783e4c41df1671e837b");
//		post.setParameter("smsMob", "13724044380");
//		post.setParameter("smsText", "订单12345678已经支付成功,谢谢!");
//		// 提交/发送请求, 返回HTTP状态码
//		int code = httpClient.executeMethod(post);
//		System.out.println("返回的状态码为:" + code);
//		System.out.println("返回的数据:" + post.getResponseBodyAsString());
//		// 释放连接
//		post.releaseConnection();
	}
}
