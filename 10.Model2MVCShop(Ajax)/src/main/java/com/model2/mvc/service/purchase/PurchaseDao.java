package com.model2.mvc.service.purchase;

import java.util.HashMap;
import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

//==> ȸ���������� CRUD �߻�ȭ/ĸ��ȭ�� DAO Interface Definition
public interface PurchaseDao {
	
	// INSERT
	public void addPurchase(Purchase purchase) throws Exception ;
	//������ Product�� �޾ƿ� insert�� �ϰ� ��� ���� ���� �ʰڴ� void

	// SELECT ONE
	public Purchase getPurchase(int tranNo) throws Exception ;
	//ProductId��� String���� �޾ƿͼ� ������ ��ȸ�ϰ� Product��� �����ο� ��Ƽ� ������� ���� ���
	//list�� ��Ƽ� ���� �ʱ� ������ �������� �޾ƿ� �� ���� �ϳ��� ������ �޾� �ϳ��� ������ ���
	public Purchase getPurchase2(int prodNo)throws Exception ;
	//prodNo �� tranNo �� ��ȸ �ϴ� 
	// SELECT LIST
	public List<Purchase> getPurchaseList(Search search , String buyerId) throws Exception ;
	//select�� ������ü�� ��ȸ�ϰ� �װ���� search�� ��Ƽ� list�������̽��� Product�� �������� ��Ƽ� ���� ������ ���
	public HashMap<String,Object> getSaleList(Search search) throws Exception ;
	
	// UPDATE
	public void updatePurchase(Purchase purchase) throws Exception ;
	//Product�����ο� ������ ���� �޾ƿ� �����͸� �����Ѵ�. �׷��� void�̱� ������ ��� ���� ����
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
	public int getTotalCount(String buyerId ) throws Exception ;
	//

	public void updateTranCode(Purchase purchase) throws Exception;
	
	
}