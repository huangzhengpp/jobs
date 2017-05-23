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
 * ComInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COM_INFO", schema = "JOB")

public class ComInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private Oper oper;
	private Trade trade;
	private String comName;
	private String comAddr;
	private String comPro;
	private String comScale;
	private String comInfo;
	private String comPhone;
	private String comMobilephone;
	private String comEmail;
	private String comContact;
	private String comPermitFile;
	private String comPermitNum;
	private Set<JobInfo> jobInfos = new HashSet<JobInfo>(0);
	private String comStatus;

	// Constructors

	/** default constructor */
	public ComInfo() {
	}

	/** minimal constructor */
	public ComInfo(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public ComInfo(Integer cid, Oper oper, Trade trade, String comName, String comAddr, String comPro, String comScale,
			String comInfo, String comPhone, String comMobilephone, String comEmail, String comContact,
			String comPermitFile, String comPermitNum, Set<JobInfo> jobInfos,String comStatus) {
		this.cid = cid;
		this.oper = oper;
		this.trade = trade;
		this.comName = comName;
		this.comAddr = comAddr;
		this.comPro = comPro;
		this.comScale = comScale;
		this.comInfo = comInfo;
		this.comPhone = comPhone;
		this.comMobilephone = comMobilephone;
		this.comEmail = comEmail;
		this.comContact = comContact;
		this.comPermitFile = comPermitFile;
		this.comPermitNum = comPermitNum;
		this.jobInfos = jobInfos;
		this.comStatus = comStatus;
	}

	// Property accessors
	@SequenceGenerator(name="SEQ_COM",sequenceName="SEQ_COM",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_COM")
	@Column(name = "CID", unique = true, nullable = false, precision = 6, scale = 0)

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COM_OID")

	public Oper getOper() {
		return this.oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COM_TID")

	public Trade getTrade() {
		return this.trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@Column(name = "COM_NAME", length = 50)

	public String getComName() {
		return this.comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	@Column(name = "COM_ADDR", length = 50)

	public String getComAddr() {
		return this.comAddr;
	}

	public void setComAddr(String comAddr) {
		this.comAddr = comAddr;
	}

	@Column(name = "COM_PRO", length = 30)

	public String getComPro() {
		return this.comPro;
	}

	public void setComPro(String comPro) {
		this.comPro = comPro;
	}

	@Column(name = "COM_SCALE", length = 30)

	public String getComScale() {
		return this.comScale;
	}

	public void setComScale(String comScale) {
		this.comScale = comScale;
	}

	@Column(name = "COM_INFO", length = 2000)

	public String getComInfo() {
		return this.comInfo;
	}

	public void setComInfo(String comInfo) {
		this.comInfo = comInfo;
	}

	@Column(name = "COM_PHONE", length = 30)

	public String getComPhone() {
		return this.comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}

	@Column(name = "COM_MOBILEPHONE", length = 30)

	public String getComMobilephone() {
		return this.comMobilephone;
	}

	public void setComMobilephone(String comMobilephone) {
		this.comMobilephone = comMobilephone;
	}

	@Column(name = "COM_EMAIL", length = 30)

	public String getComEmail() {
		return this.comEmail;
	}

	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}

	@Column(name = "COM_CONTACT", length = 20)

	public String getComContact() {
		return this.comContact;
	}

	public void setComContact(String comContact) {
		this.comContact = comContact;
	}

	@Column(name = "COM_PERMIT_FILE", length = 50)

	public String getComPermitFile() {
		return this.comPermitFile;
	}

	public void setComPermitFile(String comPermitFile) {
		this.comPermitFile = comPermitFile;
	}

	@Column(name = "COM_PERMIT_NUM", length = 30)

	public String getComPermitNum() {
		return this.comPermitNum;
	}

	public void setComPermitNum(String comPermitNum) {
		this.comPermitNum = comPermitNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comInfo")

	public Set<JobInfo> getJobInfos() {
		return this.jobInfos;
	}

	public void setJobInfos(Set<JobInfo> jobInfos) {
		this.jobInfos = jobInfos;
	}
	
	@Column(name = "COM_STATUS", nullable = false, length = 2)

	public String getComStatus() {
		return comStatus;
	}

	public void setComStatus(String comStatus) {
		this.comStatus = comStatus;
	}
	
	

}