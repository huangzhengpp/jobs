package com.newer.huangzheng.dao;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.newer.model.ComInfo;
import com.newer.model.JobClass;
import com.newer.model.JobField;
import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;


@Repository("jobDAO")
public class JobDAOImp extends HibernateDaoSupport implements JobDAO {
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void updateComInfo(ComInfo comInfo) {
		this.getHibernateTemplate().update(comInfo);

	}

	@Override
	public List<ComInfo> comList() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(ComInfo.class);
	}

	@Override
	public void addJob(JobInfo jobInfo) {
		this.getHibernateTemplate().save(jobInfo);

	}

	@Override
	public void updateJob(JobInfo jobInfo) {
		
		this.getHibernateTemplate().update(jobInfo);

	}

	@Override
	public List<JobInfo> jobList() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(JobInfo.class);
	}

	@Override
	public JobInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(JobInfo.class, id);
	}

	@Override
	public List<JobInfo> findJobByPage(JobName jobName, String jiedu, Trade trade, String sal, Date jireledate,
			String jiStatus, int jiNum, String jiPro, ComInfo comInfo,int pageNo, int pageSize) {
		String tempHql ="from JobInfo where 1=1";
		if(jobName!=null){
			tempHql +=" and jobName=:jobName";
		}
		if(comInfo!=null){
			tempHql +=" and comInfo=:comInfo";
		}
		if(!StringUtils.isEmpty(jiedu)){
			tempHql +=" and jiEdu like :jiedu";
		}
		if(trade!=null){
			tempHql +=" and trade like :trade";
		}
		if(!StringUtils.isEmpty(sal)){
			tempHql +=" and jiSal like :sal";
		}
		if(jireledate!=null){
			tempHql +=" and jiReledate  like :jireledate";
		}
		if(!StringUtils.isEmpty(jiStatus)){
			tempHql +=" and jiStatus = :jiStatus";
		}
		if(jiNum>0){
			tempHql +=" and jiNum > :jiNum";
		}
		if(!StringUtils.isEmpty(jiPro)){
			tempHql +=" and jiPro like :jiPro";
		}
		tempHql +="  order by jiReledate  desc";
		final String hql = tempHql;
		return this.getHibernateTemplate().execute(new HibernateCallback<List<JobInfo>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<JobInfo> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				if(jobName!=null){
					query.setInteger("jobName", jobName.getJnid());
				}
				if(comInfo!=null){
					query.setInteger("comInfo", comInfo.getCid());
				}
				if(!StringUtils.isEmpty(jiedu)){
					query.setString("jiedu", "%"+jiedu+"%");
				}
				if(trade!=null){
					query.setEntity("trade", "%"+trade+"%");
				}
				if(!StringUtils.isEmpty(sal)){
					query.setString("sal", "%"+sal+"%");
				}
				if(jireledate!=null){
					query.setDate("jireledate", jireledate);
				}
				if(!StringUtils.isEmpty(jiStatus)){
					query.setString("jiStatus", jiStatus);
				}
				if(jiNum>0){
					query.setInteger("jiNum", jiNum);
				}
				if(!StringUtils.isEmpty(jiPro)){
					query.setString("jiPro", "%"+jiPro+"%");
				}
				
			return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
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
	public ComInfo selecComById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(ComInfo.class, id);
	}

	@Override
	public List<JobInfo> selectJobByComId(Integer id) {
		
		return (List<JobInfo>) this.getHibernateTemplate().find("JI_CID", id);
	}

}
