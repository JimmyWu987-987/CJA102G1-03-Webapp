<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>小農商城</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .product-card {
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
            text-align: center;
        }

        .product-card:hover {
            transform: translateY(-5px);
        }
        
        .product-card-body {
            padding: 1.5rem;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .product-title {
            font-size: 1.25rem;
            font-weight: bold;
            margin-bottom: 0.5rem;
        }

        .product-price {
            font-size: 1.5rem;
            color: #dc3545; /* Bootstrap 的紅色 */
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4 text-center">小農商城</h1>
        <hr>
		
        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4 g-4">
            <jsp:useBean id="productSvc" scope="page" class="com.product.service.ProductService" />
            
            <c:forEach var="productVO" items="${productSvc.all}">
                <div class="col d-flex">
                    <div class="card product-card w-100">
                    	<!-- 商品圖片的位置 -->
                        <img src="https://via.placeholder.com/400x200.png?text=商品圖片" class="card-img-top" alt="商品圖片">
                        
                        <div class="card-body">
                            <h5 class="card-title product-title">${productVO.proname}</h5>
                            <p class="card-text text-muted mb-2">
                                <b>編號:</b> ${productVO.proid} <br>
                                <b>產地:</b> ${productVO.profrom} <br>
                                <b>庫存:</b> ${productVO.prostock} <br>
                            </p>
                            <p class="product-price mt-auto mb-3">價格: ${productVO.proprice} 元</p>

                            <form name="shoppingForm" action="<%=request.getContextPath()%>/shoppingcart/shoppingcart.do" method="POST">
                                <div class="input-group mb-2">
                                    <span class="input-group-text">數量</span>
                                    <input type="number" name="prostock" class="form-control" value="1" min="1">
                                </div>
                                <input type="hidden" name="proid" value="${productVO.proid}">
                                <input type="hidden" name="proname" value="${productVO.proname}">
                
                                <input type="hidden" name="proprice" value="${productVO.proprice}">
                                <input type="hidden" name="profrom" value="${productVO.profrom}">
                                <input type="hidden" name="action" value="ADD">
                                <button type="submit" class="btn btn-primary w-100 mt-2">放入購物車</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="mt-5">
            <jsp:include page="/front_end/shopping_cart/Cart.jsp" flush="true" />
        </div>
    </div>
</body>
</html>