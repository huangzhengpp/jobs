package com.newer.service.index;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.index.IndexDao;
import com.newer.model.ComInfo;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

@Service("indexService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class IndexServiceImpl implements IndexService{
	
	@Resource(name="indexDao")
	private IndexDao indexDao;

	public void setAdminDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	@Override
	public JobName selectJobNameById(Integer id) {
		// TODO Auto-generated method stub
		return indexDao.selectJobNameById(id);
	}

	@Override
	public List<JobInfo> selectJobInfoByJob(JobName jobName) {
		// TODO Auto-generated method stub
		return indexDao.selectJobInfoByJob(jobName);
	}

	@Override
	public List<Trade> selectAllTrade() {
		// TODO Auto-generated method stub
		return indexDao.selectAllTrade();
	}

	@Override
	public List<JobName> selectJobNamesByName(String name) {
		// TODO Auto-generated method stub
		return indexDao.selectJobNamesByName(name);
	}

	@Override
	public List<JobInfo> selectJobInfoByJobHigh(JobName jobName, String city, String sal, String edu, String pro,
			Trade trade) {
		// TODO Auto-generated method stub
		return indexDao.selectJobInfoByJobHigh(jobName, city, sal, edu, pro, trade);
	}

	@Override
	public List<ComInfo> selectComInfosByName(String name) {
		// TODO Auto-generated method stub
		return indexDao.selectComInfosByName(name);
	}

	@Override
	public List<JobInfo> selectJobInfoByComHigh(ComInfo comInfo, String city, String sal, String edu, String pro,
			Trade trade) {
		// TODO Auto-generated method stub
		return indexDao.selectJobInfoByComHigh(comInfo, city, sal, edu, pro, trade);
	}

	@Override
	public Trade selectTradeById(Integer id) {
		// TODO Auto-generated method stub
		return indexDao.selectTradeById(id);
	}

	@Override
	public List<JobField> selectAllJobField() {
		// TODO Auto-generated method stub
		return indexDao.selectAllJobField();
	}

	@Override
	public List<JobInfo> selectAllJobInfo() {
		// TODO Auto-generated method stub
		return indexDao.selectAllJobInfo();
	}

	@Override
	public List<JobName> selectAllJobName() {
		// TODO Auto-generated method stub
		return indexDao.selectAllJobName();
	}

	@Override
	public List<JobInfo> selectJobInfosByCom(ComInfo comInfo) {
		// TODO Auto-generated method stub
		return indexDao.selectJobInfosByCom(comInfo);
	}

	@Override
	public JobInfo selectJobInfoById(Integer id) {
		// TODO Auto-generated method stub
		return indexDao.selectJobInfoById(id);
	}

}
