package com.newer.action.backjob;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.newer.model.ComInfo;
import com.newer.service.backjob.ComInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;

import net.sf.json.JSONObject;

@ParentPackage("json-default")
@Namespace("/")
@ResultPath("/")
@Controller("comInfoJsonAction")//控制层注解
public class ComInfoJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="comInfoService")
	private ComInfoService comInfoService;
	private ComInfo comInfo;
	private Integer cid;
    private Map<String,Object> map;
    private boolean flag;
    
	
public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

		public ComInfoService getComInfoService() {
		return comInfoService;
	}
	public void setComInfoService(ComInfoService comInfoService) {
		this.comInfoService = comInfoService;
	}
  
	public ComInfo getComInfo() {
		return comInfo;
	}
	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}

	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Action(value="updateCom",results={@Result(name="success",type="json",params={"root","comInfo"})})
	public String updateCom(){
//		System.out.println("666");
	comInfo=comInfoService.comFindById(cid);
	comInfo.setComName(comInfo.getComName());
     	this.comInfoService.comUpdate(comInfo);
     	flag=true;
		System.out.println("666");
  
	return SUCCESS;
	}
}