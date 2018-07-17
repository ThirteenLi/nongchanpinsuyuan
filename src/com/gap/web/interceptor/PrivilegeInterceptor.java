package com.gap.web.interceptor;

import java.util.Map;

import com.gap.domain.Administrator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//不校验登陆和注册方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1 获得Session
			Map<String, Object> session = ActionContext.getContext().getSession();
		//2 获得登陆标识
			Administrator admin = (Administrator) session.get("admin1");
		//3 判断标识是否存在
			if(admin != null){
				//存在=> 放行
				return invocation.invoke();
			}else{
				//不存在=> 重定向到登陆页面
				return "noAdmin";
			}
			
	}

}
