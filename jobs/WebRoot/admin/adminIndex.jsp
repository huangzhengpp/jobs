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
	<title>求职通平台管理首页</title>
	<meta content="23635710066417756375" property="qc:admins">


<!-- <div class="web_root"  style="display:none">http://www.lagou.com</div> -->

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
<script src="../style/js/ajaxCross.json" charset="UTF-8"></script></head>
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
	<c:if test="${!empty loginSysuser}"><li class="current"><a rel="nofollow" href="admin/adminIndex.jsp">求职通平台管理系统</a></li></c:if>
	
</ul>
<dl class="collapsible_menu">
	<dt>
			<span>${loginOper.OUsername }${loginSysuser.SUsername }&nbsp;</span> 
			<span class="red dn"
			id="noticeDot-1"></span> <i></i>
	</dt>
	<c:if test="${!empty loginOper}">
		<dd class="btm" style="display: none;"><a href="backjob/mycome.jsp">我的公司主页</a></dd>
		<dd style="display: none;"><a href="selectFiled">发布求职信息</a></dd>
	</c:if>
	<c:if test="${!empty loginSysuser}">
		<dd style="display: none;"><a href="admin/adminIndex.jsp">求职通管理系统</a></dd>
	</c:if>
	<dd class="logout" style="display: none;"><a rel="注销" href="logOut">退出</a></dd>
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
        
        
  </div>
	<!-- end .sidebar -->
			<div class="content">
				<dl class="company_center_content">
					<dt>
						<h1>
							待处理事项<span> </span>
						</h1>
					</dt>
					<dd>
						<form id="searchForm">
							<input type="hidden" value="Publish" name="type">
							<ul id="gaoji" class="reset my_jobs">
								<li data-id="149594">
									<h3>
										<a target="_blank" title="随便写"
											href="http://www.lagou.com/jobs/149594.html">审核公司信息</a> <span>数量(5)</span>
									</h3> <span class="receivedResumeNo"><a
										href="unHandleResumes.html?positionId=149594">应聘简历（1）</a></span>
									<div>兼职 / 1k-2k / 1-3年 / 硕士及以上</div>
									<div class="c9">发布时间： 2014-07-01 17:07:01</div>
									<div class="links">
										<a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a>
										<a target="_blank" class="job_edit"
											href="create.html?positionId=149594">编辑</a> <a
											class="job_offline" href="javascript:void(0)">下线</a> <a
											class="job_del" href="javascript:void(0)">删除</a>
									</div>
								</li>
							</ul>
						</form>
					</dd>
					<dd>
						<form id="searchForm">
							<input type="hidden" value="Publish" name="type">
							<ul class="reset my_jobs">
								<li data-id="149594">
									<h3>
										<a target="_blank" title="随便写"
											href="http://www.lagou.com/jobs/149594.html">审核发布职位信息</a> <span>数量(15)</span>
									</h3> <span class="receivedResumeNo"><a
										href="unHandleResumes.html?positionId=149594">应聘简历（1）</a></span>
									<div>兼职 / 1k-2k / 1-3年 / 硕士及以上</div>
									<div class="c9">发布时间： 2014-07-01 17:07:01</div>
									<div class="links">
										<a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a>
										<a target="_blank" class="job_edit"
											href="create.html?positionId=149594">编辑</a> <a
											class="job_offline" href="javascript:void(0)">下线</a> <a
											class="job_del" href="javascript:void(0)">删除</a>
									</div>
								</li>
							</ul>
						</form>
					</dd>
					<dd>
						<form id="searchForm">
							<input type="hidden" value="Publish" name="type">
							<ul class="reset my_jobs">
								<li data-id="149594">
									<h3>
										<a href="javascript(false)">高级查询</a>
									</h3> 
									<div>
									名称模糊查询：<input type="text" width="30">
									
									
									</div>
									<div class="c9">发布时间： 2014-07-01 17:07:01</div>
									<div class="links">
										<a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a>
										<a target="_blank" class="job_edit"
											href="create.html?positionId=149594">编辑</a> <a
											class="job_offline" href="javascript:void(0)">下线</a> <a
											class="job_del" href="javascript:void(0)">删除</a>
									</div>
								</li>
							</ul>
						</form>
						<br>
					</dd>
				</dl>
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