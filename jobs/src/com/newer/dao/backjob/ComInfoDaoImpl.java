package com.newer.dao.backjob;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.model.ComInfo;
import com.newer.model.Oper;
@Repository("comInfoDao")
public class ComInfoDaoImpl extends HibernateDaoSupport implements ComInfoDao {
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void comUpdate(ComInfo comInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(comInfo);
	}

	@Override
	public ComInfo comFindId(Oper oper) {
		// TODO Auto-generated method stub
		String hql="from ComInfo where oper=?";
		return (ComInfo) this.getHibernateTemplate().find(hql, oper).get(0);
	}
	@Override
	public ComInfo comFindById(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(ComInfo.class, cid);
	}

}
