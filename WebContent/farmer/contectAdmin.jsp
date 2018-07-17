<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
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
</head>


<body>
	
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">输入变更申请</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm3" enctype="multipart/form-data" action="ApplyAction_FarmerContectAdmin" method="POST">
							<input type="hidden" value="${farmer1.id_nh}" name="userid" />
							<div class="form-group">
						    	<label for="loginFlag" class="col-sm-2 control-label" style="text-align:left;">变更类型</label>
						    	<div class="col-sm-8">
						    		  <select name="applycategory" id="applycategory"  class="selectpicker show-tick form-control" data-live-search="true">
							 			 	 <option value="农户信息变更" selected="selected">信息变更申请</option>
											 <option value="农户留言">留言</option>											
								      </select>
						    	</div>
							</div>
          
							<div class="form-group">
						    	<label for="name" class="col-sm-2 control-label" style="text-align:left;">变更申请内容</label>
						    	<div class="col-sm-8">
								      <input style="height: 360px;"
								      
								       type="text" name="userapply" id="userapply" class="form-control"/>
						    	</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath }/farmer/homepage.jsp">返回</a>
   									<button type="button" class="btn btn-sm btn-primary" id="formSubmit" onclick ="javascript:$('#dailogForm3').submit();">提交</button>
								</div>
 							</div> 
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>