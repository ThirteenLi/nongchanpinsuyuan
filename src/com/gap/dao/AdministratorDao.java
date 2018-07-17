package com.gap.dao;

import com.gap.domain.Administrator;


public interface AdministratorDao extends BaseDao<Administrator>{
	
	//根据管理员的用户名查询管理员信息
	public Administrator getByUserCode(final String usercode);
	
}
