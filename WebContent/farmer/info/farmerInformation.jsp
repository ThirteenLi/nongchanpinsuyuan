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
<body>
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">我的信息</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form">						
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">电话号码</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${farmer1.phoneNumber_nh }" type="text"  class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">邮箱地址</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${farmer1.email_nh }" type="text"  class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="name" class="col-sm-2 control-label" style="text-align:left;">身份证号</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${farmer1.IDCardNum_nh }" type="text"  class="form-control"/>
						    	</div>
							</div>
						
							<div class="form-group">
						    	<label for="phone" class="col-sm-2 control-label" style="text-align:left;">真实姓名</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${farmer1.realName_nh }" type="text"  class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">我的性别</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${farmer1.gender_nh }" type="text"  name="mainProduct_ncfarm" id="mainProduct_ncfarm" class="form-control"/>
						    	</div>
							</div>


							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath}/farmer/info/farmerInfoAndChange.jsp">返回</a>
   									
								</div>
 							</div>
					</form>
						
				</div>
			</div>
		</div>
	</div>
</body>
</html>