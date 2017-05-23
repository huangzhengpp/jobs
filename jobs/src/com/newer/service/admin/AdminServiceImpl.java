package com.newer.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.admin.AdminDao;
import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

@Service("adminService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class AdminServiceImpl implements AdminService{
	
	@Resource(name="adminDao")
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public JobInfo selectJobInfoByID(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectJobInfoByID(id);
	}

	@Override
	public ComInfo selectComInfoByID(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectComInfoByID(id);
	}

	@Override
	public List<JobInfo> selectChecked(String status, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return adminDao.selectChecked(status, pageSize, pageNo);
	}

	@Override
	public List<JobInfo> selectByHigh(String status, JobName jobName, Trade trade, String date, Integer pageSize,
			Integer pageNo) {
		// TODO Auto-generated method stub
		return adminDao.selectByHigh(status, jobName, trade, date, pageSize, pageNo);
	}

	@Override
	public List<JobInfo> selectChecked(String status) {
		// TODO Auto-generated method stub
		return adminDao.selectChecked(status);
	}

	@Override
	public List<JobInfo> selectByHigh(String status, JobName jobName, Trade trade, String date) {
		// TODO Auto-generated method stub
		return adminDao.selectByHigh(status, jobName, trade, date);
	}

	@Override
	public List<JobField> selectAllJobField() {
		// TODO Auto-generated method stub
		return adminDao.selectAllJobField();
	}

	@Override
	public JobClass selectJobClassById(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectJobClassById(id);
	}

	@Override
	public JobName selectJobNameByName(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectJobNameByName(id);
	}

	@Override
	public Trade selectTradeByName(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectTradeByName(id);
	}

	@Override
	public List<JobInfo> selectJobInfoByName(String status,String name,Integer pageSize,Integer pageNo) {
		// TODO Auto-generated method stub
		return adminDao.selectJobInfoByName(status,name,pageSize,pageNo);
	}

	@Override
	public List<JobInfo> selectJobInfoByName(String status,String name) {
		// TODO Auto-generated method stub
		return adminDao.selectJobInfoByName(status,name);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateJobInfo(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		adminDao.updateJobInfo(jobInfo);
	}

	@Override
	public List<Trade> selectAllTrade() {
		// TODO Auto-generated method stub
		return adminDao.selectAllTrade();
	}

	@Override
	public JobField selectJobField(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.selectJobField(id);
	}

	@Override
	public List<JobClass> selectAllJobClassByField(JobField field) {
		// TODO Auto-generated method stub
		return adminDao.selectAllJobClassByField(field);
	}

	@Override
	public List<JobName> selectAllJobNameByClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		return adminDao.selectAllJobNameByClass(jobClass);
	}

	@Override
	public List<JobInfo> selectJobInfoByDate(String date1, String date2) {
		// TODO Auto-generated method stub
		return adminDao.selectJobInfoByDate(date1, date2);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void addJobField(JobField jobField) {
		// TODO Auto-generated method stub
		adminDao.addJobField(jobField);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateJobField(JobField jobField) {
		// TODO Auto-generated method stub
		adminDao.updateJobField(jobField);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void addJobClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		adminDao.addJobClass(jobClass);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateJobClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		adminDao.updateJobClass(jobClass);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void addJobName(JobName jobName) {
		// TODO Auto-generated method stub
		adminDao.addJobName(jobName);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateJobName(JobName jobName) {
		// TODO Auto-generated method stub
		adminDao.updateJobName(jobName);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void addTrade(Trade trade) {
		// TODO Auto-generated method stub
		adminDao.addTrade(trade);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public void updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		adminDao.updateTrade(trade);
	}

}
