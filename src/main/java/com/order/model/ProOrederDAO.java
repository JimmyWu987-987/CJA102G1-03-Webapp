package com.order.model;

import java.util.List;

public interface ProOrederDAO {

	void insert(ProOrderVO proOrderVO);
	void updata(ProOrderVO proOrderVO);
	void delete(Integer proOrdId);
	
	// 單筆查詢
	ProOrderVO findByPrimaryKey(Integer proOrdId);
	
	// 會員 id 單筆查詢（回傳多筆）
	List<ProOrderVO> findMemId(Integer menId);
	
	// 查詢小農該商品有幾筆訂單（回傳多筆）
	// 要Sql指令join小農會員表單
	List<ProOrderVO> find
	
	// 查詢全部
	List<ProOrderVO> getAll(); 
	
}
