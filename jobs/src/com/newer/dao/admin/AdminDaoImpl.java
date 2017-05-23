package com.newer.dao.admin;

import java.sql.Date;
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
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

//持久层实例
@Repository("adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public JobInfo selectJobInfoByID(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobInfo.class, id);
	}

	@Override
	public ComInfo selectComInfoByID(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(ComInfo.class, id);
	}

	@Override
	public List<JobInfo> selectChecked(String status, Integer pageSize, Integer pageNo) {
		String tempHql="from JobInfo where 1=1 ";
		if(!status.equals("-1")){
			tempHql+=" and jiStatus=:jiStatus";
		}
		
		tempHql+=" order by jiReledate";
		final String hql=tempHql;
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(!status.equals("-1")){
					query.setString("jiStatus", status);
				}	
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}

	@Override
	public List<JobInfo> selectByHigh(String status,JobName jobName,Trade trade,String date,Integer pageSize,
			Integer pageNo) {
		String tempHql="from JobInfo where 1=1 ";
		if(!status.equals("-1")){
			tempHql+=" and jiStatus=:jiStatus";
		}
		
		if(jobName!=null){
			tempHql+=" and jobName=:jobName";
		}
		
		if(trade!=null){
			tempHql+=" and trade=:trade";
		}
		
		if(!StringUtils.isEmpty(date)){
			tempHql+=" and jiReledate=:jiReledate";
		}
		
		tempHql+=" order by jiReledate desc";
		final String hql=tempHql;
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(!status.equals("-1")){
					query.setString("jiStatus", status);
				}
				
				if(jobName!=null){
					query.setEntity("jobName", jobName);
				}
				
				if(trade!=null){
					query.setEntity("trade", trade);
				}
				
				if(!StringUtils.isEmpty(date)){
					Date date1 = Date.valueOf(date);
					query.setDate("jiReledate", date1);
				}
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}

	@Override
	public List<JobInfo> selectChecked(String status) {
		// TODO Auto-generated method stub
		String hql="from JobInfo where jiStatus=? order by jiReledate desc";
		return (List<JobInfo>) this.getHibernateTemplate().find(hql, new Object[]{status});
	}

	@Override
	public List<JobInfo> selectByHigh(String status,JobName jobName,Trade trade, String date) {
		String tempHql="from JobInfo where 1=1 ";
		if(!status.equals("-1")){
			tempHql+=" and jiStatus=:jiStatus";
		}
		
		if(jobName!=null){
			tempHql+=" and jobName=:jobName";
		}
		
		if(trade!=null){
			tempHql+=" and trade=:trade";
		}
		
		if(!StringUtils.isEmpty(date)){
			tempHql+=" and jiReledate=:jiReledate";
		}
		
		tempHql+=" order by jiReledate desc";
		final String hql=tempHql;
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(!status.equals("-1")){
					query.setString("jiStatus", status);
				}
				
				if(jobName!=null){
					query.setEntity("jobName", jobName);
				}
				
				if(trade!=null){
					query.setEntity("trade", trade);
				}
				
				if(!StringUtils.isEmpty(date)){
					Date date1 = Date.valueOf(date);
					query.setDate("jiReledate", date1);
				}
				return query.list();
			}
		});
	}

	@Override
	public List<JobField> selectAllJobField() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(JobField.class);
	}

	@Override
	public JobClass selectJobClassById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobClass.class, id);
	}

	@Override
	public JobName selectJobNameByName(Integer id) {
		// TODO Auto-generated method stub
		return (JobName) this.getHibernateTemplate().get(JobName.class, id);
	}

	@Override
	public Trade selectTradeByName(Integer id) {
		// TODO Auto-generated method stub
		return (Trade) this.getHibernateTemplate().get(Trade.class, id);
	}

	@Override
	public List<JobInfo> selectJobInfoByName(String status,String name,Integer pageSize,Integer pageNo) {
		final String hql="from JobInfo where jiStatus=:jiStatus and comInfo.comName like :name order by jiReledate";
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				query.setString("jiStatus",status);
				query.setString("name","%"+name+"%");
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
			}
		});
	}

	@Override
	public List<JobInfo> selectJobInfoByName(String status,String name) {
		// TODO Auto-generated method stub
		String hql="from JobInfo where jiStatus=? and comInfo.comName like ?";
		return (List<JobInfo>)this.getHibernateTemplate().find(hql, new Object[]{status,"%"+name+"%"});
	}

	@Override
	public void updateJobInfo(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jobInfo);
	}

	@Override
	public List<Trade> selectAllTrade() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(Trade.class);
	}

	@Override
	public JobField selectJobField(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobField.class, id);
	}

	@Override
	public List<JobClass> selectAllJobClassByField(JobField field) {
		// TODO Auto-generated method stub
		String hql="from JobClass where jobField=?";
		return (List<JobClass>)this.getHibernateTemplate().find(hql, new Object[]{field});
	}

	@Override
	public List<JobName> selectAllJobNameByClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		String hql="from JobName where jobClass=?";
		return (List<JobName>) this.getHibernateTemplate().find(hql, new Object[]{jobClass});
	}

	@Override
	public List<JobInfo> selectJobInfoByDate(String date1, String date2) {
		// TODO Auto-generated method stub
		String hql = "from JobInfo where jiReledate between ? and ?";
		return (List<JobInfo>) this.getHibernateTemplate().find(hql,new Object[]{Date.valueOf(date1),Date.valueOf(date2)});
	}

	@Override
	public void addJobField(JobField jobField) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jobField);
	}

	@Override
	public void updateJobField(JobField jobField) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jobField);
	}

	@Override
	public void addJobClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jobClass);
	}

	@Override
	public void updateJobClass(JobClass jobClass) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jobClass);
	}

	@Override
	public void addJobName(JobName jobName) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jobName);
	}

	@Override
	public void updateJobName(JobName jobName) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jobName);
	}

	@Override
	public void addTrade(Trade trade) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(trade);
	}

	@Override
	public void updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(trade);
	}


}
