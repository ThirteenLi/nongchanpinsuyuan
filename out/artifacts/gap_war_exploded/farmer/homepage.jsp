<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>绿色农产品溯源系统</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/rs-plugin/css/settings.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/freeze.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr.custom.32033.js"></script>

</head>
<body>
<body>

    <div class="wrapper"> 
        <section id="about">
            <div class="container">
                
                <div class="section-heading scrollpoint sp-effect3">
                    <h1>农户系统</h1>
                    <div class="divider"></div>
                    <p>欢迎</p>${farmer1.realName_nh}
                </div>

                <div class="row">
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="about-item scrollpoint sp-effect2">                       
                            	<a href="${pageContext.request.contextPath}/NongchangAction_list2?id_nh=${farmer1.id_nh}">
                            		<i class="fa fa-edit fa-2x" ></i>
                            	</a>                          
                            <h3>录入信息</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>   
                    
                   <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect5">
                        	<a href="${pageContext.request.contextPath}/ProductAction_NHGetRepository?idOwner_rep=${farmer1.id_nh}">
                            	<i class="fa fa-home fa-2x"></i>
                            </a>
                            <h3>仓库管理</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>        
                              
                    <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect5">                            
                            <a  href="${pageContext.request.contextPath}/NongchangAction_list?id_nh=${farmer1.id_nh}">
                            	<i class="fa fa-tree fa-2x"></i>
                            </a>
                            <h3>农场管理</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                    
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="about-item scrollpoint sp-effect2">
                        	<a href="${pageContext.request.contextPath}/Search.jsp">
                            	<i class="fa fa-search fa-2x"></i>
                            </a>
                            <h3>溯源查询</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                    

                </div>
                
                <div class="row">

                    <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect5">
                        	<a href="${pageContext.request.contextPath}/ApplyAction_FarmerApplyChange?userid=${farmer1.id_nh}">
                            	<i class="fa fa-user fa-2x"></i>
                            </a>
                            <h3>用户设置</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                    
                    <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect1">
                        	<a href="${pageContext.request.contextPath}/farmer/contectAdmin.jsp">
                            	<i class="fa fa-comments fa-2x"></i>
                            </a>
                            
                            <h3>联系客服</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                 
                    <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect5">
                        	<a href="${pageContext.request.contextPath}/OrderAction_searchAllOrder?sellerid=${farmer1.id_nh}">
                            <i class="fa fa-shopping-cart fa-2x"></i>
                            </a>
                            <h3>订单管理</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                    

                    
                    
                    
                    <div class="col-md-3 col-sm-3 col-xs-6" >
                        <div class="about-item scrollpoint sp-effect1">
                            <i class="fa fa-check fa-2x"></i>
                            <h3>质量信息</h3>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                </div>                
            </div>
        </section> 
    </div>
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/placeholdem.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>

</body>
</html>