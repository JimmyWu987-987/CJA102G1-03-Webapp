package com.proreport.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.proreport.model.ProReportVO;
import com.proreport.service.ProReportService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProReportServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 來自select_page.jsp的請求
		// 單筆查詢檢舉文章編號， 單筆結果。
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("prorptid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入檢舉文章編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer prorptid = null;
			try {
				prorptid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("檢舉文章編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProReportService proReportSvc = new ProReportService();
			ProReportVO proReportVO = proReportSvc.getOneProReport(prorptid);
			if (proReportVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("proReportVO", proReportVO); // 資料庫取出的proReportVO物件,存入req
			String url = "/back_end/pro_report/listOneProReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProReport.jsp
			successView.forward(req, res);

		}

//		 單筆查詢商品編號，多筆結果。
		if ("getOneProduct_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("proid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入檢舉文章編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer proid = null;
			try {
				proid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("檢舉文章編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProReportService proReportSvc = new ProReportService();
			List<ProReportVO> proReportList = proReportSvc.getOneProduct(proid);
			
			if (proReportList == null || proReportList.isEmpty()) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/pro_report/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.getSession().setAttribute("list", proReportList); // 資料庫取出的proReportVO物件,存入req
//			req.setAttribute("proid", proid);
			
			String url = "/back_end/pro_report/listOneProReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProReport.jsp
			successView.forward(req, res);

		}

		// 新增
		// 來自addProReport.jsp的請求
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer proid = null;
			try {
				proid = Integer.valueOf(req.getParameter("proid").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請輸入商品編號!");
			}

			Integer memid = null;
			try {
				memid = Integer.valueOf(req.getParameter("memid").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請輸入會員編號!");
			}

			Integer prorptstatus = null;
			try {
				prorptstatus = Integer.valueOf(req.getParameter("prorptstatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("文章審核狀態要為0(未審核)");
			}

			java.sql.Timestamp prorptat = null; // 改為 Timestamp
			try {
				// 確保接收到的字串格式是 "YYYY-MM-DD HH:MM:SS"
				String prorptatStr = req.getParameter("prorptat").trim();
				if (prorptatStr != null && !prorptatStr.isEmpty()) {
					prorptat = java.sql.Timestamp.valueOf(prorptatStr); // 使用 Timestamp.valueOf()
				} else {
					errorMsgs.add("請輸入檢舉日期!");
				}
			} catch (IllegalArgumentException e) {
				// 如果字串格式不正確，還是會進到這裡
				prorptat = new java.sql.Timestamp(System.currentTimeMillis()); // 預設值
				errorMsgs.add("檢舉日期格式不正確，應為 YYYY-MM-DD HH:MM:SS");
			}

			String prorpttitle = req.getParameter("prorpttitle").trim();
			if (prorpttitle == null || prorpttitle.trim().length() == 0) {
				errorMsgs.add("檢舉標題請勿空白！");
			}

			String prorptcont = req.getParameter("prorptcont").trim();

			if (prorptcont == null || prorptcont.trim().length() == 0) {
				errorMsgs.add("檢舉內容請勿空白！");
			}

			ProReportVO proReportVO = new ProReportVO(proid, memid, prorptstatus, prorptat, prorpttitle, prorptcont);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {

				req.setAttribute("proReportVO", proReportVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/pro_report/addProReport.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProReportService proReportSvc = new ProReportService();
			proReportVO = proReportSvc.addProReport(proid, memid, prorptstatus, prorptat, prorpttitle, prorptcont);
			
			System.out.println(proReportVO);
			
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/pro_report/listAllProReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listOneProReport.jsp
			successView.forward(req, res);

		}

		// 修改
		// 先單一查詢
		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer prorptid = Integer.valueOf(req.getParameter("prorptid"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProReportService proReportSvc = new ProReportService();
			ProReportVO proReportVO = proReportSvc.getOneProReport(prorptid);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("proReportVO", proReportVO); // 資料庫取出的proReportVO物件,存入req
			String url = "/back_end/pro_report/update_proReport_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_proReport_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer prorptid = Integer.valueOf(req.getParameter("prorptid"));

			Integer proid = null;
			try {
				proid = Integer.valueOf(req.getParameter("proid").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請輸入商品編號!");
			}

			Integer memid = null;
			try {
				memid = Integer.valueOf(req.getParameter("memid").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請輸入會員編號!");
			}

			Integer prorptstatus = null;
			try {
				prorptstatus = Integer.valueOf(req.getParameter("prorptstatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("文章審核狀態要為0(未審核)");
			}

			java.sql.Timestamp prorptat = null; // 改為 Timestamp
			try {
				// 確保接收到的字串格式是 "YYYY-MM-DD HH:MM:SS"
				String prorptatStr = req.getParameter("prorptat").trim();
				if (prorptatStr != null && !prorptatStr.isEmpty()) {
					prorptat = java.sql.Timestamp.valueOf(prorptatStr); // 使用 Timestamp.valueOf()
				} else {
					errorMsgs.add("請輸入檢舉日期!");
				}
			} catch (IllegalArgumentException e) {
				// 如果字串格式不正確，還是會進到這裡
				prorptat = new java.sql.Timestamp(System.currentTimeMillis()); // 預設值
				errorMsgs.add("檢舉日期格式不正確，應為 YYYY-MM-DD HH:MM:SS");
			}

			String prorpttitle = req.getParameter("prorpttitle").trim();
			if (prorpttitle == null || prorpttitle.trim().length() == 0) {
				errorMsgs.add("檢舉標題請勿空白！");
			}

			String prorptcont = req.getParameter("prorptcont").trim();

			if (prorptcont == null || prorptcont.trim().length() == 0) {
				errorMsgs.add("檢舉內容請勿空白！");
			}

			ProReportVO proReportVO = new ProReportVO(proid, memid, prorptstatus, prorptat, prorpttitle, prorptcont);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("proReportVO", proReportVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/pro_report/update_proReport_input.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProReportService proReportSvc = new ProReportService();
			proReportVO = proReportSvc.updateProReport(prorptid, proid, memid, prorptstatus, prorptat, prorpttitle,
					prorptcont);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("proReportVO", proReportVO); // 資料庫取出的proReportVO物件,存入req
			String url = "/back_end/pro_report/listOneProReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_proReport_input.jsp
			successView.forward(req, res);
		}

		// 刪除
		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer prorptid = Integer.valueOf(req.getParameter("prorptid"));

			/*************************** 2.開始刪除資料 ***************************************/
			ProReportService proReportSvc = new ProReportService();
			proReportSvc.deleteProReport(prorptid);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/pro_report/listAllProReport.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
