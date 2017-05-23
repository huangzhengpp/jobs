<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
	<meta content="no-siteapp" http-equiv="Cache-Control">
	<link  media="handheld" rel="alternate">
	<!-- end 云适配 -->
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
	<title>拉勾网-最专业的互联网招聘平台</title>
	<meta content="23635710066417756375" property="qc:admins">
	<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站">
	<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
	<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

	
	<script type="text/javascript">
	var ctx = "http://www.lagou.com";
	console.log(1);
	</script>
	<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
	<link href="style/css/style.css" type="text/css" rel="stylesheet">
	<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
	<link href="style/css/popup.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
	<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
	<script src="style/js/additional-methods.js" type="text/javascript"></script>

	<script type="text/javascript">
	var youdao_conv_id = 271546; 
	</script> 
	<script src="style/js/conv.js" type="text/javascript"></script>
	<script src="style/js/ajaxCross.json" charset="UTF-8"></script>
	

  </head>
  
  <body>
    <script src="http://tajs.qq.com/jiathis.php?uid=1626433&amp;dm=www.lagou.com" charset="utf-8"></script><link href="style/css/jiathis_share.css" rel="stylesheet" type="text/css"><iframe frameborder="0" style="position: fixed; display: none; opacity: 0;"></iframe><div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; top: 50%; left: 50%; overflow: auto;"></div><div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; overflow: auto;"></div><iframe frameborder="0" style="display: none;" src="http://v3.jiathis.com/code_mini/jiathis_utility.html"></iframe>
	<div id="body">
	<div id="header">
	<div class="wrapper">
	<a class="logo" href="index.html">
	<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
	</a>
	<ul id="navheader" class="reset">
	<li><a href="index.html">首页</a></li>
	<li><a href="companylist.html">公司</a></li>
	<li><a target="_blank" href="">论坛</a></li>
	<li><a rel="nofollow" href="jianli.html">我的简历</a></li>
		</ul>
	<dl class="collapsible_menu">
	<dt>
	<span>${loginOper.OUsername }${loginSysuser.SUsername }&nbsp;</span> 
	<span class="red dn" id="noticeDot-0"></span>
	<i></i>
	</dt>
	<dd><a href="accountBind.html">帐号设置</a></dd>
	<dd class="logout"><a rel="nofollow" href="login.html">退出</a></dd>
	</dl>
	<div class="dn" id="noticeTip">
	<span class="bot"></span>
	<span class="top"></span>
	<a target="_blank" href="delivery.html"><strong>0</strong>条新投递反馈</a>
	<a class="closeNT" href="javascript:;"></a>
	</div>
	</div>
	</div><!-- end #header -->
	<div id="container">

	<div class="sidebar">
	<a class="btn_create" href="create.html">发布新职位</a>

	<dl class="company_center_aside">
	<dt>我发布的职位</dt>
	<dd>
	<a href="positions.html">有效职位</a>
	</dd>
	<dd>
	<a href="positions.html">已下线职位</a>
	</dd>
	</dl>
	<div class="subscribe_side mt20">
	<div class="f14">想收到更多更好的简历？</div>
	<div class="f18 mb10">就用求职通加速助手 </div>
	<div>咨询：<a class="f16" href="mailto:jessica@lagou.com">jessica@lagou.com</a></div>
	<div class="f18 ti2em">010-57286512</div>
	</div>
	<div class="subscribe_side mt20">
	<div class="f14">加入互联网HR交流群</div>
	<div class="f18 mb10">跟同行聊聊</div>
	<div class="f24">338167634</div>
	</div>            </div><!-- end .sidebar -->
	<div class="content">
	<dl class="company_center_content">
	<dt>
	<h1>
	<em></em>
	发布新职位
	</h1>
	</dt>
	<dd> 
	<div class="ccc_tr">已发布 <span>${pageSize }</span> 个职位   还可发布 <span>${100-pageSize }</span> 个职位</div>
	<div class="publish_tip">
	<h2>恭喜你，职位发布成功！</h2>
	
	
	
	
<%-- 			<a target="_blank" href="backJob/jobDetail.jsp">预览职位${jobInfo.comInfo.cid}${jobInfo.jiEdu}</a><br> --%>
			<a target="_blank" href="previews?id=${jobInfo.comInfo.cid}">预览职位</a><br>
			
			
			
			
					<a class="greylink" href="selectFiled">继续发布新职位</a><br>
					<a class="greylink" href="backjob/mycome.jsp"> 进入我的公司主页</a><br>
	<div style="float:left;" class="invite_share">
	<!-- JiaThis Button BEGIN -->
	<div class="jiathis_style_32x32">
	<a class="jiathis_button_tsina" title="分享到新浪微博"><span class="jiathis_txt jiathis_separator jtico jtico_tsina">分享到新浪微博</span></a>
	</div>
	<!-- JiaThis Button END -->
	</div>
	</div>
	<div class="weixin weixinSuc">
	<div class="qr">
	<img width="110" height="110" src="style/images/d1f91afa15eb451eaef4d14dcb3b54ec_318969.jpg">
	<div>[仅限本人使用]</div>
	</div>
	<div class="qr_text">
	<h3>关注微信服务号，可随时获取接收简历的通知 </h3>
	关注方式：<br>
	<span>打开微信 </span>  <img width="30" height="30" src="style/images/wx1.png"><span> →发现 </span> <img width="31" height="30" src="style/images/wx2.png"><span> →扫一扫左侧二维码</span><img width="78" height="29" src="style/images/wx3.png"> 
	</div>
	</div>
	</dd>
	</dl>
	</div><!-- end .content -->
	<style>
	.jiathis_style_32x32 .jiathis_txt{font-size:14px!important;text-decoration:underline!important;padding-left:0 !important;}
	.jiathis_style_32x32 .jiathis_separator{margin:0!important; line-height:22px !important;}
	.jiathis_style_32x32 .jtico{height:auto !important;background:none;line-height:22px !important;padding-left:0 !important;}
	</style>
	<script type="text/javascript">
	var jiathis_config={summary:"【公司名称随便写招聘随便写】我们公司正在招聘随便写，月薪1k-2k，如果你对这个职位感兴趣，请进入详情页投递简历：http://www.lagou.com/jobs/149594.html @拉勾网",boldNum:6,title:"#拉勾网热招职位#",url:"http://www.lagou.com/jobs/149594.html",hideMore:!0,appkey:{tsina:"3761453225"},pic:"",evt:{share:""}};
	popQR();
	function popQR(){
	$.ajax({
	url:ctx+"/mycenter/showQRCode",
	type:"GET"
	}).done(function(data){
	if(data.success){
	$('.weixinSuc .qr img').attr("src",data.content);
	$('.weixinSuc').removeClass('dn');
	}
	});  
	}
	</script>
	<script charset="utf-8" src="style/js/jia.js" type="text/javascript"></script>
	<div class="clear"></div>
	<input type="hidden" value="e0b2bdfab8ab466cb973d5ee5acc6adb" id="resubmitToken">
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

	<!--  -->

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

	<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div>

  </body>
</html>
