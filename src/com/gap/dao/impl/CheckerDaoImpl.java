package com.gap.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.CheckerDao;
import com.gap.domain.Checker;






public class CheckerDaoImpl extends BaseDaoImpl<Checker> implements CheckerDao {

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
	
	@Override
	public Checker getByUserCode(final String usercode) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Checker>() {
			@Override
			public Checker doInHibernate(Session session) throws HibernateException {
					String hql = "from Checker where username_zjy = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, usercode);
					Checker checker = (Checker) query.uniqueResult();
				return checker;
			}
		});

	}
}
