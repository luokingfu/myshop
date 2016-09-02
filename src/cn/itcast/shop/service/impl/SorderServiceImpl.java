package cn.itcast.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.shop.model.Forder;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.model.Sorder;
import cn.itcast.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Sorder productToSorder(Sorder sorder,Product product) {
		sorder.setName(product.getName());
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product); // 判断购物项是否重复时使用
		return sorder;
	}

	@Override
	public Forder addSorder(Forder forder, Sorder sorder) {
		// 判断当前购物项是否在购物车中已经存在
		boolean isHave = false;
		for (Sorder temp : forder.getSorderList()) {
			if (temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				// 说明当前购物项已经存在,增加数量即可
				temp.setNumber(temp.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		// 当前购物项没有存在购物车中,直接添加即可
		if (!isHave) {
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	@Override
	public Forder alterSorder(Forder forder, Sorder sorder) {
		for (Sorder temp : forder.getSorderList()) {
			if (temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				// 说明当前购物项已经存在,增加数量即可
				temp.setNumber(sorder.getNumber());
				break;
			}
		}
		return forder;
	}

	@Override
	public List<Sorder> sole(int number,String start,String end) {
		return sorderDao.sole(number,start,end);
	}
}
