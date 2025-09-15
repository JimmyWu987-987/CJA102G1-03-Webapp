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
	public ProReportVO addProReport(Integer proId, Integer memId, Integer proRptStatus, java.sql.Timestamp proRptAt,
			String proRptTitle, String proRptCont) {

		ProReportVO proReportVO = new ProReportVO();
		proReportVO.setProId(proId);
		proReportVO.setMemId(memId);
		proReportVO.setProRptStatus(proRptStatus);
		proReportVO.setProRptAt(proRptAt);
		proReportVO.setProRptTitle(proRptTitle);
		proReportVO.setProRptCont(proRptCont);
		dao.insert(proReportVO);

		return proReportVO;
	}

	// 修改
	public ProReportVO updateProReport(Integer prorptid, Integer proId, Integer memId, Integer proRptStatus,
			java.sql.Timestamp proRptAt, String proRptTitle, String proRptCont) {
		
		ProReportVO proReportVO = new ProReportVO();
		proReportVO.setProRptId(prorptid);
		proReportVO.setProId(proId);
		proReportVO.setMemId(memId);
		proReportVO.setProRptStatus(proRptStatus);
		proReportVO.setProRptAt(proRptAt);
		proReportVO.setProRptTitle(proRptTitle);
		proReportVO.setProRptCont(proRptCont);
		dao.update(proReportVO);

		return proReportVO;
	}

	// 刪除
	public void deleteProReport(Integer proRptId) {
		dao.delete(proRptId);
	}
	// 單筆查詢，	單筆結果。
	public ProReportVO getOneProReport(Integer proRptId) {
		return dao.findByPrimaryKey(proRptId);
	}
	
	// 單筆查詢，多筆結果。
	public List<ProReportVO> getOneProduct(Integer proId) {
		return dao.findProid(proId);
	}

	// 全部查詢
	public List<ProReportVO> getAll() {
		return dao.getAll();
	}
	
	// 依商品編號查詢，並列出多筆資料

}
