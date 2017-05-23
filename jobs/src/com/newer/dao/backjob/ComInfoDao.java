package com.newer.dao.backjob;

import com.newer.model.ComInfo;
import com.newer.model.Oper;

public interface ComInfoDao {
   void comUpdate(ComInfo comInfo);
   ComInfo  comFindId(Oper oper);
   ComInfo comFindById(Integer cid);
	
	  
}
