package com.newer.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.user.SysUserDao;
import com.newer.model.Sysuser;

@Service("sysuserService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class SysUserServiceImpl implements SysUserService {

	@Resource(name="sysuserDao")
	private SysUserDao sysUserDao;
	@Override
	public Sysuser findBySysuser(Integer sid) {
		// TODO Auto-generated method stub
		return sysUserDao.findBySysuser(sid);
	}

	@Override
	public List<Sysuser> findSysUsers() {
		// TODO Auto-generated method stub
		return sysUserDao.findSysUsers();
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateSysuser(Sysuser sysuser) {
		sysUserDao.updateSysuser(sysuser);

	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addSysuser(Sysuser sysuser) {
		sysUserDao.addSysuser(sysuser);
		
	}

}
