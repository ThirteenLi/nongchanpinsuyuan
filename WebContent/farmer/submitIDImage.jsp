<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绿色农产品溯源系统</title>
	<meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">      
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default3.css">
    <link href="${pageContext.request.contextPath}/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	

</head>
<body>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>请上传相关证件</h1>			
		</header>

		<div class="container kv-main">
            <form action="FarmerAction_upload" method="post" enctype="multipart/form-data">
            	<input name="id_nh" type="hidden" value="${farmer2.id_nh }">
            	<h3>身份证正面 </h3>	
                <input name="photo" id="file-0a" class="file" type="file" multiple data-min-file-count="1">
                <br>
                <h3>身份证反面 </h3>	
                <input name="photo2" id="file-0a" class="file" type="file" multiple data-min-file-count="1">
                <br>
                <h3>手持身份证拍照 </h3>	
                <input name="photo3" id="file-0a" class="file" type="file" multiple data-min-file-count="1">
                <br>
                <button type="submit" class="btn btn-primary">提交</button>
                <button type="reset" class="btn btn-default">重置</button>
            </form>

        </div>
		
	</div>
	
	<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/jquery-Upload/js/fileinput.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/jquery-Upload/js/fileinput_locale_zh.js" type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
    <script>

</body>
</html>