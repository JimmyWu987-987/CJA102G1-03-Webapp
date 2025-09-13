package com.proreport.model;

import java.sql.Timestamp;

public class ProReportVO {
	private Integer proRptId;
	private Integer proId;
	private Integer memId;
	private Integer proRptStatus;
	private java.sql.Timestamp proRptAt;
	private String proRptTitle;
	private String proRptCont;
	
	public ProReportVO() {
		super();

	}
	
	

	public ProReportVO(Integer proId, Integer memId, Integer proRptStatus, Timestamp proRptAt, String proRptTitle,
			String proRptCont) {
		super();
		this.proId = proId;
		this.memId = memId;
		this.proRptStatus = proRptStatus;
		this.proRptAt = proRptAt;
		this.proRptTitle = proRptTitle;
		this.proRptCont = proRptCont;
	}



	public Integer getProRptId() {
		return proRptId;
	}

	public void setProRptId(Integer proRptId) {
		this.proRptId = proRptId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Integer getProRptStatus() {
		return proRptStatus;
	}

	public void setProRptStatus(Integer proRptStatus) {
		this.proRptStatus = proRptStatus;
	}

	public java.sql.Timestamp getProRptAt() {
		return proRptAt;
	}

	public void setProRptAt(java.sql.Timestamp proRptAt) {
		this.proRptAt = proRptAt;
	}

	public String getProRptTitle() {
		return proRptTitle;
	}

	public void setProRptTitle(String proRptTitle) {
		this.proRptTitle = proRptTitle;
	}

	public String getProRptCont() {
		return proRptCont;
	}

	public void setProRptCont(String proRptCont) {
		this.proRptCont = proRptCont;
	}

	@Override
	public String toString() {
		return "ProReportVO [proRptId=" + proRptId + ", proId=" + proId + ", memId=" + memId + ", proRptStatus="
				+ proRptStatus + ", proRptAt=" + proRptAt + ", proRptTitle=" + proRptTitle + ", proRptCont="
				+ proRptCont + "]";
	}

	
}
