package com.newer.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * JobInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JOB_INFO", schema = "JOB")

public class JobInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer jiid;
	private JobName jobName;
	private Trade trade;
	private ComInfo comInfo;
	private Integer jiNum;
	private String jiEdu;
	private String jiPro;
	private String jiDetail;
	private String jiSal;
	private String jiPhone;
	private String jiContact;
	private String jiAddr;
	private Date jiReledate;
	private String jiStatus;

	// Constructors

	/** default constructor */
	public JobInfo() {
	}

	/** minimal constructor */
	public JobInfo(Integer jiid, Integer jiNum, String jiEdu, String jiPro, String jiDetail, String jiSal,
			String jiPhone, String jiContact, String jiAddr, Date jiReledate, String jiStatus) {
		this.jiid = jiid;
		this.jiNum = jiNum;
		this.jiEdu = jiEdu;
		this.jiPro = jiPro;
		this.jiDetail = jiDetail;
		this.jiSal = jiSal;
		this.jiPhone = jiPhone;
		this.jiContact = jiContact;
		this.jiAddr = jiAddr;
		this.jiReledate = jiReledate;
		this.jiStatus = jiStatus;
	}

	/** full constructor */
	public JobInfo(Integer jiid, JobName jobName, Trade trade, ComInfo comInfo, Integer jiNum, String jiEdu,
			String jiPro, String jiDetail, String jiSal, String jiPhone, String jiContact, String jiAddr,
			Date jiReledate, String jiStatus) {
		this.jiid = jiid;
		this.jobName = jobName;
		this.trade = trade;
		this.comInfo = comInfo;
		this.jiNum = jiNum;
		this.jiEdu = jiEdu;
		this.jiPro = jiPro;
		this.jiDetail = jiDetail;
		this.jiSal = jiSal;
		this.jiPhone = jiPhone;
		this.jiContact = jiContact;
		this.jiAddr = jiAddr;
		this.jiReledate = jiReledate;
		this.jiStatus = jiStatus;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_JOB",sequenceName="SEQ_JOB",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_JOB")
	@Column(name = "JIID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getJiid() {
		return this.jiid;
	}

	public void setJiid(Integer jiid) {
		this.jiid = jiid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JI_JNID")

	public JobName getJobName() {
		return this.jobName;
	}

	public void setJobName(JobName jobName) {
		this.jobName = jobName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JI_TID")

	public Trade getTrade() {
		return this.trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JI_CID")

	public ComInfo getComInfo() {
		return this.comInfo;
	}

	public void setComInfo(ComInfo comInfo) {
		this.comInfo = comInfo;
	}

	@Column(name = "JI_NUM", nullable = false, precision = 6, scale = 0)

	public Integer getJiNum() {
		return this.jiNum;
	}

	public void setJiNum(Integer jiNum) {
		this.jiNum = jiNum;
	}

	@Column(name = "JI_EDU", nullable = false, length = 30)

	public String getJiEdu() {
		return this.jiEdu;
	}

	public void setJiEdu(String jiEdu) {
		this.jiEdu = jiEdu;
	}

	@Column(name = "JI_PRO", nullable = false, length = 30)

	public String getJiPro() {
		return this.jiPro;
	}

	public void setJiPro(String jiPro) {
		this.jiPro = jiPro;
	}

	@Column(name = "JI_DETAIL", nullable = false, length = 1000)

	public String getJiDetail() {
		return this.jiDetail;
	}

	public void setJiDetail(String jiDetail) {
		this.jiDetail = jiDetail;
	}

	@Column(name = "JI_SAL", nullable = false, length = 30)

	public String getJiSal() {
		return this.jiSal;
	}

	public void setJiSal(String jiSal) {
		this.jiSal = jiSal;
	}

	@Column(name = "JI_PHONE", nullable = false, length = 30)

	public String getJiPhone() {
		return this.jiPhone;
	}

	public void setJiPhone(String jiPhone) {
		this.jiPhone = jiPhone;
	}

	@Column(name = "JI_CONTACT", nullable = false, length = 20)

	public String getJiContact() {
		return this.jiContact;
	}

	public void setJiContact(String jiContact) {
		this.jiContact = jiContact;
	}

	@Column(name = "JI_ADDR", nullable = false, length = 30)

	public String getJiAddr() {
		return this.jiAddr;
	}

	public void setJiAddr(String jiAddr) {
		this.jiAddr = jiAddr;
	}

	@Column(name = "JI_RELEDATE", nullable = false, length = 7)

	public Date getJiReledate() {
		return this.jiReledate;
	}

	public void setJiReledate(Date jiReledate) {
		this.jiReledate = jiReledate;
	}

	@Column(name = "JI_STATUS", nullable = false, length = 1)

	public String getJiStatus() {
		return this.jiStatus;
	}

	public void setJiStatus(String jiStatus) {
		this.jiStatus = jiStatus;
	}

}