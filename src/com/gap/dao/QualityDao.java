package com.gap.dao;

import com.gap.domain.Quality;

public interface QualityDao extends BaseDao<Quality> {

	public Quality getByCode(final String code) ;
}
