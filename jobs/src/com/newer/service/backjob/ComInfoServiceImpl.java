package com.newer.service.backjob;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.backjob.ComInfoDao;
import com.newer.model.ComInfo;
import com.newer.model.Oper;
@Service("comInfoService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class ComInfoServiceImpl implements ComInfoService{
	@Resource(name="comInfoDao")
	 private ComInfoDao comInfoDao;
	
	
	public ComInfoDao getComInfoDao() {
		return comInfoDao;
	}

	public void setComInfoDao(ComInfoDao comInfoDao) {
		this.comInfoDao = comInfoDao;
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	
	@Override
	public void comUpdate(ComInfo comInfo) {
		// TODO Auto-generated method stub
		comInfoDao.comUpdate(comInfo);
	}

	@Override
	public ComInfo comFindId(Oper oper) {
		// TODO Auto-generated method stub
		
		return comInfoDao.comFindId(oper);
	}

	@Override
	public ComInfo comFindById(Integer cid) {
		// TODO Auto-generated method stub
		return comInfoDao.comFindById(cid);
	}

}
