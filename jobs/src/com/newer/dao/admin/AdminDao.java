package com.newer.dao.admin;

import java.util.List;

import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

public interface AdminDao {
	
	//根據時間查所有
	List<JobInfo> selectJobInfoByDate(String date1,String date2);

	//根据信息ID查询单个职位审核信息
	JobInfo selectJobInfoByID(Integer id);
	
	//根据编号查询公司信息
	ComInfo selectComInfoByID(Integer id);
	
	//根据公司名称分页模糊查询公司集合
	List<JobInfo> selectJobInfoByName(String status,String name,Integer pageSize,Integer pageNo);
	
	//根据公司名称模糊查询公司集合（用于查总条数）
	List<JobInfo> selectJobInfoByName(String status,String name);
	
	//管理员审核职位信息
	void updateJobInfo(JobInfo jobInfo);
	
	//分页查询未审核/已通过/未通过的职位信息
	List<JobInfo> selectChecked(String status,Integer pageSize,Integer pageNo);
	
	//分页已通过/未通过职位信息高级查询
	List<JobInfo> selectByHigh(String status,JobName jobName,Trade trade,String date,Integer pageSize,Integer pageNo);
	
	//查询未审核/已通过/未通过的职位信息（用于查总条数）
	List<JobInfo> selectChecked(String status);
	
	//已通过/未通过职位信息高级查询（用于查总条数）
	List<JobInfo> selectByHigh(String status,JobName jobName,Trade trade,String date);
	
	//查询所有工作领域
	List<JobField> selectAllJobField();
	
	//查询所有行業
	List<Trade> selectAllTrade();
	
	//根據id查單個工作領域
	JobField selectJobField(Integer id);
	
	//查单个工作类别
	JobClass selectJobClassById(Integer id);
	
	//查具体的工作岗位
	JobName selectJobNameByName(Integer id);
	
	//查询单个行业
	Trade selectTradeByName(Integer id);
	
	//查詢具體工作領域下的類別集合
	List<JobClass> selectAllJobClassByField(JobField field);
	
	//查詢具體工作類別下的工作集合
	List<JobName> selectAllJobNameByClass(JobClass jobClass);
	
	//增加工作领域
	void addJobField(JobField jobField);
	
	//修改工作领域
	void updateJobField(JobField jobField);
	
	//增加工作类别
	void addJobClass(JobClass jobClass);
		
	//修改工作类别
	void updateJobClass(JobClass jobClass);
	
	//增加职位
	void addJobName(JobName jobName);
			
	//修改职位
	void updateJobName(JobName jobName);
	
	//增加行业
	void addTrade(Trade trade);
			
	//修改行业
	void updateTrade(Trade trade);

}
