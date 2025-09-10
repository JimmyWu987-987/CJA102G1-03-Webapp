package com.proreport.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ProReportVO {
	private Integer prorptid;
	private Integer proid;
	private Integer memid;
	private Integer prorptstatus;
	private java.sql.Timestamp prorptat;
	private String prorpttitle;
	private String prorptcont;
	
	public ProReportVO() {
		super();

	}
	
	

	public ProReportVO(Integer proid, Integer memid, Integer prorptstatus, java.sql.Timestamp prorptat, String prorpttitle,
			String prorptcont) {
		super();
		this.proid = proid;
		this.memid = memid;
		this.prorptstatus = prorptstatus;
		this.prorptat = prorptat;
		this.prorpttitle = prorpttitle;
		this.prorptcont = prorptcont;
	}



	public ProReportVO(Integer prorptid, Integer proid, Integer memid) {
		super();
		this.prorptid = prorptid;
		this.proid = proid;
		this.memid = memid;
	}


	public Integer getProrptid() {
		return prorptid;
	}
	public void setProrptid(Integer prorptid) {
		this.prorptid = prorptid;
	}
	
	
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	
	
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	
	
	public Integer getProrptstatus() {
		return prorptstatus;
	}
	public void setProrptstatus(Integer prorptstatus) {
		this.prorptstatus = prorptstatus;
	}
	
	
	public Timestamp getProrptat() {
		return prorptat;
	}
	public void setProrptat(Timestamp prorptat) {
		this.prorptat = prorptat;
	}
	
	
	public String getProrpttitle() {
		return prorpttitle;
	}
	public void setProrpttitle(String prorpttitle) {
		this.prorpttitle = prorpttitle;
	}
	
	
	public String getProrptcont() {
		return prorptcont;
	}
	public void setProrptcont(String prorptcont) {
		this.prorptcont = prorptcont;
	}


	@Override
	public String toString() {
		return "ProReportVO [prorptid=" + prorptid + ", proid=" + proid + ", memid=" + memid + ", prorptstatus="
				+ prorptstatus + ", prorptat=" + prorptat + ", prorpttitle=" + prorpttitle + ", prorptcont="
				+ prorptcont + "]";
	}
	
}
