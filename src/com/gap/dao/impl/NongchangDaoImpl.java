package com.gap.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.NongchangDao;
import com.gap.domain.Customer;
import com.gap.domain.Nongchang;

public class NongchangDaoImpl extends BaseDaoImpl<Nongchang> implements NongchangDao {

	
	public Nongchang getNongchangByName(String usercode) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Nongchang>() {
			@Override
			public Nongchang doInHibernate(Session session) throws HibernateException {
				String hql = "from Nongchang where name_ncfarm = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				Nongchang myfarm = (Nongchang) query.uniqueResult();
				return myfarm;
			}
		});
	}

	@Override
	public List<Nongchang> getNongchangPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<Nongchang> list = (List<Nongchang>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		List<Nongchang> listnew = new ArrayList<>();
		
		//清洗数据
		Iterator<Nongchang> it = list.iterator();
		while (it.hasNext()){
			Nongchang ntemp = it.next();		
			ntemp.setId_nh(ntemp.getFarmer().getId_nh());
			ntemp.setFarmer(null);
			listnew.add(ntemp);
		}
		return listnew;
	}
}
