package com.newer.huangzheng.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.huangzheng.dao.JobDAO;
import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

@Service("jobService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class JobServiceImp  implements JobService {
	@Resource(name="jobDAO")
	private JobDAO dao;
	
	public void setDao(JobDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateComInfo(ComInfo comInfo) {
		this.dao.updateComInfo(comInfo);

	}

	@Override
	public List<ComInfo> comList() {
		// TODO Auto-generated method stub
		return this.dao.comList();
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void addJob(JobInfo jobInfo) {
		this.dao.addJob(jobInfo);

	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateJob(JobInfo jobInfo) {
		
		this.dao.updateJob(jobInfo);

	}

	@Override
	public List<JobInfo> jobList() {
		// TODO Auto-generated method stub
		return this.dao.jobList();
	}

	@Override
	public JobInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id);
	}

	

	@Override
	public List<JobField> selectAllJobField() {
		// TODO Auto-generated method stub
		return this.dao.selectAllJobField();
	}

	@Override
	public JobClass selectJobClassById(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.selectJobClassById(id);
	}

	@Override
	public JobName selectJobNameByName(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.selectJobNameByName(id);
	}

	@Override
	public Trade selectTradeByName(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.selectTradeByName(id);
	}

	@Override
	public List<JobInfo> findJobByPage(JobName jobName, String jiedu, Trade trade, String sal, Date jireledate,
			String jiStatus, int jiNum, String jiPro, ComInfo comInfo,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.dao.findJobByPage(jobName, jiedu, trade, sal, jireledate, jiStatus, jiNum, jiPro, comInfo, pageNo, pageSize);
	}

	@Override
	public ComInfo selectComById(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.selecComById(id);
	}

	@Override
	public List<JobInfo> selectJobByComId(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.selectJobByComId(id);
	}

}
