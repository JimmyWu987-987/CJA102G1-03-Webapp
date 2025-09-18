<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.product.model.*"%>
<html>
<head>
    <title>Mode II �d�ҵ{�� - ���b</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">�p�A�ӫ� - ���b</h1>
        <hr>

        <%
            @SuppressWarnings("unchecked")
            Vector<ProductVO> buylist = (Vector<ProductVO>) session.getAttribute("shoppingcart");
            String amount =  (String) request.getAttribute("amount");
        %>

        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">�ӫ~�s��</th>
                        <th scope="col">�ӫ~�W��</th>
                        <th scope="col">�ӫ~���a</th>
                        <th scope="col">����</th>
                        <th scope="col">�ƶq</th>
                        <th scope="col">�Ӱӫ~�`��</th>
                    </tr>
                </thead>
                <tbody>
                    <%  for (int i = 0; i < buylist.size(); i++) {
                        ProductVO order = buylist.get(i);
                        Integer proid = order.getProid();
                        String proname = order.getProname();
                        String profrom = order.getProfrom();
                        Integer proprice = order.getProprice();
                        Integer prostock = order.getProstock();
                    %>
                    <tr>
                        <td><%=proid%></td>
                        <td><%=proname%></td>
                        <td><%=profrom%></td>
                        <td><%=proprice%></td>
                        <td><%=prostock%></td>
                        <td><%=proprice * prostock%></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <div class="text-end mt-4 p-3 border rounded bg-light">
            <h4 class="mb-0">�q���`���B�G<span class="text-danger fw-bold">$<%=amount%></span></h4>
        </div>
       
        <p class="text-center mt-5">
            <a href="<%=request.getContextPath() %>/front_end/shopping_cart/EShop.jsp" class="btn btn-outline-primary btn-lg">�O �_ �~ �� �� ��</a>
        </p>
    </div>
</body>
</html>