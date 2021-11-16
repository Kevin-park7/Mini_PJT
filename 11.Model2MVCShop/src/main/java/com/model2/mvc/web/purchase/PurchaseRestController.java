package com.model2.mvc.web.purchase;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;


//==> 회원관리 RestController
@RestController
@RequestMapping("/purchase/*")
public class PurchaseRestController {
	
	///Field
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	//setter Method 구현 않음
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	//setter Method 구현 않음
		
	public PurchaseRestController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="json/getPurchase/{tranNo}", method=RequestMethod.GET )
	public Purchase getProduct( @PathVariable String tranNo ) throws Exception{
		
		System.out.println("/purchase/json/getPurchase : GET");
		
		//Business Logic
		return purchaseService.getPurchase(Integer.parseInt(tranNo));
	}

	@RequestMapping( value="json/addPurchase", method=RequestMethod.POST )
	public Purchase addPurchase(	@RequestBody Purchase purchase ) throws Exception{
	
		System.out.println("/purchase/json/addPurchase : POST");
		//Business Logic
		System.out.println("purchase<<<<<<<<<<"+purchase.getTranNo());
		purchaseService.addPurchase(purchase);
		System.out.println("map");
//		System.out.println(map);
		Purchase dbPurchase = purchaseService.getPurchase(0);
		System.out.println("::"+dbPurchase);
		System.out.println("::"+purchase);
		
		
		return dbPurchase;
	}

	@RequestMapping(value="json/updatePurchase",method=RequestMethod.POST)
	public Purchase updatePurchase(@RequestBody Purchase purchase)throws Exception{
		
		System.out.println("/purchase/json/updatePurchase : POST");
		purchaseService.updatePurchase(purchase);

		return purchaseService.getPurchase(purchase.getTranNo());
	}
	@RequestMapping(value="json/listPurchase",method=RequestMethod.POST)
	public Map listPurchase(@RequestBody Search search,String buyer )throws Exception{
		Map<String,Object> map = purchaseService.getPurchaseList(search,buyer);
		System.out.println("json/listPurchase"+map);
		
		
		
		return map;
	}
	@RequestMapping(value="json/getProdNo/{prodNo}",method=RequestMethod.GET)
	public Map getProdNo(@PathVariable int prodNo)throws Exception{
		
		System.out.println("/purchase/json/getProdNo  : GET  ");
		Map<String,Object> map = purchaseService.getProdNo(prodNo);
		map.put("product",productService.getProduct(prodNo));
		return map;
	}
}