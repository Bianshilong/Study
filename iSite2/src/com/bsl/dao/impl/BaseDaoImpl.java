package com.bsl.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bsl.dao.BaseDao;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory SessionFactory;
	

	@Override		//根据ID加载实体
	public T get(Class<T> entityClazz, Long id) {
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override		//保存实体
	public Long save(T entity) {
		return (Long) getSessionFactory().getCurrentSession().save(entity);
	}

	@Override		//更新实体
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override		// 删除实体
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}
	
	@Override		//根据ID删除实体
	public void delete(Class<T> entityClazz, Long id) {
		getSessionFactory().getCurrentSession().createQuery("delete "
				+ entityClazz.getSimpleName()+" en where en.id = ?0")
				.setParameter("0", id)
				.executeUpdate();
		
	}

	@Override		//获取所有实体
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from "+entityClazz.getSimpleName()+" en");
	}

	@Override		//获取实体总数
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	//使用HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql){
		List<T> list =(List<T>) getSessionFactory().getCurrentSession().createQuery(hql).getResultList();
		return list;
	}
	
	//根据占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql,Object... params){
		//创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//为包含占位符的HQL语句设置参数
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+"", params[i]);
		}
		return query.getResultList();
	}
}
