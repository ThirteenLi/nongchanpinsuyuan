package com.gap.dao;

import com.gap.domain.Product;

public interface ProductDao extends BaseDao<Product> {

	//根据批次号从数据库中查找对应的产品
	public Product getByProductId(final String productId_rep);
}
