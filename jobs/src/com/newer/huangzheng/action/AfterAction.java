package com.newer.huangzheng.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.newer.huangzheng.service.JobService;
import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("jobAction")
public class AfterAction extends ActionSupport implements SessionAware{

	
	private static final long serialVersionUID = 1L;
	@Resource(name="jobService")
	private JobService jobService;
	private ComInfo comInfo;
	private List<ComInfo> comList;
	private JobInfo jobInfo;
	private JobField jobField;
	private JobClass jobClass;
	private JobName jobName;
	private List<JobField> jobFieldlist;
	private List<JobInfo> jobList;
	private int pageNo =1;
	private int pageSize=0;
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<JobInfo> getJobList() {
		return jobList;
	}
	public void setJobList(List<JobInfo> jobList) {
		this.jobList = jobList;
	}
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<JobField> getJobFieldlist() {
		return jobFieldlist;
	}
	public void setJobFieldlist(List<JobField> jobFieldlist) {
		this.jobFieldlist = jobFieldlist;
	}
	public ComInfo getComInfo() {
		return comInfo;
	}
	public JobInfo getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}
	public JobService getJobService() {
		return jobService;
	}
	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}
	public List<ComInfo> getComList() {
		return comList;
	}
	public void setComList(List<ComInfo> comList) {
		this.comList = comList;
	}
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//session集合
	Map session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session =arg0;
	}
	
	
	
	/*
	 * 查询所有的公司信息
	 */
	@Action(value="comList",results={@Result(name="success",location="/list.jsp"),@Result(name="error",location="/error.jsp")})
	public String comList(){
		comList = this.jobService.comList();
		return SUCCESS;
	}
	/*
	 * 增加工作
	 */
	@Action(value="addJob",results={@Result(name="success",location="/backjob/addSuccess.jsp")})

	public String addJob(){
//		System.out.println("addjob");
		jobInfo.setJiStatus("0");
		jobInfo.setJobName(jobName);
		jobInfo.setJiReledate(new java.sql.Date(System.currentTimeMillis()));
		
		ComInfo comInfo = (ComInfo) session.get("loginComInfo");
		
		jobInfo.setComInfo(comInfo);
		jobInfo.setTrade(comInfo.getTrade());
		this.jobService.addJob(jobInfo);
		session.put("jobSssion", jobInfo);
		
		pageSize=  this.jobService.findJobByPage(null, null, null, null, null, null, 0, null, comInfo, 1,99999).size();
		session.put("tatalNums", pageSize);
		return SUCCESS;
	}
	/*
	 * 导航信息
	 */
	@Action(value="selectFiled",results={@Result(name="success",location="/backjob/addJob.jsp")})
	public String selectFiled(){
		ComInfo com = new ComInfo();
		com.setCid(2);
		jobFieldlist = this.jobService.selectAllJobField();
		pageSize=  this.jobService.findJobByPage(null, null, null, null, null, null, 0, null, com, 1,99999).size();
		session.put("tatalNums", pageSize);
		return SUCCESS;
	}
	/*
	 *根据id查找公司 
	 */
	@Action(value="previews",results={@Result(name="success",location="/backjob/jobDetail.jsp")})
	public String previews(){
	
		System.out.println("previe");
		
//		System.out.println("id:"+id);

		
		comInfo = this.jobService.selectComById(id);
		
		session.put("jobid", comInfo);
		System.out.println("comInfo.getComName()"+comInfo.getComName());
		return SUCCESS;
	}
	//查找登入后的职位招聘信息并分页
	@Action(value="findAllJobInfo",results={@Result(name="success",location="/backjob/position.jsp")})
	public String findJobInfoListByComId(){
//		System.out.println("id2:"+id);
		ComInfo com = new ComInfo();
		com.setCid(2);
		jobList = this.jobService.findJobByPage(null, null, null, null, null, null, 0, null, com, pageNo,6);
		pageSize=  this.jobService.findJobByPage(null, null, null, null, null, "1", 0, null, com, 1,99999).size();
		System.out.println("pageSize:"+pageSize);
		session.put("jobList", jobList);
		session.put("tatalNums", pageSize);
		return SUCCESS;
	}
	@Action(value="downLine",results={@Result(name="success",location="/backjob/position.jsp")})
	public String downLine(){
		jobInfo.setJiid(id);
		jobInfo.setJiStatus(2+"");
		this.jobService.updateJob(jobInfo);
		return SUCCESS;
	}
	
	
	

}
