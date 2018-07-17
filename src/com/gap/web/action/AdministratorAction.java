package com.gap.web.action;

import com.gap.domain.Administrator;
import com.gap.service.AdministratorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdministratorAction extends ActionSupport implements ModelDriven<Administrator> {

	private Administrator admin = new Administrator();
	private AdministratorService admins;

	
	
	public String loginAdministrator() throws Exception{
		try{
			Administrator admin1 = admins.getAdministratorByNamePassword(admin);
			ActionContext.getContext().getSession().put("admin1", admin1);
		}catch(Exception e){
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
		return "adminLogin";
	}
	
	@Override
	public Administrator getModel() {
		return admin;
	}

	public void setAdmins(AdministratorService admins) {
		this.admins = admins;
	}
	
	
}
