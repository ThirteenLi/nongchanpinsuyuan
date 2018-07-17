$(function(){
	
	
	$("#registForm").validate({
		rules:{
			phoneNumber_nh:{
				required:true,
				minlength:11,
				maxlength:11,
				digits:true
			},
			password_nh:{
				required:true,
				minlength:6
			},
			repassword_nh:{
				required:true,
				equalTo:"[name='password_nh']"
			},
			email_nh:{
				required:true,
				email:true
			},
			realName_nh:{
				required:true
			},
			gender_nh:{
				required:true
			},
			IDCardNum_nh: "isIdCardNo",
			contract_nh:{
				required:true
			},
			
			phoneNumber_cus:{
				required:true,
				minlength:11,
				maxlength:11,
				digits:true
			},
			password_cus:{
				required:true,
				minlength:6
			},
			repassword_cus:{
				required:true,
				equalTo:"[name='password_cus']"
			},				
			email_cus:{
				required:true,
				email:true
			},
			nickName_cus:{
				required:true,
			},
			contrace_cus:{
				required:true,
			}
		},
		messages:{
			phoneNumber_nh:{
				required:"手机号不能为空！",
				minlength:"请正确填写手机号！",
				maxlength:"请正确填写手机号！",
				digits:"请正确填写手机号！"
			},
			password_nh:{
				required:"密码不能为空!",
				minlength:"密码不得少于6位!"
			},
			repassword_nh:{
				required:"确认密码不能为空!",
				equalTo:"两次输入密码不一致!"
			},
			email_nh:{
				required:"邮箱不能为空",
				email:"邮箱格式不正确!"
			},
			realName_nh:{
				required:"姓名不能为空!"
			},
			gender_nh:{
				required:"性别必须勾选!"
			},
			IDCardNum_nh: {
				required: "请正确填写身份证号码",
			},
			contract_nh:{
				required:"如果不接受用户协议则无法成功注册本系统"
			},
			
			phoneNumber_cus:{
				required:"手机号不能为空！",
				minlength:"请正确填写手机号！",
				maxlength:"请正确填写手机号！",
				digits:"请正确填写手机号！"
			},
			password_cus:{
				required:"密码不能为空!",
				minlength:"密码不得少于6位!"
			},
			repassword_cus:{
				required:"确认密码不能为空!",
				equalTo:"两次输入密码不一致!"
			},
			email_cus:{
				required:"邮箱不能为空",
				email:"邮箱格式不正确!"
			},
			nickName_cus:{
				required:"昵称不能为空"
			},
			contrace_cus:{
				required:"如果不接受用户协议则无法成功注册本系统"
			}
		},
		errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
				
	});
	
	
	
	$("#dailogForm").validate({
		rules:{
			name_rep:{
				required:true,
			},
			number_rep:{
				required:true,
				number:true,
			},
			idPlace_rep:{
				required:true,
			},
			buyPrice_rep:{
				required:true,
				number:true,
			},
			buyUnit_rep:{
				required:true,
			},
			sellPrice_rep:{
				required:true,
				number:true,
			},
			sellUnit_rep:{
				required:true,
			},


		},
		
		messages:{
			name_rep:{
				required:"产品名称不能为空！"
			},
			number_rep:{
				required:"数量不能为空！",
				number:"请正确输入产品数量",
			},
			idPlace_rep:{
				required:"请选择农场",
			},
			buyPrice_rep:{
				required:"请放心输入成本价格，系统会严格保密！",
				number:"请正确输入成本价格",
			},
			buyUnit_rep:{
				required:"请输入库存单位",
			},
			sellPrice_rep:{
				required:"请输入售价",
				number:"请正确输入销售价格",
			},
			sellUnit_rep:{
				required:"请输入销售单位",
			},
	
		},
		
		errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
		
		success: function(label) { //验证成功后的执行的回调函数
			//label指向上面那个错误提示信息标签label
			label.text(" ") //清空错误提示消息
			.addClass("success"); //加上自定义的success类
		}
	});

	
	$("#dailogForm31").validate({
		rules:{
			
			buynumber:{
				required:true,
				number:true,
			},
			id_shop:{
				required:true,
			},

		},
		
		messages:{
			
			buynumber:{
				required:"请正确填写",
				number:"请正确填写",
			},
			id_shop:{
				required:"请正确填写",
				
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
