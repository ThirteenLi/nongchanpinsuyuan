/**
 * common.js
 * @author dahaofeng
 * @date 20162-3-7 上午14:20:48
 */
HF = function(){
	return {
		
		simpleKindeditor:function(name,url){
			var editor = null;
			KindEditor.ready(function(K) {
				_uploadJson =url;
				editor = K.create('textarea[name="'+name+'"]', {
					resizeType:1,
					minWidth:300,
					allowPreviewEmoticons:false,
					allowImageUpload : true,
					uploadJson:_uploadJson,
					//下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
					afterBlur: function(){this.sync();},
					items : ['fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					         'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					         'insertunorderedlist','|','image', 'link','source']
					
				});
			});
			return editor;
		},
		
		//提示消息
		alert:function(title,msg,buttonName){
			bootbox.alert({
			    title:title,  
	            buttons: {  
	               ok: {  
	                    label: buttonName,  
	                    className: 'btn-myStyle'  
	                }  
	            },  
	            message: msg,
	            size: 'small',
	            callback: function() {  
	                //alert('关闭了alert');  
	            },  
	            closeButton:true
	        });
		},
		
		//确认消息
		confirm : function(title,msg,btnOKName,btnCanlName,funcOK,funcCanl){
			  bootbox.confirm({  
				    title:title, 
			        buttons: {  
			            confirm: {  
			                label: btnOKName,  
			                className: 'btn-myStyle'
			            },  
			            cancel: {  
			                label: btnCanlName,  
			                className: 'btn-default'
			            }  
			        },  
			        message: msg,  
			        size: 'small',
			        callback: function(result) {  
			            if(result) { 
			            	if(funcOK){
			            		funcOK();  
			            	}else{
			            		bootbox.hideAll();
			            	}
			          
			            }else {  
			            	if(funcCanl){
			            		funcCanl();  
			            	}else{
			            		bootbox.hideAll();
			            	}
			            }  
			        } 
		        });
			 // $(".modal-content").css({"width":"100px","height":"100px"});
        },
        
        
    	//弹窗  bootbox
		openDialog : function(msg,funcOK,callback,width,height){  
	        bootbox.dialog({  
	            message: "I am a custom confirm",  
	            title: "Confirm title",  
	            buttons: {  
	                Cancel: {  
	                    label: "Cancel",  
	                    className: "btn-default",  
	                    callback: function () {  
	                        alert("Cancel");  
	                    }  
	                }  
	                , OK: {  
	                    label: "OK",  
	                    className: "btn-primary",  
	                    callback: function () {  
	                        alert("OK");  
	                    }  
	                }  
	            }  
	        });
		},
		
		/**
		 * ajax提交FORM
		 * 
		 */
		ajaxdoFormSubmit:function(formId) {
			$("body").mask("Waiting...");
			var url = $('#' + formId).attr("action");
			$('#'+formId).ajaxSubmit({
		        url: url,
		        type: 'post',
		        dataType: 'json',
		        success: function(data, status){
	        		HF.alert("提交数据",data.message,"确定");
		        	$("body").unmask();
		        },  
		        error : function errorCallBack(xhr, type, errorThrown){
					console.log("ajax require error code = " + xhr.status + " type= " + type+"errorThrown="+errorThrown);
					HF.alert("提交数据","系统异常","确定");
					$("body").unmask();
				}
			}); 
		},
		
		
		
		// 确认对话框
		confirmx:function(message, href){
			bootbox.confirm({  
			    title:"系统提示", 
		        buttons: {  
		            confirm: {  
		                label: "确定",  
		                className: 'btn-myStyle'
		            },  
		            cancel: {  
		                label: "取消",  
		                className: 'btn-default'
		            }  
		        },  
		        message: message,  
		        size: 'small',
		        callback: function(result) { 
		            if(result) { 
		            	$("body").mask("Waiting...");
		            	location = href;
		            	$("body").unmask();
		            }else {  
	            		bootbox.hideAll();
		            } 
		           
		        } 
	        });
		},
		
		
		deleteData:function(url,datas){
			HF.confirm("删除数据","确定要删除该条数据吗？","确定","取消",function(){
				$("body").mask("Waiting...");
				$.ajax({
					url:url,
					async:false,
					dataType: 'json',
					type: "post",   //请求方式
				    cache:false,  
					data:datas,
					context: document.body,
					success: function(data){
						console.info(data);
						if(data.success){
			        		HF.alert("删除数据",data.message,"确定");
			        		$("form").submit();
			        	}else{
			        		HF.alert("删除数据",data.message,"确定");
			        	}
						$("#body").unmask();
					},
					error : function errorCallBack(xhr, type, errorThrown){
						console.log("ajax require error code = " + xhr.status + " type= " + type+"errorThrown="+errorThrown);
						HF.alert("删除数据","系统异常","确定");
						$("body").unmask();
					}
				});
				
				
			})
		},
		
		 //判断是否为空,如果为空返回true，否则返回false
		 isEmpty : function(text){
			if(text == undefined || text == null || text == '' || text == 'null' || text == 'undefined'){
				return true;
			}else{
				text = text.replace(/(\s*$)/g, '');
				if(text == ''){
					return true;
				}
			}
			return false;
		 },
		 //英文、数字正则表达式，验证通过返回 true；
		 numValid : function(text){
			var patten = new RegExp(/^[0-9]+$/);
			return patten.test(text);
		 },
		 
		 //英文、数字正则表达式
		 enNumValid : function(text){
			var patten = new RegExp(/^[a-zA-Z0-9]+$/);
			return patten.test(text);
		 },
		 
	     //英文、数字、-、_验证
		 cValid : function(text){
			var patten = new RegExp(/^[a-zA-Z][\w-_]{5,19}$/);
			return patten.test(text);
		 },
		 
		 //中文、英文、数字、-、_验证
		 zcValid : function(text){
			var patten = RegExp(/^[\u4E00-\u9FA5A-Za-z0-9_-]+$/);
			return patten.test(text);
		 },
		 //email
		 emailValid : function(text){
			var patten = RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
			return patten.test(text);
		 },
		 
		 
		//解决浏览器缓存
		 timestamp:function(url){
			 var getTimestamp=new Date().getTime();
			 if(url.indexOf("?")>-1){
				 url=url+"&timestamp="+getTimestamp
			 }else{
		        url=url+"?timestamp="+getTimestamp
			 }
			 return url;
	    }
		 
	};
}();


$(function(){
});

