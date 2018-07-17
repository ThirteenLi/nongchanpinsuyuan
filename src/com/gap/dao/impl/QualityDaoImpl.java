package com.gap.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.QualityDao;
import com.gap.domain.Quality;

public class QualityDaoImpl extends BaseDaoImpl<Quality> implements QualityDao {

	@Override
	public Quality getByCode(final String code) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Quality>() {
			@Override
			public Quality doInHibernate(Session session) throws HibernateException {
					String hql = "from Quality where id_pro = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, code);
					Quality quality = (Quality) query.uniqueResult();
				return quality;
			}
		});

	}




}
