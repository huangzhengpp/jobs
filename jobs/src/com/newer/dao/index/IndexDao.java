package com.newer.dao.index;

import java.util.List;

import com.newer.model.ComInfo;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

public interface IndexDao {
	
	//根据id查职位
	JobName selectJobNameById(Integer id);
	
	//根据id查询招聘信息详情
	JobInfo selectJobInfoById(Integer id);
	
	//根据职位查招聘信息
	List<JobInfo> selectJobInfoByJob(JobName jobName);
	
	//根据id查单个行业
	Trade selectTradeById(Integer id);
	
	//查所有行业的集合
	List<Trade> selectAllTrade();
	
	//查所有领域的集合
    List<JobField> selectAllJobField();
    
    //查询所有招聘信息
    List<JobInfo> selectAllJobInfo();
    
    //查询所有职位
    List<JobName> selectAllJobName();
    
    //根据公司查询职位招聘信息
    List<JobInfo> selectJobInfosByCom(ComInfo comInfo);
	
	//职位模糊查询
	List<JobName> selectJobNamesByName(String name);
	
	//高级查询查有效的职位招聘信息(根据职位)
	List<JobInfo> selectJobInfoByJobHigh(JobName jobName,String city,String sal,String edu,String pro,Trade trade);

	//公司模糊查询
	List<ComInfo> selectComInfosByName(String name);
		
	//高级查询查有效的职位招聘信息(根据公司)
	List<JobInfo> selectJobInfoByComHigh(ComInfo comInfo,String city,String sal,String edu,String pro,Trade trade);
}
