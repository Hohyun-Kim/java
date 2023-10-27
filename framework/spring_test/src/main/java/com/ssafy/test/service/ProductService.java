package com.ssafy.test.service;

import java.util.List;

import com.ssafy.test.model.mapper.ProductDto;

public interface ProductService {
	
	void regist(ProductDto productDto) throws Exception;
	
	List<ProductDto> list() throws Exception;
	
	ProductDto view(String code) throws Exception;
}
