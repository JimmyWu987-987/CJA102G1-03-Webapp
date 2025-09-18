package com.shoppingcart.controller;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.product.model.ProductVO;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		
		@SuppressWarnings("unchecked")
		List<ProductVO> buylist = (Vector<ProductVO>) session.getAttribute("shoppingcart");
		String action = req.getParameter("action");

		if (!action.equals("CHECKOUT")) {

			// 刪除購物車中的書籍
			if (action.equals("DELETE")) {
				String del = req.getParameter("del");
				int d = Integer.parseInt(del);
				buylist.remove(d);
			}
			// 新增書籍至購物車中
			else if (action.equals("ADD")) {
				// 取得後來新增的書籍
				ProductVO aproduct = getProduct(req);

				if (buylist == null) {
					buylist = new Vector<ProductVO>();
					buylist.add(aproduct);
				} else {
					if (buylist.contains(aproduct)) {
						ProductVO innerBOOK = buylist.get(buylist.indexOf(aproduct));
						innerBOOK.setProstock(innerBOOK.getProstock() + aproduct.getProstock());
					} else {
						buylist.add(aproduct);
					}
				}
			}

			session.setAttribute("shoppingcart", buylist);
			String url = "/front_end/shopping_cart/EShop.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// 結帳，計算購物車書籍價錢總數
		else if (action.equals("CHECKOUT")) {
			int total = 0;
			for (int i = 0; i < buylist.size(); i++) {
				ProductVO order = buylist.get(i);
				Integer price = order.getProprice();
				Integer prostock = order.getProstock();
				total += (price * prostock);
			}

			String amount = String.valueOf(total);
			req.setAttribute("amount", amount);
			String url = "/front_end/shopping_cart/Checkout.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
	}

	private ProductVO getProduct(HttpServletRequest req) {

		String prostock = req.getParameter("prostock");
		String proid = req.getParameter("proid");
		String proname = req.getParameter("proname");
		String proprice = req.getParameter("proprice");
		String profrom = req.getParameter("profrom");

		ProductVO product = new ProductVO();
		
		product.setProid(Integer.valueOf(proid));
		product.setProname(proname);
		product.setProprice(Integer.valueOf(proprice));
		product.setProfrom(profrom);
		product.setProstock(Integer.valueOf(prostock));
		
		return product;
	}
}