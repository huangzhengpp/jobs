<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<script async="" src="style/js/analytics.js"></script>
<script type="text/javascript" async="" src="style/js/conversion.js"></script>
<script src="style/js/allmobilize.min.js" charset="utf-8"
	id="allmobilize"></script>
<style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link media="handheld" rel="alternate">
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
<script src="../style/js/ajaxCross.json" charset="UTF-8"></script>

<script type="text/javascript">
	function show(status) {
		window.location.href = "selectByPage?jiStatus="+status;
	}
</script>
</head>
<body>
	<div id="body">
		<div id="header">
			<div class="wrapper">
    		<a class="logo" href="index.html">
    			<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
    		</a>
    		<ul id="navheader" class="reset">
    			<li><a href="index.html">首页</a></li>
    			<li><a href="companylist.html">公司</a></li>
    			<li><a target="_blank" href="toForum.html">论坛</a></li>
    				    			<li></li>
	    						    		</ul>
        	        	<dl class="collapsible_menu">
            	<dt>
           			<span>${loginOper.OUsername }&nbsp;</span> 
            		<span class="red dn" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
                                	<dd>
                                <dd class="logout"><a rel="nofollow" href="logOut">退出</a></dd>
            </dl>
                                    <div class="dn" id="noticeTip">
            	<span class="bot"></span>
				<span class="top"></span>
				<a target="_blank" href="delivery.html"><strong>0</strong>条新投递反馈</a>
				<a class="closeNT" href="javascript:;"></a>
            </div>
			</div>
		</div>
		<!-- end #header -->
		<div id="container">
			<div class="sidebar">
				<a class="btn_create" href="backjob/mycome.jsp">公司首页</a>

				<dl class="company_center_aside">
					<dt>发布职位信息管理</dt>
					<dd class="${jiStatus=='1'?'current':''}">
						<a href="javascript:show(1)">有效职位信息</a>
					</dd>
					<dd class="${jiStatus=='0'?'current':''}">
						<a href="javascript:show(0)">待审核职位</a>
					</dd>
				   <dd class="${jiStatus=='3'?'current':''}">
						<a href="javascript:show(3)">下线职位</a>
					</dd>
					<dd class="${jiStatus=='2'?'current':''}">
						<a href="javascript:show(2)">审核未通过职位</a>
					</dd>
				</dl>
			</div>
			<!-- end .sidebar -->
			<div class="content">
				<dl class="company_center_content">
					<dt>
						<h1>
							 下线职位 <span></span>
						</h1>
					</dt>
					<dd>
					<ul id="gaojo" class="reset my_jobs">
						<form action="selectByPage?jiStatus=3" method="post">
							<h3>高级查询</h3>
				
					<p>薪水：
					<select name="jiSal">
				     	<option value=""  ${jiSal==''?'selected':'' }></option>
						<option value="3000以下" ${jiSal=='3000以下'?'selected':'' }>3000以下</option>
						<option value="3000-5000"  ${jiSal=='3000-5000'?'selected':'' }>3000-5000</option>
						<option value="5000-7000"  ${jiSal=='5000-7000'?'selected':'' }>5000-7000</option>
						<option value="7000-10000"  ${jiSal=='7000-10000'?'selected':'' }>7000-10000</option>
						<option value="10000以上"  ${jiSal=='10000以上'?'selected':'' }>10000以上</option>
							<option value="面议"  ${jiSal=='面议'?'selected':'' }>面议</option>
						
					</select>
					工作性质：
					<select name="jiPro">
					   <option value=""  ${jiPro==''?'selected':'' }></option> 
						<option value="实习" ${jiPro=='实习'?'selected':'' }>实习</option>
						<option value="正式员工" ${jiPro=='正式员工'?'selected':'' }>正式员工</option>
						
					</select>
					<br>
					日期：<input type="date" name="date1" value="${date1}" >
					<input type="date" name="date2" value="${date2}" >
					&nbsp&nbsp
				
					
					
					<input class="right" type="submit" value="查询">
					</p>
					</form></ul>
					</dd>
					<c:forEach items="${pb.data }" var="job">
					<dd>
							<ul class="reset my_jobs">
								
									<li data-id="149594">
										<h3>
											<a target="_blank"
												href="http://www.lagou.com/jobs/149594.html">${job.jobName.jnname }</a>
											<span>${job.jiAddr }</span>
										</h3> <span class="receivedResumeNo"><a
											href="unHandleResumes.html?positionId=149594">应聘简历（1）</a></span>
										<div>${job.jiPro }/ ${job.jiSal}/招聘${job.jiNum}人</div>
										<div class="c9">发布时间：${job.jiReledate }</div>
										<div class="links">
										
											<a href="findById?jobInfo.jiid=${job.jiid }">查看详情</a>
											
										</div>

									</li>
								</ul>
								</dd>
								</c:forEach>
								<dd>
								
									<ul class="reset">
										<li id="fenye"><a
	href="selectByPage?pb.pageNo=1&jiStatus=${jiStatus }&jiSal=${jiSal }&date1=${date1}&date2=${date2}&jiPro=${jiPro}">首页</a> <a
	href="selectByPage?pb.pageNo=${pb.first }&jiStatus=${jiStatus }&jiSal=${jiSal }&date1=${date1}&date2=${date2}&jiPro=${jiPro}">上一页</a> <a
	href="selectByPage?pb.pageNo=${pb.last }&jiStatus=${jiStatus }&jiSal=${jiSal }&date1=${date1}&date2=${date2}&jiPro=${jiPro}">下一页</a> <a
    href="selectByPage?pb.pageNo=${pb.totalPage }&jiStatus=${jiStatus }&jiSal=${jiSal }&date1=${date1}&date2=${date2}&jiPro=${jiPro}">末页</a>
                  
										 <c:if test="${pb.pageNo<=pb.totalPage }">
											${pb.pageNo }/${pb.totalPage }页</c:if>
											
										 <c:if test="${pb.pageNo>pb.totalPage }">
											0/0页</c:if></li>
									</ul>

								</dd>
							</ul>
						</form>
					</dd>
				</dl>
			</div>
			<!-- end .content -->
			<script src="style/js/job_list.min.js" type="text/javascript"></script>
			<div class="clear"></div>
			<input type="hidden" value="74fb1ce14ebf4e2495270b0fbad64704"
				id="resubmitToken"> <a rel="nofollow" title="回到顶部"
				id="backtop"></a>
		</div>
		<!-- end #container -->
	</div>
	<!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="about.html">联系我们</a> <a
				target="_blank" href="http://www.lagou.com/af/zhaopin.html">互联网公司导航</a>
			<a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
			<a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
			<div class="copyright">
				&copy;2013-2014 Lagou <a
					href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action"
					target="_blank">京ICP备14023790号-2</a>
			</div>
		</div>
	</div>

	<script src="style/js/core.min.js" type="text/javascript"></script>
	<script src="style/js/popup.min.js" type="text/javascript"></script>
	<script src="style/js/tongji.js" type="text/javascript"></script>
	<!--  -->
	<script src="style/js/analytics01.js" type="text/javascript"></script>
	<script type="text/javascript" src="style/js/h.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#noticeDot-1').hide();
			$('#noticeTip a.closeNT').click(function() {
				$(this).parent().hide();
			});
		});
		var index = Math.floor(Math.random() * 2);
		var ipArray = new Array('42.62.79.226', '42.62.79.227');
		var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
		var CallCenter = {
			init : function(url) {
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
					if (notice.status[0] == 0) {
						$('#noticeDot-0').hide();
						$('#noticeTip').hide();
						$('#noticeNo').text('').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
						$('#noticeNoPage').text('').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
					} else {
						$('#noticeDot-0').show();
						$('#noticeTip strong').text(notice.status[0]);
						$('#noticeTip').show();
						$('#noticeNo').text('(' + notice.status[0] + ')').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
						$('#noticeNoPage').text(' (' + notice.status[0] + ')').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
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
	<div id="colorbox" class="" role="dialog" tabindex="-1"
		style="display: none;">
		<div id="cboxWrapper">
			<div>
				<div id="cboxTopLeft" style="float: left;"></div>
				<div id="cboxTopCenter" style="float: left;"></div>
				<div id="cboxTopRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxMiddleLeft" style="float: left;"></div>
				<div id="cboxContent" style="float: left;">
					<div id="cboxTitle" style="float: left;"></div>
					<div id="cboxCurrent" style="float: left;"></div>
					<button type="button" id="cboxPrevious"></button>
					<button type="button" id="cboxNext"></button>
					<button id="cboxSlideshow"></button>
					<div id="cboxLoadingOverlay" style="float: left;"></div>
					<div id="cboxLoadingGraphic" style="float: left;"></div>
				</div>
				<div id="cboxMiddleRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxBottomLeft" style="float: left;"></div>
				<div id="cboxBottomCenter" style="float: left;"></div>
				<div id="cboxBottomRight" style="float: left;"></div>
			</div>
		</div>
		<div
			style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div>
	</div>
</body>
</html>