<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mycheck.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script>

<script>
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
				<div class="panel-heading">修改该批次的信息</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm" enctype="multipart/form-data" action="ProductAction_DLSModifyProductInfo" method="POST">
							<input type="hidden" value="${productByPID.productId_rep}" name="productId_rep" />
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">农产品名称</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${productByPID.name_rep }"  type="text" name="name_rep" id="name_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">农产品数量</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.number_rep }"  type="text"  name="number_rep" id="number_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">产品余量</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.reduceNum_rep }"  type="text"  name="reduceNum_rep" id="reduceNum_rep" class="form-control"/>
						    	</div>
							</div>							

							<div class="form-group">
						    	<label for="email" class="col-sm-2 control-label" style="text-align:left;">成本单价（元）</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.buyPrice_rep }"  type="text" name="buyPrice_rep" id="buyPrice_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="name" class="col-sm-2 control-label" style="text-align:left;">入库计量单位</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.buyUnit_rep }"  type="text" name="buyUnit_rep" id="buyUnit_rep" class="form-control"/>
						    	</div>
							</div>


							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">销售单价（元）</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.sellPrice_rep }"  type="text"  name="sellPrice_rep" id="sellPrice_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="phone" class="col-sm-2 control-label" style="text-align:left;">销售计量单位</label>
						    	<div class="col-sm-8">
								      <input value="${productByPID.sellUnit_rep }"  type="text" name="sellUnit_rep" id="sellUnit_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath }/agent/homepage.jsp">返回</a>
   									<button type="button" class="btn btn-sm btn-primary" id="formSubmit" onclick ="javascript:$('#dailogForm').submit();">提交</button>
								</div>
 							</div>
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>