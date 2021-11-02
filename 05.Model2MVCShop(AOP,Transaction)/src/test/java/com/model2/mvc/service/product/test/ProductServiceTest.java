package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


/*
 *	FileName :  ProductServiceTest.java
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
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

//	@Test
//	public void testAddProduct() throws Exception {
//		
//		Product product = new Product();
//		product.setProdName("��ǰ��");
//		product.setProdDetail("��ǰ������");
//		product.setManuDate("21/10/10");
//		product.setPrice(1000);
//		product.setFileName("�̹�������");
//		//product.setRegDate("111-2222-3333");
//		
//		productService.addProduct(product);
//		
//		product = productService.getProduct(10041);
//
//		//==> console Ȯ��
//		System.out.println(product);
//		
		//==> API Ȯ��
//		Assert.assertEquals("testProductId", product.getProductId());
//		Assert.assertEquals("testProductName", product.getProductName());
//		Assert.assertEquals("testPasswd", product.getPassword());
//		Assert.assertEquals("111-2222-3333", product.getPhone());
//		Assert.assertEquals("��⵵", product.getAddr());
//		Assert.assertEquals("test@test.com", product.getEmail());
	
	
	@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
		//==> �ʿ��ϴٸ�...
//		product.setProductId("testProductId");
//		product.setProductName("testProductName");
//		product.setPassword("testPasswd");
//		product.setSsn("1111112222222");
//		product.setPhone("111-2222-3333");
//		product.setAddr("��⵵");
//		product.setEmail("test@test.com");
		
		product = productService.getProduct(10041);

		//==> console Ȯ��
		System.out.println(product);
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
	
	
	@Test
	 public void testUpdateProduct() throws Exception{
		 
		Product product = productService.getProduct(10041);
//		Assert.assertNotNull(product);
//		
//		Assert.assertEquals("testProductName", product.getProductName());
//		Assert.assertEquals("111-2222-3333", product.getPhone());
//		Assert.assertEquals("��⵵", product.getAddr());
//		Assert.assertEquals("test@test.com", product.getEmail());

		product.setProdName("��ǰ");
		product.setManuDate("21/01/11");
		product.setPrice(300000);
		product.setFileName("change@change.com");
		product.setProdDetail("���ʹ�");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10041);
		Assert.assertNotNull(product);
		
		//==> console Ȯ��
		System.out.println(product);
			
		//==> API Ȯ��
//		Assert.assertEquals("change", product.getProductName());
//		Assert.assertEquals("777-7777-7777", product.getPhone());
//		Assert.assertEquals("change", product.getAddr());
//		Assert.assertEquals("change@change.com", product.getEmail());
	 }
	 
//	//@Test
//	public void testCheckDuplication() throws Exception{
//
//		//==> �ʿ��ϴٸ�...
////		Product product = new Product();
////		product.setProductId("testProductId");
////		product.setProductName("testProductName");
////		product.setPassword("testPasswd");
////		product.setSsn("1111112222222");
////		product.setPhone("111-2222-3333");
////		product.setAddr("��⵵");
////		product.setEmail("test@test.com");
////		
////		productService.addProduct(product);
//		
//		//==> console Ȯ��
//		System.out.println(productService.checkDuplication("testProductId"));
//		System.out.println(productService.checkDuplication("testProductId"+System.currentTimeMillis()) );
//	 	
//		//==> API Ȯ��
//		Assert.assertFalse( productService.checkDuplication("testProductId") );
//	 	Assert.assertTrue( productService.checkDuplication("testProductId"+System.currentTimeMillis()) );
//		 	
//	}
//	
//	 //==>  �ּ��� Ǯ�� �����ϸ�....
	 //@Test
	 public void testGetProductListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println("list"+list.size());
	 	System.out.println("list"+list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(2);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	//==> console Ȯ��
	 	System.out.println("list :"+list);
	 	System.out.println("list :"+list.size());
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println("totalCout :"+totalCount);
	 }
	 
	 @Test
	 public void testGetProductListByProdNo() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("10001");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println("list"+list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("10001");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
//	 
//	 //@Test
//	 public void testGetProductListByProductName() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword("SCOTT");
//	 	Map<String,Object> map = productService.getProductList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(3, list.size());
//	 	
//		//==> console Ȯ��
//	 	System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword(""+System.currentTimeMillis());
//	 	map = productService.getProductList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(0, list.size());
//	 	
//		//==> console Ȯ��
//	 	System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }	 
}