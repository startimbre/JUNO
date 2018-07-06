package com.juno.shopping.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.shopping.biz.product.ProductService;
import com.juno.shopping.biz.product.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAOMybatis productDAO;
	// 메인화면 상품
	// (나중에) 구매, 조회 데이터 기반 상품 추천
	// 지금은 있는 상품 나열
	@Override
	public void buyProduct(ProductVO vo) {
	}

	@Override
	public ProductVO getProductDetail(ProductVO vo) {
		return productDAO.getProductDetail(vo);
	}
	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return productDAO.getProductList(vo);
	}
	@Override
	public ProductVO getProductExplain(ProductVO vo) {
		
		return null;
	}
}
