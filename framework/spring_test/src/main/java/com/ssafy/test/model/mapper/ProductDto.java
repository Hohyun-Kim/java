package com.ssafy.test.model.mapper;

public class ProductDto {
	
	private String code;
	private String model;
	private int price;
	private String id;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", model=" + model + ", price=" + price + ", id=" + id + "]";
	}
	
	
}
