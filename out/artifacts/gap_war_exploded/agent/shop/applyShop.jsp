<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/jscheck/check.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script> 

<head>


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



</head>
<body>
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">申请新的代理点</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm22" enctype="multipart/form-data" action="${pageContext.request.contextPath}/ShopAction_applyNewShop" method="POST">
								
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">代理点名称</label>
						    	<div class="col-sm-8">
								      <input type="text"  name="name_shop" id="name_shop" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">代理点地址</label>
						    	<div class="col-sm-8">
								      <input type="text"  name="address_shop" id="address_shop" class="form-control"/>
						    	</div>
							</div>
							
							<div class="form-group">
						    	<label for="phone" class="col-sm-2 control-label" style="text-align:left;">交通方式</label>
						    	<div class="col-sm-8">
								      <input type="text"  name="traffic_shop" id="traffic_shop" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">主要经营</label>
						    	<div class="col-sm-8">
								      <input type="text"  name="mainProduct_shop" id="mainProduct_shop" class="form-control"/>
						    	</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath}/farmer/nongchang/nongchangAdmin.jsp">返回</a>
   									<button type="button" class="btn btn-sm btn-primary" id="formSubmit" onclick ="javascript:$('#dailogForm22').submit();">提交</button>
								</div>
 							</div>
 							<input type="hidden" name="agent.id_dls" value="${agent1.id_dls }">

 							
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>