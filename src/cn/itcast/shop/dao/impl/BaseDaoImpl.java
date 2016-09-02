package cn.itcast.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import cn.itcast.shop.dao.BaseDao;
import cn.itcast.shop.model.PageModel;

//@Repository("baseDao")
//@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz;

//	@Resource
//	private SqlSessionFactory sqlSessionFactory;
//
	protected SqlSession getSession() {
		return sqlSession;
	}
	
	@Resource
	private SqlSessionTemplate sqlSession;

	public BaseDaoImpl() {
		System.out.println(this.getClass());
		System.out.println("获取当前对象的父类(不包括父类的泛型信息):"
				+ this.getClass().getSuperclass());
		System.out.println("获取当前对象的父类(包括父类的泛型信息):"
				+ this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T model) {
		sqlSession.insert(model.getClass().getName() + ".insert", model);
//		Integer.parseInt("xxx");
	}

	@Override
	public T get(int id) {
		return sqlSession.selectOne(clazz.getName() + ".get", id);
	}

	@Override
	public List<T> queryForPage(PageModel pageModel) {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("keyword", "%" + pageModel.getKeyword() + "%");
		pageMap.put("start", (pageModel.getPage() - 1) * pageModel.getRows());
		pageMap.put("rows", pageModel.getRows());
		return sqlSession.selectList(clazz.getName() + ".queryForPage",
				pageMap);
	}

	@Override
	public int queryCount(String keyword) {
		return sqlSession.selectOne(clazz.getName() + ".queryCount",
				"%" + keyword + "%");
	}

	@Override
	public int deleteByIds(String[] ids) {
		return sqlSession.delete(clazz.getName() + ".deleteByIds", ids);
	}

	@Override
	public int update(T model) {
		// TODO Auto-generated method stub
		return sqlSession.update(clazz.getName() + ".update", model);
	}

	@Override
	public List<T> query() {
		return sqlSession.selectList(clazz.getName() + ".query");
	}
}
