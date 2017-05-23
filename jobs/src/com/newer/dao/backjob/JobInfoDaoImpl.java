package com.newer.dao.backjob;


import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.From;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.components.Head;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

@Repository("jobInfoDao")
public class JobInfoDaoImpl extends HibernateDaoSupport implements JobInfoDao {
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean add(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jobInfo);
		return true;
	}

	
	@Override
	public JobInfo findById(Integer jiid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobInfo.class, jiid);
	}

	@Override
	public List<JobInfo> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(JobInfo.class);
	}

	@Override
	public List<JobInfo> selectBypage(String jiStatus,String jiSal, String jiPro, String jiReledate,String jiReledate1,
			int pageNo,int pageSize) {
		
		String tempHql="from JobInfo where 1=1 ";
		if(!StringUtils.isEmpty(jiStatus)){
			tempHql+=" and jiStatus=:jiStatus";
		}
		
		if(!StringUtils.isEmpty(jiSal)){
			tempHql+=" and jiSal=:jiSal";
		}
		if(!StringUtils.isEmpty(jiPro)){
			tempHql+=" and jiPro=:jiPro";
		}
		if(!StringUtils.isEmpty(jiReledate)&&StringUtils.isEmpty(jiReledate1)){
			tempHql+=" and jiReledate=:jiReledate";
		}
		if(!StringUtils.isEmpty(jiReledate)&&!StringUtils.isEmpty(jiReledate1)){
			tempHql+=" and jiReledate between :jiReledate and :jiReledate1";
		}
		tempHql+=" order by jiReledate desc";
		final String hql=tempHql;
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
		
		@Override
		public List<JobInfo> doInHibernate(Session session) throws HibernateException {
			
			// TODO Auto-generated method stub
			Query query=session.createQuery(hql);
			if(!StringUtils.isEmpty(jiStatus)){
				query.setString("jiStatus", jiStatus);
			}
			
			if(!StringUtils.isEmpty(jiSal)){
				query.setString("jiSal", jiSal);
			}
			if(!StringUtils.isEmpty(jiPro)){
				query.setString("jiPro", jiPro);
			}
			if(!StringUtils.isEmpty(jiReledate)&&StringUtils.isEmpty(jiReledate1)){
				Date date=Date.valueOf(jiReledate);
				query.setDate("jiReledate", date);
			}
			if(!StringUtils.isEmpty(jiReledate)&&!StringUtils.isEmpty(jiReledate1)){
				Date date3=Date.valueOf(jiReledate);
			    Date date4=Date.valueOf(jiReledate1);
			    query.setDate("jiReledate", date3);
			    query.setDate("jiReledate1", date4);
			    
			}
			System.out.println(hql);
			return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		}
		});

			}

	@Override
	public  List<JobInfo> findStatus(String jiStatus,int pageNo,int pageSize) {
		String hql="from JobInfo j where j.jiStatus=:jiStatus ";
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				query.setString("jiStatus", jiStatus);
				return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageNo*pageSize).list();
				
			}
		});
	}

	@Override
	public void update(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jobInfo);
		
	}

	@Override
	public  Integer selectCount(String jiStatus,String jiSal, String jiPro, String jiReledate, String jiReledate1) {

		String tempHql="from JobInfo where 1=1 ";
		if(!StringUtils.isEmpty(jiStatus)){
			tempHql+=" and jiStatus=:jiStatus";
		}
		if(!StringUtils.isEmpty(jiSal)){
			tempHql+=" and jiSal=:jiSal";
		}
		if(!StringUtils.isEmpty(jiPro)){
			tempHql+=" and jiPro=:jiPro";
		}
		if(!StringUtils.isEmpty(jiReledate)&&StringUtils.isEmpty(jiReledate1)){
			tempHql+=" and jiReledate=:jiReledate";
		}
		if(!StringUtils.isEmpty(jiReledate)&&!StringUtils.isEmpty(jiReledate1)){
			tempHql+=" and jiReledate between :jiReledate and :jiReledate1";
		}
		tempHql+=" order by jiReledate desc";
		final String hql=tempHql;
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
		
		@Override
		public List<JobInfo> doInHibernate(Session session) throws HibernateException {
			
			// TODO Auto-generated method stub
			Query query=session.createQuery(hql);
			if(!StringUtils.isEmpty(jiStatus)){
				query.setString("jiStatus", jiStatus);
			}
			if(!StringUtils.isEmpty(jiSal)){
				query.setString("jiSal", jiSal);
			}
			if(!StringUtils.isEmpty(jiPro)){
				query.setString("jiPro", jiPro);
			}
			if(!StringUtils.isEmpty(jiReledate)&&StringUtils.isEmpty(jiReledate1)){
				Date date=Date.valueOf(jiReledate);
				query.setDate("jiReledate", date);
			}
			if(!StringUtils.isEmpty(jiReledate)&&!StringUtils.isEmpty(jiReledate1)){
				Date date3=Date.valueOf(jiReledate);
			    Date date4=Date.valueOf(jiReledate1);
			    query.setDate("jiReledate", date3);
			    query.setDate("jiReledate1", date4);
			    
			}
			System.out.println(hql);
			return query.list();
		}
		}).size();
	
	
	
	}
}
