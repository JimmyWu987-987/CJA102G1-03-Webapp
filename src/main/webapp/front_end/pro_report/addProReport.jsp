<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proreport.service.*"%>
<%@ page import="com.proreport.model.*"%>

<%
ProReportVO proReportVO = (ProReportVO) request.getAttribute("proReportVO");
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增檢舉</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <%
    java.sql.Timestamp prorptat = null;
    try {
        prorptat = proReportVO.getProRptAt();
    } catch (Exception e) {
        prorptat = new java.sql.Timestamp(System.currentTimeMillis());
    }
    %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/datetimepicker/jquery.datetimepicker.css" />
    <script src="<%=request.getContextPath()%>/resource/datetimepicker/jquery.datetimepicker.full.js"></script>
    <style>
        /* 調整 datetimepicker 樣式以適應 Bootstrap */
        .xdsoft_datetimepicker .xdsoft_datepicker, .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
            width: auto;
        }
        .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
             height: 151px;
        }
    </style>
</head>
<body class="bg-light">

<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4 border-bottom pb-2">
        <h3 class="mb-0">新增檢舉</h3>
        <a href="${pageContext.request.contextPath}/back_end/pro_report/select_page.jsp" class="btn btn-secondary d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/resource/images/back1.gif" width="20" height="20" class="me-2" alt="回首頁">
            回首頁
        </a>
    </div>

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

    <h4 class="mb-3">資料新增:</h4>

    <form method="post" action="<%=request.getContextPath()%>/proreport/proreport.do" name="form1">
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="proidSelect" class="form-label">投訴商品:<span class="text-danger fw-bold">*</span></label>
                    <jsp:useBean id="productSvc" scope="page" class="com.product.service.ProductService" />
                    <select class="form-select" name="proId" id="proidSelect">
                        <option value="">請選擇商品編號</option>
                        <c:forEach var="productVO" items="${productSvc.all}">
                            <option value="${productVO.proid}"
                                ${(proReportVO.proId == productVO.proid) ? 'selected' : ''}>
                                ${productVO.proname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="memId" class="form-label">申訴會員編號:</label>
                    <input name="memId" id="memId" type="text" class="form-control"
                        value="<%=(proReportVO == null) ? "" : proReportVO.getMemId()%>">
                </div>
            </div>
        </div>

        <input name="proRptStatus" type="hidden" value="0">

        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="proRptAt" class="form-label">檢舉日期:</label>
                    <input name="proRptAt" id="f_date1" type="text" class="form-control" value="" readonly>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="proRptTitle" class="form-label">檢舉標題:</label>
                    <input type="text" name="proRptTitle" class="form-control"
                        value="<%=(proReportVO == null) ? "" : proReportVO.getProRptTitle()%>">
                </div>
            </div>
        </div>

        <div class="mb-3">
            <label for="proRptCont" class="form-label">檢舉內容:</label>
            <textarea name="proRptCont" id="proRptCont" rows="4" class="form-control"><%=(proReportVO == null) ? "" : proReportVO.getProRptCont()%></textarea>
        </div>

        <div class="d-grid mt-4">
            <input type="hidden" name="action" value="insert">
            <button type="submit" class="btn btn-primary btn-lg">送出新增</button>
        </div>
    </form>
</div>

<script>
    $.datetimepicker.setLocale('zh');
    $('#f_date1').datetimepicker({
        theme: '',
        timepicker: false,
        step: 1,
        format: 'Y-m-d H:i:s',
        value: new Date(),
    });
</script>

</body>
</html>