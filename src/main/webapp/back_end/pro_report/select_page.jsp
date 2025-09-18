<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.proreport.service.*"%>
<%@ page import="com.proreport.model.*"%>
<html>
<head>
    <title>CJA102G1test ProReport : Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .page-header {
            background-color: #f8f9fa;
            border-bottom: 3px ridge #adb5bd;
        }
    </style>
</head>
<body>

<div class="container my-5">
    <div class="page-header py-3 text-center">
        <h1>CJA102G1test ProReport : Home</h1>
        <h4 class="text-secondary">( MVC )</h4>
    </div>
    <p class="mt-4">This is the Home page for CJA102G1test ProReport : Home</p>

    <hr>

    <h3>資料查詢:</h3>
    
    <%-- 錯誤表列 --%>
    <c:if test="${not empty errorMsgs}">
        <div class="alert alert-danger" role="alert">
            請修正以下錯誤:
            <ul class="mb-0">
                <c:forEach var="message" items="${errorMsgs}">
                    <li>${message}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <div class="list-group">
        <%--
        <li>
            <a class="list-group-item list-group-item-action" href='<%=request.getContextPath()%>/back_end/pro_report/listAllProReport.jsp'>
                List all ProReport.
            </a>
        </li>
        --%>

        <div class="list-group-item">
            <h5 class="mb-3">輸入被檢舉商品編號:</h5>
            <form class="d-flex align-items-center" method="post" action="<%=request.getContextPath()%>/proreport/proreport.do">
                <input type="text" class="form-control me-2" name="proId" placeholder="請輸入商品編號">
                <input type="hidden" name="action" value="getOneProduct_For_Display">
                <button type="submit" class="btn btn-primary">送出</button>
            </form>
        </div>
        
        <jsp:useBean id="proReportSvc" scope="page" class="com.proreport.service.ProReportService" />
        
        <%
            List<ProReportVO> allReports = proReportSvc.getAll();
            Set<Integer> distinctProids = new TreeSet<>();
            for (ProReportVO report : allReports) {
                distinctProids.add(report.getProId());
            }
            request.setAttribute("reportedProids", new ArrayList<Integer>(distinctProids));
        %>
        
        <div class="list-group-item">
            <h5 class="mb-3">查詢被檢舉商品編號:</h5>
            <form class="d-flex align-items-center" method="post" action="<%=request.getContextPath()%>/proreport/proreport.do">
                <select class="form-select me-2" name="proId">
                    <option value="" disabled selected>請選擇商品編號</option>
                    <c:forEach var="proId" items="${reportedProids}">
                        <option value="${proId}">${proId}</option>
                    </c:forEach>   
                </select>
                <input type="hidden" name="action" value="getOneProduct_For_Display">
                <button type="submit" class="btn btn-primary">送出</button>
            </form>
        </div>
    </div>
    
    <hr>
    
    <h3>新增檢舉</h3>
    <a class="btn btn-success" href='<%=request.getContextPath()%>/front_end/pro_report/addProReport.jsp'>新增檢舉</a>

    <hr>

    <jsp:include page="listAllProReport.jsp"/>
    
</div>

</body>
</html>