package com.newer.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * JobName entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JOB_NAME", schema = "JOB")

public class JobName implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer jnid;
	private JobClass jobClass;
	private String jnname;
	private Set<JobInfo> jobInfos = new HashSet<JobInfo>(0);

	// Constructors

	/** default constructor */
	public JobName() {
	}

	/** minimal constructor */
	public JobName(Integer jnid, JobClass jobClass, String jnname) {
		this.jnid = jnid;
		this.jobClass = jobClass;
		this.jnname = jnname;
	}

	/** full constructor */
	public JobName(Integer jnid, JobClass jobClass, String jnname, Set<JobInfo> jobInfos) {
		this.jnid = jnid;
		this.jobClass = jobClass;
		this.jnname = jnname;
		this.jobInfos = jobInfos;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_NAME",sequenceName="SEQ_NAME",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_NAME")
	@Column(name = "JNID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getJnid() {
		return this.jnid;
	}

	public void setJnid(Integer jnid) {
		this.jnid = jnid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JN_JCID", nullable = false)

	public JobClass getJobClass() {
		return this.jobClass;
	}

	public void setJobClass(JobClass jobClass) {
		this.jobClass = jobClass;
	}

	@Column(name = "JNNAME", nullable = false, length = 30)

	public String getJnname() {
		return this.jnname;
	}

	public void setJnname(String jnname) {
		this.jnname = jnname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobName")

	public Set<JobInfo> getJobInfos() {
		return this.jobInfos;
	}

	public void setJobInfos(Set<JobInfo> jobInfos) {
		this.jobInfos = jobInfos;
	}

}