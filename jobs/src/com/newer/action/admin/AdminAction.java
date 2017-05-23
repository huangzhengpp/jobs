package com.newer.action.admin;

import java.util.ArrayList;
import java.util.List;

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

@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("adminAction")//控制层注解
public class AdminAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="adminService")
	AdminService adminService;
	
	private List<JobInfo> list;
	private List<ComInfo> coms;
	private List<JobField> fields;
	private List<Trade> trades;
	private List<JobClass> jobClasses;
	private List<JobName> jobNames;
	private String status="-1";
	private JobField jobField;
	private JobClass jobClass;
	private JobName jobName;
	private ComInfo comInfo;
	private JobInfo jobInfo;
	private Trade trade;
	private String date;
	private Integer pageNo=1;
	private Integer pageSize=3;
	private Integer pageNum;
	private Integer sum;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@Action(value="addTradeAdmin",results={@Result(name="success",location="admin/checkedJobs.jsp")})
	public String addTradeAdmin(){
		adminService.addTrade(trade);
		return SUCCESS;
	}
	
	@Action(value="updateTradeAdmin",results={@Result(name="success",location="admin/checkedJobs.jsp")})
	public String updateTradeAdmin(){
		adminService.updateTrade(trade);
		return SUCCESS;
	}
	
	@Action(value="selectTradeAdmin",results={@Result(name="success",location="admin/selectTradesAdmin.jsp")})
	public String selectTradeAdmin(){
		trades = adminService.selectAllTrade();
		trade = trades.get(0);
		return SUCCESS;
	}
	
	@Action(value="updateFieldAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String updateFieldAdmin(){
		adminService.updateJobField(jobField);
		return SUCCESS;
	}
	
	@Action(value="updateClassAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String updateClassAdmin(){
		jobField = adminService.selectJobField(jobField.getJfid());
		jobClass.setJobField(jobField);
		adminService.updateJobClass(jobClass);
		return SUCCESS;
	}
	
	@Action(value="updateJobAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String updateJobAdmin(){
		jobClass = adminService.selectJobClassById(jobClass.getJcid());
		jobName.setJobClass(jobClass);
		adminService.updateJobName(jobName);
		return SUCCESS;
	}
	
	//修改工作职位页面
	@Action(value="updateJobJobPage",results={@Result(name="success",location="admin/updateJobAdmin.jsp")})
	public String updateJobJobPage(){
		jobName = adminService.selectJobNameByName(jobName.getJnid());
		jobClass = jobName.getJobClass();
		jobField = jobClass.getJobField();
		jobClasses = new ArrayList<JobClass>(jobField.getJobClasses());
		fields = adminService.selectAllJobField();
		return SUCCESS;		
	}
	
	//修改工作类型页面
	@Action(value="updateJobClassPage",results={@Result(name="success",location="admin/updateJobAdmin.jsp")})
	public String updateJobClassPage(){
		jobClass = adminService.selectJobClassById(jobClass.getJcid());
		fields = adminService.selectAllJobField();
		jobField = jobClass.getJobField();
		return SUCCESS;		
	}
	
	//修改工作领域页面
	@Action(value="updateJobFieldPage",results={@Result(name="success",location="admin/updateJobAdmin.jsp")})
	public String updateJobFieldPage(){
		jobField = adminService.selectJobField(jobField.getJfid());
		return SUCCESS;		
	}
		
	
	@Action(value="addFieldAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String addFieldAdmin(){
		adminService.addJobField(jobField);
		return SUCCESS;
	}
	
	@Action(value="addClassAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String addClassAdmin(){
		jobField = adminService.selectJobField(jobField.getJfid());
		jobClass.setJobField(jobField);
		adminService.addJobClass(jobClass);
		return SUCCESS;
	}
	
	@Action(value="addJobAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String addJobAdmin(){
		jobClass = adminService.selectJobClassById(jobClass.getJcid());
		jobName.setJobClass(jobClass);
		adminService.addJobName(jobName);
		return SUCCESS;
	}
	
	@Action(value="addJobAdminPage",results={@Result(name="success",location="admin/addJobAdmin.jsp")})
	public String addJobAdminPage(){
		fields = adminService.selectAllJobField();
		jobField = fields.get(0);
		jobClasses = adminService.selectAllJobClassByField(jobField);
		return SUCCESS;
	}
	
	@Action(value="selectCombInforAdmin",results={@Result(name="success",location="admin/comInfo.jsp")})
	public String selectCombInforAdmin(){
		comInfo = adminService.selectComInfoByID(comInfo.getCid());
		return SUCCESS;
		
	}
	
	@Action(value="selectFieldsAdmin",results={@Result(name="success",location="admin/jobSelect.jsp")})
	public String selectFieldsAdmin(){
		fields = adminService.selectAllJobField();
		jobField = fields.get(0);
		jobClasses = adminService.selectAllJobClassByField(jobField);
		jobClass = jobClasses.get(0);
		jobNames = adminService.selectAllJobNameByClass(jobClass);
		return SUCCESS;
	}
	
	@Action(value="updateJaobInforAdmin",results={@Result(name="success",location="selectUncheckedAdmin?status=0",type="redirectAction")})
	public String updateJaobInforAdmin(){
		
		JobInfo j1 = adminService.selectJobInfoByID(jobInfo.getJiid());
		j1.setJiStatus(jobInfo.getJiStatus());
		adminService.updateJobInfo(j1);
		return SUCCESS;
		
	}
	
	@Action(value="selectJaobInforAdmin",results={@Result(name="success",location="admin/jobInforQuery.jsp")})
	public String selectJaobInforAdmin(){
		jobInfo = adminService.selectJobInfoByID(jobInfo.getJiid());
		return SUCCESS;
		
	}
	
	//分页查询所有待审核的职位信息
	@Action(value="selectUncheckedAdmin",results={@Result(name="success",location="admin/uncheckJobs.jsp")})
	public String selectUncheckedAdmin(){
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
			return SUCCESS;
	}
	
	//分页查询所有审核过的职位信息
	@Action(value="selectCheckedAdmin",results={@Result(name="success",location="admin/checkedJobs.jsp"),@Result(name="checked",location="admin/checkedJobs.jsp")})
	public String selectCheckedAdmin(){
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
		this.fields = adminService.selectAllJobField();
		this.trades = adminService.selectAllTrade();
		this.list = adminService.selectChecked(status, pageSize, pageNo);
		return SUCCESS;
	}
	
	public List<JobInfo> getList() {
		return list;
	}

	public void setList(List<JobInfo> list) {
		this.list = list;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public ComInfo getComInfo() {
		return comInfo;
	}

	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}

	public List<ComInfo> getComs() {
		return coms;
	}

	public void setComs(List<ComInfo> coms) {
		this.coms = coms;
	}

	public JobInfo getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
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

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public List<JobClass> getJobClasses() {
		return jobClasses;
	}

	public void setJobClasses(List<JobClass> jobClasses) {
		this.jobClasses = jobClasses;
	}

	public List<JobName> getJobNames() {
		return jobNames;
	}

	public void setJobNames(List<JobName> jobNames) {
		this.jobNames = jobNames;
	}	

}
