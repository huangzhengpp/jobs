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
    
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">
<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<link rel="stylesheet" type="text/css" href="style/css/external.min.css"/>
<link rel="stylesheet" type="text/css" href="style/css/popup.css"/>
<link rel="stylesheet" type="text/css" href="style/tyle.css"/>
<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script src="style/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/additional-methods.js"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 

<style type="text/css">
li:nth-child(even) {
	background-color: #fafafa;
}
</style>
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
    </div><!-- end #header -->
    <div id="container">
        
       	<div class="sidebar">
       		            <div id="options" class="greybg">
                                <dl >
                   	<dt>十班3组项目成员 <em ></em></dt>
	                <dd >
	                    	                    	<div>傅金国</div>
	                    	                    	<div>李旭</div>
	                    	                    	<div>罗东</div>
	                    	                    	<div>黄征</div>
	                    	                    	<div>唐威</div>
	                    	                </dd> 
                </dl>
                               
                            </div>
            
            <!-- QQ群 -->
            	            		            <div class="qq_group">
		            	加入<span>十班</span>QQ群
		            	<div class="f18">跟同行聊聊</div>
		            	<p>191487803</p>
		            </div>
	    </div>                      
           
        
<div class="content">

        <dl class="company_center_content">	
        <dt>
        <h1>职位招聘信息搜索</h1><span></span>
        </dt>
        <dd><ul id="indexlist" class="reset">
        
        <br/><li>
		<form id="searchForm" name="searchForm" action="selectJobInfosByHihIndex" method="post">
       
      
       <p style="font-size:18px;">职位：<input type="text" name="jobName.jnname" value="${jobName.jnname}" class="selectrindex selectr_380" /></p>
       <p style="font-size:18px;">公司： <input type="text" name="comInfo.comName" value="${comInfo.comName}" class="selectrindex selectr_380" /></p>
       
       <p style="font-size:18px;">
              行业： <select name="trade.tid">
       <option value="">----请选择----</option>
       <c:forEach items="${trades}" var="t">
        <c:if test="${trade.tid eq t.tid}">
         <option value="${t.tid}" selected="selected"><c:out value="${t.tname}"></c:out></option>
        </c:if>
        <c:if test="${trade.tid ne t.tid}">
         <option value="${t.tid}"><c:out value="${t.tname}"></c:out></option>
        </c:if>
       </c:forEach>
       </select>  &nbsp;&nbsp;&nbsp;&nbsp;月薪： <select name="jobInfo.jiSal">
       <option value="">----请选择月薪区间----</option>
  		<option value="3000以下" ${jobInfo.jiSal=='3000以下'?'selected':'' }>3000以下</option>
		<option value="3000——5000" ${jobInfo.jiSal=='3000——5000'?'selected':'' }>3000——5000</option>
		<option value="5000——7000" ${jobInfo.jiSal=='5000——7000'?'selected':'' }>5000——7000</option>
		<option value="7000——10000" ${jobInfo.jiSal=='7000——10000'?'selected':'' }>7000——10000</option>
		<option value="10000以上" ${jobInfo.jiSal=='10000以上'?'selected':'' }>10000以上</option>
		<option value="面议" ${jobInfo.jiSal=='面议'?'selected':'' }>面议</option>
       </select>&nbsp;&nbsp;&nbsp;&nbsp;
              学历： <select name="jobInfo.jiEdu">
             <option value="">----学历要求----</option>
		     <option value="本科" ${jobInfo.jiEdu=='本科'?'selected':'' }>本科</option>
		     <option value="大专" ${jobInfo.jiEdu=='大专'?'selected':'' }>大专</option>
		     <option value="高中" ${jobInfo.jiEdu=='高中'?'selected':'' }>高中</option>
		     <option value="中专" ${jobInfo.jiEdu=='中专'?'selected':'' }>中专</option>
            </select>
       </p>
       
       <p style="font-size:18px;">
             职位性质： <select name="jobInfo.jiPro">
       <option value="">----请选择----</option>
       <option value="实习员工" ${jobInfo.jiPro=='实习员工'?'selected':''}>实习员工</option>
       <option value="正式员工" ${jobInfo.jiPro=='正式员工'?'selected':''}>正式员工</option>
       </select>  &nbsp;&nbsp;&nbsp;&nbsp;
       <input class="selectr1 selectr_280" type="text" placeholder="选择工作城市" id="place" value="${jobInfo.jiAddr}" name="jobInfo.jiAddr"></p>
	
	<!-- 城市 -->
	<div id="in_city" style="display: none"></div>
	
	<script type="text/javascript" src="js/cityTemplate.js"></script>
	<script type="text/javascript">

	    var cityA = $(".city_a_le1 a"); //城市
	    var pla = $("#place");  //出发地
	    var dest = $("#destination");  //目的地
	    // 默认值
	    inCity.width = "345";  //城市选择框  宽
	    inCity.height = "auto";  //城市选择框  高
	    inCity.id = "#in_city";  //城市选择框  父级ID
	    inCity.Children = '.city_a_le1';  //城市名box
	    // 初始化 城市HTML模板
	    $(inCity.id).prepend(inCity._template.join(''));
	    inCity.Hot(cityA);
	    
	    //城市 导航
	    var apay = $(".screen a");

	    var placeThis; //当前选择标签
	    apay.click(function(obj){  //城市导航
	        inCity.payment($(this));
	    })

	    inCity.place(pla); //出发地
	    inCity.destination(dest);  //目的地
	    inCity.cityClick(cityA); //显示赋值城市
	</script>
	<input type="submit" value="搜索" class="btn_32"/>
       <br><br>
    </form>
    </li>
</ul></dd>
</dl>
<br>
<div class="breakline"></div>
<style>
.ui-autocomplete{width:488px;background:#fafafa !important;position: relative;z-index:10;border: 2px solid #91cebe;}
.ui-autocomplete-category{font-size:16px;color:#999;width:50px;position: absolute;z-index:11; right: 0px;/*top: 6px; */text-align:center;border-top: 1px dashed #e5e5e5;padding:5px 0;}
.ui-menu-item{ *width:439px;vertical-align: middle;position: relative;margin: 0px;margin-right: 50px !important;background:#fff;border-right: 1px dashed #ededed;}
.ui-menu-item a{display:block;overflow:hidden;}
</style>
<script type="text/javascript" src="style/js/search.min.js"></script>
       <ul class="hot_pos reset">
      
			    	  		<c:forEach items="${jobInfos}" var="j">	
			    	  
	                    		                    			                <li style="height: 110px;">
			                			                				                	<div class="hot_pos_l">
			                        <div class="mb10">
			                                              <span style="font-size: 16px;color:#0d9572;">职位：<c:out value="${j.jobName.jnname}"></c:out></span> 
			                            &nbsp;
			                            <span class="c9">[<c:out value="${j.jiAddr}"></c:out>]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪：</em><c:out value="${j.jiSal}"></c:out></span>
			                        <span><em class="c7">学历要求：</em><c:out value="${j.jiEdu}"></c:out></span>
			                        
			                        <br /><span><em class="c7">职位性质： </em><c:out value="${j.jiPro}"></c:out></span>
			                        <span><em class="c7">招聘人数：</em><c:out value="${j.jiNum}"></c:out></span>
			                        <br /><span><em class="c7">发布时间：</em><c:out value="${j.jiReledate}"></c:out></span><br/>
			                    </div>
						        <div class="hot_pos_r">
			                        <div class="apply">
			                        <a href="selectJobInfoById?jobInfo.jiid=${j.jiid}" target="_blank">招聘详情</a>
			                        				                        </div>
			                        <div class="mb10"><span style="font-size: 14px;color:#0d9572;">公司：<c:out value="${j.comInfo.comName}"></c:out></span></div>
			                        <span><em class="c7">公司所属行业： </em><c:out value="${j.trade.tname}"></c:out></span>
			                        			                        <span><em class="c7">公司联系人：</em><c:out value="${j.jiContact}"></c:out></span>
			                        			                        <br />
			                        <span><em class="c7">规模： </em><c:out value="${j.comInfo.comScale}"></c:out></span>
			      
			                    </div>
			                 </li>
			            	
			               </c:forEach>	 
	                    		                    			                

                               </ul>
                          
	                        	<div class="Pagination"></div>
            	                    </div>	

			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="" />
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