//package com.juno.shopping.view;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.juno.shopping.biz.product.ProductVO;
//
//@Controller
//public class ProductController {
//	// 상품 목록 검색
//	@RequestMapping(value="product-details.do")
//	public String getProductDetail(ProductVO vo, Model model)
//	{
//		model.addAttribute("product", vo);
//		return "product-details";
//	}
//}