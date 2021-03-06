package com.juno.shopping;

import com.juno.shopping.biz.product.ProductVO;

public interface PurchaseService {

	// 구매 기능 구현
	// 장바구니에 물건을 담고 구매
	// 물건 구매 시 재고가 줄어든다.
	// 포인트가 결제금액*적립율 만큼 오른다.
	// 총 결제금액, 포인트 추가
	void buyProduct(ProductVO vo);
}
