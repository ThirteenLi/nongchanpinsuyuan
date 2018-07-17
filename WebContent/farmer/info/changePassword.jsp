<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript">
$(function(){
	$('.form_datetime').datetimepicker({
		language:'zh-CN',
		format: "yyyy-mm-dd hh:ii:ss",
		weekStart: 1,
        autoclose: true,
        todayBtn: true,
		todayHighlight: 1,
		startView: 'month',
		forceParse: true,
        showMeridian: 1
	});
});
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/jscheck/check.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script> 
<body>
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">修改密码</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm4" enctype="multipart/form-data" action="${pageContext.request.contextPath}/FarmerAction_changeFarmerPassword" method="POST">
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">${FarmerChangePassworderror}</label>
							</div>							
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">输入原密码</label>
						    	<div class="col-sm-8">
								      <input type="password"  name="password_nh" id="password_nh" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">输入新密码</label>
						    	<div class="col-sm-8">
								      <input type="password" type="text"  name="newPassword" id="newPassword" class="form-control"/>
						    	</div>
							</div>

							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">重复新密码</label>
						    	<div class="col-sm-8">
								      <input type="password" type="text"  name="renewPassword" id="renewPassword" class="form-control"/>
						    	</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath}/farmer/info/farmerInfoAndChange.jsp">返回</a>
   									<button type="button" class="btn btn-sm btn-primary" id="formSubmit" onclick ="javascript:$('#dailogForm4').submit();">提交</button>
								</div>
 							</div>
 							<input type="hidden" name="id_nh" value="${farmer1.id_nh }">

 							
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>