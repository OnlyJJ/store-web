package com.xy.sczl.service;


import java.math.BigDecimal;
import java.util.List;

import com.xy.sczl.entity.ProductEntity;
import com.xy.sczl.model.dto.ProductInfoDTO;

public interface ProductService {

	/**
	 * 添加商品
	 * @param prodto
	 */
	void insert(ProductInfoDTO prodto);
	
	/**
	 * 根据 ID 查询
	 * @param id
	 * @return
	 */
	ProductEntity findById(Integer id);
	
	/**
	 * 查询所有商品
	 * @return
	 */
	List<ProductEntity> findProducts();
}
