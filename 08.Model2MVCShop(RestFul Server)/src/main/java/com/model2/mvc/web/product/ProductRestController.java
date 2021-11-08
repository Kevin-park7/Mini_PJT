package com.model2.mvc.web.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


//==> ȸ������ RestController
@RestController
@RequestMapping("/product/*")
public class ProductRestController {
	
	///Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	//setter Method ���� ����
		
	public ProductRestController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="json/getProduct/{prodNo}", method=RequestMethod.GET )
	public Product getProduct( @PathVariable String prodNo ) throws Exception{
		
		System.out.println("/product/json/getProduct : GET");
		
		//Business Logic
		return productService.getProduct(Integer.parseInt(prodNo));
	}

	@RequestMapping( value="json/addProduct", method=RequestMethod.POST )
	public Product addProduct(	@RequestBody Product product ) throws Exception{
	
		System.out.println("/product/json/addProduct : POST");
		//Business Logic
		System.out.println("product<<<<<<<<<<"+product.getProdNo());
		productService.addProduct(product);
		System.out.println("map");
//		System.out.println(map);
		Product dbProduct = productService.getProduct(0);
		System.out.println("::"+dbProduct);
		System.out.println("::"+product);
		
		
		return dbProduct;
	}

	@RequestMapping(value="json/updateProduct",method=RequestMethod.POST)
	public Product updateProduct(@RequestBody Product product)throws Exception{
		
		System.out.println("/product/json/updateProduct : POST");
		productService.updateProduct(product);
		
		return productService.getProduct(product.getProdNo());
	}
	@RequestMapping(value="json/listProduct",method=RequestMethod.POST)
	public Map listProduct(@RequestBody Search search )throws Exception{
		Map<String,Object> map = productService.getProductList(search);
		System.out.println("json/listProduct"+map);
		
		
		
		return map;
	}
	@RequestMapping(value="json/listProdNo",method=RequestMethod.POST)
	public Map listProdNo(@RequestBody Product product)throws Exception{
		Map<String> map = productService.getProdNo(Product);
		
		
		return map;
	}
}