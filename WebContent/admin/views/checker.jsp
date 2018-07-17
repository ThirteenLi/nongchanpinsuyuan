<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script>
		function submitForm() {
			// submit the form    
			$('#ff').submit(); 
		}
		$(function(){
			//确保窗口关闭
			$('#w').window('close');  
			
			$('#ff').form({    
			    url:'${pageContext.request.contextPath}/CheckerAction_regist',    
			    onSubmit: function(){    
			        return true;
			    },    
			    success:function(data){    
			    	$('#w').window('close');
			    	$('#test').datagrid('reload');
			    	$('#ff').form('clear');
			    }    
			});    
			 
			//数据表格
			$('#test').datagrid({
				url:'${pageContext.request.contextPath}/CheckerAction_list',  //指定表格数据加载路径
				title:'质检员列表',    //表格标题
				singleSelect:true,   //只允许单选
				iconCls:'icon-tip',  //表格标题图标
				width:823,           //数据表格宽度
				height:390,          //数据表格高度
				nowrap: true,        //较长时是否换行
				striped: true,       //是否隔行变色
				collapsible:false,   //是否折叠表格				
				sortName: 'id_zjy',  //指定使用哪一列进行排序
				sortOrder: 'asc',    //升序或降序
				remoteSort: false,   //是否支持远程排序
				idField:'id_zjy',    //id列
				pagination:true,     //分页栏
				rownumbers:true,     //列名
				//冻结列
				frozenColumns:[[
	                {field:'ck',checkbox:true},  //是否勾选
	                {title:'质检员号',field:'id_zjy',width:155,sortable:true}
				]],
				//列属性
				columns:[[
					{field:'username_zjy',title:'用户名',width:100},
					{field:'realName_zjy',title:'真实姓名',width:100},
					{field:'phone_zjy',title:'联系电话',width:230},
					{field:'qq_zjy',title:'QQ微信',width:120},
					{field:'condition_zjy',title:'用户状态',width: 55},
				]],

				//设置工具栏属性
				toolbar:[
				'-',
				{
					id:'btnadd',
					text:'添加用户',
					handler:function(){
						
						$('#btnsave').linkbutton('enable');
						$('#ff').form('clear');
						$('#w').window('open');
					}
				}
				,'-',
				{
					id:'btncut',
					text:'修改用户',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						//获得被选中id
						var id_zjy = getSelected();
						if(!id_zjy){
							alert("请选择用户!");
							return;
						}						
						$('#ff').form('load','${pageContext.request.contextPath}/CheckerAction_toEdit=?id_zjy='+id_zjy);
						//打开窗口
						$('#w').window('open');
					}
				}
				,'-',
				{
					id:'btnsave',
					text:'删除用户',
					disabled:false,
					handler:function(){
						$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
						//获得被选中的用户id
						var id_zjy = getSelected();
						//判断id不能为空
						if(!id_zjy){
							alert("请选择用户!");
							return;
						}
						//alert(id_zjy)
						//调用ajax异步发送请求删除用户
						$.get("${pageContext.request.contextPath}/CheckerAction_delete?id_zjy="+id_zjy, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						});
					}
				}
				,'-',
				{
					id:'btnsave',
					text:'快速激活',
					disabled:false,
					handler:function(){
						$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
						//获得被选中的用户id
						//获得被选中的用户的id
						var id_zjy = getSelected();
						//判断id不能为空
						if(!id_zjy){
							alert("请选择用户!");
							return;
						}
						//alert(id_zjy)
						//调用ajax异步发送请求激活用户
						$.get("${pageContext.request.contextPath}/CheckerAction_openAuthorization?id_zjy="+id_zjy, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						});
					}
				}
				,'-',
				{
					id:'btnsave',
					text:'查看详情',
					disabled:false,
					handler:function(){
						//点击后按钮是否可以继续点击
						$('#btnsave').linkbutton('enable');
						
						//获得被选中的用户id
						var id_zjy = getSelected();
						//判断id不能为空
						if(!id_zjy){
							alert("请选择用户!");
							return;
						}
						//alert(id_zjy)
						//调用ajax异步发送请求删除用户
						$.get("${pageContext.request.contextPath}/CheckerAction_delete?id_zjy="+id_zjy, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						});
					}
				},'-']
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
		
		//获得被选中的
		function getSelected(){
			var selected = $('#test').datagrid('getSelected');
			if (selected){
				return selected.id_zjy;
			}
		}
		
		function getSelections(){
			var ids = [];
			var rows = $('#test').datagrid('getSelections');
			for(var i=0;i<rows.length;i++){
				ids.push(rows[i].code);
			}
			alert(ids.join(':'));
		}
		function clearSelections(){
			$('#test').datagrid('clearSelections');
		}
		function selectRow(){
			$('#test').datagrid('selectRow',2);
		}
		function selectRecord(){
			$('#test').datagrid('selectRecord','002');
		}
		function unselectRow(){
			$('#test').datagrid('unselectRow',2);
		}
		function mergeCells(){
			$('#test').datagrid('mergeCells',{
				index:2,
				field:'addr',
				rowspan:2,
				colspan:2
			});
		}
	</script>
	
	<style type="text/css">
		label{
			width:60px;
			display: inline-block;
		}
		/* id_zjy */
		.inputdiv{
			margin: 10px;
		}
		#mm{
			width: 30px;
			height: 100px;
		}
		#box_relative1 {
		  position: relative;
		  top:-150px;
		}
		#box_relative2 {
		  position: relative;
		  top:-140px;
		}
		#box_relative3 {
		  position: relative;
		  top:-130px;
		}
		#box_relative4 {
		  position: relative;
		  top:-120px;
		}
		#box_relative5 {
		  position: relative;
		  top:-110px;
		}
		#box_relative6 {
		  position: relative;
		  top:-100px;
		}	
		#box_relative7 {
		  position: relative;
		  top:-90px;
		}		
	</style>
</head>


<body>
	
	<label style="width:120px;">请输入相关查询条件</label>
	<input class="easyui-searchbox" data-options="prompt:'请输入查询条件',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm" style="width: 60px; height: 230px;">
		<div id="box_relative1" data-options="name:'phoneNumber_zjy'">手机</div>
		<div id="box_relative2" data-options="name:'id_zjy'">序号</div>
		<div id="box_relative3" data-options="name:'nickName_zjy'">昵称</div>
		<div id="box_relative4" data-options="name:'address_zjy'">地址</div>
		<div id="box_relative5" data-options="name:'gender_zjy'">性别</div>
		<div id="box_relative6" data-options="name:'email_zjy'">邮箱</div>
		<div id="box_relative7" data-options="name:'condition_zjy'">状态</div>
	</div>
	<script>
		function doSearch(value,name){
			//alert('You input: ' + value+'('+name+')');
			$('#test').datagrid({
				title:'搜索结果'
			});
		}
	</script>
	<div style="margin:20px 0;"></div>
	
	
	<!-- 表单主体 -->
	<table id="test"></table>
	
	
	
	
	<div id="w" class="easyui-window" title="添加质检员" iconCls="icon-add" style="width:375px;height:365px;padding:5px;">
	<div style="background:#fafafa;padding:10px;width:330px;height:300px;">
	    <form id="ff" method="post" novalidate >
	    	<input type="hidden" name="id_zjy">
	        <div class="inputdiv">
	            <label class="mylabel1" for="name" >用户名</label>
	            <input class="easyui-validatebox" type="text" name="username_zjy" style="width:100px;"></input>
	        </div>
	        <div class="inputdiv">
	            <label class="mylabel1" for="name" >密码</label>
	            <input class="easyui-validatebox" type="text" name="password_zjy" style="width:210px;"></input>
	        </div>
	        <div class="inputdiv">
	        	<label class="mylabel1" for="name">真实姓名</label>
	            <input class="easyui-validatebox" type="text" name="realName_zjy" style="width:210px;"></input>
	        </div>	
	
	       	<div class="inputdiv">
	            <label class="mylabel1" for="name">联系电话</label>
	            <input class="easyui-validatebox" type="text" name="phone_zjy"></input>
	        </div>
	        	       	<div class="inputdiv">
	            <label class="mylabel1" for="name">QQ微信</label>
	            <input class="easyui-validatebox" type="text" name="qq_zjy"></input>
	        </div>	
	       	<div class="inputdiv">
	        	<label class="mylabel1" for="name">状态</label>
	            <input type="radio" name="condition_zjy"  value="1" checked="checked">激活
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="radio" name="condition_zjy"  value="0">禁用
	        </div>	
	       	<div class="inputdiv"><label class="mylabel1" for="name">&nbsp;&nbsp;</label></div>    
	       	<div class="inputdiv"><label class="mylabel1" for="name">&nbsp;&nbsp;</label></div>     	                
	        <div class="inputdiv">
	            <input type="button" value="提交" onclick="submitForm();">
	        </div>
	    </form>
	</div>
	</div>
</body>
</html>