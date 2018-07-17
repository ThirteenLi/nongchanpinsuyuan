package com.gap.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.AdministratorDao;
import com.gap.domain.Administrator;
import com.gap.domain.Customer;

public class AdministratorDaoImpl extends BaseDaoImpl<Administrator> implements AdministratorDao {


	@Override
	public Administrator getByUserCode(String usercode) {
		
		
		return getHibernateTemplate().execute(new HibernateCallback<Administrator>() {
			@Override
			public Administrator doInHibernate(Session session) throws HibernateException {
					String hql = "from Administrator where username_gly = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, usercode);
					Administrator admin = (Administrator) query.uniqueResult();
				return admin;
			}
		});
	}

}
