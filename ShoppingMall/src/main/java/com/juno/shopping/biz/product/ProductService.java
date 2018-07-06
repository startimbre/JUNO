package com.juno.shopping.biz.product;

import java.util.List;

public interface ProductService {

	// Product의 기능 구현
	// 장바구니에 물건을 담고 구매
	
	// 물건 구매 시 재고가 줄어든다.
	// 포인트가 결제금액*적립율 만큼 오른다.
	void buyProduct(ProductVO vo);
	
	// 메인화면 상품
	// (나중에) 구매, 조회 데이터 기반 상품 추천
	// 지금은 있는 상품 나열
	ProductVO getProductDetail(ProductVO vo);
	// 상품 목록 출력(메인화면용)
	List<ProductVO> getProductList(ProductVO vo);
	// 상품 설명 출력
	ProductVO getProductExplain(ProductVO vo);
}
