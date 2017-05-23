package com.newer.dao.user;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.model.Sysuser;

@Repository("sysuserDao")
public class SysUserDaoImpl extends HibernateDaoSupport  implements SysUserDao {

	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public Sysuser findBySysuser(Integer sid) {
		
		return getHibernateTemplate().get(Sysuser.class, sid);
	}

	@Override
	public List<Sysuser> findSysUsers() {
		String hql="from Sysuser where SType='0'";
		return (List<Sysuser>) getHibernateTemplate().find(hql);
	}

	@Override
	public void updateSysuser(Sysuser sysuser) {
		getHibernateTemplate().update(sysuser);

	}
	@Override
	public void addSysuser(Sysuser sysuser) {
	
		getHibernateTemplate().save(sysuser);
		
	}

}
