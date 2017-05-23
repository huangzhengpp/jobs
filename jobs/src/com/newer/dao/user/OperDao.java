package com.newer.dao.user;


import java.util.List;

import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;

public interface OperDao {
        //登录
	public Oper findByOper(Oper oper);
	
	List<Trade> findTrades();
	public  Sysuser findBySysuser(Sysuser sysuser);
	
}
