<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script async="" src="style/js/analytics.js"></script>
<script type="text/javascript" async="" src="style/js/conversion.js"></script>
<script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
<style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta content="23635710066417756375" property="qc:admins">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<script type="text/javascript">
var ctx = "http://www.lagou.com";
console.log(1);
</script>
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
<script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script>


  
  <body>
<div id="body">
<div id="header">
<div class="wrapper">
<a class="logo" href="http://www.lagou.com/">
<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
</a>
<ul id="navheader" class="reset">
<li><a href="index.html">首页</a></li>
<li><a href="companylist.html">公司</a></li>
<li><a target="_blank" href="http://www.lagou.com/toForum.html">论坛</a></li>
<li><a rel="nofollow" href="jianli.html">我的简历</a></li>
</ul>
<dl class="collapsible_menu">
<dt>
<span>jason&nbsp;</span> 
<span class="red" id="noticeDot-0"></span>
<i></i>
</dt>
<dd><a rel="nofollow" href="jianli.html">我的简历</a></dd>
<dd><a href="collections.html">我收藏的职位</a></dd>
<dd><a href="delivery.html">我投递的职位 <span id="noticeNo" class="red">(1)</span></a></dd>
<dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
<dd><a href="create.html">我要招人</a></dd>
<dd><a href="accountBind.html">帐号设置</a></dd>
<dd class="logout"><a rel="nofollow" href="login.html">退出</a></dd>
</dl>
<div id="noticeTip">
<span class="bot"></span>
<span class="top"></span>
<a target="_blank" href="delivery.html"><strong>1</strong>条新投递反馈</a>
<a class="closeNT" href="javascript:;"></a>
</div>
</div>
</div><!-- end #header -->
<div id="container">
<div class="sidebar">
<a class="btn_create" href="create.html">发布新职位</a>

<dl class="company_center_aside">
<dt>我发布的职位</dt>
<dd class="current">
<a href="positions.html">有效职位</a>
</dd>
<dd>
<a href="positions.html">已下线职位</a>
</dd>
<dd>
<a href="positions.html">待审核职位</a>
</dd>
</dl>
</div><!-- end .sidebar -->
<div class="content">
<dl class="company_center_content">
<dt>
<h1>
<em></em>
有效职位 <span>（共<i style="color:#fff;font-style:normal" id="positionNumber">${pageSize }</i>个）</span>                        </h1>
</dt>
<dd>
<c:forEach items="${jobList }" var="jobList">
<form id="searchForm">
			<input type="hidden" value="Publish" name="type">
			<ul class="reset my_jobs">
				<li data-id="149594">

					<h3>
						<a target="_blank" title="随便写" href="#">${jobList.jobName.jnname}</a> 
						<span>[${jobList.jiAddr}]</span>
					</h3>

					<span class="receivedResumeNo"><a href="unHandleResumes.html?positionId=149594"></a></span>
					<div>兼职${jobList.jiPro} / ${jobList.jiSal} / 1-3年 /${jobList.jiEdu}</div>
					<div class="c9">${jobList.jiReledate}</div>
					<div class="links">
						<a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a>
						<a class="job_offline" href="downLine?id=${jobList.jiid }">下线</a>                      
					</div>
				</li>
			</ul>
</form>
</c:forEach>

<div class="Pagination myself" id="">
	<a title="1" >首页</a>
	<a title="上一页" href="findAllJobInfo?pageNo=2">下一页 </a>
	<a title="2" href="findAllJobInfo?pageNo=1" >1</a>
	<a title="2" href="findAllJobInfo?pageNo=2" >2</a>
	<a title="3" href="findAllJobInfo?pageNo=3">3</a>
	<a title="4" href="findAllJobInfo?pageNo=4">4</a>
	<a title="5" href="findAllJobInfo?pageNo=5">5</a>
	<a title="下一页" >下一页 </a>
	<a title="5" href="findAllJobInfo?pageNo=2">尾页</a>
</div>

</dd>
</dl>
</div><!-- end .content -->
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
<a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
<a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
<div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
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

<div id="cboxOverlay" style="display: none;"></div>
<div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
<div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div>
<div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div>
</div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div>
<div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div>
<div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button>
<button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button>
<div id="cboxLoadingOverlay" style="float: left;"></div>
<div id="cboxLoadingGraphic" style="float: left;"></div></div>
<div id="cboxMiddleRight" style="float: left;"></div></div>
<div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div>
<div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;">
</div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;">
</div></div>
</body>
</html>
