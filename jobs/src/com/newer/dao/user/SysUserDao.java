package com.newer.dao.user;


import java.util.List;

import com.newer.model.Sysuser;

public interface SysUserDao {
        //登录
	public Sysuser findBySysuser(Integer sid);
	
	List<Sysuser> findSysUsers();
	
	void addSysuser(Sysuser sysuser);
	
	void updateSysuser(Sysuser sysuser);
	
}
