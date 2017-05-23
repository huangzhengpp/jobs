package com.newer.action.backjob;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.stereotype.Controller;

import com.newer.model.JobInfo;
import com.newer.model.PageBean;
import com.newer.service.backjob.JobInfoService;
import com.opensymphony.xwork2.ActionSupport;



@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("jobInfoAction") // 控制层注解
public class JobInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jobInfoService")
	JobInfoService jobInfoService;
	String date1;
	String date2;
	String jiStatus;
	
    public String getJiSal() {
		return jiSal;
	}

	public void setJiSal(String jiSal) {
		this.jiSal = jiSal;
	}

	public String getJiPro() {
		return jiPro;
	}

	public void setJiPro(String jiPro) {
		this.jiPro = jiPro;
	}

	String jiSal;
	String jiPro;
	JobInfo jobInfo;
	List<JobInfo> list;
	PageBean<JobInfo> pb;
	
	
	
	


	public JobInfoAction() {
		pb=new PageBean<JobInfo>();
	}

	public PageBean<JobInfo> getPb() {
		return pb;
	}

	public void setPb(PageBean<JobInfo> pb) {
		this.pb =pb;
	}
   
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public JobInfo getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}

	public List<JobInfo> getList() {
		return list;
	}

	public void setList(List<JobInfo> list) {
		this.list = list;
	}

	public String getJiStatus() {
		return jiStatus;
	}

	public void setJiStatus(String jiStatus) {
		this.jiStatus = jiStatus;
	}

	public JobInfoService getJobInfoService() {
		return jobInfoService;
	}

	public void setJobInfoService(JobInfoService jobInfoService) {
		this.jobInfoService = jobInfoService;
	}

	@Action(value = "add", results = { @Result(name = "success", location = "/index.jsp", type = "redirectAction") })
	public String add() {
		jobInfoService.add(jobInfo);
		return SUCCESS;
	}
	


	@Action(value = "findAll", results = { @Result(name = "success", location = "/index.jsp") })
	public String findAll() {
		list = jobInfoService.findAll();
		return SUCCESS;
	}
	@Action(value = "findById", results = { @Result(name = "success", location = "/backjob/backDetail.jsp") })
	public String findById() {
		jobInfo= jobInfoService.findById(jobInfo.getJiid());
		return SUCCESS;
	}
	@Action(value = "update", results = { @Result(name = "success", location ="selectByPage?jiStatus=1",type = "redirectAction") })
	
 	public String update(){
    JobInfo job=jobInfoService.findById(jobInfo.getJiid());
  job.setJiStatus(jobInfo.getJiStatus());
	this.jobInfoService.update(job);
	System.out.println("ok");
   
	return SUCCESS;
}
	
	

	@Action(value = "selectByPage", results = { @Result(name = "success", location = "/backjob/positions1.jsp")
	,@Result(name = "success1", location = "/backjob/positions.jsp"),
	@Result(name = "success2", location = "/backjob/positions3.jsp"),
	@Result(name = "success3", location = "/backjob/positions2.jsp")
	
	
	
	})
	public String selectByPage() {
		if(pb.getPageNo()==0){
			pb.setPageNo(1);
		}
		
		if(pb.getPageSize()==0){
			pb.setPageSize(3);
		}
   
		pb.setData(jobInfoService.selectBypage(jiStatus,jiSal, jiPro, date1, date2,
				pb.getPageNo(), pb.getPageSize()));
		pb.setTotal(jobInfoService.selectCount(jiStatus, jiSal, jiPro, date1, date2));
		
		if ("0".equals(jiStatus)) {

			return SUCCESS;
		}

		if ("1".equals(jiStatus)) {

			return "success1";
		}
		if ("2".equals(jiStatus)) {
			return "success2";
		} else {
			
			return "success3";
		}
		
	}

}
