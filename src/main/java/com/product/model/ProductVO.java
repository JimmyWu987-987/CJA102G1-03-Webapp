package com.product.model;


public class ProductVO implements java.io.Serializable{
	private	Integer	proid;
	private String proname;
	private Integer prostock;
	private Integer proprice;
	private Integer prostatus;
	private String profrom;
	private Integer fmemid;
	
	
	
	
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Integer getProstock() {
		return prostock;
	}
	public void setProstock(Integer prostock) {
		this.prostock = prostock;
	}
	public Integer getProprice() {
		return proprice;
	}
	public void setProprice(Integer proprice) {
		this.proprice = proprice;
	}
	public Integer getProstatus() {
		return prostatus;
	}
	public void setProstatus(Integer prostatus) {
		this.prostatus = prostatus;
	}
	public String getProfrom() {
		return profrom;
	}
	public void setProfrom(String profrom) {
		this.profrom = profrom;
	}

	public Integer getFmemid() {
		return fmemid;
	}

	public void setFmemid(Integer fmemid) {
		this.fmemid = fmemid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proid == null) ? 0 : proid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVO other = (ProductVO) obj;
		if (proid == null) {
			if (other.proid != null)
				return false;
		} else if (!proid.equals(other.proid))
			return false;
		return true;
	}

}
