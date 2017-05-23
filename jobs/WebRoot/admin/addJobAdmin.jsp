<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script async="" src="style/js/analytics.js"></script>
    <script type="text/javascript" async="" src="style/js/conversion.js"></script>
    <script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
    <style type="text/css"></style>
	<meta content="no-siteapp" http-equiv="Cache-Control">
	<link  media="handheld" rel="alternate">
	<!-- end 云适配 -->
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
	<title>求职通职位联动添加</title>
	<meta content="23635710066417756375" property="qc:admins">


<!-- <div class="web_root"  style="display:none">http://www.lagou.com</div> -->
<script type="text/javascript">
	var ctx = "http://www.lagou.com";
	console.log(1);
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="style/js/additional-methods.js"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
	<script type="text/javascript">
		var youdao_conv_id = 271546; 
	</script> 
<script src="../style/js/conv.js" type="text/javascript"></script>
<script src="../style/js/ajaxCross.json" charset="UTF-8"></script>
<script type="text/javascript" src="js/jquery-2.2.2.js"></script>
<script type="text/javascript" src="js/myjs1.js"></script>
<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>

<script type="text/javascript">
  function checkField(){
    var field = document.getElementById("jobField").value;
    if(confirm("是否确认增加？")){
      $.ajax({
            url:"json/checkField",
			data:{"jobField.jfname":field},
			dataType:"json",
			success:function(date){
			  if(date.flg){
			    document.form1.submit();
			  }else{
			    document.getElementById("msg").innerHTML=date.msg;
			  }
			}
    });
    } 
  }
  
  function checkClass(){
    var jobClass = document.getElementById("jobClass").value;
    var field = document.getElementById("field").value;
    if(confirm("是否确认增加？")){
    $.ajax({
            url:"json/checkClass",
			data:{"jobField.jfid":field,"jobClass.jcname":jobClass},
			dataType:"json",
			success:function(date){
			  if(date.flg){
			    document.form2.submit();
			  }else{
			    document.getElementById("msg").innerHTML=date.msg;
			  }
			}
    });
    }
  }
  
  function checkJob(){
    var jobClass = document.getElementById("class").value;
    var job = document.getElementById("jobName").value;
    if(confirm("是否确认增加？")){
    $.ajax({
            url:"json/checkJob",
			data:{"jobClass.jcid":jobClass,"jobName.jnname":job},
			dataType:"json",
			success:function(date){
			  if(date.flg){
			    document.form3.submit();
			  }else{
			    document.getElementById("msg").innerHTML=date.msg;
			  }
			}
    });
    }
  }
</script>
<style type="text/css">
  #msg{color: red;}
</style>
</head>


<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a class="logo" href="selectAllJobInfoIndex">
    			<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
    		</a>
				<ul id="navheader" class="reset">
					<li><a href="selectAllJobInfoIndex">首页</a></li>

					<c:if test="${!empty loginOper}">
						<li><a href="backjob/mycome.jsp">我的公司首页</a></li>
						<li class="current"><a rel="nofollow" href="selectFiled">发布职位</a></li>
					</c:if>
					<c:if test="${!empty loginSysuser}">
						<li class="current"><a rel="nofollow" href="admin/adminIndex.jsp">求职通平台管理系统</a></li>
					</c:if>

				</ul>
				<dl class="collapsible_menu">
					<dt>
						<span>${loginOper.OUsername }${loginSysuser.SUsername }&nbsp;</span> <span class="red dn"
							id="noticeDot-1"></span> <i></i>
					</dt>
					<c:if test="${!empty loginOper}">
						<dd class="btm" style="display: none;">
							<a href="backjob/mycome.jsp">我的公司主页</a>
						</dd>
						<dd style="display: none;">
							<a href="selectFiled">发布求职信息</a>
						</dd>
					</c:if>
					<c:if test="${!empty loginSysuser}">
						<dd style="display: none;">
							<a href="admin/adminIndex.jsp">求职通管理系统</a>
						</dd>
					</c:if>
					<dd class="logout" style="display: none;">
						<a rel="注销" href="logOut">退出</a>
					</dd>
				</dl>

			</div>
    </div><!-- end #header -->
    <div id="container">
                	<div class="sidebar">
          <a class="btn_create current" href="admin/adminIndex.jsp">平台管理系统首页</a>
				<dl class="company_center_aside">
					<dt>公司信息管理</dt>
					<dd>
						<a href="checkCominfo?status=0&comInfo.comName=">待审核企业信息管理</a>
					</dd>
					<dd>
						<a href="checkCominfo?status=1&comInfo.comName=">已审核企业信息管理</a>
					</dd>
					<dd>
						<a href="comlogin?comInfo.comName=&status=">企业登录帐号管理</a>
					</dd>
					
				</dl>
					<dl class="company_center_aside">
					<dt>企业发布职位信息管理</dt>
					<dd>
						<a href="selectUncheckedAdmin?status=0">待审核职位招聘信息管理</a>
					</dd>
					<dd>
						<a href="selectCheckedAdmin?status=1">已审核职位招聘信息管理</a>
					</dd>
				</dl>
				<dl class="company_center_aside">
					<dt>工作检索管理</dt>
					<!--<dd class="current">选中效果  -->
					<dd>
						<a href="selectFieldsAdmin">职位检索管理</a>
					</dd>
					<dd>
						<a href="selectTradeAdmin">行业检索管理</a>
					</dd> 
					
				</dl>
				<c:if test="${loginSysuser.SType=='1' }">
					<dl class="company_center_aside">
					<dt>平台管理员管理</dt>
					<!--<dd class="current">选中效果  -->
					<dd>
						<a href="admin/adminAddSysUser.jsp">添加平台管理员</a>
					</dd>
					<dd>
						<a href="sysUserList">平台管理员账户管理</a>
					</dd> 
					
				</dl>
				</c:if>
				
				
	</div><!-- end .sidebar -->
	
			<div class="content">
			
			<c:if test="${status eq 1}"><form action="addFieldAdmin" method="post" name="form1"></c:if>
			<c:if test="${status eq 2}"><form action="addClassAdmin" method="post" name="form2"></c:if>
		    <c:if test="${status eq 3}"><form action="addJobAdmin" method="post" name="form3"></c:if>
				<dl class="company_center_content">
					<dt>
						<h1>
						<c:if test="${status eq 1}">添加工作领域</c:if>
				        <c:if test="${status eq 2}">添加工作类型</c:if>
				        <c:if test="${status eq 3}">添加工作职位</c:if>
						<span> </span>
						</h1>
					</dt><br/><br/>
			
					<dd>
					<ul class="reset my_jobs">
					  <li>
				         <h3><a>工作领域</a></h3>
					  </li>
					  <li><br/>
					  
					    <c:if test="${status eq 1}">
					      <input type="text" name="jobField.jfname" id="jobField">&nbsp;&nbsp;&nbsp;&nbsp;
					      <input type="button" value="添加" onclick="checkField()"><div id="msg"></div>
					    </c:if>
					    
					    <c:if test="${status ne 1}">
					    <select id="field" name="jobField.jfid">
					      <c:forEach items="${fields}" var="f">
					        <option value="${f.jfid}"><c:out value="${f.jfname}"></c:out></option>
					      </c:forEach>
					    </select>
					    </c:if>
					  </li><li><br/></li>
					</ul>
					</dd>
					
					<c:if test="${status ne 1}">
					<div align="center"><img src="images/next.jpg" height="30px" width="200px"></div>
					
					<dd>
					<ul class="reset my_jobs">
					  <li>
				         <h3><a>工作类型</a></h3>
					  </li>
					  <li><br/>
					    <c:if test="${status eq 2}">
					      <input type="text" name="jobClass.jcname" id="jobClass">&nbsp;&nbsp;&nbsp;&nbsp;
					      <input type="button" value="添加" onclick="checkClass()"><div id="msg"></div>
					    </c:if>
					    
					    <c:if test="${status ne 2}">
					    <select id="class" name="jobClass.jcid">
					      <c:forEach items="${jobClasses}" var="c">
					        <option value="${c.jcid}"><c:out value="${c.jcname}"></c:out></option>
					      </c:forEach>
					    </select>
					    </c:if>
					  </li><li><br/></li>
					</ul>
					</dd>
					</c:if>
					
					
					<c:if test="${status eq 3}">
					<div align="center"><img src="images/next.jpg" height="30px" width="200px"></div>
					<dd>
					<ul class="reset my_jobs">
					  <li>
				         <h3><a>工作职位</a></h3>
					  </li>
					  <li><br/>
					    <input type="text" name="jobName.jnname" id="jobName">&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="button" value="添加" onclick="checkJob()"><div id="msg"></div>
					  </li><li><br/></li>
					</ul>
					</dd><br/></c:if>
					
				</dl>
			  <c:if test="${status eq 1}"><form/></c:if>
			  <c:if test="${status eq 2}"><form/></c:if>
		      <c:if test="${status eq 3}"><form/></c:if>
			</div>
			<!-- end .content -->
<script src="style/js/job_list.min.js" type="text/javascript"></script> 
			<div class="clear"></div>
			<input type="hidden" value="74fb1ce14ebf4e2495270b0fbad64704" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="about.html">联系我们</a>
		    <a target="_blank" href="http://www.lagou.com/af/zhaopin.html">互联网公司导航</a>
		    
			<div class="copyright">&copy;2017 Three Team <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备99999999号-1</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>
<script src="style/js/tongji.js" type="text/javascript"></script>
<!--  -->
<script src="style/js/analytics01.js" type="text/javascript"></script><script type="text/javascript" src="style/js/h.js"></script>
<script type="text/javascript">
$(function(){
	$('#noticeDot-1').hide();
	$('#noticeTip a.closeNT').click(function(){
		$(this).parent().hide();
	});
});
var index = Math.floor(Math.random() * 2);
var ipArray = new Array('42.62.79.226','42.62.79.227');
var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
var CallCenter = {
		init:function(url){
			var _websocket = new WebSocket(url);
			_websocket.onopen = function(evt) {
				console.log("Connected to WebSocket server.");
			};
			_websocket.onclose = function(evt) {
				console.log("Disconnected");
			};
			_websocket.onmessage = function(evt) {
				//alert(evt.data);
				var notice = jQuery.parseJSON(evt.data);
				if(notice.status[0] == 0){
					$('#noticeDot-0').hide();
					$('#noticeTip').hide();
					$('#noticeNo').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}else{
					$('#noticeDot-0').show();
					$('#noticeTip strong').text(notice.status[0]);
					$('#noticeTip').show();
					$('#noticeNo').text('('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text(' ('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}
				$('#noticeDot-1').hide();
			};
			_websocket.onerror = function(evt) {
				console.log('Error occured: ' + evt);
			};
		}
};
CallCenter.init(url);
</script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body>
