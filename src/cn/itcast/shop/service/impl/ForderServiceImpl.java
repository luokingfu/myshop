package cn.itcast.shop.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Sorder;
import cn.itcast.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {

	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total = new BigDecimal(0.00);
		for (Sorder sorder : forder.getSorderList()) {
			// 返回追加后的数据
			total = total.add(sorder.getPrice().multiply(
					new BigDecimal(sorder.getNumber())));
		}
		return total;
	}
	
	@Override  // 级联查询购物车与购物项目,并且在同一个事务中
	public void insert(Forder forder) {
		// 先插入订单
		forderDao.insert(forder);
		// 级联插入购物项
//		Integer.parseInt("xxxx");
		for(Sorder sorder:forder.getSorderList()){
			// 需要forder的主键 Mapper中需要配置: useGeneratedKeys="true" keyProperty="id"
			sorder.setForder(forder);  
			sorderDao.insert(sorder);
		}
	}

}
