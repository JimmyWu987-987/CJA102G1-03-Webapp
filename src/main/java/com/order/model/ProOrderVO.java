package com.order.model;

import java.sql.Timestamp;

public class ProOrderVO {
	private Integer proOrdId;
	private Integer menId;
	private Integer cpnHolderDetailId;
	private Timestamp proOrdDate;
	private Integer proOrdStatus;
	private Integer proPayStatus;
	private Integer proTotal;
	private Integer proOrdShipFee;
	private Integer proOrdCpndisc;
	private Integer proOrdPointdisc;
	private Integer proOrdPointGet;
	private Integer proOrdGrandTotal;
	private String proOrdComm;
	private Integer proOrdPayment;
	private Integer proOrdShipment;
	private String proTrackingNo;
	private Timestamp proOrdShipdate;
	
	public ProOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProOrderVO(Integer proOrdId, Integer menId, Integer cpnHolderDetailId, Timestamp proOrdDate,
			Integer proOrdStatus, Integer proPayStatus, Integer proTotal, Integer proOrdShipFee, Integer proOrdCpndisc,
			Integer proOrdPointdisc, Integer proOrdPointGet, Integer proOrdGrandTotal, String proOrdComm,
			Integer proOrdPayment, Integer proOrdShipment, String proTrackingNo, Timestamp proOrdShipdate) {
		super();
		this.proOrdId = proOrdId;
		this.menId = menId;
		this.cpnHolderDetailId = cpnHolderDetailId;
		this.proOrdDate = proOrdDate;
		this.proOrdStatus = proOrdStatus;
		this.proPayStatus = proPayStatus;
		this.proTotal = proTotal;
		this.proOrdShipFee = proOrdShipFee;
		this.proOrdCpndisc = proOrdCpndisc;
		this.proOrdPointdisc = proOrdPointdisc;
		this.proOrdPointGet = proOrdPointGet;
		this.proOrdGrandTotal = proOrdGrandTotal;
		this.proOrdComm = proOrdComm;
		this.proOrdPayment = proOrdPayment;
		this.proOrdShipment = proOrdShipment;
		this.proTrackingNo = proTrackingNo;
		this.proOrdShipdate = proOrdShipdate;
	}

	public Integer getProOrdId() {
		return proOrdId;
	}

	public void setProOrdId(Integer proOrdId) {
		this.proOrdId = proOrdId;
	}

	public Integer getMenId() {
		return menId;
	}

	public void setMenId(Integer menId) {
		this.menId = menId;
	}

	public Integer getCpnHolderDetailId() {
		return cpnHolderDetailId;
	}

	public void setCpnHolderDetailId(Integer cpnHolderDetailId) {
		this.cpnHolderDetailId = cpnHolderDetailId;
	}

	public Timestamp getProOrdDate() {
		return proOrdDate;
	}

	public void setProOrdDate(Timestamp proOrdDate) {
		this.proOrdDate = proOrdDate;
	}

	public Integer getProOrdStatus() {
		return proOrdStatus;
	}

	public void setProOrdStatus(Integer proOrdStatus) {
		this.proOrdStatus = proOrdStatus;
	}

	public Integer getProPayStatus() {
		return proPayStatus;
	}

	public void setProPayStatus(Integer proPayStatus) {
		this.proPayStatus = proPayStatus;
	}

	public Integer getProTotal() {
		return proTotal;
	}

	public void setProTotal(Integer proTotal) {
		this.proTotal = proTotal;
	}

	public Integer getProOrdShipFee() {
		return proOrdShipFee;
	}

	public void setProOrdShipFee(Integer proOrdShipFee) {
		this.proOrdShipFee = proOrdShipFee;
	}

	public Integer getProOrdCpndisc() {
		return proOrdCpndisc;
	}

	public void setProOrdCpndisc(Integer proOrdCpndisc) {
		this.proOrdCpndisc = proOrdCpndisc;
	}

	public Integer getProOrdPointdisc() {
		return proOrdPointdisc;
	}

	public void setProOrdPointdisc(Integer proOrdPointdisc) {
		this.proOrdPointdisc = proOrdPointdisc;
	}

	public Integer getProOrdPointGet() {
		return proOrdPointGet;
	}

	public void setProOrdPointGet(Integer proOrdPointGet) {
		this.proOrdPointGet = proOrdPointGet;
	}

	public Integer getProOrdGrandTotal() {
		return proOrdGrandTotal;
	}

	public void setProOrdGrandTotal(Integer proOrdGrandTotal) {
		this.proOrdGrandTotal = proOrdGrandTotal;
	}

	public String getProOrdComm() {
		return proOrdComm;
	}

	public void setProOrdComm(String proOrdComm) {
		this.proOrdComm = proOrdComm;
	}

	public Integer getProOrdPayment() {
		return proOrdPayment;
	}

	public void setProOrdPayment(Integer proOrdPayment) {
		this.proOrdPayment = proOrdPayment;
	}

	public Integer getProOrdShipment() {
		return proOrdShipment;
	}

	public void setProOrdShipment(Integer proOrdShipment) {
		this.proOrdShipment = proOrdShipment;
	}

	public String getProTrackingNo() {
		return proTrackingNo;
	}

	public void setProTrackingNo(String proTrackingNo) {
		this.proTrackingNo = proTrackingNo;
	}

	public Timestamp getProOrdShipdate() {
		return proOrdShipdate;
	}

	public void setProOrdShipdate(Timestamp proOrdShipdate) {
		this.proOrdShipdate = proOrdShipdate;
	}

	@Override
	public String toString() {
		return "ProOrderVO [proOrdId=" + proOrdId + ", menId=" + menId + ", cpnHolderDetailId=" + cpnHolderDetailId
				+ ", proOrdDate=" + proOrdDate + ", proOrdStatus=" + proOrdStatus + ", proPayStatus=" + proPayStatus
				+ ", proTotal=" + proTotal + ", proOrdShipFee=" + proOrdShipFee + ", proOrdCpndisc=" + proOrdCpndisc
				+ ", proOrdPointdisc=" + proOrdPointdisc + ", proOrdPointGet=" + proOrdPointGet + ", proOrdGrandTotal="
				+ proOrdGrandTotal + ", proOrdComm=" + proOrdComm + ", proOrdPayment=" + proOrdPayment
				+ ", proOrdShipment=" + proOrdShipment + ", proTrackingNo=" + proTrackingNo + ", proOrdShipdate="
				+ proOrdShipdate + "]";
	}
	
	
	
}
