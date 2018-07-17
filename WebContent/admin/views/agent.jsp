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
			$('#w').window('close');  //确保窗口关闭
			
			$('#ff').form({    
			    url:'${pageContext.request.contextPath}/AgentAction_regist',    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;   
			        return true;
			    },    
			    success:function(data){    
			    	$('#w').window('close');
			    	$('#test').datagrid('reload');
			    	$('#ff').form('clear');
			    }    
			});    
			 


			$('#test').datagrid({
				title:'代理商列表',
				singleSelect:true, //只允许单选
				iconCls:'icon-tip',  //表格标题图标
				width:1200,
				height:600,
				nowrap: true,    //较长时是否换行
				striped: true,  //是否隔行变色
				collapsible:false,  //是否折叠表格
				url:'${pageContext.request.contextPath}/AgentAction_list',  //指定表格数据加载路径
				sortName: 'id_dls',  //指定使用哪一列进行排序
				sortOrder: 'desc',
				remoteSort: false,//是否支持远程排序
				idField:'id_dls',//id列
				frozenColumns:[[
	                {field:'ck',checkbox:true},  //是否勾选
	                {title:'代理商号',field:'id_dls',width:155,sortable:true}
				]],
				columns:[[
					{field:'phoneNumber_dls',title:'手机号',width:100},
					{field:'password_dls',title:'密码',width:100},
					{field:'email_dls',title:'邮箱',width:100},
					{field:'IDCardNum_dls',title:'身份证号',width:100},
					{field:'realName_dls',title:'真实姓名',width:100},
					{field:'gender_dls',title:'性别',width:100},
					{field:'pictureIDCF_dls',title:'身份证正面照',width:100},
					{field:'pictureIDCB_dls',title:'身份证反面照',width:100},
					{field:'pictureIDC_dls',title:'手持身份证拍照',width:30},
					{field:'condition_dls',title:'状态',width:30}
					//{field:'col4',title:'密码',width:150,rowspan:2}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{//配置工具栏
					id:'btnadd',
					text:'添加用户',
					//iconCls:'icon-add',
					handler:function(){
						
						$('#btnsave').linkbutton('enable');
						$('#ff').form('clear');
						$('#w').window('open');
					}
				},{
					id:'btncut',
					text:'修改用户',
					//iconCls:'icon-cut',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						//获得被选中id
						var id_dls = getSelected();
						if(!id_dls){
							alert("请选择用户!");
							return;
						}						
						$('#ff').form('load','${pageContext.request.contextPath}/AgentAction_toEdit=?id_dls='+id_dls);
						//打开窗口
						$('#w').window('open');
					}
				},'-',{
					id:'btnsave',
					text:'删除用户',
					disabled:false,
					//iconCls:'icon-save',
					handler:function(){
						$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
						//获得被选中的用户id
						//获得被选中的用户的id
						var id_dls = getSelected();
						//判断id不能为空
						if(!id_dls){
							alert("请选择用户!");
							return;
						}
						//alert(id_cus)
						//调用ajax异步发送请求删除用户
						$.get("${pageContext.request.contextPath}/AgentAction_delete?id_dls="+id_dls, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						});
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
		function resize(){
			$('#test').datagrid('resize', {
				width:700,
				height:400
			});
		}
		
		//获得被选中的
		function getSelected(){
			var selected = $('#test').datagrid('getSelected');
			if (selected){
				return selected.id_dls;
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
		/* id_cus */
	</style>
</head>
<body>
	<table id="test"></table>
	<div id="w" class="easyui-window" title="添加代理商" iconCls="icon-save" style="width:500px;height:500px;padding:5px;">
	<div style="background:#fafafa;padding:10px;width:300px;height:300px;">
	    <form id="ff" method="post" novalidate >
	    	<input type="hidden" name="id_dls">
	        <div >
	            <label class="mylabel1" for="name" >手机号</label>
	            <input class="easyui-validatebox" type="text" name="phoneNumber_dls"></input>
	        </div>
	        <div>
	            <label class="mylabel1" for="name" >真实姓名</label>
	            <input class="easyui-validatebox" type="text" name="realName_dls" ></input>
	        </div>
	       	<div>
	            <label class="mylabel1" for="name">密码</label>
	            <input class="easyui-validatebox" type="password" name="password_dls" id="password_dls"></input>
	        </div>
	        <div>
	        	<label class="mylabel1" for="name">身份证号</label>
	            <input class="easyui-validatebox" type="text" name="IDCardNum_dls"></input>
	        </div>	
	        <div>
	            <label class="mylabel1" for="name">性别</label>
	            <input class="easyui-validatebox" type="text" name="gender_dls" ></input>
	        </div>
	       	<div>
	            <label class="mylabel1" for="name">身份证前面</label>
	            <input class="easyui-validatebox" type="text" name="pictureIDCF_dls"></input>
	        </div>
	       	<div>
	            <label class="mylabel1" for="name">身份证后面</label>
	            <input class="easyui-validatebox" type="text" name="pictureIDCB_dls"></input>
	        </div>
	       	<div>
	            <label class="mylabel1" for="name">手持身份证</label>
	            <input class="easyui-validatebox" type="text" name="pictureIDC_dls"></input>
	        </div>	
	       	<div>
	            <label class="mylabel1" for="name">邮箱</label>
	            <input class="easyui-validatebox" type="text" name="email_dls"></input>
	        </div>	
	       	<div>
	        	<label class="mylabel1" for="name">状态</label>
	            <input class="easyui-validatebox" type="text" name="condition_dls"></input>
	        </div>	        	                
	        <div>
	            <input type="button" value="提交" onclick="submitForm();">
	        </div>
	    </form>
	</div>
	</div>
</body>
</html>