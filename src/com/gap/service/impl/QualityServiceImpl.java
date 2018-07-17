package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.QualityDao;
import com.gap.domain.Customer;
import com.gap.domain.Quality;
import com.gap.service.QualityService;
import com.gap.utils.PageBean;

public class QualityServiceImpl implements QualityService {


	QualityDao qualityDao;

	
	public QualityDao getQualityDao() {
		return qualityDao;
	}


	public void setQualityDao(QualityDao qualityDao) {
		this.qualityDao = qualityDao;
	}


	/**获取分页信息*/
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = qualityDao.getTotalCount(dc);  
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);  
		//3 调用Dao查询分页列表数据
		List<Quality> list = qualityDao.getPageList(dc,pb.getStart(),pb.getPageSize());  
		//4 列表数据放入pageBean中
		pb.setList(list);
		//5 结果返回
		return pb;
	}


	@Override
	public void save(Quality quality) {
		qualityDao.saveOrUpdate(quality);
		
	}


	@Override
	public void deleteById(Long id_zl) {
		qualityDao.delete(id_zl);
		
	}


	@Override
	public Quality getById(Long id_zl) {
		
		return qualityDao.getById(id_zl);
	}


	@Override
	public Quality getByCode(String code) {
		Quality byCode = qualityDao.getByCode(code);
		if (byCode != null){
			return byCode;
		}else{
			throw new RuntimeException("暂时没有该批次号的质量信息！");
		}
		
	}
	
	
	

}
