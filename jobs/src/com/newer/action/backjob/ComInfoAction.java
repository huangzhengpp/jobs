package com.newer.action.backjob;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.newer.model.ComInfo;
import com.newer.model.Oper;
import com.newer.service.backjob.ComInfoService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("comInfoAction") // 控制层注解
public class ComInfoAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "comInfoService")
	private ComInfoService comInfoService;
	private Integer oid;
	private ComInfo comInfo;
	private Integer cid;
	Map session;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public ComInfoService getComInfoService() {
		return comInfoService;
	}
	public void setComInfoService(ComInfoService comInfoService) {
		this.comInfoService = comInfoService;
	}
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public ComInfo getComInfo() {
		return comInfo;
	}
	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}
	
	@Action(value = "comFindId", results = { @Result(name = "success", location = "/backjob/myhome.jsp") })
	public String comFindId() {
		Oper op=new Oper();
		op.setOid(oid);
	//http://localhost:8080/jobs/comFindId?oid=1
		comInfo=comInfoService.comFindId(op);
		return SUCCESS;
	}
	@Action(value = "updateCom", results = { @Result(name = "success", location = "backjob/mycome.jsp") })
	
	public String updateCom() {
		System.out.println("6666");
		System.out.println(comInfo.getTrade().getTid());
		System.out.println(comInfo.getCid());
		this.comInfoService.comUpdate(comInfo);
	    
		session.put("loginComInfo", comInfo);
	  
		return SUCCESS;
	}
	@Override
	public void setSession(java.util.Map<String, Object> session) {
		this.session=session;
		
	}

	
	
	
	
	
	
}
