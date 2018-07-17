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

import com.gap.dao.AgentDao;
import com.gap.domain.Agent;







public class AgentDaoImpl extends BaseDaoImpl<Agent> implements AgentDao {

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
	public Agent getByUserCode(final String usercode) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Agent>() {
			@Override
			public Agent doInHibernate(Session session) throws HibernateException {
				String hql = "from Agent where phoneNumber_dls = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				Agent agent = (Agent) query.uniqueResult();
				return agent;
			}
		});

	}
}
