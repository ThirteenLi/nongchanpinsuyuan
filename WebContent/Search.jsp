<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绿色农产品溯源系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/searchStyle.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ios-parallax.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript">
	$(function(){
		$("#backbtn").click(function(){
			$(window).attr('location',"${pageContext.request.contextPath }/index.jsp");
		});
	});
</script>

</head>


<body>
	<div id="top-image">
	  <div id="content" class="container center-block">
	    <div class="jumbotron">
	      <div class="container">
	        <h1>输入溯源码</h1>
	        
	        <p>${error }</p>
	        <form action="ProductAction_searchOriginInformation" method="post">
	        <div class="input-group input-group-lg" > 
	        	<span class="input-group-addon" id="sizing-addon1" style="width: 260px;">
	          		<input name="productId_rep" style="width: 260px;" type="text" class="form-control" placeholder="溯源码" aria-describedby="sizing-addon1">
				</span>
	        </div>
	        <div style="margin-top: 30px; margin-left: 20px; ">
	        	<button class="btn btn-default" type="submit">搜索</button>
	        	<button class="btn btn-default" type="button" id="backbtn">返回</button>
	        </div>

	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() {
	  $('#top-image').iosParallax({
		movementFactor: 50
	  });
	});
	</script>
	<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
	
	</div>
</body>
</html>