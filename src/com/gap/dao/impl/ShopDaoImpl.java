package com.gap.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.ShopDao;
import com.gap.domain.Shop;


public class ShopDaoImpl extends BaseDaoImpl<Shop> implements ShopDao {

	
	public Shop getShopByName(String usercode) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Shop>() {
			@Override
			public Shop doInHibernate(Session session) throws HibernateException {
				String hql = "from Shop where name_shop = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				Shop myshop = (Shop) query.uniqueResult();
				return myshop;
			}
		});
	}

	@Override
	public List<Shop> getShopPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<Shop> list = (List<Shop>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		List<Shop> listnew = new ArrayList<>();
		
		//清洗数据
		Iterator<Shop> it = list.iterator();
		while (it.hasNext()){
			Shop stemp = it.next();		
			stemp.setId_dls(stemp.getAgent().getId_dls());
			
			stemp.setAgent(null);
			listnew.add(stemp);
		}
		return listnew;
	}
}
