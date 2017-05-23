package com.newer.action.index;

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
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;
import com.newer.service.index.IndexService;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("struts-default")
@Namespace("/")
@ResultPath("/")
@Controller("indexAction")//控制层注解
public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="indexService")
	IndexService indexService;
	
	private JobName jobName;
	private List<JobField> jobFields;
	private List<JobName> jobNames;
	private List<JobInfo> jobInfos;
	private List<Trade> trades;
	private List<ComInfo> comInfos;
	private Trade trade;
	private JobInfo jobInfo;
	private ComInfo comInfo;
	
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
	//根据职位查所有职位招聘信息
	@Action(value="selectJobInfoById",results={@Result(name="success",location="jobDetail.jsp")})
	public String selectJobInfoById(){
		jobInfo = indexService.selectJobInfoById(jobInfo.getJiid());
		comInfo = jobInfo.getComInfo();
		return SUCCESS;
	}
	
	//高级查询招聘信息集合
	@Action(value="selectJobInfosByHihIndex",results={@Result(name="success",location="index2.jsp")})
	public String selectJobInfosByHihIndex(){
		trades = indexService.selectAllTrade();
		List<JobInfo> jfs1 = new ArrayList<JobInfo>();
		List<JobInfo> jfs2 = new ArrayList<JobInfo>();
		if(trade.getTid()!=null){
			trade = indexService.selectTradeById(trade.getTid());
		}else{
			trade=null;
		}
		
		jobNames = indexService.selectJobNamesByName(jobName.getJnname());
		
		for(JobName n:jobNames){
			List<JobInfo> js = indexService.selectJobInfoByJobHigh(n, jobInfo.getJiAddr(), jobInfo.getJiSal(), jobInfo.getJiEdu(), jobInfo.getJiPro(), trade);
			for(JobInfo j:js){
		    	jfs1.add(j);
		    }
		}
	
		comInfos = indexService.selectComInfosByName(comInfo.getComName());
		for(ComInfo c:comInfos){
			List<JobInfo> js1 = indexService.selectJobInfoByComHigh(c, jobInfo.getJiAddr(), jobInfo.getJiSal(), jobInfo.getJiEdu(), jobInfo.getJiPro(), trade);
		    for(JobInfo j:js1){
		    	jfs2.add(j);
		    }
		}
		
		jfs1.retainAll(jfs2);
		jobInfos = jfs1;
		return SUCCESS;
	}
	
	//根据职位查所有职位招聘信息
	@Action(value="selectJobIofosByJobIndex",results={@Result(name="success",location="index2.jsp")})
	public String selectJobIofosByJobIndex(){
		jobName = indexService.selectJobNameById(jobName.getJnid());
		jobInfos = indexService.selectJobInfoByJob(jobName);
		trades = indexService.selectAllTrade();
		return SUCCESS;
	}
	
	//根据公司名模糊查所有职位招聘信息
	@Action(value="selectJobInfoByComNameIndex",results={@Result(name="success",location="index2.jsp")})
	public String selectJobInfoByComNameIndex(){
		trades = indexService.selectAllTrade();
		List<JobInfo> jbs = new ArrayList<JobInfo>();
		comInfos = indexService.selectComInfosByName(comInfo.getComName());
		for(ComInfo c:comInfos){
			List<JobInfo> js1 = indexService.selectJobInfosByCom(c);
		    for(JobInfo j:js1){
		    	jbs.add(j);
		    }
		}
		jobInfos = jbs;
		return SUCCESS;
	}
	
	//查询所有招聘信息跟领域集合
	@Action(value="selectAllJobInfoIndex",results={@Result(name="success",location="index.jsp")})
	public String selectAllJobIofoIndex(){
		jobFields = indexService.selectAllJobField();
		jobInfos = indexService.selectAllJobInfo();
		jobNames = indexService.selectAllJobName();
		return SUCCESS;
	}
	
	public JobName getJobName() {
		return jobName;
	}
	public void setJobName(JobName jobName) {
		this.jobName = jobName;
	}
	public List<JobInfo> getJobInfos() {
		return jobInfos;
	}
	public void setJobInfos(List<JobInfo> jobInfos) {
		this.jobInfos = jobInfos;
	}
	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	public List<ComInfo> getComInfos() {
		return comInfos;
	}
	public void setComInfos(List<ComInfo> comInfos) {
		this.comInfos = comInfos;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
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

	public List<JobName> getJobNames() {
		return jobNames;
	}

	public void setJobNames(List<JobName> jobNames) {
		this.jobNames = jobNames;
	}

	public List<JobField> getJobFields() {
		return jobFields;
	}

	public void setJobFields(List<JobField> jobFields) {
		this.jobFields = jobFields;
	}

}
