package com.newer.dao.index;

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
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

//持久层实例
@Repository("indexDao")
public class IndexDaoImpl extends HibernateDaoSupport implements IndexDao{
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public JobName selectJobNameById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobName.class, id);
	}

	@Override
	public List<JobInfo> selectJobInfoByJob(JobName jobName) {
		String hql="from JobInfo where jobName=? and jiStatus='1'";
		return (List<JobInfo>) this.getHibernateTemplate().find(hql, new Object[]{jobName});
	}

	@Override
	public List<Trade> selectAllTrade() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(Trade.class);
	}

	@Override
	public List<JobName> selectJobNamesByName(String name) {
		// TODO Auto-generated method stub
		String hql="from JobName where jnname like ?";
		return (List<JobName>) this.getHibernateTemplate().find(hql, new Object[]{"%"+name+"%"});
	}

	@Override
	public List<JobInfo> selectJobInfoByJobHigh(JobName jobName, String city, String sal, String edu, String pro,
			Trade trade) {
		String tempHql="from JobInfo where jiStatus='1'";
		
		if(jobName!=null){
			tempHql+=" and jobName=:jobName";
		}
		
		if(!StringUtils.isEmpty(city)){
			tempHql+=" and jiAddr=:jiAddr";
		}
		
		if(!StringUtils.isEmpty(sal)){
			tempHql+=" and jiSal=:jiSal";
		}
		
		if(!StringUtils.isEmpty(edu)){
			tempHql+=" and jiEdu=:jiEdu";
		}
		
		if(!StringUtils.isEmpty(pro)){
			tempHql+=" and jiPro=:jiPro";
		}
		
		if(trade!=null){
			tempHql+=" and trade=:trade";
		}
		
		final String hql=tempHql;
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(jobName!=null){
					query.setEntity("jobName", jobName);
				}
				
				if(!StringUtils.isEmpty(city)){
					query.setString("jiAddr", city);
				}
				
				if(!StringUtils.isEmpty(sal)){
					query.setString("jiSal", sal);
				}
				
				if(!StringUtils.isEmpty(edu)){
					query.setString("jiEdu", edu);
				}
				
				if(!StringUtils.isEmpty(pro)){
					query.setString("jiPro", pro);
				}
				
				if(trade!=null){
					query.setEntity("trade", trade);
				}
				
				return query.list();
			}
		});
	}

	@Override
	public List<ComInfo> selectComInfosByName(String name) {
		// TODO Auto-generated method stub
		String hql="from ComInfo where comName like ?";
		return (List<ComInfo>) this.getHibernateTemplate().find(hql, new Object[]{"%"+name+"%"});
	}

	@Override
	public List<JobInfo> selectJobInfoByComHigh(ComInfo comInfo, String city, String sal, String edu, String pro,
			Trade trade) {
		// TODO Auto-generated method stub
        String tempHql="from JobInfo where jiStatus='1'";
		
		if(comInfo!=null){
			tempHql+=" and comInfo=:comInfo";
		}
		
		if(!StringUtils.isEmpty(city)){
			tempHql+=" and jiAddr=:jiAddr";
		}
		
		if(!StringUtils.isEmpty(sal)){
			tempHql+=" and jiSal=:jiSal";
		}
		
		if(!StringUtils.isEmpty(edu)){
			tempHql+=" and jiEdu=:jiEdu";
		}
		
		if(!StringUtils.isEmpty(pro)){
			tempHql+=" and jiPro=:jiPro";
		}
		
		if(trade!=null){
			tempHql+=" and trade=:trade";
		}
		
		final String hql=tempHql;
		//当hibernateTemplate模板提供的查询方法不适合实际业务需求，
		//需要自定义查询，执行hibernateTemplate的回调函数
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query=session.createQuery(hql);
				if(comInfo!=null){
					query.setEntity("comInfo", comInfo);
				}
				
				if(!StringUtils.isEmpty(city)){
					query.setString("jiAddr", city);
				}
				
				if(!StringUtils.isEmpty(sal)){
					query.setString("jiSal", sal);
				}
				
				if(!StringUtils.isEmpty(edu)){
					query.setString("jiEdu", edu);
				}
				
				if(!StringUtils.isEmpty(pro)){
					query.setString("jiPro", pro);
				}
				
				if(trade!=null){
					query.setEntity("trade", trade);
				}
				
				return query.list();
			}
		});
	}

	@Override
	public Trade selectTradeById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Trade.class, id);
	}

	@Override
	public List<JobField> selectAllJobField() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(JobField.class);
	}

	@Override
	public List<JobInfo> selectAllJobInfo() {
		// TODO Auto-generated method stub
		String hql="from JobInfo where jiStatus='1'";
		return (List<JobInfo>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<JobName> selectAllJobName() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(JobName.class);
	}

	@Override
	public List<JobInfo> selectJobInfosByCom(ComInfo comInfo) {
		// TODO Auto-generated method stub
		String hql = "from JobInfo where jiStatus='1'and comInfo=?";
		return (List<JobInfo>) this.getHibernateTemplate().find(hql, new Object[]{comInfo});
	}

	@Override
	public JobInfo selectJobInfoById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(JobInfo.class, id);
	}

}
