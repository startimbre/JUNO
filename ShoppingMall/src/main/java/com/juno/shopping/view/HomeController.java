package com.juno.shopping.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "index.do")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "shop.do")
	public String shop() {
		return "shop";
	}
	
	@RequestMapping(value = "product-details.do")
	public String productDetail() {
		return "product-details";
	}
	
	@RequestMapping(value = "cart.do")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping(value = "checkout.do")
	public String checkout() {
		return "checkout";
	}
	
//	@RequestMapping(value = "searchresult.do")
//	public String searchResult(VO, Model) {
//		DAO에서 검색결과 처리해서 DB안의 상품 불러오기
//		list.do에서 불러오기
//	}
}