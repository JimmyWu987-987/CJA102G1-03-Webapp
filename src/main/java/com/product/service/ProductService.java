package com.product.service;

import java.util.List;

import com.product.model.ProductDAO;
import com.product.model.ProductDAO_interface;
import com.product.model.ProductVO;

public class ProductService {

	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductDAO();
	}

	public ProductVO addProduct(String proname, Integer prostock, Integer proprice,
			Integer prostatus, String profrom, byte[] propic) {

		ProductVO productVO = new ProductVO();

		productVO.setProname(proname);
		productVO.setProstock(prostock);
		productVO.setProprice(proprice);
		productVO.setProstatus(prostatus);
		productVO.setProfrom(profrom);

		dao.insert(productVO);

		return productVO;
	}

	public ProductVO updateProduct(Integer proid, String proname, Integer prostock, Integer proprice,
			Integer prostatus, String profrom, byte[] propic) {

		ProductVO productVO = new ProductVO();


		productVO.setProid(proid);
		productVO.setProname(proname);
		productVO.setProstock(prostock);
		productVO.setProprice(proprice);
		productVO.setProstatus(prostatus);
		productVO.setProfrom(profrom);

		dao.update(productVO);

		return productVO;
	}

	public void deleteProduct(Integer proid) {
		dao.delete(proid);
	}

	public ProductVO getOneProduct(Integer proid) {
		return dao.findByPrimaryKey(proid);
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}
}
