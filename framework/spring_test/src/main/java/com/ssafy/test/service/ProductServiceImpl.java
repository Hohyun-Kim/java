package com.ssafy.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.mapper.ProductDto;
import com.ssafy.test.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductMapper productMapper;

	public ProductServiceImpl(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}
	
	@Override
	public void regist(ProductDto productDto) throws Exception {
		productMapper.regist(productDto);
	}
	
	@Override
	public List<ProductDto> list() throws Exception {
		return productMapper.list();
	}

	@Override
	public ProductDto view(String code) throws Exception {
		return productMapper.view(code);
	}


}
