package com.newer.service.backjob;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.backjob.JobInfoDao;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

@Service("jobInfoService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class JobInfoServiceImpl implements JobInfoService{
     @Resource(name="jobInfoDao")
	  private JobInfoDao jobInfoDao;
	  
	
	public JobInfoDao getJobInfoDao() {
		return jobInfoDao;
	}

	public void setJobInfoDao(JobInfoDao jobInfoDao) {
		this.jobInfoDao = jobInfoDao;
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public boolean add(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		return this.jobInfoDao.add(jobInfo);
	}
	

	@Override
	public List<JobInfo> selectBypage(String jiStatus,String jiSal, String jiPro, String jiReledate,String jiReledate1,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.jobInfoDao.selectBypage(jiStatus,jiSal, jiPro, jiReledate, jiReledate1, pageNo, pageSize);
	}

	@Override
	public JobInfo findById(Integer jiid) {
		// TODO Auto-generated method stub
		return this.jobInfoDao.findById(jiid);
	}

	@Override
	public List<JobInfo> findAll() {
		// TODO Auto-generated method stub
		return this.jobInfoDao.findAll();
	}

	@Override
	public List<JobInfo> findStatus(String jiStatus,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return this.jobInfoDao.findStatus(jiStatus,pageNo,pageSize);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	
	@Override
	public void update(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		jobInfoDao.update(jobInfo);
	}

	@Override
	public Integer selectCount(String jiStatus, String jiSal, String jiPro, String jiReledate, String jiReledate1) {
		// TODO Auto-generated method stub
		return jobInfoDao.selectCount(jiStatus, jiSal, jiPro, jiReledate, jiReledate1)
				;
	}

	
	
	

}
