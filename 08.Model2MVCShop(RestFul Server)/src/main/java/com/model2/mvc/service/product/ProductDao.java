package com.model2.mvc.service.product;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;


//==> 회원관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface ProductDao {
	
	// INSERT
	public void addProduct(Product product) throws Exception ;
	//정보를 Product로 받아와 insert를 하고 결과 값을 받지 않겠다 void

	// SELECT ONE
	public Product getProduct(int prodNo) throws Exception ;
	//ProductId라는 String값을 받아와서 정보를 조회하고 Product라는 도메인에 담아서 결과값을 전부 출력
	//list로 담아서 오지 않기 때문에 여러개를 받아올 수 없다 하나의 정보만 받아 하나의 정보만 출력
	
	// SELECT LIST
	public List<Product> getProductList(Search search) throws Exception ;
	//select로 정보전체를 조회하고 그결과를 search에 담아서 list인터페이스에 Product의 도메인을 담아서 많은 정보를 출력
	// UPDATE
	public void updateProduct(Product Product) throws Exception ;
	//Product도메인에 변경할 값을 받아와 데이터를 수정한다. 그러고 void이기 때문에 결과 값은 없다
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	//
	
}