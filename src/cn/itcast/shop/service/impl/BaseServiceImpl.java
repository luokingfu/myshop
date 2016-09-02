package cn.itcast.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import cn.itcast.shop.dao.AccountDao;
import cn.itcast.shop.dao.BaseDao;
import cn.itcast.shop.dao.CategoryDao;
import cn.itcast.shop.dao.ForderDao;
import cn.itcast.shop.dao.ProductDao;
import cn.itcast.shop.dao.SorderDao;
import cn.itcast.shop.dao.UserDao;
import cn.itcast.shop.model.PageModel;
import cn.itcast.shop.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class clazz=null;
	
	public BaseServiceImpl(){
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
	}
	
	@Resource  // 某些子类Service会调用	
	protected CategoryDao categoryDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
//	@Resource
	protected BaseDao<T> baseDao;  
	
	// 此baseDao应该根据不同的T来实现赋值, 例如 T=Category,则 baseDao=categoryDao T=account baseDao=accountDao
	
	@PostConstruct  // 在构造方法和set注入之后执行
	public void init(){
		System.out.println("-----init:----");
		//clazz=category, 则需要获取 categoryDao
		String clazzName=clazz.getSimpleName();  // Category|Account  ===>categoryDao
		String clazzField=clazzName.substring(0,1).toLowerCase() + clazzName.substring(1) + "Dao";
		try {
			Field field=this.getClass().getSuperclass().getDeclaredField(clazzField);
			// 获取baseDao字段
			Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this,field.get(this));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public T get(int id) {
		return baseDao.get(id);
	}

	@Override
	public void insert(T model) {
		baseDao.insert(model);
		
	}


	@Override
	public List<T> queryForPage(PageModel pageModel) {
		return baseDao.queryForPage(pageModel);
	}


	@Override
	public int queryCount(String keyword) {
		return baseDao.queryCount(keyword);
	}


	@Override
	public int deleteByIds(String[] ids) {
		return baseDao.deleteByIds(ids);
	}


	@Override
	public int update(T model) {
		// TODO Auto-generated method stub
		int result=baseDao.update(model);
//		Integer.parseInt("xxxx");
		return result;
	}


	@Override
	public List<T> query() {
		return baseDao.query();
	}

}
