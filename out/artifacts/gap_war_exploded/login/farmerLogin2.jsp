<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绿色农产品溯源系统</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>Amaze UI Examples</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/amazeui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app.css">
  <style type="text/css">
  	.myapp-login-logo-text{
  		margin-top: 10px;
  	}
  </style>
</head>

<body>
	<div class="am-g myapp-login">
		<div class="myapp-login-logo-block">
			<div class="myapp-login-logo">
				<i class="am-icon-tree"></i>
			</div>
			<div class="myapp-login-logo-text">
				<div class="myapp-login-logo-text">
					农户<span>登录</span>
					<div class="info">欢迎使用绿色农产品溯源系统</div>
				</div>
			</div>
	
			<div class="login-font">
				<a href="${pageContext.request.contextPath }/login/customerLogin2.jsp">消费者登录 </a> 或 <span> <a href="${pageContext.request.contextPath }/login/agentLogin2.jsp">代理商登录 </a></span>
			或<a href="${pageContext.request.contextPath }/index.jsp">返回注册</a>
			</div>
			<div class="am-u-sm-10 login-am-center">
				<form class="am-form">
					<fieldset>
						<div class="am-form-group">
							<input name="phoneNumber_cus" type="text" class="" id="doc-ipt-email-1" placeholder="请输入手机号">
						</div>
	
						<div class="am-form-group">
							<input type="password_cus" class="" id="doc-ipt-pwd-1" placeholder="请输入密码">
						</div>
						<p><button type="submit" class="am-btn am-btn-default">登录</button></p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>     
	     
	
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/amazeui.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/app.js"></script>
</body>
</html>