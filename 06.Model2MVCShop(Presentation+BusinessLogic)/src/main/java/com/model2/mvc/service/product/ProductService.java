package com.model2.mvc.service.product;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


//==> ȸ���������� ������ ���� �߻�ȭ/ĸ��ȭ�� Service  Interface Definition  
public interface ProductService {
	
	// ��ǰ���
	public void addProduct(Product product) throws Exception;
	
	// ��ǰ��ȸ
	public Product getProduct(int prodNo) throws Exception;
	
	// ��ǰ����Ʈ��ȸ 
	public Map<String , Object> getProductList(Search search) throws Exception;
	
	// ��ǰ��������
	public void updateProduct(Product product) throws Exception;
	
	// ȸ�� ID �ߺ� Ȯ��
	public boolean checkDuplication(int prodNo) throws Exception;
	
}