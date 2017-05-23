package com.newer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Sysuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYSUSER", schema = "JOB")

public class Sysuser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sid;
	private String SUsername;
	private String SPwd;
	private String SType;

	// Constructors

	/** default constructor */
	public Sysuser() {
	}

	/** full constructor */
	public Sysuser(Integer sid, String SUsername, String SPwd, String SType) {
		this.sid = sid;
		this.SUsername = SUsername;
		this.SPwd = SPwd;
		this.SType = SType;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_SYS",sequenceName="SEQ_SYS",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_SYS")
	@Column(name = "SID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "S_USERNAME", nullable = false, length = 20)

	public String getSUsername() {
		return this.SUsername;
	}

	public void setSUsername(String SUsername) {
		this.SUsername = SUsername;
	}

	@Column(name = "S_PWD", nullable = false, length = 30)

	public String getSPwd() {
		return this.SPwd;
	}

	public void setSPwd(String SPwd) {
		this.SPwd = SPwd;
	}

	@Column(name = "S_TYPE", nullable = false, length = 1)

	public String getSType() {
		return this.SType;
	}

	public void setSType(String SType) {
		this.SType = SType;
	}

}