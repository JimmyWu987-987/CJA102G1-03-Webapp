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
    pageContext.setAttribute("list", list);
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>所有商品檢舉資料</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h3>所有商品檢舉資料</h3>
        <a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp" class="btn btn-secondary">
            <img src="${pageContext.request.contextPath}/resource/images/back1.gif" width="20" height="20" border="0" alt="回首頁"> 回首頁
        </a>
    </div>

    <hr>
    <%@ include file="page1.file" %><p>
    <div class="row">
        <div class="col">
            <div class="list-group">
                <c:forEach var="proReportVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
                    <div class="list-group-item list-group-item-action mb-3 p-4 shadow-sm border rounded">
                        <div class="d-flex w-100 justify-content-between align-items-start">
                            <h5 class="mb-1 text-primary">檢舉標題：${proReportVO.proRptTitle}</h5>
                            <small class="text-muted">
                                檢舉時間：<fmt:formatDate value="${proReportVO.proRptAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </small>
                        </div>
                        <p class="mb-2">
                            <span class="badge bg-secondary me-2">檢舉文章編號: ${proReportVO.proRptId}</span>
                            <span class="badge bg-info text-dark me-2">商品編號: ${proReportVO.proId}</span>
                            <span class="badge bg-info text-dark me-2">申訴會員編號: ${proReportVO.memId}</span>
                            <span class="badge bg-danger me-2">文章審核狀態: ${proReportVO.proRptStatus}</span>
                        </p>
                        <p class="mb-3">${proReportVO.proRptCont}</p>

                        <div class="d-flex justify-content-end gap-2">
                            <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do">
                                <input type="submit" value="修改" class="btn btn-primary btn-sm">
                                <input type="hidden" name="proRptId" value="${proReportVO.proRptId}">
                                <input type="hidden" name="action" value="getOne_For_Update">
                            </form>
                            <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do">
                                <input type="submit" value="刪除" class="btn btn-danger btn-sm">
                                <input type="hidden" name="proRptId" value="${proReportVO.proRptId}">
                                <input type="hidden" name="action" value="delete">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    
    <div class="mt-4">
        <%@ include file="page2.file" %>
    </div>
    
</div>

</body>
</html>