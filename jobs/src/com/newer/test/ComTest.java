package com.newer.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newer.action.admin.AdminComAction;
import com.newer.model.ComInfo;
import com.newer.model.JobInfo;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;
import com.newer.service.admin.AdminComService;
import com.newer.service.admin.AdminComServiceImpl;

public class ComTest {

	private AdminComService adminComService;
	private AdminComAction adminComAction;
	@Before
	public void init(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		adminComService=ctx.getBean("adminComService",AdminComService.class);
		adminComAction=ctx.getBean("adminComAction",AdminComAction.class);
	}
	
	@Test
	public void test1(){
		//System.out.println(adminComService.cominfoCount().toString());
		List<Oper> list=adminComService.findOperAll("");
		for(Oper c:list){
			System.out.println(c.getOUsername());
		}
	}
	@Test
	public void test2(){
		//System.out.println(adminComService.cominfoCount().toString());
		System.out.println(adminComAction.Comdetail());
	}
	@Test
	public void test3(){
		//System.out.println(adminComService.cominfoCount().toString());
		Integer size=adminComService.cominfoCount("0", "n", null);
		
		System.out.println("size="+size);
	}
	@Test
	public void test4(){
		//System.out.println(adminComService.cominfoCount().toString());
		List<ComInfo> o=adminComService.findComAll(null);
		System.out.println("size="+o.size());
	}
	@Test
	public void test5(){
		//System.out.println(adminComService.cominfoCount().toString());
		/*Oper oper=adminComService.findByOper(5);
		ComInfo c=new ArrayList<ComInfo>(oper.getComInfos()).get(0);*/
		Oper oper=new Oper();
		oper.setOid(3);
		ComInfo list=adminComService.findComOid(oper);
		System.out.println(list.getComName());
		
	}
}
