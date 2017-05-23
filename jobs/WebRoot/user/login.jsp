<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link rel="shortcut icon" href="resources/images/favicon.ico" />
<link href="resources/style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery.i18n.properties-1.0.9.js" ></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/md5.js"></script>
<script type="text/javascript" src="resources/js/page_login.js?lang=zh"></script>

<script type="text/javascript">
  function show(){
    document.from1.submit();
  }
	$(function(){
	
/* 	if($("radio").attr("checked")){  
        alert("选中") 
} */

		if($("#usertype radio").attr("checked") == "checked"){
		alert("sa333333333f");
			if($(this).val()=="sysuser"){
				$("#goregist").css("display","none");
			}
		}else{
			$("#goregist").css("display","block");
		}

	});
  	
</script>

<script type="text/javascript">
var code ; //在全局定义验证码   
//产生验证码  
window.onload = function createCode(){  
     code = "";   
     var codeLength = 4;//验证码的长度  
     var checkCode = document.getElementById("code");   
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
     'S','T','U','V','W','X','Y','Z');//随机数  
     for(var i = 0; i < codeLength; i++) {//循环操作  
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
        code += random[index];//根据索引取得随机数加到code上  
    }  
    checkCode.value = code;//把code值赋给验证码  
}  
function createCod(){  
     code = "";   
     var codeLength = 4;//验证码的长度  
     var checkCode = document.getElementById("code");   
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
     'S','T','U','V','W','X','Y','Z');//随机数  
     for(var i = 0; i < codeLength; i++) {//循环操作  
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
        code += random[index];//根据索引取得随机数加到code上  
    }  
    checkCode.value = code;//把code值赋给验证码  
}  
//校验验证码  
function validate(){  
    var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写        
    if(inputCode.length <= 0) { //若输入的验证码长度为0  
        alert("请输入验证码！"); //则弹出请输入验证码  
    }         
    else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
        alert("验证码输入错误！"); //则弹出验证码输入错误  
        createCode();//刷新验证码  
        document.getElementById("input").value = "";//清空文本框  
    }         
}   
    </script>
    
      <style type="text/css">  
            #code  
            {  
                font-family:Arial;  
                font-style:italic;  
                font-weight:bold;  
                border:0;  
                letter-spacing:20px;  
                color:blue;  
            }  
            
            
        </style> 
  </head>
  
  <body>
      <div class="dataEye">
	<div class="loginbox">
		<div class="logo-a">
			<div class="logo-a">
			<a href="index.jsp" title="求职通招聘网">
				<img src="resources/images/logo.png">
			</a>
		</div>
		</div>
		<div class="login-content">
			<div class="loginbox-title">
				<h3>登录</h3>
			</div>
			<form id="signupForm"  action="login" method="post" name="from1">
			<div class="login-error"></div>
			<div class="row">
				<label class="field">用户名</label>
				<input type="text" class="input-text-user input-click" name="oper.OUsername" id="email" value="${oper.OUsername}">
			</div>
			<div class="row">
				<label class="field">密码</label>
				<input type="password" class="input-text-password input-click" name="oper.OPwd" value="${oper.OPwd}" id="password">
			</div>
			<div class="row">
				<input type = "text" id = "input"  onblur="validate()"/>  
                <input type = "button" id="code" onclick="createCode()"/> 
			    <br/><a href="javascript:createCod()">看不清楚换一张</a>
               
			</div>
			<div id="usertype" class="row"><p>类型<input type="radio" name="userclass" checked="checked" value="oper"/>用户<input type="radio" name="userclass" value="sysuser"/>管理员</p></div>
			<div class="row btnArea">
			  
				<a class="login-btn" id="submit" href="javascript:show()">登录</a>
				<!-- <input type = "button" id="submit" class="login-btn" value="登录"/>  -->
			</div>
			
			<div class="row tips">
				
			</div>
			</form>
		</div>
		<div id="goregist" class="go-regist">
			还没有账号？请
			<a href="regist.jsp">立即注册</a>
		</div>
	</div>
	

</div>

  </body>
</html>
