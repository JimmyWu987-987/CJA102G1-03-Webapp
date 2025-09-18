<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mode II 範例程式 - Eshop.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .product-card {
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transition: transform 0.2s;
            margin-bottom: 2rem;
            text-align: center;
        }
        .product-card:hover {
            transform: translateY(-5px);
        }
        .product-image {
            width: 100%;
            height: auto;
        }
        .product-card-body {
            padding: 1.5rem;
        }
        .product-title {
            font-size: 1.25rem;
            font-weight: bold;
            margin-bottom: 0.5rem;
        }
        .product-price {
            font-size: 1.5rem;
            color: #d9534f;
            font-weight: bold;
        }
        .special-offer {
            font-size: 1rem;
            color: #d9534f;
            font-weight: bold;
            text-decoration: line-through;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4 text-center">網路書店：（EShop.jsp）</h1>
        <hr>
        
        <div class="row">
            <div class="col-6 col-md-4 col-lg-3 d-flex">
                <div class="card product-card w-100">
                    <img src="https://via.placeholder.com/400x400" class="card-img-top product-image" alt="商品圖片">
                    <div class="card-body product-card-body d-flex flex-column">
                        <h5 class="card-title product-title">不一樣的養生法</h5>
                        <p class="card-text text-muted">作者：吳永志</p>
                        <p class="product-price mt-auto">特價 $<span class="fw-bold">600</span></p>
                        
                        <form name="shoppingForm1" action="Shopping.html" method="POST" class="mt-auto">
                            <div class="input-group mb-2">
                                <span class="input-group-text">數量</span>
                                <input type="text" name="quantity" class="form-control" size="3" value="1">
                            </div>
                            <input type="hidden" name="name" value="不一樣的養生法">
                            <input type="hidden" name="author" value="吳永志">
                            <input type="hidden" name="publisher" value="基峰">
                            <input type="hidden" name="price" value="600">
                            <input type="hidden" name="action" value="ADD">
                            <input type="submit" class="btn btn-primary w-100" value="放入購物車">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-6 col-md-4 col-lg-3 d-flex">
                <div class="card product-card w-100">
                    <img src="https://via.placeholder.com/400x400" class="card-img-top product-image" alt="商品圖片">
                    <div class="card-body product-card-body d-flex flex-column">
                        <h5 class="card-title product-title">哈利波特-神秘的魔法石</h5>
                        <p class="card-text text-muted">作者：J.K 羅琳</p>
                        <p class="product-price mt-auto">特價 $<span class="fw-bold">200</span></p>
                        <form name="shoppingForm2" action="Shopping.html" method="POST" class="mt-auto">
                             <div class="input-group mb-2">
                                <span class="input-group-text">數量</span>
                                <input type="text" name="quantity" class="form-control" size="3" value="1">
                            </div>
                            <input type="hidden" name="name" value="哈利波特-神秘的魔法石">
                            <input type="hidden" name="author" value="J.K 羅琳">
                            <input type="hidden" name="publisher" value="皇冠">
                            <input type="hidden" name="price" value="200">
                            <input type="hidden" name="action" value="ADD">
                            <input type="submit" class="btn btn-primary w-100" value="放入購物車">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-6 col-md-4 col-lg-3 d-flex">
                <div class="card product-card w-100">
                    <img src="https://via.placeholder.com/400x400" class="card-img-top product-image" alt="商品圖片">
                    <div class="card-body product-card-body d-flex flex-column">
                        <h5 class="card-title product-title">麻辣女教師</h5>
                        <p class="card-text text-muted">作者：蕭蓉蓉</p>
                        <p class="product-price mt-auto">特價 $<span class="fw-bold">190</span></p>
                        <form name="shoppingForm3" action="Shopping.html" method="POST" class="mt-auto">
                            <div class="input-group mb-2">
                                <span class="input-group-text">數量</span>
                                <input type="text" name="quantity" class="form-control" size="3" value="1">
                            </div>
                            <input type="hidden" name="name" value="麻辣女教師">
                            <input type="hidden" name="author" value="蕭蓉蓉">
                            <input type="hidden" name="publisher" value="平安">
                            <input type="hidden" name="price" value="190">
                            <input type="hidden" name="action" value="ADD">
                            <input type="submit" class="btn btn-primary w-100" value="放入購物車">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-6 col-md-4 col-lg-3 d-flex">
                <div class="card product-card w-100">
                    <img src="https://via.placeholder.com/400x400" class="card-img-top product-image" alt="商品圖片">
                    <div class="card-body product-card-body d-flex flex-column">
                        <h5 class="card-title product-title">把話說到心窩</h5>
                        <p class="card-text text-muted">作者：劉墉</p>
                        <p class="product-price mt-auto">特價 $<span class="fw-bold">180</span></p>
                        <form name="shoppingForm4" action="Shopping.html" method="POST" class="mt-auto">
                            <div class="input-group mb-2">
                                <span class="input-group-text">數量</span>
                                <input type="text" name="quantity" class="form-control" size="3" value="1">
                            </div>
                            <input type="hidden" name="name" value="把話說到心窩">
                            <input type="hidden" name="author" value="劉墉">
                            <input type="hidden" name="publisher" value="水雲齋">
                            <input type="hidden" name="price" value="180">
                            <input type="hidden" name="action" value="ADD">
                            <input type="submit" class="btn btn-primary w-100" value="放入購物車">
                        </form>
                    </div>
                </div>
            </div>

        </div> <p class="mt-5"> 
            <jsp:include page="/front_end/shopping_cart/Cart.jsp" flush="true" />
        </p>

    </div> </body>
</html>