package com.model2.mvc.service.purchase;

import java.util.HashMap;
import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

//==> 회원관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface PurchaseDao {
	
	// INSERT
	public void addPurchase(Purchase purchase) throws Exception ;
	//정보를 Product로 받아와 insert를 하고 결과 값을 받지 않겠다 void

	// SELECT ONE
	public Purchase getPurchase(int tranNo) throws Exception ;
	//ProductId라는 String값을 받아와서 정보를 조회하고 Product라는 도메인에 담아서 결과값을 전부 출력
	//list로 담아서 오지 않기 때문에 여러개를 받아올 수 없다 하나의 정보만 받아 하나의 정보만 출력
	public Purchase getPurchase2(int prodNo)throws Exception ;
	//prodNo 로 tranNo 를 조회 하는 
	// SELECT LIST
	public List<Purchase> getPurchaseList(Search search , String buyerId) throws Exception ;
	//select로 정보전체를 조회하고 그결과를 search에 담아서 list인터페이스에 Product의 도메인을 담아서 많은 정보를 출력
	public HashMap<String,Object> getSaleList(Search search) throws Exception ;
	
	// UPDATE
	public void updatePurchase(Purchase purchase) throws Exception ;
	//Product도메인에 변경할 값을 받아와 데이터를 수정한다. 그러고 void이기 때문에 결과 값은 없다
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(String buyerId ) throws Exception ;
	//

	public void updateTranCode(Purchase purchase) throws Exception;
	
	
}