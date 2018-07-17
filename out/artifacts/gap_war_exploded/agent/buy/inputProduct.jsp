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
		$(function () {
			$("#buynumber").blur(function (){
				var kgm = $("#number_rep").val();
				var dgm = $("#buynumber").val();
				if (kgm < dgm){
					//alert("非常抱歉！无法满足您的需求量！");
					$("#ts").html("非常抱歉！无法满足您的需求量！");
					$("#formSubmit").attr('disabled',true); 
					
				}else{
					$("#ts").empty();
					$("#formSubmit").attr('disabled',false); 
				}
			});
		});
	</script>
	
</head>
<body>
	<div class="container" style="width:98%;padding:8px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">填写订单</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" id="dailogForm31" enctype="multipart/form-data" action="OrderAction_writeOrder" method="POST">
							<!-- 卖家id -->
							<input type="hidden" value="${productByPID.idOwner_rep}" name="sellerid" />
							<!-- 卖家类型 -->
							<input type="hidden" value="${productByPID.userCategory_reo}" name="sellerzl" />
							<!-- 买家id -->
							<input type="hidden" value="${agent1.id_dls}" name="buyerid" />
							<!-- 买家类型 -->
							<input type="hidden" value="agnet" name="buyerzl" />							
							<!-- 产品批次号 -->
							<input type="hidden" value="${productByPID.productId_rep}" name="productid" />
 							<!-- 进货价 -->
							<input type="hidden" value="${productByPID.sellPrice_rep}" name="buyPrice" />
							<!-- 进货计量单位 -->
							<input type="hidden" value="${productByPID.sellUnit_rep}" name="buyUnit" />


							
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">农产品名称</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${productByPID.name_rep}" type="text" name="productName" id="productName" class="form-control" maxlength="30"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">可购买数量（${productByPID.sellUnit_rep}）</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${productByPID.reduceNum_rep}" type="text"  name="number_rep" id="number_rep" class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="email" class="col-sm-2 control-label" style="text-align:left;">价格（元/${productByPID.sellUnit_rep}）</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${productByPID.sellPrice_rep}"  type="text" name="buyPrice_rep" id="buyPrice_rep" class="form-control"/>
						    	</div>
							</div>

							<div class="form-group">
						    	<label for="mobile" class="col-sm-2 control-label" style="text-align:left;">购买数量</label>
						    	<div class="col-sm-8">
								      <input maxlength="10" type="text"  name="buynumber" id="buynumber" class="form-control"/>
						    			<label id="ts"></label>
						    	</div>
							</div>




							<div class="form-group">
						    	<label for="loginFlag" class="col-sm-2 control-label" style="text-align:left;">选择代理点</label>
						    	<div class="col-sm-8">
						    		  <select name="id_shop" id="id_shop"  class="selectpicker show-tick form-control" data-live-search="true">
							 			 	 <option value="">请选择</option>
										     <c:forEach items="${agentpageBean.list }" var="var">
												<option value="${var.id_shop }">
											     	${var.name_shop}	
										     	</option>	
										     </c:forEach>
								      </select>
						    	</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath }/agent/homepage.jsp">返回</a>
   									<button type="button" class="btn btn-sm btn-primary" id="formSubmit" onclick ="javascript:$('#dailogForm31').submit();">提交</button>
								</div>
 							</div>
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>