package com.newer.dao.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.model.ComInfo;
import com.newer.model.JobInfo;
import com.newer.model.Oper;
import com.newer.model.Sysuser;
import com.newer.model.Trade;

@Repository("adminComDao")
public class AdminComDaoImpl extends HibernateDaoSupport implements AdminComDao {

	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Integer cominfoCount(String status, String comname, Trade trade) {
		String hql="from ComInfo c where 1=1";
		if("0".equals(status)){
			 hql+=" and c.comStatus="+status;
		}else{
			hql+=" and c.comStatus<>'0'";
		}
		if(!(trade==null)){
			if(trade.getTid()!=null){
				hql+=" and c.trade="+trade.getTid();
			}
		}
		if(!StringUtils.isEmpty(comname)){
			hql+=" and c.comName like ?";
			
			return this.getHibernateTemplate().find(hql,"%"+comname+"%").size();
		}
		return this.getHibernateTemplate().find(hql).size(); 
	}
	
	@Override
	public ComInfo findByCominfo(Integer cid) {
	
		
		return this.getHibernateTemplate().get(ComInfo.class, cid);
	}

	@Override
	public List<ComInfo> findCominfos(Integer pageSize, Integer pageNo, String status, String comname, Trade trade) {
		String tempHql="from ComInfo c where 1=1";
		System.out.println("status="+status);
		if("0".equals(status)){
			tempHql+=" and c.comStatus="+status;
		}else{
			tempHql+=" and c.comStatus<>'0'";
		}
		if(!StringUtils.isEmpty(comname)){
			tempHql+=" and c.comName like :comname";
		}
		if(!(trade==null)){
			if(trade.getTid()!=null){
				tempHql+=" and trade=:trade";
			}
		}
		tempHql+=" order by cid desc";
		final String hql=tempHql;
		return this.getHibernateTemplate().execute(new HibernateCallback<List<ComInfo>>() {

			@Override
			public List<ComInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(!StringUtils.isEmpty(comname)){
					query.setString("comname", "%"+comname+"%");
				}
				if(!(trade==null)){
					if(trade.getTid()!=null){
						query.setInteger("trade", trade.getTid());
					}
					//query.setProperties(trade);
					
				}
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
			}
			
		});
	}

	@Override
	public void updateCominfo(ComInfo comInfo) {
		this.getHibernateTemplate().update(comInfo);

	}

	@Override
	public void addCominfo(ComInfo comInfo) {
		this.getHibernateTemplate().save(comInfo);

	}

	@Override
	public Oper findByOper(Integer oid) {
		
		return this.getHibernateTemplate().get(Oper.class, oid);
	}

	@Override
	public List<Oper> findOpers(Integer pageSize, Integer pageNo,Integer oid) {
		String tempHql="from Oper where 1=1";
		if(!(oid==null)){
			tempHql+=" and oid=:oid";
		}
		
		tempHql+=" order by oid desc";
		final String hql=tempHql;
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Oper>>() {

			@Override
			public List<Oper> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(!(oid==null)){
					query.setInteger("oid", oid);
				}
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
			}
			
		});
	}

	@Override
	public void updateOper(Oper oper) {
		getHibernateTemplate().update(oper);

	}

	@Override
	public void addSysuser(Sysuser sysuser) {
		getHibernateTemplate().save(sysuser);

	}

	@Override
	public Integer operCount(String statues, String comname, Trade trade) {
		
		return getHibernateTemplate().loadAll(Oper.class).size();
	}

	@Override
	public void updateJobInfo(JobInfo jobInfo) {
		getHibernateTemplate().update(jobInfo);
		
	}

	@Override
	public void updateSysuser(Sysuser sysuser) {
		
		
	}

	@Override
	public List<ComInfo> findComAll(String comname) {
		String hql="from ComInfo where 1=1";
		if(!StringUtils.isEmpty(comname)){
			hql+=" and comName=?";
			return (List<ComInfo>) this.getHibernateTemplate().find(hql,comname);
		}
		return (List<ComInfo>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<ComInfo> findComAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().loadAll(ComInfo.class);
	}

	@Override
	public List<Oper> findOperAll(String status) {
		String hql="from Oper where 1=1";
		if(!StringUtils.isEmpty(status)){
			hql+=" and OStatus=?";
			return (List<Oper>) getHibernateTemplate().find(hql, status);
		}
		return getHibernateTemplate().loadAll(Oper.class);
	}

	

	@Override
	public ComInfo findComOid(Oper oper) {
		String hql="from ComInfo where oper=?";
	
			return (ComInfo) getHibernateTemplate().find(hql,oper).get(0);
		
	}

}
