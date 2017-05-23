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
 * JobClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JOB_CLASS", schema = "JOB")

public class JobClass implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer jcid;
	private JobField jobField;
	private String jcname;
	private Set<JobName> jobNames = new HashSet<JobName>(0);

	// Constructors

	/** default constructor */
	public JobClass() {
	}

	/** minimal constructor */
	public JobClass(Integer jcid, JobField jobField, String jcname) {
		this.jcid = jcid;
		this.jobField = jobField;
		this.jcname = jcname;
	}

	/** full constructor */
	public JobClass(Integer jcid, JobField jobField, String jcname, Set<JobName> jobNames) {
		this.jcid = jcid;
		this.jobField = jobField;
		this.jcname = jcname;
		this.jobNames = jobNames;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_CLASS",sequenceName="SEQ_CLASS",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_CLASS")
	@Column(name = "JCID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getJcid() {
		return this.jcid;
	}

	public void setJcid(Integer jcid) {
		this.jcid = jcid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JC_JFID", nullable = false)

	public JobField getJobField() {
		return this.jobField;
	}

	public void setJobField(JobField jobField) {
		this.jobField = jobField;
	}

	@Column(name = "JCNAME", nullable = false, length = 30)

	public String getJcname() {
		return this.jcname;
	}

	public void setJcname(String jcname) {
		this.jcname = jcname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobClass")

	public Set<JobName> getJobNames() {
		return this.jobNames;
	}

	public void setJobNames(Set<JobName> jobNames) {
		this.jobNames = jobNames;
	}

}