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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * JobField entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JOB_FIELD", schema = "JOB")

public class JobField implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer jfid;
	private String jfname;
	private Set<JobClass> jobClasses = new HashSet<JobClass>(0);

	// Constructors

	/** default constructor */
	public JobField() {
	}

	/** minimal constructor */
	public JobField(Integer jfid) {
		this.jfid = jfid;
	}

	/** full constructor */
	public JobField(Integer jfid, String jfname, Set<JobClass> jobClasses) {
		this.jfid = jfid;
		this.jfname = jfname;
		this.jobClasses = jobClasses;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_FIELD",sequenceName="SEQ_FIELD",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_FIELD")
	@Column(name = "JFID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getJfid() {
		return this.jfid;
	}

	public void setJfid(Integer jfid) {
		this.jfid = jfid;
	}

	@Column(name = "JFNAME", length = 30)

	public String getJfname() {
		return this.jfname;
	}

	public void setJfname(String jfname) {
		this.jfname = jfname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobField")

	public Set<JobClass> getJobClasses() {
		return this.jobClasses;
	}

	public void setJobClasses(Set<JobClass> jobClasses) {
		this.jobClasses = jobClasses;
	}

}