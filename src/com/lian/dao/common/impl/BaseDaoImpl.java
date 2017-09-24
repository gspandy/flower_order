package com.lian.dao.common.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lian.dao.common.BaseDao;
import com.lian.util.PageModel;


public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	/**
	 * 对应的持久化类
	 */
	private Class<T> clazz;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public BaseDaoImpl(){
		//通过反射机制获取子类传递过来的实体类的类型信息
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>)type.getActualTypeArguments()[0];		
	}

	@Override
	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(get(id));
	}

	@Override
	public void edit(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(entity);
	}

	@Override
	public T get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql="select t from "+clazz.getSimpleName()+" t";
		return session.createQuery(hql).list();
	}

	@Override
	public int getTotalCount() {
		Session session = sessionFactory.getCurrentSession();
		int count = 0;
		String hql = "select count(t) from "+clazz.getSimpleName()+" t";
		Long temp = (Long)session.createQuery(hql).uniqueResult();
		if (temp != null ){
			count = temp.intValue();
		}
		return count;
	}

	@Override
	public PageModel<T> getByPager(int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		PageModel<T> pm = new PageModel<T>(pageNo, pageSize);
		String hql="select t from "+clazz.getSimpleName()+" t";
		int startRow = (pageNo - 1) * pageSize;
		pm.setDatas(session.createQuery(hql).setFirstResult(startRow).setMaxResults(pageSize).list());
		pm.setRecordCount(getTotalCount());
		return pm;
	}
	
}
