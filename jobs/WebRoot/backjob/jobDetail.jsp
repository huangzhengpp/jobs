<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<div id="header" >
    	<div class="wrapper">
    		<a href="index.html" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
    			<li ><a href="index.html">首页</a></li>
    			<li ><a href="companylist.html" >公司</a></li>
    			<li ><a href="h/toForum.html" target="_blank">论坛</a></li>
    				    			<li ><a href="jianli.html" rel="nofollow">我的简历</a></li>
	    							    			<li ><a href="create.html" rel="nofollow">发布职位</a></li>
	    		    		</ul>
        	            <ul class="loginTop">
            	<li><a href="login.html" rel="nofollow">登录</a></li> 
            	<li>|</li>
            	<li><a href="register.html" rel="nofollow">注册</a></li>
            </ul>
    </div>
    </div><!-- end #header -->
    <div id="container">
                <div class="clearfix">
            <div class="content_l">
            	                <dl class="job_detail">
                    <dt>
                        <h1 title="内容运营">
                            <em></em>
                            
                      		<div>${comInfo.comName}招聘</div>
<%--                       		<div>${sessionScope.jobSssion.comInfo.comName}运营部招聘</div> --%>
                           	                  	内容运营
                        </h1>         
                                               	
                       	<a class="inline jd_collection" href="#loginPop" title="登录">
                      	</a>
                        </dt>
                    <dd class="job_request">
                    	<span class="red">${sessionScope.jobSssion.jiSal}</span>
                       	<span>${sessionScope.jobSssion.jiAddr}</span> 
                       	<span>${sessionScope.jobSssion.jiEdu}</span> 
                       	<span>${sessionScope.jobSssion.jiPro}</span><br />
                      	
                      	<div>发布时间：${sessionScope.jobSssion.jiReledate}</div>
                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">职位描述</h3>
						<p> ${sessionScope.jobSssion.jiDetail}</p>
                        
						</dd>
                     
                        <dd class="unresume">
	                        <div>
	                       	</div>
	                    </dd>
                       <div class="saoma saoma_btm">
							<div class="dropdown_menu">
								<div class="drop_l">
									<img src="style/images/job_qr_btm.png" width="131" height="131" />
								</div>
							<div class="drop_r">
								<div class="drop_title"></div>
								<p>
									想知道HR在看简历嘛？<br />
          							想在微信中收到面试通知？<br />
          							<span><< 扫一扫，给你解决</span>
								</p>
								
							</div>
							</div>
							</div>
								<dd>
									<a href="#" title="登录" class="inline btn fr btn_apply">投个简历</a>
								</dd>
                </dl>
                          
            </div>	
            <div class="content_r">
                <dl class="job_company">
                    <dt>
                    	<a href="h/c/683.html" target="_blank">
                            <img class="b2" src="style/images/ff80808140ac5ed90140b953972e0215.png" width="80" height="80" alt="北京立方网信息技术有限公司" />
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
                        	<li><span>领域</span>  	${comInfo.trade.tname}</li>
                        	<li><span>规模</span> ${comInfo.comScale}</li>
                        	<li>
                        		<span>主页</span> 
                        		    	<a href="http://L99.com" target="_blank" title="http://L99.com" rel="nofollow">http://L99.com</a>
							</li>
                        </ul>
                        
                        <h4>发展阶段</h4>
                        <ul class="c_feature reset">
                        	<li><span>目前阶段</span> A轮</li>
                        	<li><span>投资机构</span> IDG(A轮)</li>
                        </ul>
                       	<h4>工作地址</h4>
                       	<div>${sessionScope.jobSssion.jiAddr}</div>
                        </dd>
                </dl>
                <a href="h/subject/s_zhouyou.html?utm_source=BD__lagou&utm_medium=&utm_campaign=zhouyou" target="_blank" class="eventAd">
                  <img src="style/images/zhouyou.jpg" width="280" height="135" />
                </a>
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
			<a href="h/about.html" target="_blank" rel="nofollow">联系我们</a>
		    <a href="h/af/zhaopin.html" target="_blank">互联网公司导航</a>
		    <a href="http://e.weibo.com/lagou720" target="_blank" rel="nofollow">拉勾微博</a>
		    <a class="footer_qr" href="javascript:void(0)" rel="nofollow">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a target="_blank" href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action">京ICP备14023790号-2</a></div>
		</div>
	</div>
<script type="text/javascript" src="style/js/core.min.js"></script>
<script type="text/javascript" src="style/js/popup.min.js"></script>

<!--  -->

</body>
</html>
