package com.proreport.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProReportDAOJNDIImpl implements ProReportDAO {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CJA102G1test");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO pro_report (pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT pro_rpt_id,pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont FROM pro_report";
	private static final String GET_ONE_STMT = "SELECT pro_rpt_id,pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont FROM pro_report where pro_rpt_id = ?";
	private static final String GET_ONE_PRODUCT_STMT = "SELECT pro_rpt_id,pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont FROM pro_report where pro_id = ?";
	private static final String DELETE = "DELETE FROM pro_report where pro_rpt_id = ?";
	private static final String UPDATE = "UPDATE pro_report set pro_id=?, mem_id=?, pro_rpt_status=?, pro_rpt_at=?, pro_rpt_title=?, pro_rpt_cont=? where pro_rpt_id = ?";

	@Override
	public void insert(ProReportVO proReportVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, proReportVO.getProId());
			pstmt.setInt(2, proReportVO.getMemId());
			pstmt.setInt(3, proReportVO.getProRptStatus());
			pstmt.setTimestamp(4, proReportVO.getProRptAt());
			pstmt.setString(5, proReportVO.getProRptTitle());
			pstmt.setString(6, proReportVO.getProRptCont());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public void update(ProReportVO proReportVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, proReportVO.getProId());
			pstmt.setInt(2, proReportVO.getMemId());
			pstmt.setInt(3, proReportVO.getProRptStatus());
			pstmt.setTimestamp(4, proReportVO.getProRptAt());
			pstmt.setString(5, proReportVO.getProRptTitle());
			pstmt.setString(6, proReportVO.getProRptCont());
			pstmt.setInt(7, proReportVO.getProRptId());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public void delete(Integer prorptid) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prorptid);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public ProReportVO findByPrimaryKey(Integer prorptid) {
		ProReportVO proReport = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, prorptid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				proReport = new ProReportVO();
				proReport.setProRptId(rs.getInt("pro_rpt_id"));
				proReport.setProId(rs.getInt("pro_id"));
				proReport.setMemId(rs.getInt("mem_id"));
				proReport.setProRptStatus(rs.getInt("pro_rpt_status"));
				proReport.setProRptAt(rs.getTimestamp("pro_rpt_at"));
				proReport.setProRptTitle(rs.getString("pro_rpt_title"));
				proReport.setProRptCont(rs.getString("pro_rpt_cont"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return proReport;
	}

	@Override
	public List<ProReportVO> findProid(Integer proid) {

		List<ProReportVO> proReportList = new ArrayList<ProReportVO>();
		ProReportVO proReport = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_PRODUCT_STMT);
			pstmt.setInt(1, proid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				proReport = new ProReportVO();
				proReport.setProRptId(rs.getInt("pro_rpt_id"));
				proReport.setProId(rs.getInt("pro_id"));
				proReport.setMemId(rs.getInt("mem_id"));
				proReport.setProRptStatus(rs.getInt("pro_rpt_status"));
				proReport.setProRptAt(rs.getTimestamp("pro_rpt_at"));
				proReport.setProRptTitle(rs.getString("pro_rpt_title"));
				proReport.setProRptCont(rs.getString("pro_rpt_cont"));

				proReportList.add(proReport);

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return proReportList;
	}

	@Override
	public List<ProReportVO> getAll() {
		List<ProReportVO> proReportList = new ArrayList<ProReportVO>();
		ProReportVO proReport = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				proReport = new ProReportVO();
				proReport.setProRptId(rs.getInt("pro_rpt_id"));
				proReport.setProId(rs.getInt("pro_id"));
				proReport.setMemId(rs.getInt("mem_id"));
				proReport.setProRptStatus(rs.getInt("pro_rpt_status"));
				proReport.setProRptAt(rs.getTimestamp("pro_rpt_at"));
				proReport.setProRptTitle(rs.getString("pro_rpt_title"));
				proReport.setProRptCont(rs.getString("pro_rpt_cont"));

				proReportList.add(proReport);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return proReportList;
	}

	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

}
