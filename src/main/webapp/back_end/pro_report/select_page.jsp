<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.proreport.service.*"%>
<%@ page import="com.proreport.model.*"%>
<html>
<head>
<title>CJA102G1test ProReport : Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>CJA102G1test ProReport : Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for CJA102G1test ProReport : Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
<%--   <li><a href='<%=request.getContextPath()%>/back_end/pro_report/listAllProReport.jsp'>List</a> all ProReport.  <br><br></li> --%>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/proreport/proreport.do" >
        <b>輸入被檢舉商品編號:</b>
        <input type="text" name="proId">
        <input type="hidden" name="action" value="getOneProduct_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="proReportSvc" scope="page" class="com.proreport.service.ProReportService" />
   
   <%
    // 假設 proReportSvc.all 是一個包含所有檢舉文章的清單
    List<ProReportVO> allReports = proReportSvc.getAll();
    
    // 使用 Set 來儲存不重複的商品 ID
    Set<Integer> distinctProids = new TreeSet<>();
    for (ProReportVO report : allReports) {
        distinctProids.add(report.getProId());
    }
    
    // 將 Set 轉換為 List，以便在 JSTL 中循環
    request.setAttribute("reportedProids", new ArrayList<Integer>(distinctProids));
%>
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/proreport/proreport.do" >

       <b>查詢被檢舉商品編號:</b>
       <select size="1" name="proId">
       	<option value="">請選擇商品編號</option>
         <c:forEach var="proReportVO" items="${reportedProids}" >
          <option value="${proReportVO}">${proReportVO}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOneProduct_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
</ul>


<h3>新增檢舉</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/front_end/pro_report/addProReport.jsp'>Add</a> a new ProReport.</li>
</ul>

<jsp:include page="listAllProReport.jsp"></jsp:include>


</body>
</html>