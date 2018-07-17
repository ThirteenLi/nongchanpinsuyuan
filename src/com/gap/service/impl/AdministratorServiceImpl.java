package com.gap.service.impl;

import com.gap.dao.AdministratorDao;
import com.gap.domain.Administrator;

import com.gap.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

	AdministratorDao admind;
	public AdministratorDao getAdmind() {
		return admind;
	}

	public void setAdmind(AdministratorDao admind) {
		this.admind = admind;
	}



	@Override
	public Administrator getAdministratorByNamePassword(Administrator admin) {
		Administrator gly = admind.getByUserCode(admin.getUsername_gly());
		if (gly==null){
			throw new RuntimeException("您输入的用户名不存在！");
		}
		if (!gly.getPassword_gly().equals(admin.getPassword_gly())){
			throw new RuntimeException("您输入的密码错误！");
		}
		return gly;
	}

}
