package com.juno.shopping.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.shopping.biz.product.ProductService;
import com.juno.shopping.biz.product.ProductVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// 상품 목록 검색
	@RequestMapping(value="product-details.do")
	public String getProductDetail(ProductVO vo, Model model)
	{	
		model.addAttribute("product", productService.getProductDetail(vo));
		return "product-details";
	}
}
