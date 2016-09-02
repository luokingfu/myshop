package cn.itcast.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
@Component("sendEmail")
public class SendEmailUtil implements SendEmail {

	/* (non-Javadoc)
	 * @see cn.itcast.shop.util.SendEmail#sendEmail(int, java.lang.String)
	 */
	@Override
	public void sendEmail(String order,String address) {
		// 1：登陆邮件客户端 (创建会话)
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(prop);
		session.setDebug(true); // 可以显示发送流程
		Transport transport = null;
		try {
			// 2: 创建邮件
			Message message = new MimeMessage(session);
			// 3: 编写邮件相关信息(主题、正文、发件人地址)
			message.setSubject("订单支付成功邮件!");
			message.setContent("订单号" + order + "已经支付成功!", "text/html;charset=UTF-8");
			// 发件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			// 4: 传输邮件 (设置邮件服务器地址,端口, 收件人地址)
			transport = session.getTransport();
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			transport.sendMessage(message, new Address[] { new InternetAddress(address)});
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 5: 关闭(释放资源)
			try {
				transport.close();
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}

	}

	// public static void main(String[] args) throws Exception {
	// // 1：登陆邮件客户端 (创建会话)
	// Properties prop=new Properties();
	// prop.setProperty("mail.transport.protocol", "smtp");
	// Session session = Session.getDefaultInstance(prop);
	// session.setDebug(true); // 可以显示发送流程
	// // 2: 创建邮件
	// Message message=new MimeMessage(session);
	// // 3: 编写邮件相关信息(主题、正文、发件人地址)
	// message.setSubject("订单支付成功邮件!");
	// message.setContent("订单号******** 已经支付成功!", "text/html;charset=UTF-8");
	// // 发件人地址
	// message.setFrom(new InternetAddress("soft03_test@sina.com"));
	// // 4: 传输邮件 (设置邮件服务器地址,端口, 收件人地址)
	// Transport transport = session.getTransport();
	// transport.connect("smtp.sina.com","soft03_test","soft03_test");
	// transport.sendMessage(message, new Address[]{new
	// InternetAddress("soft03_test@sina.com")});
	// // 5: 关闭(释放资源)
	// transport.close();
	// }
}
