<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.proreport.service.*"%>
<%@ page import="com.proreport.model.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>


<%
    ProReportService proReportSvc = new ProReportService();
    List<ProReportVO> list = proReportSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllProReport.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<!-- <h4>此頁練習採用 EL 的寫法取值:</h4> -->
<%-- <table id="table-1">
	<tr><td>
		 <h3>所有檢舉資料 - listAllProReport.jsp</h3>
		 <h4><a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp">
		 	<img src="${pageContext.request.contextPath}/resource/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table> --%>

<table>
	<tr>
		<th>檢舉文章編號</th>
		<th>商品編號</th>
		<th>申訴會員編號</th>
		<th>文章審核狀態</th>
		<th>檢舉時間</th>
		<th>檢舉標題</th>
		<th>檢舉內容</th>
		<th>修改審核狀態</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="proReportVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${proReportVO.proRptId}</td>
			<td>${proReportVO.proId}</td>
			<td>${proReportVO.memId}</td>
			<td>${proReportVO.proRptStatus}</td>
			<td><fmt:formatDate value="${proReportVO.proRptAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${proReportVO.proRptTitle}</td>
			<td>${proReportVO.proRptCont}</td>

			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/proreport/proreport.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="proRptId"  value="${proReportVO.proRptId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/proreport/proreport.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="proRptId"  value="${proReportVO.proRptId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="page2.file" %>


</body>
</html>