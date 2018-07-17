<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>  
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mycheck.js"></script>  
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script>
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
	
	<script type="text/javascript">
		$(function(){
			$("#sellPrice_rep").change(function(){
				//销售价格
				var sellprice = $("#sellPrice_rep").val();
				//成本价
				var buyprice = $("#buyPrice_rep").val();
				//库存单位
				var buyunit = $("#buyUnit_rep").val();
				//销售单位
				var sellunit = $("#sellUnit_rep").val();
				if (sellprice<buyprice && buyunit==sellunit){
					$("#ts").html("销售价不能低于成本价！");
				}
				else if (sellprice>buyprice || buyunit!=sellunit || sellprice==buyprice){
					$("#ts").empty();
				}
				
				
			});
		});
	</script>
</head>
<body>
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">确认订单</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm" enctype="multipart/form-data" action="ProductAction_DLSSaveProduct" method="POST">
							<input type="hidden" value="${agentorder.productid }" name="idHead_rep">
							<input type="hidden" value="${agentorder.id_order }" name="id_order">
							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">产品名</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.productName }" type="text"  name="name_rep" id="name_rep" class="form-control"/>
						    		<label id="ts"></label>
						    	</div>	
							</div>
							
							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">买家号</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.buyerid }" type="text"  name="idOwner_rep" id="sellPrice_rep" class="form-control"/>
						    		<label id="ts"></label>
						    	</div>	
							</div>
							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">商店位置</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.id_shop }" type="text"  name="idPlace_rep" id="idPlace_rep" class="form-control"/>
						    		<label id="ts"></label>
						    	</div>	
							</div>	
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">交易数量</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.buynumber }" type="text"  name="number_rep" id="number_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="email" class="col-sm-2 control-label" style="text-align:left;">成交单价（元）</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.buyPrice }"  type="text" name="buyPrice_rep" id="buyPrice_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="name" class="col-sm-2 control-label" style="text-align:left;">成交计量单位</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${agentorder.buyUnit }"  type="text" name="buyUnit_rep" id="buyUnit_rep" class="form-control"/>
						    	</div>
							</div>


						

							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath }/farmer/homepage.jsp">返回</a>
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