package com.xy.sczl.dao;

import java.math.BigDecimal;
import java.util.List;

import com.xy.sczl.entity.ProductEntity;

public interface ProductMapper {
	
	int insert(ProductEntity proen);
	
	ProductEntity findById(Integer id);
	
	// ==> new ArrayList<ProductEntity>();
	// 如果findProducts()有数据，则返回相应数据，如果没有，则返回0
	// 此方法永远不会返回null
	List<ProductEntity> findProducts();
}
