<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proreport.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
ProReportVO proReportVO = (ProReportVO) request.getAttribute("proReportVO");
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>審核檢舉狀態</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
    <script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

    <style>
        .xdsoft_datetimepicker .xdsoft_datepicker {
            width: 300px;
        }
        .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
            height: 151px;
        }
    </style>
</head>

<body class="bg-light">

<div class="container py-4">

    <div class="d-flex justify-content-between align-items-center mb-4 border-bottom pb-2">
        <h3 class="mb-0">審核檢舉狀態</h3>
        <a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp" class="btn btn-secondary d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/resource/images/back1.gif" width="20" height="20" class="me-2" alt="回首頁">
            回首頁
        </a>
    </div>

    <h4 class="mb-3">資料修改:</h4>

    <%-- 錯誤表列 --%>
    <c:if test="${not empty errorMsgs}">
        <div class="alert alert-danger" role="alert">
            <p>請修正以下錯誤:</p>
            <ul class="mb-0">
                <c:forEach var="message" items="${errorMsgs}">
                    <li>${message}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <c:if test="${not empty successMsgs}">
        <div class="alert alert-success" role="alert">
            ${successMsgs}
        </div>
    </c:if>

    <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do">
        <div class="row g-3">
            <div class="col-md-6">
                <label for="proRptId" class="form-label">檢舉文章編號:</label>
                <input type="text" class="form-control" id="proRptId" value="<%=proReportVO.getProRptId()%>" readonly>
            </div>
            <div class="col-md-6">
                <label for="proId" class="form-label">商品編號:</label>
                <input type="text" class="form-control" id="proId" name="proId" value="<%=proReportVO.getProId()%>" readonly>
            </div>
            <div class="col-md-6">
                <label for="memId" class="form-label">申訴會員編號:</label>
                <input type="text" class="form-control" id="memId" name="memId" value="<%=proReportVO.getMemId()%>" readonly>
            </div>
            <div class="col-md-6">
                <label for="proRptAt" class="form-label">檢舉日期:</label>
                <input type="text" class="form-control" id="proRptAt" name="proRptAt" value="<%=proReportVO.getProRptAt()%>" readonly>
            </div>
            <div class="col-12">
                <label for="proRptTitle" class="form-label">檢舉標題:</label>
                <input type="text" class="form-control" id="proRptTitle" name="proRptTitle" value="<%=proReportVO.getProRptTitle()%>" readonly>
            </div>
            <div class="col-12">
                <label for="proRptCont" class="form-label">檢舉內容:</label>
                <textarea class="form-control" id="proRptCont" name="proRptCont" rows="4" readonly><%=proReportVO.getProRptCont()%></textarea>
            </div>
            <div class="col-12">
                <label for="proRptStatusSelect" class="form-label">審核狀態:</label>
                <select class="form-select" name="proRptStatus" id="proRptStatusSelect">
                    <option value="0" <%=proReportVO.getProRptStatus() == 0 ? "selected" : ""%>>編輯中</option>
                    <option value="1" <%=proReportVO.getProRptStatus() == 1 ? "selected" : ""%>>待審核</option>
                    <option value="2" <%=proReportVO.getProRptStatus() == 2 ? "selected" : ""%>>審核通過</option>
                    <option value="3" <%=proReportVO.getProRptStatus() == 3 ? "selected" : ""%>>審核未過</option>
                </select>
            </div>
        </div>

        <div class="d-grid gap-2 d-md-block mt-4">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="proRptId" value="<%=proReportVO.getProRptId()%>">
            <button type="submit" class="btn btn-primary btn-lg me-md-2">送出修改</button>
            <button type="button" class="btn btn-secondary btn-lg" onclick="window.history.back();">回上一頁</button>
        </div>
    </form>
</div>

</body>
</html>