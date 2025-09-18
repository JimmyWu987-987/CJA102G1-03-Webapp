<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.proreport.service.*"%>
<%@ page import="com.proreport.model.*"%>
<%@ page import="java.util.*"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>
<%
List<ProReportVO> list = (List<ProReportVO>)session.getAttribute("list");
%>

<html>
<head>
<title>單一商品被檢舉資料</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body class="bg-light">

<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center mb-4 border-bottom pb-2">
        <h3 class="mb-0">單一商品被檢舉資料</h3>
        <a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp" class="btn btn-secondary d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/resource/images/back1.gif" width="20" height="20" class="me-2" alt="回首頁">
            回首頁
        </a>
    </div>

    <div class="row">
        <div class="col-12">
            <c:choose>
                <c:when test="${not empty list}">
                    <%@ include file="page1.file"%>
                    <c:forEach var="proReport" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
                        <div class="card shadow-sm mb-4">
                            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                                <span>檢舉文章編號：${proReport.proRptId}</span>
                                <span class="badge bg-light text-dark">狀態: ${proReport.proRptStatus}</span>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${proReport.proRptTitle}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">商品編號: ${proReport.proId} | 會員編號: ${proReport.memId}</h6>
                                <p class="card-text">${proReport.proRptCont}</p>
                                <hr>
                                <ul class="list-unstyled d-flex justify-content-between align-items-center mb-0">
                                    <li><small class="text-muted">檢舉時間：<fmt:formatDate value="${proReport.proRptAt}" pattern="yyyy-MM-dd HH:mm:ss"/></small></li>
                                    <li>
                                        <div class="d-flex gap-2">
                                            <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do" class="mb-0">
                                                <input type="hidden" name="proRptId" value="${proReport.proRptId}">
                                                <input type="hidden" name="action" value="getOne_For_Update">
                                                <button type="submit" class="btn btn-primary btn-sm">修改</button>
                                            </form>
                                            <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do" class="mb-0">
                                                <input type="hidden" name="proRptId" value="${proReport.proRptId}">
                                                <input type="hidden" name="action" value="delete">
                                                <button type="submit" class="btn btn-danger btn-sm">刪除</button>
                                            </form>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                    <%@ include file="page2.file"%>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info text-center" role="alert">
                        找不到符合條件的檢舉資料。
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

</body>
</html>