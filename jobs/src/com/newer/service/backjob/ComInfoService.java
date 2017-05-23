package com.newer.service.backjob;

import com.newer.model.ComInfo;
import com.newer.model.Oper;

public interface ComInfoService {
	void comUpdate(ComInfo comInfo);
	ComInfo comFindId(Oper oper);
	 ComInfo comFindById(Integer cid);
}
