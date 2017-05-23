package com.newer.huangzheng.service;

import java.sql.Date;
import java.util.List;

import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;



public interface JobService {
	/*
	 * 企业信息的增删改
	 */
	public void updateComInfo(ComInfo comInfo);
	// findAll查所有
	public List<ComInfo> comList();
	public ComInfo selectComById(Integer id);
	/*
	 * 职位信息的增改禁
	 */
	//根据公司ID查找简历
	public List<JobInfo> selectJobByComId(Integer id);
	//add职位
	public void addJob(JobInfo jobInfo);
	//禁用职位信息
	public void updateJob(JobInfo jobInfo);
	// findAll查所有
	public List<JobInfo> jobList();
	//find by id
	public JobInfo findById(Integer id);
	//模糊加工作分页查询
	public List<JobInfo> findJobByPage(JobName jobName,String jiedu,Trade trade,String sal,Date jireledate,String jiStatus,int jiNum,String jiPro,ComInfo comInfo, int pageNo,int pageSize );
	//二级查询
	public List<JobField> selectAllJobField();
	public JobClass selectJobClassById(Integer id);
	public JobName selectJobNameByName(Integer id);
	public Trade selectTradeByName(Integer id);
}
