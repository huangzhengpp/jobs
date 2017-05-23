package com.newer.action.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.stereotype.Controller;

import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;
import com.newer.service.admin.AdminService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Namespace("/json")
@ResultPath("/")
@Controller("adminJsonAction")//控制层注解
public class AdminJsonAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="adminService")
	AdminService adminService;
	
	private Map<String,Object> map = new HashMap<String, Object>();
	private List<JobInfo> list;
	private List<JobClass> jobClasses;
	private List<JobField> fields;
	private List<Trade> trades;
	private ComInfo comInfo;
	private JobField jobField;
	private JobClass jobClass;
	private JobName jobName;
	private Trade trade;
	private String status;
	private Integer pageNo=1;
	private Integer pageSize=3;
	private Integer pageNum;
	private String date;
	private Integer sum;
	private boolean flg=true;
	private String msg;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//检查行业有没与重复
	@Action(value="checkTrade",results={@Result(name="success",type="json",params={"root","map"})})
	public String checkTrade(){
		trades = adminService.selectAllTrade();
		for(Trade t : trades){
			if(trade.getTname().equals(t.getTname())){
				flg = false;
				msg="该行业已存在";
			}
		}
		map.put("flg", flg);
		map.put("msg", msg);
		return SUCCESS;
	}
	
	//检查工作领域有没与重复
	@Action(value="checkField",results={@Result(name="success",type="json",params={"root","map"})})
	public String checkField(){
		fields = adminService.selectAllJobField();
		for(JobField f : fields){
			if(jobField.getJfname().equals(f.getJfname())){
				flg = false;
				msg="该工作领域已存在";
			}
		}
		map.put("flg", flg);
		map.put("msg", msg);
		return SUCCESS;
	}
	
	//检查工作类型有没与重复
	@Action(value="checkClass",results={@Result(name="success",type="json",params={"root","map"})})
	public String checkClass(){
		jobField = adminService.selectJobField(jobField.getJfid());
		for(JobClass c : jobField.getJobClasses()){
			if(jobClass.getJcname().equals(c.getJcname())){
					flg = false;
					msg=jobField.getJfname()+"领域已存在该工作类型";
			}
		}
		map.put("flg", flg);
		map.put("msg", msg);
		return SUCCESS;
	}
	
	//检查职位有没与重复
	@Action(value="checkJob",results={@Result(name="success",type="json",params={"root","map"})})
	public String checkJob(){
		jobClass = adminService.selectJobClassById(jobClass.getJcid());
		for(JobName n : jobClass.getJobNames()){
			if(jobName.getJnname().equals(n.getJnname())){
					flg = false;
					msg=jobClass.getJcname()+"类型已存在该职位";
			}
		}
		map.put("flg", flg);
		map.put("msg", msg);
		return SUCCESS;
	}
	
	//查具體的工作集合
	@Action(value="selectJobName",results={@Result(name="success",type="json",params={"root","jobClass"})})
	public String selectJobName(){

		jobClass = adminService.selectJobClassById(jobClass.getJcid());
		
		return SUCCESS;
	}
	
	//查具體的領域下面的工作類型集合
	@Action(value="selectJobClass",results={@Result(name="success",type="json",params={"root","map"})})
	public String selectJobClass(){
		if(map.size()!=0){
			map.clear();
		}
		
		jobField = adminService.selectJobField(jobField.getJfid());
		
		jobClasses = adminService.selectAllJobClassByField(jobField);
		
		jobClass = jobClasses.get(0);
		
		map.put("jobClasses", jobClasses);
		map.put("jobClass", jobClass);
		return SUCCESS;
	}
	
	//JSON按公司名字分页模糊查询所有职位信息
	@Action(value="selectUncheckedByNameAdmin",results={@Result(name="success",type="json",params={"root","map"})})
	public String selectUncheckedByNameAdmin(){
		if(map.size()!=0){
			map.clear();
		}

		if(comInfo.getComName().equals("")){
			list = adminService.selectChecked(status);
			pageNum = list.size();
			sum = list.size();
			if(pageNum%pageSize==0){
				this.pageNum=pageNum/pageSize;
				if(pageNum==0){
					pageNum=pageNum+1;
				}
			}else{
				this.pageNum=pageNum/pageSize+1;
			}
			this.list = adminService.selectChecked(status, pageSize, pageNo);
			System.out.println("这是没有公司名的方法");
		}else{
			list = adminService.selectJobInfoByName(status,comInfo.getComName());
			System.out.print(list.size());
			pageNum = list.size();
			sum = list.size();
			if(pageNum%pageSize==0){
				this.pageNum=pageNum/pageSize;
				if(pageNum==0){
					pageNum=pageNum+1;
				}
			}else{
				this.pageNum=pageNum/pageSize+1;
			}
			list = adminService.selectJobInfoByName(status,comInfo.getComName(), pageSize, pageNo);
			System.out.println(list.size());
			System.out.println("这是有公司名的方法");
		}
		
		map.put("list",list);
		map.put("pageNo",pageNo);
		map.put("pageNum",pageNum);
		map.put("sum",sum);
	    return SUCCESS;
	}
	
	//高級查詢職位信息集合
	@Action(value="selectByHigh",results={@Result(name="success",type="json",params={"root","map"})})
	public String selectByHigh(){
		if(map.size()!=0){
			map.clear();
		}		
		if(jobName.getJnid()!=null){
			jobName = adminService.selectJobNameByName(jobName.getJnid());
		}else{jobName=null;}
		if(trade.getTid()!=null){
			trade = adminService.selectTradeByName(trade.getTid());
		}else{trade=null;}
		list = adminService.selectByHigh(status, jobName, trade, date);
		System.out.println(list.size());
		pageNum = list.size();
		sum = list.size();
		if(pageNum%pageSize==0){
			this.pageNum=pageNum/pageSize;
			if(pageNum==0){
				pageNum=pageNum+1;
			}
		}else{
			this.pageNum=pageNum/pageSize+1;
		}
		this.list = adminService.selectByHigh(status, jobName, trade, date, pageSize, pageNo);
		map.put("list",list);
		map.put("pageNo",pageNo);
		map.put("pageNum",pageNum);
		map.put("sum",sum);
	    return SUCCESS;
	}


	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public List<JobInfo> getList() {
		return list;
	}

	public void setList(List<JobInfo> list) {
		this.list = list;
	}

	public JobField getJobField() {
		return jobField;
	}

	public void setJobField(JobField jobField) {
		this.jobField = jobField;
	}

	public JobClass getJobClass() {
		return jobClass;
	}

	public void setJobClass(JobClass jobClass) {
		this.jobClass = jobClass;
	}

	public JobName getJobName() {
		return jobName;
	}

	public void setJobName(JobName jobName) {
		this.jobName = jobName;
	}

	public List<JobClass> getJobClasses() {
		return jobClasses;
	}

	public void setJobClasses(List<JobClass> jobClasses) {
		this.jobClasses = jobClasses;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public boolean isFlg() {
		return flg;
	}

	public void setFlg(boolean flg) {
		this.flg = flg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<JobField> getFields() {
		return fields;
	}

	public void setFields(List<JobField> fields) {
		this.fields = fields;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

}
