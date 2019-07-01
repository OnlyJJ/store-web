package com.xy.sczl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.sczl.dao.ProductMapper;
import com.xy.sczl.entity.ProductEntity;
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

}
