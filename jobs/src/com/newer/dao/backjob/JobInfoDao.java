package com.newer.dao.backjob;

import java.util.List;


import com.newer.model.JobInfo;
import com.newer.model.JobName;
import com.newer.model.Trade;

public interface JobInfoDao {
   public boolean add(JobInfo jobInfo);
   void update(JobInfo jobInfo);
   public List<JobInfo> selectBypage(String jiStatus, String jiSal,String jiPro,String jiReledate,String jiReledate1,int pageNo,int pageSize);
   public JobInfo findById(Integer jiid);
   public  List<JobInfo> findStatus(String jiStatus,int pageNo,int pageSize);
   public List<JobInfo> findAll();
   //public Integer selectCount(String jiStatus,String jiSal,String jiPro,String jiReledate,String jiReledate1);
   public  Integer selectCount(String jiStatus,String jiSal,String jiPro,String jiReledate,String jiReledate1);

	
}
