package com.proreport.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProReportDAOJDBCImpl implements ProReportDAO {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/myproject?serverTimezone=Asia/Taipei";
	private static final String USER = "root";
	private static final String PASSWORD = "112233445566";

	private static final String INSERT_STMT = "INSERT INTO pro_report (pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT pro_rpt_id,pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont FROM pro_report";
	private static final String GET_ONE_STMT = "SELECT pro_rpt_id,pro_id, mem_id, pro_rpt_status, pro_rpt_at, pro_rpt_title, pro_rpt_cont FROM pro_report where pro_rpt_id = ?";
	private static final String DELETE = "DELETE FROM pro_report where pro_rpt_id = ?";
	private static final String UPDATE = "UPDATE pro_report set pro_id=?, mem_id=?, pro_rpt_status=?, pro_rpt_at=?, pro_rpt_title=?, pro_rpt_cont=? where pro_rpt_id = ?";

	@Override
	public void insert(ProReportVO proReportVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, proReportVO.getProid());
			pstmt.setInt(2, proReportVO.getMemid());
			pstmt.setInt(3, proReportVO.getProrptstatus());
			pstmt.setTimestamp(4, proReportVO.getProrptat());
			pstmt.setString(5, proReportVO.getProrpttitle());
			pstmt.setString(6, proReportVO.getProrptcont());

			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException se) {
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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, proReportVO.getProid());
			pstmt.setInt(2, proReportVO.getMemid());
			pstmt.setInt(3, proReportVO.getProrptstatus());
			pstmt.setTimestamp(4, proReportVO.getProrptat());
			pstmt.setString(5, proReportVO.getProrpttitle());
			pstmt.setString(6, proReportVO.getProrptcont());
			pstmt.setInt(7, proReportVO.getProrptid());

			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException se) {
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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, prorptid);
			

			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException se) {
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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, prorptid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				proReport = new ProReportVO();
				proReport.setProrptid(rs.getInt("pro_rpt_id"));
				proReport.setProid(rs.getInt("pro_id"));
				proReport.setMemid(rs.getInt("mem_id"));
				proReport.setProrptstatus(rs.getInt("pro_rpt_status"));
				proReport.setProrptat(rs.getTimestamp("pro_rpt_at"));;
				proReport.setProrpttitle(rs.getString("pro_rpt_title"));
				proReport.setProrptcont(rs.getString("pro_rpt_cont"));

			}

		} catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return proReport;
	}

	@Override
	public List<ProReportVO> getAll() {
		List<ProReportVO> proReportList = new ArrayList<ProReportVO>();
		ProReportVO proReport = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				proReport = new ProReportVO();
				proReport.setProrptid(rs.getInt("pro_rpt_id"));
				proReport.setProid(rs.getInt("pro_id"));
				proReport.setMemid(rs.getInt("mem_id"));
				proReport.setProrptstatus(rs.getInt("pro_rpt_status"));
				proReport.setProrptat(rs.getTimestamp("pro_rpt_at"));;
				proReport.setProrpttitle(rs.getString("pro_rpt_title"));
				proReport.setProrptcont(rs.getString("pro_rpt_cont"));

				proReportList.add(proReport);
			}

		} catch (SQLException | ClassNotFoundException se) {
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
