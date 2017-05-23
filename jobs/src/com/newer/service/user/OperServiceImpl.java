package com.newer.service.user;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.user.OperDao;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;

@Service("operService")
@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
public class OperServiceImpl implements OperService{

	@Resource(name="operDao")
	private OperDao operDao;

	public void setOperDao(OperDao operDao) {
		this.operDao = operDao;
	}
	
	@Override
	public Oper findByOper(Oper oper) {
		
		return this.operDao.findByOper(oper);
	}

	@Override
	public Sysuser findBySysuser(Sysuser sysuser) {
		
		return this.operDao.findBySysuser(sysuser);
		
	}

	@Override
	public List<Trade> findTrades() {
		// TODO Auto-generated method stub
		return operDao.findTrades();
	}

}
