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
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">批次号</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${byCode.id_pro }" type="text"  class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="loginName" class="col-sm-2 control-label" style="text-align:left;">农药残留量</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${byCode.ny }" type="text"  class="form-control"/>
						    	</div>
							</div>
							<div class="form-group">
						    	<label for="name" class="col-sm-2 control-label" style="text-align:left;">有害物质含量</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${byCode.harm }" type="text"  class="form-control"/>
						    	</div>
							</div>
						
							<div class="form-group">
						    	<label for="phone" class="col-sm-2 control-label" style="text-align:left;">综合评分</label>
						    	<div class="col-sm-8">
								      <input readonly="readonly" value="${byCode.yjw }" type="text"  class="form-control"/>
						    	</div>
							</div>



							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-10">
									<a type="button" class="btn btn-sm btn-default" id="formReturn" href="${pageContext.request.contextPath}/quality.jsp">返回</a>
   									
								</div>
 							</div>
					</form>
						
				</div>
			</div>
		</div>
	</div>
</body>
</html>