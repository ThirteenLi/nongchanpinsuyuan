<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绿色农产品溯源系统</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="${pageContext.request.contextPath}/js/jquery.easing.min.js"></script>
<link href='http://fonts.useso.com/css?family=Raleway:400,100,300,500,700,800,900,600,200' rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Agro Agency Responsive web template, Bootstrap Web Templates, 
								Flat Web Templates, Andriod Compatible web template, 
								Smartphone Compatible web template, free webdesigns for 
								Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); 
	}, false); 
	function hideURLbar(){ 
		window.scrollTo(0,1); 
	} 
</script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},800);
			});
		});
</script>
<script type="text/javascript" 	src="${pageContext.request.contextPath}/js/jquery.smint.js"></script>


<style type="text/css">
	.top-grid-section{
		display: inline;
		
	}
</style>

</head>


<body>
<div id="home" class="banner">
	<div class="container">
		<div class="banner-info">
			<h1>绿色农产品溯源系统</h1>
 			<a class="hvr-shutter-out-vertical button" href="${pageContext.request.contextPath}/Search.jsp">查询</a>	  			
 			<a class="hvr-shutter-out-vertical button" href="${pageContext.request.contextPath}/customer/customerLogin.jsp">登录</a>	 
 			
 			<a id="reg1" class="hvr-shutter-out-vertical button" href="#top-grid">注册</a>	 

		</div>
	 </div>
</div>

<!-- ----------------------------------------------------------------- -->

<div class="navigation" >
	<div class="container">
		<div class="fixed-header">
			<div class="top-menu">
				<ul>
					<li class="active"><a class="scroll" href="#home">主页</a></li>
					<li><a class="scroll" href="#top-grid">用户注册</a></li>
					<li><a class="scroll" href="#about">系统简介</a></li>
					<li><a class="scroll" href="#gallery">精彩图集</a></li>
				</ul>			
			</div>
				
			<div class="clearfix"></div>
		</div>
		
 		
 		<script>
			$("span.menu").click(function(){
				$(".top-menu ul").slideToggle(5000, function(){
				});
			});
		</script>
  
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});		
		</script>


	
	 </div>
</div>

<!-- ----------------------------------------------------------------- -->

<div id="top-grid" class="top-grid" style="margin: 0px;">
	<div class="container">
		<div class="top-grid-section">	
			<div class="col-md-3 top-grids">
				<a id="btn1" href="${pageContext.request.contextPath}/register/customerRegister2.jsp">
					 <span class="icon1" id="btn1"></span>
				</a>
				<h3>消费者注册</h3>
 			</div>
 			
			<div class="col-md-3 top-grids">
				<a id="btn2" href="${pageContext.request.contextPath}/register/farmerRegister.jsp">
					 <span class="icon2" id="btn2"></span>
				</a>
				 <h3>农户注册</h3>
 			</div>
 			
			<div class="col-md-3 top-grids">
				<a id="btn3" href="${pageContext.request.contextPath}/register/agentRegister.jsp">
					 <span class="icon3" id="btn3"></span>
				</a>
				 <h3>代理商注册</h3>
 			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	
</div>

<!-- ----------------------------------------------------------------- -->
   
<div id="about" class="about">
	 <div class="container">
		 <div class="col-md-6 about-pic">
			 <img src="images/trac.jpg" alt=""/>
		 </div>
		 <div class="col-md-6 about-info">
			 <h3>绿色农产品溯源系统</h3>
			 
			 <p>本系统全称绿色农产品溯源系统，由张亚楠老师项目组负责研发。
			 为了能广大消费者吃上放心的农产品，只要在本系统输入溯源码，即可查询到农产品从原产地到货架的所有信息。
			 注册成功后还能享受更多功能。</p>
			 <a class="hvr-bounce-to-bottom" href="#">了解更多</a>
		 </div>
	 </div>
</div>
<div id="gallery" class="portfolio section s2">
	<div class="container portfolio-head">
		<h3>精彩图集</h3>
		<p>为绿色农产品点赞！让我们的食品越来越安全！</p>
	</div>
	
	<script src="js/hover_pack.js"></script>
	<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
	<script type="text/javascript">
		$(function () {
			var filterList = {
				init: function () {
					// MixItUp plugin
					// http://mixitup.io
					$('#portfoliolist').mixitup({
						targetSelector: '.portfolio',
						filterSelector: '.filter',
						effects: ['fade'],
						easing: 'snap',
						// call the hover effect
						onMixEnd: filterList.hoverEffect()
					});				
						
				},
				hoverEffect: function () {
					// Simple parallax effect
					$('#portfoliolist .portfolio').hover(
						function () {
							$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
							$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
						},
						function () {
							$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
							$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
						}		
					);				
						
				}
			};
			// Run the show!
			filterList.init();
		});	
	</script>

	<ul id="filters" class="clearfix">
		<li><span class="filter active" data-filter="app card icon">全部</span></li>
		<li><span class="filter" data-filter="app">种子</span></li>
		<li><span class="filter" data-filter="card">种植</span></li>
		<li><span class="filter" data-filter="icon">发展</span></li>
	</ul>
	<div id="portfoliolist">
		<div class="portfolio app mix_all" data-cat="logo" style="display: inline-block; opacity: 1;">
			<div class="portfolio-wrapper">		
				<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
				<img src="images/p1.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
			</div></a>
		</div>
	</div>				
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p2.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>		
					<div class="portfolio card mix_all" data-cat="web" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p3.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>				
					<div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p4.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>	
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p8.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>			
					<div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p6.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>	
					<div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p7.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>	
					<div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/p5.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="images/link-ico.png" alt=""/></h2>
						  	</div></a>
		                </div>
					</div>		
					<div class="clearfix"> </div>																																					
				</div>
		</div>

		
		
		
		<script src="js/bootstrap.min.js"></script>
	
						<a data-toggle="modal" data-target=".bs-example-modal-md" href="#"> </a>
						<div class="modal fade bs-example-modal-md light-box" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
						  <div class="modal-dialog modal-md">
						    <div class="modal-content light-box-info">
						    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="images/close.png" title="close" /></button>
						     <h3>Place Yours content here</h3>
						     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris egestas orci et blandit dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque posuere diam et est hendrerit, eget sodales lectus tincidunt. Etiam suscipit orci sapien, at molestie lorem imperdiet vitae. Fusce nunc eros, congue non hendrerit sed, lobortis scelerisque magna. Ut in nunc sem. Integer bibendum enim et erat molestie, sed interdum nisl ultricies. In hac habitasse platea dictumst. Nullam sem diam, tincidunt dapibus tellus pulvinar, pulvinar tempus dui. Integer eu faucibus arcu. Duis adipiscing commodo ipsum dapibus elementum.</p>
						    </div>
						  </div>
						</div>
	
		<div  class="testmonials section s3">
			<div class="container">
			<div class="bs-example">
			    <div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
			
			        <ol class="carousel-indicators pagenate-icons">
			            <!-- <li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
			            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			            <li data-target="#myCarousel" data-slide-to="1"></li>
			            <li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
						<li data-target="#myCarousel" data-slide-to="5"></li>

			        </ol>   
			     
			        <div class="carousel-inner">

						<div class="active item">
							<%--<img src="${pageContext.request.contextPath}/images/people1.jpg" />--%>
							<div class="carousel-caption caption">
								<h3>项目组长：李桦杰</h3>
								<p>哈尔滨理工大学本科在读学生。热爱开发软件，</p>
								<p>勤于学习各种软件开发技术。现备战研究生入学考试。 </p>
								<p>研究方向：算法、大数据、各类比赛</p>
							</div>
						</div>
			            <div class="item">
			            <%--   <img src="${pageContext.request.contextPath}/images/people2.jpg" title="name" />--%>
			                <div class="carousel-caption caption">
			                  <h3>核心成员：李宏磊</h3>
			                  <p>哈尔滨理工大学本科在读学生。为人勤奋刻苦，具有较强的学习和团队开发能力。
			                 	 渴望学习更多新的技术。 </p>
			                 <p>研究方向：web前端</p>
			                </div>
			            </div>
			            <div class="item">
			               <%-- <img src="${pageContext.request.contextPath}/images/people4.jpg"  />--%>
			                <div class="carousel-caption caption">
			                  <h3>核心成员：巨延生</h3>
			                  	<p>哈尔滨理工大学本科在读学生。热爱开发软件，</p>
			                  	<p>勤于学习各种软件开发技术。现备战研究生入学考试。 </p>
			                  <p>研究方向：Java,大数据</p>
			                </div>
			            </div>

						<div class="item">
							<%--<img src="${pageContext.request.contextPath}/images/people5.jpg" />--%>
							<div class="carousel-caption caption">
								<h3>核心成员：海栋</h3>
								<p>哈尔滨理工大学本科在读学生。能够完成分配任务。</p>
								<p>勤于学习前端知识。现备战研究生入学考试。 </p>
								<p>研究方向：web前端</p>
							</div>
						</div>
						<div class="item">
							<%--<img src="${pageContext.request.contextPath}/images/people6.jpg" />--%>
							<div class="carousel-caption caption">
								<h3>核心成员：陈昀</h3>
								<p>哈尔滨理工大学本科在读学生。热爱英语</p>
								<p>勤于学习各种软件开发技术。现备战研究生入学考试。 </p>
								<p>研究方向：Java</p>
							</div>
						</div>
						<div class="item">
							<%--<img src="${pageContext.request.contextPath}/images/people7.jpg" />--%>
							<div class="carousel-caption caption">
								<h3>核心成员：赵文瑄</h3>
								<p>哈尔滨理工大学本科在读学生。热爱开发软件</p>
								<p>勤于学习各种软件开发技术。现备战研究生入学考试。 </p>
								<p>研究方向：算法、大数据</p>
							</div>
						</div>
			        </div>
			  
			    </div>
			</div>
		</div>
	</div>

		
		
		
		
		
		
		
		
		
		
</body>
</html>