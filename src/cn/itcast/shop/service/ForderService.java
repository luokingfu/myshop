package cn.itcast.shop.service;

import java.math.BigDecimal;

import cn.itcast.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	// 计算购物总价格
	public BigDecimal cluTotal(Forder forder);
}
