package com.ssafy.test.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	void regist(ProductDto productDto) throws Exception;
	List<ProductDto> list() throws Exception;
	ProductDto view(String code) throws Exception;
}
