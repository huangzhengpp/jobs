package com.newer.action.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.stereotype.Controller;

import com.newer.model.ComInfo;
import com.newer.model.JobInfo;
import com.newer.model.Oper;
import com.newer.model.Trade;
import com.newer.service.admin.AdminComService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("adminComAction")//控制层注解
public class AdminComAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="adminComService")
	AdminComService adminComService;
	
	private JobInfo jobInfo;
	private ComInfo comInfo;
	private Oper oper;
	private List<ComInfo> comInfos;
	private List<Oper> opers;
	private Integer pageSize=5;
	private Integer pageNo=1;
	private String status;
	private Trade trade;
	private Integer pageNum;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Oper getOper() {
		return oper;
	}
	public void setOper(Oper oper) {
		this.oper = oper;
	}
	public List<Oper> getOpers() {
		return opers;
	}
	public void setOpers(List<Oper> opers) {
		this.opers = opers;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public List<ComInfo> getComInfos() {
		return comInfos;
	}
	public void setComInfos(List<ComInfo> comInfos) {
		this.comInfos = comInfos;
	}
	public JobInfo getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}
	public ComInfo getComInfo() {
		return comInfo;
	}
	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}
	public void setAdminComService(AdminComService adminComService) {
		this.adminComService = adminComService;
	}


	//查询list+分页
	@Action(value="checkCominfo",results={@Result(name="uncheck",location="/admin/unCheckComInfo.jsp"),@Result(name="checked",location="/admin/checkedComInfo.jsp")})
	public String ComNameList(){
		comInfos=adminComService.findCominfos(pageSize, pageNo, status, comInfo.getComName(), trade);
		
		int sum=adminComService.cominfoCount(status, comInfo.getComName(), trade);
		int temp=sum%pageSize.intValue();
		System.out.println(temp);
		
		pageNum=(temp==0?sum/5:(sum/5+1));
		System.out.println(pageNum);
		//System.out.println(pageNum);
		if(status.equals("0")){
			return "uncheck";
		}else{
			return "checked";
		}
		
	}
	//公司详情
	@Action(value="comdetail",results={@Result(name="success",location="/admin/adminComDetail.jsp")})
	public String Comdetail(){
		
		comInfo=adminComService.findByCominfo(comInfo.getCid());
		//status=comInfo.getComStatus();
		return SUCCESS;
	}
	//审核公司 同时更新oper
	@Action(value="checkOperAndCom",results={@Result(name="success",location="/admin/adminMsg.jsp")})
	public String updateOper(){
		comInfo=adminComService.findByCominfo(comInfo.getCid());
		comInfo.setComStatus(status);
		oper=comInfo.getOper();
		oper.setOStatus(status);
		adminComService.updateCominfo(comInfo);
		adminComService.updateOper(oper);
		msg="用户名："+oper.getOUsername()+"\n公司名称："+comInfo.getComName();
		if("1".equals(status)){
			msg+=" 已通过审核.";
		}else{
			msg+=" 审核不通过.";
		}
		return SUCCESS;
	}
	//封号公司 同时更新comInfo
		@Action(value="updateOperAndCom",results={@Result(name="success",location="/admin/adminMsg.jsp")})
		public String updateOperCom(){
			
			Oper temp=adminComService.findByOper(oper.getOid());
			temp.setOStatus(oper.getOStatus());
			adminComService.updateOper(temp);//更新登录表
			List<ComInfo> list=new ArrayList<ComInfo>(temp.getComInfos());
			comInfo=list.get(0);
			comInfo.setComStatus(oper.getOStatus());
			adminComService.updateCominfo(comInfo);
			msg="用户名："+temp.getOUsername()+"\n公司名称："+comInfo.getComName()+"已封号.";
			return SUCCESS;
		}
	//登录账户查询
	@Action(value="comlogin",results={@Result(name="success",location="/admin/comLoginMan.jsp")})
	public String ComLoginList(){
		if(oper==null&&StringUtils.isEmpty(comInfo.getComName())){
			System.out.println(1+status);
			opers=adminComService.findOperAll(status);

			return SUCCESS;
		}else if (oper.getOid()==null&&!StringUtils.isEmpty(comInfo.getComName())) {
			System.out.println(2+status);
			opers=adminComService.findOperAll(status);
			comInfos=adminComService.findComAll(comInfo.getComName());
			if(comInfos.size()<=0){
				return SUCCESS;
			}
			comInfo=comInfos.get(0);
		
			opers=adminComService.findOpers(pageSize, pageNo,comInfo.getOper().getOid());
			
			
			return SUCCESS;
		}else if(oper.getOid()!=null){
			System.out.println(3+status);
			System.out.println("e"+oper.getOid());
			System.out.println(oper.getOStatus());
			System.out.println(oper.getOUsername());
			
			System.out.println("name="+comInfo.getComName());
			opers=new ArrayList<Oper>();
			oper=adminComService.findByOper(oper.getOid());
			status=oper.getOStatus();
			opers.add(oper);
			
			return SUCCESS;
		}else{
			System.out.println(4+status);
			opers=adminComService.findOperAll(status);
			
			
			return SUCCESS;
		}
	}

}
