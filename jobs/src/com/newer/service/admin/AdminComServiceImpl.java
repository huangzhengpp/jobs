package com.newer.service.admin;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.admin.AdminComDaoImpl;
import com.newer.model.ComInfo;
import com.newer.model.JobInfo;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;

@Service("adminComService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class AdminComServiceImpl implements AdminComService {
	
	@Resource(name="adminComDao")
	private AdminComDaoImpl adminComDaoImpl;
	
	
	
	
	public void setAdminComDaoImpl(AdminComDaoImpl adminComDaoImpl) {
		this.adminComDaoImpl = adminComDaoImpl;
	}

	@Override
	public Integer cominfoCount(String statues, String comname, Trade trade) {
		
		return adminComDaoImpl.cominfoCount(statues,comname,trade);
	}

	@Override
	public ComInfo findByCominfo(Integer cid) {
		// TODO Auto-generated method stub
		return adminComDaoImpl.findByCominfo(cid);
	}

	@Override
	public List<ComInfo> findCominfos(Integer pageSize, Integer pageNo, String statues, String comname, Trade trade) {
		
		return adminComDaoImpl.findCominfos(pageSize, pageNo, statues, comname, trade);
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateCominfo(ComInfo comInfo) {
		adminComDaoImpl.updateCominfo(comInfo);

	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addCominfo(ComInfo comInfo) {
		adminComDaoImpl.addCominfo(comInfo);

	}

	@Override
	public Integer operCount(String statues, String comname, Trade trade) {
		return adminComDaoImpl.operCount(statues,comname,trade);
	}

	@Override
	public Oper findByOper(Integer oid) {
		
		return adminComDaoImpl.findByOper(oid);
	}

	@Override
	public List<Oper> findOpers(Integer pageSize,Integer pageNo,Integer oid){
		return adminComDaoImpl.findOpers(pageSize, pageNo, oid);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateOper(Oper oper) {
		adminComDaoImpl.updateOper(oper);

	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addSysuser(Sysuser sysuser) {
		adminComDaoImpl.addSysuser(sysuser);

	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateJobInfo(JobInfo jobInfo) {
		adminComDaoImpl.updateJobInfo(jobInfo);

	}

	@Override
	public List<ComInfo> findComAll(String comname) {
		return adminComDaoImpl.findComAll(comname);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateSysuser(Sysuser sysuser) {
		adminComDaoImpl.updateSysuser(sysuser);
		
	}

	@Override
	public List<ComInfo> findComAll() {
		// TODO Auto-generated method stub
		return adminComDaoImpl.findComAll();
	}

	@Override
	public List<Oper> findOperAll(String status) {
		
		return adminComDaoImpl.findOperAll(status);
	}

/*	@Override
	public ComInfo findByOperId(Oper oper) {
		
		return adminComDaoImpl.findByOperId(oper);
	}
*/
	@Override
	public ComInfo findComOid(Oper oper) {
		// TODO Auto-generated method stub
		return adminComDaoImpl.findComOid(oper);
	}

}
