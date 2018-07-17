<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绿色农产品溯源系统</title>
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>

  

<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">绿色农产品溯源系统-管理员登录</h1>
			<div><font color="red" ><s:property value="exception.message" /> </font></div>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="AdministratorAction_loginAdministrator" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input name="username_gly" type="text" class="form-control" id="username" placeholder="用户名">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input name="password_gly" type="password" class="form-control" id="password" placeholder="密码">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="checkbox"> 记住密码
                		</label>
	              	</div>
	              	
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">   
		          	<div class="control-wrapper">
		          		<input type="submit" value="登录" class="btn btn-info">
		          		
		          	</div>
		          	
		          </div>
		        </div>
		        <hr>
		      </form>
		</div>
	</div>
</body>
</html>