package com.newer.dao.user;





import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;


@Repository("operDao")
public class OperDaoImpl extends HibernateDaoSupport implements OperDao{
     
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	
	@Override
	public Oper findByOper(Oper oper) {
		String hql ="from Oper where OUsername=? and OPwd=?";
		
		List<Oper> list=(List<Oper>) this.getHibernateTemplate().find(hql,new Object[]{oper.getOUsername(),oper.getOPwd()});
		if(list.size()>=1){
			return list.get(0);
		}
		
		return null;
		
	}


	@Override
	public Sysuser findBySysuser(Sysuser sysuser) {
		String hql ="from Sysuser where SUsername=? and SPwd=?";
		
		List<Sysuser> list=(List<Sysuser>) this.getHibernateTemplate().find(hql,new Object[]{sysuser.getSUsername(),sysuser.getSPwd()});
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
		
	}


	@Override
	public List<Trade> findTrades() {
		return getHibernateTemplate().loadAll(Trade.class);
	}






}
