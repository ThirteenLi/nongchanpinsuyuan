<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<title>绿色农产品溯源系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">


    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.map"></script>
	
	
	<!-- 分页设置 -->
	<script type="text/javascript">
		function changePage(pageNum){
			//1 将页码的值放入对应表单隐藏域中
				$("#currentPageInput").val(pageNum);
			//2 提交表单
				$("#pageForm").submit();
		};
		
		function changePageSize(pageSize){
				//1 将页码的值放入对应表单隐藏域中
				$("#pageSizeInput").val(pageSize);
			//2 提交表单
				$("#pageForm").submit();
		};
	</script>


    
</head>

<body>

	<!-- 顶端部件 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">绿色农产品溯源系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">登录</a></li>
            <li><a href="#">注册</a></li>
            <li><a href="#">查询溯源信息</a></li>
            <li><a href="#">留言板</a></li>
            <li><a href="#">返回</a></li>

          </ul>

        </div>
      </div>
    </nav>

	<!-- 主体表单 -->
    <div class="container-fluid">
      <div class="row">
      
      	<!-- 左侧表单 -->
        <div class="col-sm-3 col-md-2 sidebar" id="lb">
          <ul class="nav nav-sidebar">
            <li><a href="#">登录</a></li>
            <li><a href="#" >注册</a></li>
            <li><a href="#">查询溯源信息</a></li>
            <li><a href="#">管理订单</a></li>
            <li><a href="#">管理个人信息</a></li>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<!-- 主标题 -->
          <h1 class="page-header">您将代理批次号为：${pid}</h1>
          <!-- 圆圈 -->
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
            <a href="${pageContext.request.contextPath }/ProductAction_ApplyToBuy?productId_rep=${pid}&id_dls=${agent1.id_dls}">
            	<img src="${pageContext.request.contextPath }/images/p5.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
           	</a>
              <h4>填写订单</h4>              
            <span class="text-muted">Write Application</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">             
              <a href="${pageContext.request.contextPath }/agent/homepage.jsp">
              	<img src="${pageContext.request.contextPath }/images/p6.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              </a>
              <h4>返回</h4>
              <span class="text-muted">Return</span>
            </div>


          </div>
		
			<!-- 主要内容 -->
          <h2 class="sub-header">您查询的溯源信息如下</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  
                  <th width="18%">时间</th>
                  <th width="18%">商品名称</th>               
                  <th width="13%">商家店名</th>
                  <th width="25%">流经地点</th>
                  <th >价格</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="origin" items="${sessionScope.originList }">
                 	<tr>
                		<td><c:out value="${origin.pickTime }"></c:out></td>
                		<td><c:out value="${origin.productName }"></c:out></td>
                		<td><c:out value="${origin.placeName }"></c:out></td>
                		<td><c:out value="${origin.placeAddress }"></c:out></td>
                		<td><c:out value="${origin.price }"></c:out></td>

                	</tr>               
                </c:forEach>
              </tbody>
            </table>
			
          </div>
          
          
          
          
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath}/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
</body>
</html>