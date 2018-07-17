package com.gap.dao.impl;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.gap.dao.ProductDao;
import com.gap.domain.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	
	//根据批次号从数据库中查找对应的产品
	@Override
	public Product getByProductId(String productId_rep) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<Product>() {
			@Override
			public Product doInHibernate(Session session) throws HibernateException {
					String hql = "from Product where productId_rep = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, productId_rep);
					Product product = (Product) query.uniqueResult();
				return product;
			}
		});
	}



}
