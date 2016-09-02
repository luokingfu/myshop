package cn.itcast.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.shop.dao.SorderDao;
import cn.itcast.shop.model.Sorder;
/*
 *  此类只需要实现自身的业务逻辑方法，公共的方法通过继承BaseDaoImpl来完成
 * */
@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao {

	@Override
	public List<Sorder> sole(int number,String start,String end) {
		Map<String,Object> hashMap=new HashMap<String, Object>();
		hashMap.put("number",number);
		hashMap.put("start",start);
		hashMap.put("end",end);
		return getSession().selectList(Sorder.class.getName() + ".sole",hashMap);
	}
	
}
