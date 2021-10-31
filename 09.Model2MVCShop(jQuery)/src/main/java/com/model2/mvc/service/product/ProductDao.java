package com.model2.mvc.service.product;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


//==> ȸ���������� CRUD �߻�ȭ/ĸ��ȭ�� DAO Interface Definition
public interface ProductDao {
	
	// INSERT
	public void addProduct(Product product) throws Exception ;
	//������ Product�� �޾ƿ� insert�� �ϰ� ��� ���� ���� �ʰڴ� void

	// SELECT ONE
	public Product getProduct(int prodNo) throws Exception ;
	//ProductId��� String���� �޾ƿͼ� ������ ��ȸ�ϰ� Product��� �����ο� ��Ƽ� ������� ���� ���
	//list�� ��Ƽ� ���� �ʱ� ������ �������� �޾ƿ� �� ���� �ϳ��� ������ �޾� �ϳ��� ������ ���
	
	// SELECT LIST
	public List<Product> getProductList(Search search) throws Exception ;
	//select�� ������ü�� ��ȸ�ϰ� �װ���� search�� ��Ƽ� list�������̽��� Product�� �������� ��Ƽ� ���� ������ ���

	// UPDATE
	public void updateProduct(Product Product) throws Exception ;
	//Product�����ο� ������ ���� �޾ƿ� �����͸� �����Ѵ�. �׷��� void�̱� ������ ��� ���� ����
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	//
	
}