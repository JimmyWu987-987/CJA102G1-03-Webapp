<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.product.model.*" %>
<html>
<head>
    <title>Mode II 範例程式 - Cart.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container my-5">
        <% @SuppressWarnings("unchecked")
        Vector<ProductVO> buylist = (Vector<ProductVO>) session.getAttribute("shoppingcart");%>
        
        <% if (buylist != null && buylist.size() > 0) {%>
            <h1 class="mb-4">目前購物車的內容如下：</h1>
            
            <div class="table-responsive">
                <table class="table table-striped table-hover align-middle">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">商品編號</th>
                            <th scope="col">商品名稱</th>
                            <th scope="col">商品產地</th>
                            <th scope="col">價格</th>
                            <th scope="col">數量</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int index = 0; index < buylist.size(); index++) {
                            ProductVO order = buylist.get(index); %>
                            <tr>
                                <td><%= order.getProid() %></td>
                                <td><%= order.getProname() %></td>
                                <td><%= order.getProfrom() %></td>
                                <td><%= order.getProprice() %></td>
                                <td><%= order.getProstock() %></td>
                                <td>
                                    <form action="<%=request.getContextPath()%>/shoppingcart/shoppingcart.do" method="POST" class="d-grid">
                                        <input type="hidden" name="action" value="DELETE">
                                        <input type="hidden" name="del" value="<%= index %>">
                                        <button type="submit" class="btn btn-danger btn-sm">刪 除</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>

            <div class="d-grid gap-2 d-md-block mt-4">
                <form action="<%=request.getContextPath()%>/shoppingcart/shoppingcart.do" method="POST" class="d-inline-block">
                    <input type="hidden" name="action" value="CHECKOUT">
                    <button type="submit" class="btn btn-success btn-lg">付款結帳</button>
                </form>
            </div>
        <% } else { %>
            <div class="alert alert-info text-center" role="alert">
                <h4 class="alert-heading">您的購物車是空的</h4>
                <p>請前往商品頁面挑選您喜歡的商品。</p>
            </div>
        <% } %>
    </div>
</body>
</html>