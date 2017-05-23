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
 * Oper entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OPER", schema = "JOB")

public class Oper implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer oid;
	private String OUsername;
	private String OPwd;
	private String OStatus;
	private Set<ComInfo> comInfos = new HashSet<ComInfo>(0);

	// Constructors

	/** default constructor */
	public Oper() {
	}

	/** minimal constructor */
	public Oper(Integer oid, String OUsername, String OPwd, String OStatus) {
		this.oid = oid;
		this.OUsername = OUsername;
		this.OPwd = OPwd;
		this.OStatus = OStatus;
	}

	/** full constructor */
	public Oper(Integer oid, String OUsername, String OPwd, String OStatus, Set<ComInfo> comInfos) {
		this.oid = oid;
		this.OUsername = OUsername;
		this.OPwd = OPwd;
		this.OStatus = OStatus;
		this.comInfos = comInfos;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_OPER",sequenceName="SEQ_OPER",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_OPER")
	@Column(name = "OID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	@Column(name = "O_USERNAME", nullable = false, length = 20)

	public String getOUsername() {
		return this.OUsername;
	}

	public void setOUsername(String OUsername) {
		this.OUsername = OUsername;
	}

	@Column(name = "O_PWD", nullable = false, length = 30)

	public String getOPwd() {
		return this.OPwd;
	}

	public void setOPwd(String OPwd) {
		this.OPwd = OPwd;
	}

	@Column(name = "O_STATUS", nullable = false, length = 1)

	public String getOStatus() {
		return this.OStatus;
	}

	public void setOStatus(String OStatus) {
		this.OStatus = OStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "oper")

	public Set<ComInfo> getComInfos() {
		return this.comInfos;
	}

	public void setComInfos(Set<ComInfo> comInfos) {
		this.comInfos = comInfos;
	}

}