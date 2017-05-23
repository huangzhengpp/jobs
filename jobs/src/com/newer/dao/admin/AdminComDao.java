package com.newer.dao.admin;

import java.util.List;

import com.newer.model.ComInfo;
import com.newer.model.JobInfo;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;

public interface AdminComDao {
	//公司信息dao
	Integer cominfoCount(String status, String comname, Trade trade);
	ComInfo findByCominfo(Integer cid);
	List<ComInfo> findComAll(String comname);
	ComInfo findComOid(Oper oper);
	List<ComInfo> findComAll();
	List<ComInfo> findCominfos(Integer pageSize,Integer pageNo,String status,String comname,Trade trade);
	
	void updateCominfo(ComInfo comInfo);	
	void addCominfo(ComInfo comInfo);
	//公司登录dao
	Integer operCount(String statues, String comname, Trade trade);
	Oper findByOper(Integer oid);
	
	List<Oper> findOperAll(String status);
	List<Oper> findOpers(Integer pageSize,Integer pageNo,Integer oid);
	void updateOper(Oper oper);
	//管理员dao
	void addSysuser(Sysuser sysuser);
	void updateSysuser(Sysuser sysuser);
	//职位信息状态
	void updateJobInfo(JobInfo jobInfo);
	
}
