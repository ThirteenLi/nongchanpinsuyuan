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
			    url:'${pageContext.request.contextPath}/QualityAction_regist',    
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
				url:'${pageContext.request.contextPath}/QualityAction_list',  //指定表格数据加载路径
				title:'质检员列表',    //表格标题
				singleSelect:true,   //只允许单选
				iconCls:'icon-tip',  //表格标题图标
				width:823,           //数据表格宽度
				height:390,          //数据表格高度
				nowrap: true,        //较长时是否换行
				striped: true,       //是否隔行变色
				collapsible:false,   //是否折叠表格				
				sortName: 'id_zl',  //指定使用哪一列进行排序
				sortOrder: 'asc',    //升序或降序
				remoteSort: false,   //是否支持远程排序
				idField:'id_zl',    //id列
				pagination:true,     //分页栏
				rownumbers:true,     //列名
				//冻结列
				frozenColumns:[[
	                {field:'ck',checkbox:true},  //是否勾选
	                {title:'质量信息号',field:'id_zl',width:155,sortable:true}
				]],
				//列属性
				columns:[[
					{field:'id_pro',title:'产品号',width:130},
					{field:'ny',title:'农药残留量',width:80},
					{field:'harm',title:'有害物质含量',width:80},
					{field:'yjw',title:'总评分',width:80},
				]],

				//设置工具栏属性
				toolbar:[
				'-',
				{
					id:'btnadd',
					text:'添加质量信息',
					handler:function(){
						
						$('#btnsave').linkbutton('enable');
						$('#ff').form('clear');
						$('#w').window('open');
					}
				}
				,'-',
				{
					id:'btncut',
					text:'修改质量信息',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						//获得被选中id
						var id_zl = getSelected();
						if(!id_zl){
							alert("请选择用户!");
							return;
						}						
						$('#ff').form('load','${pageContext.request.contextPath}/QualityAction_toEdit=?id_zl='+id_zl);
						//打开窗口
						$('#w').window('open');
					}
				}
				,'-',
				{
					id:'btnsave',
					text:'删除质量信息',
					disabled:false,
					handler:function(){
						$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
						//获得被选中的用户id
						var id_zl = getSelected();
						//判断id不能为空
						if(!id_zl){
							alert("请选择用户!");
							return;
						}
						//alert(id_zl)
						//调用ajax异步发送请求删除用户
						$.get("${pageContext.request.contextPath}/QualityAction_delete?id_zl="+id_zl, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						});
					}
				}
			,'-']
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
				return selected.id_zl;
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
		/* id_zl */
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
   
	
	
	<!-- 表单主体 -->
	<table id="test"></table>

	
	<div id="w" class="easyui-window" title="添加质量信息" iconCls="icon-add" style="width:375px;height:365px;padding:5px;">
	<div style="background:#fafafa;padding:10px;width:330px;height:300px;">
	    <form id="ff" method="post" novalidate >
	    	<input type="hidden" name="id_zl">
	        <div class="inputdiv">
	            <label class="mylabel1" for="name" >产品号</label>
	            <input class="easyui-validatebox" type="text" name="id_pro" style="width:100px;"></input>
	        </div>
	        <div class="inputdiv">
	            <label class="mylabel1" for="name" >农药残留量</label>
	            <input class="easyui-validatebox" type="text" name="ny" style="width:210px;"></input>
	        </div>
	        <div class="inputdiv">
	        	<label class="mylabel1" for="name">有害物质含量</label>
	            <input class="easyui-validatebox" type="text" name="harm" style="width:210px;"></input>
	        </div>	
	
	       	<div class="inputdiv">
	            <label class="mylabel1" for="name">质量总评分</label>
	            <input class="easyui-validatebox" type="text" name="yjw"></input>
	        </div>

     	                
	        <div class="inputdiv">
	            <input type="button" value="提交" onclick="submitForm();">
	        </div>
	    </form>
	</div>  
	</div>
</body>
</html>