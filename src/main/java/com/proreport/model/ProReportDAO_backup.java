package com.proreport.model;

import java.util.List;

public interface ProReportDAO {
		public void insert(ProReportVO proReportVO);
		public void update(ProReportVO proReportVO);
		public void delete(Integer prorptid);
		
		// 單筆查詢(回傳一個物件)
		ProReportVO findByPrimaryKey(Integer prorptid);	
		// 多筆查詢(回傳一個集合)
		List<ProReportVO> getAll();				
		
		
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
//      public List<EmpVO> getAll(Map<String, String[]> map); 
		
}
