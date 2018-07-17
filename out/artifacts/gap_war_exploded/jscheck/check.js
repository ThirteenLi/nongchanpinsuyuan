$(function(){

	$("#dailogForm2").validate({
		rules:{		
			name_ncfarm:{
				required:true,
			},
			address_ncfarm:{
				required:true,
			},
			area_ncfarm:{
				required:true,
				number:true,
			},
			areaUnit_ncfarm:{
				required:true,
			},		
			traffic_ncfarm:{
				required:true,
			},
			mainProduct_ncfarm:{
				required:true,
			},
		},
		
		messages:{

			name_ncfarm:{
				required:"请正确填写农场名",
			},
			address_ncfarm:{
				required:"请正确填写农场地址",
			},
			area_ncfarm:{
				required:"请正确填写农场面积",
				number:"请正确填写农场面积",
			},
			areaUnit_ncfarm:{
				required:"请正确填写农场面积计量单位",
			},		
			traffic_ncfarm:{
				required:"请正确填写前往农场的方式",
			},
			mainProduct_ncfarm:{
				required:"请正确填写主要作物",
			},
		},
		
		errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
		
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
	});
	
	

	
	
	$("#dailogForm3").validate({
		rules:{		
			userapply:{
				required:true,
			},
		},		
		messages:{
			userapply:{
				required:"请正确填写你的申请！",
			},
		},
		
		errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
		
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
	});
	
	
	
	
	
	
	$("#dailogForm4").validate({
		rules:{		
			newPassword:{
				required:true,
				minlength:6,
			},
			renewPassword:{
				required:true,
				equalTo:"[name='newPassword']"
			},
		},		
		messages:{
			newPassword:{
				required:"该项必须填写！",
				minlength:"密码不得少于6位!",
			},
			renewPassword:{
				required:"该项必须填写！",
				equalTo:"两次输入密码不一致!"
			},
		},
		
		errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
		
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
	});
	
});
