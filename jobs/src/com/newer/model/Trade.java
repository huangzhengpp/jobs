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
 * Trade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TRADE", schema = "JOB")

public class Trade implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tname;
	private Set<ComInfo> comInfos = new HashSet<ComInfo>(0);
	private Set<JobInfo> jobInfos = new HashSet<JobInfo>(0);

	// Constructors

	/** default constructor */
	public Trade() {
	}

	/** minimal constructor */
	public Trade(Integer tid) {
		this.tid = tid;
	}

	/** full constructor */
	public Trade(Integer tid, String tname, Set<ComInfo> comInfos, Set<JobInfo> jobInfos) {
		this.tid = tid;
		this.tname = tname;
		this.comInfos = comInfos;
		this.jobInfos = jobInfos;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_TRADE",sequenceName="SEQ_TRADE",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_TRADE")
	@Column(name = "TID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "TNAME", length = 30)

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trade")

	public Set<ComInfo> getComInfos() {
		return this.comInfos;
	}

	public void setComInfos(Set<ComInfo> comInfos) {
		this.comInfos = comInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trade")

	public Set<JobInfo> getJobInfos() {
		return this.jobInfos;
	}

	public void setJobInfos(Set<JobInfo> jobInfos) {
		this.jobInfos = jobInfos;
	}

}