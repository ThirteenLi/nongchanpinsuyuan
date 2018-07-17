package com.gap.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gap.dao.FarmerDao;
import com.gap.domain.Farmer;






public class FarmerDaoImpl extends BaseDaoImpl<Farmer> implements FarmerDao {

	@Override
	@SuppressWarnings("all")
	public List<Object[]> getIndustryCount() {
		//原生SQL查询
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			String sql = " SELECT                                 "+
						"  bd.`dict_item_name`,                   "+
						"  COUNT(*) total                         "+
						" FROM                                    "+
						"  cst_customer c,                        "+
						"  base_dict bd                           "+
						" WHERE c.`cust_industry` = bd.`dict_id`  "+
						" GROUP BY c.`cust_industry`              ";
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		
		return list;
	}

	
	/** 通过手机号码查询农户*/
	@Override
	public Farmer getByPhoneNumber(final String phoneNumber) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Farmer>() {
			@Override
			public Farmer doInHibernate(Session session) throws HibernateException {
				String hql = "from Farmer where phoneNumber_nh = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, phoneNumber);
				Farmer farmer = (Farmer) query.uniqueResult();
				return farmer;
			}
		});
	}

	
	/** 通过身份证号码查询农户*/
	@Override
	public Farmer getByIDCardNumber(String IDCardNum_nh) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Farmer>() {
			@Override
			public Farmer doInHibernate(Session session) throws HibernateException {
				String hql = "from Farmer where IDCardNum_nh = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, IDCardNum_nh);
				Farmer farmer = (Farmer) query.uniqueResult();
				return farmer;
			}
		});
	}
	
	
}
