package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Nongchang;

public interface NongchangDao extends BaseDao<Nongchang>{
	//查询当前用户的所有农场
	public Nongchang getNongchangByName(String string);
	/** 查：根据条件查询对象，分页查询*/
	
	public List<Nongchang> getNongchangPageList(DetachedCriteria dc, Integer start, Integer pageSize) ;	

	
}
