<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link type="text/css" href="themes/css/v3/reset.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/public.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/register.css" rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico" />
<script src="themes/js/jquery.min.js" type="text/javascript"></script>
<script src="themes/js/jquery.form.js" type="text/javascript"></script>
<script src="themes/js/json.parse.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$(".btn").click(function(){
				var agreenMent=$("#agreement").attr("data");
				
				//alert(agreenMent);0
				var userName= $("#username").val();
				var userPass= $("#password1").val();
				var userPass2=$("#password2").val();
				var userEmail=$("#mail").val();
				var vercode =$("#varcode").val();
				
				userPass=$.trim(userPass);
				userPass2=$.trim(userPass2);
				
				$(".input_div1 span,.input_div2 span,.input_div3 span,.input_div4 span,.input_div6 span,.input_div5 span").html("");
				//$(".btn").val('注册中...').attr('disabled','disabled');
				
				if(!isRegisterUserName(userName)){
					$(".input_div1 span").html('<img src="themes/images/v3/text_error.png"><font color=red>账户名格式不正确!</font>');
					$("#username").focus();
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(!isEmail(userEmail)){
					$(".input_div2 span").html('<img src="themes/images/v3/text_error.png"><font color=red>邮箱格式不正确!</font>');
					$("#mail").focus();
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(userPass.length <8){
					$(".input_div3 span").html('<img src="themes/images/v3/text_error.png"><font color=red>密码格式不正确!</font>');
					$("#password1").focus();
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(userPass != userPass2){
					$(".input_div4 span").html('<img src="themes/images/v3/text_error.png"><font color=red>两次输入的密码不一致!</font>');
					$("#password2").focus();
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				} else if(vercode ==''){
					$(".input_div5 span").html('<img src="themes/images/v3/text_error.png"><font color=red>输入图片验证码</font>').fadeIn();
					$("#varcode").focus();
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				} else if(agreenMent != '1'){
					//$(".agreenment-tips").html('请先同意用户条款!').fadeIn();
					$(".input_div6 span").html('<img src="themes/images/v3/text_error.png"><font color=red>请先同意用户条款!</font>');
					//$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else{
					document.getElementById("oper").style.display="none";
					document.getElementById("l1").className="li2";
					document.getElementById("l2").className="li1";
					
					document.getElementById("comInfo").style.display="block";
				}
				
		})
	
	$(".change").click(function(){
		$("#imgcode").attr('src','vercode');
	})
	
	$('.check2').click(function(){
		var rel = $('#agreement').attr("data");
		//alert(rel);
		if(rel =='1'){
			$('#agreement').attr("data","0");
		}else{
			$('#agreement').attr("data","1");
		}
		$('.check2').toggleClass("check1");
	});
	
});

function isRegisterUserName(s){  
	var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[._]){5,19}$/;  
	if (!patrn.exec(s)) return false
	return true
}

function isEmail(email){
	   var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	   if(!myreg.test(email)) return false;
		return true; 
 }

</script>
<style>
.input_div span{ background:#FFF;}
</style>
<script language="javascript" >
function change(){
 var obj=document.getElementById("ChildMenu1");
if(obj.style.display=='none'){
obj.style.display='block';
}else{
obj.style.display='none';
}
}

</script>
  </head>
  
  <body>
          	<div id="header">
		<div class="header">
			<h1 class="png_bg">求职通招聘网</h1>
		
			<a class="png_bg" href="">返回主页</a>
		</div>
	</div>
	
	<div class="register_content">
	
		 <ul class="step_ul step1 clear">
			<li id="l1" class="li1">01、填写登录账户信息</li>
			<li id="l2" class="li2">02、填写公司信息</li>
		</ul>
		
		 <form name="registerForm" id='registerForm' action="register/ldo" method="post" style="padding:60px 40px 88px 40px;font-family:Microsoft Yahei" enctype="multipart/from-data">
			<div id="oper">
			<div class="div_form clear ">
				<label>账户名：</label>
				<div class="input_div input_div1">
					<input id="username" name="username" type="text" placeholder="格式6-24位数字字母组合" maxlength="24">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>常用的邮箱帐号：</label>
				<div class="input_div input_div2" >
					<input id="mail" name="useremail"  type="text" placeholder="请填写正确的邮箱，以便接收账号激活邮件" maxlength="64">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>请创建一个密码：</label>
				<div class="input_div input_div3">
					<input id="password1" name="userpass" type="password" placeholder="最少 8 个字符，区分大小写" maxlength="32">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>重新输入密码：</label>
				<div class="input_div input_div4">
					<input id="password2" name="userpass2" type="password" placeholder="再次输入密码" maxlength="32">
					<span></span>
				</div>
			</div>
			
			<div class="div_form clear ">
				<label></label>
				<div class="input_div check2 input_div6" data="0" id="agreement">
					我已阅读并接受《JS代码网用户服务协议》
                    <span></span>
				</div>
			</div>
            
			<div class="div_form clear ">
				<label></label>
				<div class="input_div">
					<input id="btn" class="btn" type="button" value="下一步" />
				</div>
			</div>
			</div>
			
			
			
			<!--  公司信息   -->
			
			<div id="comInfo" style="display:none;">
			<div class="div_form clear ">
				<label>账户名：</label>
				<div class="input_div input_div1">
					<input id="username" name="username" type="text" placeholder="格式6-24位数字字母组合" maxlength="24">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>常用的邮箱帐号：</label>
				<div class="input_div input_div2" >
					<input id="mail" name="useremail"  type="text" placeholder="请填写正确的邮箱，以便接收账号激活邮件" maxlength="64">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>请创建一个密码：</label>
				<div class="input_div input_div3">
					<input id="password1" name="userpass" type="password" placeholder="最少 8 个字符，区分大小写" maxlength="32">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>重新输入密码：</label>
				<div class="input_div input_div4">
					<input id="password2" name="userpass2" type="password" placeholder="再次输入密码" maxlength="32">
					<span></span>
				</div>
			</div>
			
			<div class="div_form clear ">
				<label></label>
				<div class="input_div check2 input_div6" data="0" id="agreement">
					我已阅读并接受《JS代码网用户服务协议》
                    <span></span>
				</div>
			</div>
            
			<div class="div_form clear ">
				<label></label>
				<div class="input_div">
					<input id="btn" class="btn" type="button" value="注册" />
				</div>
			</div>
			</div>
		</form>
		
		<div class="reg_login">
			<p>已有帐号？</p>
			<a class="btn2" href="login">登录</a>
		</div>
		<div class="bg"></div>
	</div>
  </body>
</html>
