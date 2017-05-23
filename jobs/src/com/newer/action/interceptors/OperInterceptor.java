package com.newer.action.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class OperInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Map session=arg0.getInvocationContext().getSession();
		
		if(session.get("loginOper")==null){
			System.out.println("oper=null");
			return Action.LOGIN;
		}else{
			System.out.println("oper=on");
			return arg0.invoke();
		}
		
	}

}
