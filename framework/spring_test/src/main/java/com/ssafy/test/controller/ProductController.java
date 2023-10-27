package com.ssafy.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.model.mapper.ProductDto;
import com.ssafy.test.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(ProductDto productDto) {
		System.out.println("dto : " + productDto);
		try {
			productService.regist(productDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<ProductDto> list = productService.list();
		model.addAttribute("list", list);
		System.out.println(list.size());
		return "list";
	}
	
	@GetMapping("/view")
	public String view(String code, Model model) throws Exception {
		System.out.println("code : " + code);
		ProductDto productDto = productService.view(code);
		model.addAttribute("dto", productDto);
		return "view";
	}
}
