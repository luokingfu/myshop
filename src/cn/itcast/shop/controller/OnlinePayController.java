package cn.itcast.shop.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.shop.model.BackData;
import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.SendData;
import cn.itcast.shop.model.Status;
import cn.itcast.shop.model.User;

/* 在线支付的控制层  */
@Controller
@RequestMapping("/onlinePay")
public class OnlinePayController extends BaseController {

	@Resource
	private HttpSession session;

	// 1: 获取数据, 2: 并且追加和加密 3: 存储到request中
	@RequestMapping("/sendData")
	public String sendData(SendData sendData, Map<String, Object> request) {
		// 补全SendData的数据, P2 p3 pd Pa 是前台注入
		Forder forder = (Forder) session.getAttribute("oldForder");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt((forder.getTotal().toString()));
		// 获取用户 手机号码和邮箱名称, 支付成功后需要使用
		User user = (User) session.getAttribute("user");
		sendData.setPa_MP(user.getPhone() + "," + user.getEmail());
		// 返回的是追加后的数据
		request = payService.saveDataToRequest(request, sendData);
		// 跳转到选择银行确认页面
		return "forward:/users/pay.jsp";
	}

	@RequestMapping("/backData")
	public String backData(BackData backData, Map<String, Object> resultMap) {
		boolean isOk = payService.checkBackData(backData);
		if (isOk && backData.getR1_Code().equals("1")) {
			System.out.println("----支付返回成功-----");
			String orderId = backData.getR6_Order();
			// 修改订单状态, 发送邮件, 短信
			Forder forder = new Forder();
			forder.setId(Integer.parseInt(orderId));
			forder.setStatus(new Status(1));
			forderService.update(forder);
			// 发送短息
			sendMessage.sendMessage(orderId, backData.getR8_MP().split(",")[0]);
			// 发送邮件
			sendEmail.sendEmail(orderId, backData.getR8_MP().split(",")[1]);
			resultMap.put("result",
					"订单" + orderId + ",金额为: " + backData.getR3_Amt()
							+ "已经支付成功!");
		} else {
			resultMap.put("result", "支付失败!");
		}
		return "/result.jsp";
	}
}
