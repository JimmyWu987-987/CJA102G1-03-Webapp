package com.proreport.service;

import java.util.List;

import com.proreport.model.ProReportDAO;
import com.proreport.model.ProReportDAOJNDIImpl;
import com.proreport.model.ProReportVO;

public class ProReportService {
	private ProReportDAO dao;

	public ProReportService() {
		dao = new ProReportDAOJNDIImpl();
	}

	// 新增
	public ProReportVO addProReport(Integer proid, Integer memid, Integer prorptstatus, java.sql.Timestamp prorptat,
			String prorpttitle, String prorptcont) {

		ProReportVO proReportVO = new ProReportVO();
		proReportVO.setProid(proid);
		proReportVO.setMemid(memid);
		proReportVO.setProrptstatus(prorptstatus);
		proReportVO.setProrptat(prorptat);
		proReportVO.setProrpttitle(prorpttitle);
		proReportVO.setProrptcont(prorptcont);
		dao.insert(proReportVO);

		return proReportVO;
	}

	// 修改
	public ProReportVO updateProReport(Integer prorptid, Integer proid, Integer memid, Integer prorptstatus,
			java.sql.Timestamp prorptat, String prorpttitle, String prorptcont) {
		
		ProReportVO proReportVO = new ProReportVO();
		proReportVO.setProrptid(prorptid);
		proReportVO.setProid(proid);
		proReportVO.setMemid(memid);
		proReportVO.setProrptstatus(prorptstatus);
		proReportVO.setProrptat(prorptat);
		proReportVO.setProrpttitle(prorpttitle);
		proReportVO.setProrptcont(prorptcont);
		dao.update(proReportVO);

		return proReportVO;
	}

	// 刪除
	public void deleteProReport(Integer prorptid) {
		dao.delete(prorptid);
	}
	// 單筆查詢，	單筆結果。
	public ProReportVO getOneProReport(Integer prorptid) {
		return dao.findByPrimaryKey(prorptid);
	}
	
	// 單筆查詢，多筆結果。
	public List<ProReportVO> getOneProduct(Integer proid) {
		return dao.findProid(proid);
	}

	// 全部查詢
	public List<ProReportVO> getAll() {
		return dao.getAll();
	}
	
	// 依商品編號查詢，並列出多筆資料

}
