package com.newer.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.newer.model.ComInfo;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;
import com.newer.service.admin.AdminComService;
import com.newer.service.user.OperService;
import com.newer.service.user.SysUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;


@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("userAction")//控制层注解
public class userAction extends ActionSupport implements SessionAware{
	

	private static final long serialVersionUID = 1L;

	
	@Resource(name="operService")
	OperService operService;
	
	@Resource(name="adminComService")
	AdminComService adminComService;
	
	@Resource(name="sysuserService")
	SysUserService sysUserService;
	
	private String userclass;
	private Oper oper;
	private ComInfo comInfo;
	private Sysuser sysuser;
	private Trade trade;
	private List<Trade> trades;
	private List<Sysuser> sysusers;
	private String msg;
	Map session; 
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public AdminComService getAdminComService() {
		return adminComService;
	}

	public void setAdminComService(AdminComService adminComService) {
		this.adminComService = adminComService;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public List<Sysuser> getSysusers() {
		return sysusers;
	}

	public void setSysusers(List<Sysuser> sysusers) {
		this.sysusers = sysusers;
	}

	public ComInfo getComInfo() {
		return comInfo;
	}

	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}

	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public Sysuser getSysuser() {
		return sysuser;
	}
	public void setSysuser(Sysuser sysuser) {
		this.sysuser = sysuser;
	}
	
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	public OperService getOperService() {
		return operService;
	}
	public Oper getOper() {
		return oper;
	}
	public void setOper(Oper oper) {
		this.oper = oper;
	}
	public void setOperService(OperService operService) {
		this.operService = operService;
	}
	
	@Action(value="login",results={@Result(name="login",location="user/login.jsp"),@Result(name="sys",location="admin/adminIndex.jsp"),@Result(name="oper",location="backjob/mycome.jsp")})
	public String findOper(){
		System.out.println( userclass);
		if("oper".equals(userclass)){
			oper=operService.findByOper(oper);
			if(oper==null){
				return LOGIN;
			}
			//登录用户信息加入session
			session.put("loginOper", oper);
			//登录用户公司信息加入session
			comInfo=adminComService.findComOid(oper);
			session.put("loginComInfo", comInfo);
			//所有行业信息加入session
			session.put("loginTrades", operService.findTrades());
			return "oper";
		}else{
			Sysuser temp=new Sysuser();
			temp.setSUsername(oper.getOUsername());
			temp.setSPwd(oper.getOPwd());
			sysuser=operService.findBySysuser(temp);
			if(sysuser==null){
				return LOGIN;
			}
			session.put("loginSysuser",sysuser);
			//所有行业信息加入session
			session.put("loginTrades", operService.findTrades());
			return "sys";
		}
		
	}
	@Action(value="logOut",results={@Result(name="login",location="user/login.jsp")})
	public String loginOut(){
		session.clear();
		return "login";
	}
	//添加平台管理员
	@Action(value="addSysUser",results={@Result(name="success",location="admin/adminMsg.jsp"),@Result(name="repeat",location="admin/adminAddSysUser.jsp")})
	public String addSysUser(){
		sysusers=sysUserService.findSysUsers();
		for(Sysuser s:sysusers){
			if(s.getSUsername().equals(sysuser.getSUsername())){
				msg="*用户名已占用";
				return "repeat";
			}
		}
		sysuser.setSType("0");
		sysUserService.addSysuser(sysuser);
		msg="平台管理员添加成功.";
		return SUCCESS;
	}
	//更新平台管理员
	@Action(value="updateSysUser",results={@Result(name="success",location="admin/adminMsg.jsp")})
	public String updateSysUser(){
		
		sysuser.setSType("0");
		sysUserService.updateSysuser(sysuser);
		msg="平台管理员账户更新成功.";
		return SUCCESS;
	}
	//查询单个平台管理员
		@Action(value="findBySysUser",results={@Result(name="success",location="admin/adminUpdateSysUser.jsp")})
		public String findBySysUser(){
			
			sysuser=sysUserService.findBySysuser(sysuser.getSid());
			return SUCCESS;
		}
	//平台管理员list
	@Action(value="sysUserList",results={@Result(name="success",location="admin/adminSysuserList.jsp")})
	public String sysUserList(){
		if(sysuser!=null){
			if(sysuser.getSid()!=null){
				sysusers=new ArrayList<Sysuser>();
				sysuser=sysUserService.findBySysuser(sysuser.getSid());
				if(sysuser==null){
					return SUCCESS;
				}
				if("0".equals(sysuser.getSType())){
					sysusers.add(sysuser);
				}
			}else{
				sysusers=sysUserService.findSysUsers();
			}
		}else{
			sysusers=sysUserService.findSysUsers();
		}
		return SUCCESS;
	}

}
