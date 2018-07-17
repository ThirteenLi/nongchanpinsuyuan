package com.gap.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.gap.dao.BaseDao;

/**
 * @author HoraceHe
 * @category 数据库操作类
 * @param <T>
 */

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	/** 用于接收运行期泛型类型*/
	private Class clazz;

	
	/** 构造器：为clazz赋值*/
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	
	/** 增：把某个对象存进数据库*/
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	
	/** 删：把某个对象从数据库中删除*/
	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	
	/** 删：把某个对象从数据库中删除*/
	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}

	
	/** 改：修改数据库中某个对象的值*/
	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	
	/** 改：（保存或更新）修改数据库中某个对象的值*/
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	
	/** 查：根据Id查询某个对象的值*/
	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	
	/** 初查：根据条件查询总记录数*/
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}

	
	/** 查：根据条件查询对象，分页查询*/
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

}
