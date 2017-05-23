<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jobDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内容运营-立方网-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />


<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<link rel="stylesheet" type="text/css" href="style/css/external.min.css"/>
<link rel="stylesheet" type="text/css" href="style/css/popup.css"/>
<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script src="style/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="style/js/jquery-hbzx.js" type="text/javascript"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>
  
  <body>
   <div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a href="index.html" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		
    		<ul id="navheader" class="reset">
	<li><a href="selectAllJobInfoIndex">首页</a></li>
	
	<c:if test="${!empty loginOper}">
		<li><a href="backjob/mycome.jsp">我的公司首页</a></li>
		<li class="current"><a rel="nofollow" href="selectFiled">发布职位</a></li>
	</c:if>
	<c:if test="${!empty loginSysuser}"><li><a rel="nofollow" href="admin/adminIndex.jsp">求职通管理系统</a></li></c:if>
	
</ul>
<c:if test="${empty loginOper and empty loginSysuser}">
		 <ul class="loginTop">
              <li><a href="user/login.jsp" rel="nofollow">登录</a></li> 
              <li>|</li>
              <li><a href="register.html" rel="nofollow">注册</a></li>
            </ul>
	</c:if>
<c:if test="${!empty loginOper or !empty loginSysuser}">
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
</c:if>

<!--  -->
                                </div>
    </div>
    <!-- end #header -->
    <div id="container">
                <div class="clearfix">
            <div class="content_l">
            	                <dl class="job_detail">
                    <dt>
                        <h1 title="内容运营">
                            <em></em>
                            
                      		<div>${comInfo.comName}招聘</div>
<%--                       		<div>${sessionScope.jobSssion.comInfo.comName}运营部招聘</div> --%>
                           	                  	${jobInfo.jobName.jnname}
                        </h1>         
                                               	
                       	
                        </dt>
                    <dd class="job_request">
                    	<span class="red">${jobInfo.jiSal}</span>
                       	<span>${jobInfo.jiAddr}</span> 
                       	<span>${jobInfo.jiEdu}</span> 
                       	<span>${jobInfo.jiPro}</span><br />
                      	
                      	<div>发布时间：${jobInfo.jiReledate}</div>
                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">职位描述</h3>
						
                        <p>岗位职责：</p>
						<p> ${jobInfo.jiDetail}</p>
						<br><br>
						
						</dd>
                     
                        <dd class="unresume">
	                        <div>
	                       	</div>
	                    </dd>
                   
								
                </dl>
                          
            </div>	
            <div class="content_r">
                <dl class="job_company">
                    <dt>
                    	<a href="selectJobIofosByJobIndex" target="_blank">
                            <img class="b2" src="style/images/ff80808140ac5ed90140b953972e0215.png" width="80" height="80" alt="${comInfo.comName}" />
                            <div>
                                <h2 class="fl">
									 	${comInfo.comName}                                 	                                  	
                             	<img src="style/images/valid.png" width="15" height="19" alt="拉勾认证企业" /> 
                                    	<span class="dn">拉勾认证企业</span>                                     
                                </h2>
                            </div>
                        </a>
                    </dt>
                    <dd>
                    	<ul class="c_feature reset">
                        	<li><span>公司领域</span>  	${comInfo.trade.tname}</li>
                        	<li><span>公司性质</span> ${comInfo.comPro}</li>
                        	<li><span>公司规模</span> ${comInfo.comScale}</li>
                        	<li><span>公司地址</span> ${comInfo.comAddr}</li>
                        </ul>
                        
                        <h4>联系方式</h4>
                        <ul class="c_feature reset">
                        	<li><span>联系人</span> ${comInfo.comContact}</li>
                        	<li><span>联系方式</span> ${comInfo.comPhone}</li>
                        </ul>
                       	<h4>工作地址</h4>
                       	<div>${jobInfo.jiAddr}</div>
                        </dd>
                </dl>
               
            </div>
       	</div>                    	
		<div id="tipOverlay" ></div>
<!-------------------------------------弹窗lightbox  ----------------------------------------->

<!------------------------------------- end ----------------------------------------->
<script type="text/javascript" src="style/js/job_detail.js"></script>
<script type="text/javascript" src="style/js/count.js"></script>
			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="6e1925fdbe7142468f154abd1d33f5a8" />
	    	<a id="backtop" title="回到顶部" rel="nofollow"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="about.html">联系我们</a>
		    <a target="_blank" href="http://www.lagou.com/af/zhaopin.html">互联网公司导航</a>
		    
			<div class="copyright">&copy;2017 Three Team <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备99999999号-1</a></div>
		</div>
	</div>
<script type="text/javascript" src="style/js/core.min.js"></script>
<script type="text/javascript" src="style/js/popup.min.js"></script>

<!--  -->

</body>
</html>
