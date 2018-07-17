<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绿色农产品溯源系统</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
	<!--引入国际化js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script>
	<style type="text/css">
		#clj1{
			color: #3333FF;
		}
		#clj2{
			color: #3333FF;
		}
		label.error{
			background:url(${pageContext.request.contextPath}/images/unchecked.gif) no-repeat 10px 3px;
			padding-left: 30px;
			font-family:georgia;
			font-size: 15px;
			font-style: normal;
			color: red;
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/myvalidate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/mycheck.js"></script>

	<script type="text/javascript">
		$(function(){
			$("#phoneNumber_cus").blur(function(){
				var phoneNumber_cusInput = $(this).val();
				$.post(
					"${pageContext.request.contextPath}/CustomerAction_checkPhoneNumber",
					{"phoneNumber_cus":phoneNumber_cusInput},
					function(data){
						var isExist = data.isExist;
						var phoneNumber_cusInfo = "";
						if (isExist){
							phoneNumber_cusInfo = "该手机号码已经注册";
							$("#phoneNumber_cusInfo").css("color","red");
							
						}
						$("#phoneNumber_cusInfo").html(phoneNumber_cusInfo);
					},
					"json"
				);
			});
		});
	</script>
</head>
  


<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">消费者注册</h1>
	<div class="container">
		<div class="col-md-12">			
			<form id="registForm" enctype="multipart/form-data" class="form-horizontal templatemo-create-account templatemo-container" role="form" action="CustomerAction_registNewCustomer" method="post">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="phoneNumber" class="control-label">手机号</label>
			            <label id="phoneNumber_cusInfo"></label>
			            <input id="phoneNumber_cus" name="phoneNumber_cus" type="text" class="form-control"  placeholder="" maxlength="11"> 		 
			                      		            		           
			          </div>             
			        </div>

			        <div class="form-group">
			          <div class="col-md-6">
			            <label for="password" class="control-label">密码</label>
			            <input name="password_cus" type="password" class="form-control" id="password" placeholder="">
			          </div>
			          <div class="col-md-6">
			            <label for="password" class="control-label">确认密码</label>
			            <input name="repassword_cus" type="password" class="form-control" id="password_confirm" placeholder="">
			          </div>
			        </div>			        
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">邮箱</label>
			            <input name="email_cus" type="email" class="form-control" id="email" placeholder="" maxlength="30">		            		            		            
			          </div>              
			        </div>

				      
			
			        <div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="username" class="control-label">昵称</label>
			            <input name="nickName_cus" type="text" class="form-control" id="username" placeholder="" maxlength="20">		            		            		            
			          </div>
			          <div class="col-md-6 templatemo-radio-group">
			          	<label class="radio-inline">
		          			<input type="radio" name="gender_cus" id="optionsRadios1" value="先生" checked="checked"> 先生
		          		</label>
		          		<label class="radio-inline">
		          			<input type="radio" name="gender_cus" id="optionsRadios2" value="女士"> 女士
		          		</label>
			          </div>             
			        </div>
	


			        <div class="form-group">
			          <div class="col-md-12">
			            <label><input name="contrace_cus" type="checkbox">我同意 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal" id="clj1">绿色农产品溯源系统消费者使用协议</a></label>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="submit" value="注册" class="btn btn-info">
			            <a href="${pageContext.request.contextPath}/index.jsp" class="pull-right" id="clj2">返回主页</a>
			          </div>
			        </div>	
				</div>				    	
		      </form>		      
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
	      </div>
	      <div class="modal-body">
	      	<p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5 Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
	        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
	        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>


	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>

</html>