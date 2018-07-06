package com.juno.shopping.biz.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.juno.shopping.biz.product.ProductVO;

@Repository
public class ProductDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public ProductVO getProductDetail(ProductVO vo) {
		System.out.println("Show Products method exec...");
		return (ProductVO) mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	public List<ProductVO> getProductList(ProductVO vo) {
		System.out.println("Show Products method exec...");
		return mybatis.selectList("ProductDAO.getProductList");
	}
	
	// 물건 구매시 처리
	// 1. 재고가 줄어든다.
	// 2. 구매자의 돈이 줄어든다.
	// 3. 
//	public void buyProduct(ProductVO vo) {
//		int point = vo.getPrice() * vo.getPointPercent();
//	}

}