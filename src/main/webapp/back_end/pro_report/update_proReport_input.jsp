<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proreport.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat" %>

<% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)

ProReportVO proReportVO = (ProReportVO) request.getAttribute("proReportVO");


%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>審核檢舉狀態 - update_ProReport_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>審核檢舉狀態 - update_ProReport_input.jspp</h3>
		 <h4><a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp"><img 
		 src="${pageContext.request.contextPath}/resource/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/proreport/proreport.do" name="form1">
<table>
	<tr>
		<td>檢舉文章編號:<font color=red><b>*</b></font></td>
		<td><%=proReportVO.getProRptId()%></td>
	</tr>
	<tr>
		<td>商品編號:</td>
		<td><input type="TEXT" name="proid" value="<%=proReportVO.getProId()%>" size="45" readonly/></td>
	</tr>
	<tr>
		<td>申訴會員編號:</td>
		<td><input type="TEXT" name="memid"   value="<%=proReportVO.getMemId()%>" size="45" readonly/></td>
	</tr>
	
	<tr>
		<td>檢舉日期:</td>
		<td><input name="prorptat" type="text" value="<%=proReportVO.getProRptAt()%>" readonly ></td> 
	</tr>
	<tr>
		<td>檢舉標題:</td>
		<td><input type="TEXT" name="prorpttitle"   value="<%=proReportVO.getProRptTitle()%>" size="45" readonly/></td>
	</tr>
	<tr>
		<td>檢舉內容:</td>
		<td><textarea name="prorptcont" rows="4" cols="30" readonly><%=proReportVO.getProRptCont()%></textarea></td>
	</tr>
	
<%-- 	<tr>
		<td>審核狀態:</td>
		<td><input type="TEXT" name="prorptstatus"  value="<%=proReportVO.getProrptstatus()%>" size="45"/></td>
	</tr> --%>
	
	<tr>
		<td>審核狀態:</td>
		<td>
		<select size="1" name="proRptStatus" id="proRptStatusSelect">
		<option value="0" <%=proReportVO.getProRptStatus() == 0 ? "selected" : ""%>>編輯中</option>
		<option value="1" <%=proReportVO.getProRptStatus() == 1 ? "selected" : ""%>>待審核</option>
		<option value="2" <%=proReportVO.getProRptStatus() == 2 ? "selected" : ""%>>審核通過</option>
		<option value="3" <%=proReportVO.getProRptStatus() == 3 ? "selected" : ""%>>審核未過</option>
	
		</select>
		</td>
	</tr>
	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="proRptId" value="<%=proReportVO.getProRptId()%>">
<input type="submit" value="送出修改"></FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>




<script>
   
        
</script>
</html>