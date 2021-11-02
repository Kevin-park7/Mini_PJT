package com.model2.mvc.service.purchase.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


/*
 *	FileName :  PurchaseServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {	"classpath:config/context-common.xml",
										"classpath:config/context-aspect.xml",
										"classpath:config/context-mybatis.xml",
										"classpath:config/context-transaction.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Purchase purchase = new Purchase();
		Product product =new Product();
		product.setProdNo(10000);
		purchase.setPurchaseProd(product);
		User user = new User();
		user.setUserId("user13");
		purchase.setBuyer(user);
		purchase.setPaymentOption("1");
		purchase.setReceiverName("�ڼ����˃�");
		purchase.setReceiverPhone("0102010");
		purchase.setDivyAddr("����");
		purchase.setDivyRequest("1");
		purchase.setDivyDate("21/10/27");
		//product.setRegDate("111-2222-3333");
		
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchase(10001);

		//==> console Ȯ��
		System.out.println(product);
		
		//==> API Ȯ��
//		Assert.assertEquals("testProductId", product.getProductId());
//		Assert.assertEquals("testProductName", product.getProductName());
//		Assert.assertEquals("testPasswd", product.getPassword());
//		Assert.assertEquals("111-2222-3333", product.getPhone());
//		Assert.assertEquals("��⵵", product.getAddr());
//		Assert.assertEquals("test@test.com", product.getEmail());
	}
	
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		//==> �ʿ��ϴٸ�...
//		product.setProductId("testProductId");
//		product.setProductName("testProductName");
//		product.setPassword("testPasswd");
//		product.setSsn("1111112222222");
//		product.setPhone("111-2222-3333");
//		product.setAddr("��⵵");
//		product.setEmail("test@test.com");
		
		purchase = purchaseService.getPurchase(10011);

		//==> console Ȯ��
		System.out.println(purchase);
	}
		//==> API Ȯ��
//		Assert.assertEquals("10001", product.getProdNo());
//		Assert.assertEquals("testProdu", product.getFileName());
//		Assert.assertEquals("testPasswd", product.getManuDate());
//		Assert.assertEquals("111-2222-3333", product.getPrice());
//		Assert.assertEquals("��⵵", product.getProdDetail());
//		Assert.assertEquals("test@test.com", product.getProdName());
//
//		Assert.assertNotNull(productService.getProduct("product02"));
//		Assert.assertNotNull(productService.getProduct("product05"));
	
	
	//@Test
	 public void testUpdatePurchase() throws Exception{
		 
		Purchase purchase = new Purchase();
//		Assert.assertNotNull(purchase);
//		
//		Assert.assertEquals("testProductName", purchase.getProductName());
//		Assert.assertEquals("111-2222-3333", purchase.getPhone());
//		Assert.assertEquals("��⵵", purchase.getAddr());
//		Assert.assertEquals("test@test.com", purchase.getEmail());

		purchase.setReceiverName("����");
		purchase.setPaymentOption("001");
		purchase.setDivyRequest("1");
		purchase.setReceiverPhone("001");
		purchase.setDivyAddr("����");
		purchase.setTranNo(10001);
		//purchase.setDivyDate("21/10/22");
		System.out.println(purchase);
		purchaseService.updatePurcahse(purchase);
		
		purchase = purchaseService.getPurchase(10001);
		//Assert.assertNotNull(purchase);
		
		//==> console Ȯ��
		System.out.println(purchase);
			
		//==> API Ȯ��
//		Assert.assertEquals("change", purchase.getProductName());
//		Assert.assertEquals("777-7777-7777", purchase.getPhone());
//		Assert.assertEquals("change", purchase.getAddr());
//		Assert.assertEquals("change@change.com", purchase.getEmail());
	 }
	 
//	//@Test
//	public void testCheckDuplication() throws Exception{
//
//		//==> �ʿ��ϴٸ�...
////		Product purchase = new Product();
////		purchase.setProductId("testProductId");
////		purchase.setProductName("testProductName");
////		purchase.setPassword("testPasswd");
////		purchase.setSsn("1111112222222");
////		purchase.setPhone("111-2222-3333");
////		purchase.setAddr("��⵵");
////		purchase.setEmail("test@test.com");
////		
////		purchaseService.addProduct(purchase);
//		
//		//==> console Ȯ��
//		System.out.println(purchaseService.checkDuplication("testProductId"));
//		System.out.println(purchaseService.checkDuplication("testProductId"+System.currentTimeMillis()) );
//	 	
//		//==> API Ȯ��
//		Assert.assertFalse( purchaseService.checkDuplication("testProductId") );
//	 	Assert.assertTrue( purchaseService.checkDuplication("testProductId"+System.currentTimeMillis()) );
//		 	
//	}
//	
//	 //==>  �ּ��� Ǯ�� �����ϸ�....
	 @Test
	 public void testGetPurchaseListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage("1");
	 	search.setPageSize(3);
	 	User user =new User();
	 	user.setUserId("user13");
	 	Purchase purchase = new Purchase();
	 	purchase.setBuyer(user);
	 	Map<String,Object> map = purchaseService.getPurchaseList(search,purchase.getBuyer().getUserId());
	 	
	 	//Map<Object> list = (Map<Object>)map.get("list");
	 	//Assert.assertEquals(3, list.size());
	 	
		//==> console Ȯ��
	 	//System.out.println("list"+list.size());
	 	System.out.println("list"+map);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println("���������� :"+totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	//search.setCurrentPage(2);
	 	//search.setPageSize(3);
	 	//search.setSearchCondition("0");
	 	//search.setSearchKeyword("");
	 	//map = purchaseService.getProductList(search);
	 	
	 	//list = (List<Object>)map.get("list");
	 	//Assert.assertEquals(3, list.size());
	 	
	 	//==> console Ȯ��
	 	//System.out.println("list :"+list);
	 	//System.out.println("list :"+list.size());
	 	
	 	//totalCount = (Integer)map.get("totalCount");
	 	//System.out.println("totalCout :"+totalCount);
	 }
}
