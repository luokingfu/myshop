package cn.itcast.shop.service;

import java.util.Map;

import cn.itcast.shop.model.BackData;
import cn.itcast.shop.model.SendData;

public interface PayService {

	// 完成数据的追加
//	public abstract String joinSendDataParam(SendData sendData);
	public Map<String, Object> saveDataToRequest(Map<String, Object> request,SendData sendData);
	
	public boolean checkBackData(BackData backData);

}