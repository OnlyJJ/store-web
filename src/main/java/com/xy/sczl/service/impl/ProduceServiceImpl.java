package com.xy.sczl.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.sczl.common.utils.UserUtil;
import com.xy.sczl.dao.ProductMapper;
import com.xy.sczl.entity.ProductEntity;
import com.xy.sczl.model.dto.ProductInfoDTO;
import com.xy.sczl.service.ProductService;

@Service
public class ProduceServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper dao;
	
	@Override
	public ProductEntity findById(Integer id) {
		if(id == null) {
			return null;
		}
		return dao.findById(id);
	}

	@Override
	public void insert(ProductInfoDTO prodto) {
		ProductEntity proen = new ProductEntity();
		BeanUtils.copyProperties(prodto, proen);
		// 设置商品id
		String productId = UserUtil.genUserId();
		proen.setProductId(productId);
		dao.insert(proen);
	}

	@Override
	public List<ProductEntity> findProducts() {
		// resdis -- > null
		return dao.findProducts();
	}


}
