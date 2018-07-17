package com.gap.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Quality;
import com.gap.utils.PageBean;

public interface QualityService {
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	public void save(Quality quality);

	public void deleteById(Long id_zl);

	public Quality getById(Long id_zl);
	
	public Quality getByCode(String code);

}
