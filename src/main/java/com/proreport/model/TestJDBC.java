package com.proreport.model;

import java.util.List;

public class TestJDBC {
	public static void main(String[] args) {
		ProReportDAO dao = new ProReportDAOJDBCImpl();
	
		
		// 步驟一：建立一個 java.util.Date 物件
		java.util.Date utilDate = new java.util.Date();
		// 步驟二：使用 utilDate.getTime() 取得毫秒數，並建立一個新的 java.sql.Date 物件
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		// 步驟三：將轉換後的 sqlDate 傳入 setProrptat() 方法
		
		// 新增
		
//		ProReportVO prorepadd = new ProReportVO();
//		prorepadd.setProid(17);
//		prorepadd.setMemid(9);
//		prorepadd.setProrptstatus(0);
//		prorepadd.setProrptat(sqlDate);
//		prorepadd.setProrpttitle("水果超難吃");
//		prorepadd.setProrptcont("難吃又不能退貨，黑心賣家！");
//		
//		dao.insert(prorepadd);
		
		// 修改
//		ProReportVO prorepupdate = new ProReportVO();
//		prorepupdate.setProrptid(6);
//		prorepupdate.setProid(17);
//		prorepupdate.setMemid(9);
//		prorepupdate.setProrptstatus(0);
//		prorepupdate.setProrptat(java.sql.Date.valueOf("2025-09-02"));
//		prorepupdate.setProrpttitle("水果極度超難吃6677777666");
//		prorepupdate.setProrptcont("難吃又不能退貨，黑心賣家！55555");
//		
//		dao.update(prorepupdate);
		
		
		// 刪除
//		dao.delete(6);
		
		// 查詢多筆
		List<ProReportVO> list = dao.getAll();
		for (ProReportVO prorep : list) {
			System.out.println(prorep);
		}
		System.out.println("---------------------------");
		
		// 查詢單筆
		ProReportVO prorep = dao.findByPrimaryKey(3);
		System.out.println(prorep);
		
	}
}
