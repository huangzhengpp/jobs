package com.newer.service.user;

import java.util.List;

import com.newer.model.Sysuser;

public interface SysUserService {

	public Sysuser findBySysuser(Integer sid);
	
	List<Sysuser> findSysUsers();
	
	void addSysuser(Sysuser sysuser);
	
	void updateSysuser(Sysuser sysuser);
}
