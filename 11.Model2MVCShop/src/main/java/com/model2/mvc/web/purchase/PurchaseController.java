package com.model2.mvc.web.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {
	
	///Field
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	//setter Method 구현 않음
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
		
	public PurchaseController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml 참조 할것
	//==> 아래의 두개를 주석을 풀어 의미를 확인 할것
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	@RequestMapping(value="addPurchase", method=RequestMethod.GET)
	public ModelAndView addPurchaseView(@RequestParam("prodNo")int prodNo) throws Exception {
//ModelAttribute 는 전체를 넘겨준다
		//RequestP
		System.out.println("/addPurchaseView.do");
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/purchase/addpurchaseView.jsp");
		Product prod = productService.getProduct(prodNo);
		view.addObject("product", prod);
		
		return view;
	}
	
	@RequestMapping(value="addPurchase", method=RequestMethod.POST)
	public ModelAndView addPurchase( @ModelAttribute("purchase") Purchase purchase,
									@ModelAttribute("product")Product product) throws Exception {

		System.out.println("/addPurchase.do");
		//Business Logic
		//purchaseService.addPurchase();
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/purchase/getpurchase.jsp");
		//String manuDate = purchase.getDivyDate().replace("/", "-");
		//purchase.setDivyDate(manuDate);
		product.setAmount(product.getAmount()-purchase.getQuantity());
		productService.updateProduct(product);
		System.out.println("purchase : "+purchase);
		purchaseService.addPurchase(purchase);
//		manuDate
		//Purchase prodNo = purchaseService.getPurchase2(purchase.getPurchaseProd().getProdNo());
		//purchase.setPurchaseProd(prodNo.getPurchaseProd());
		view.addObject("purch", purchase);
//		String manuDate = request.getParameter("manuDate").replace("-", "");
		//purchaseService.addPurchase(purchase);
		
		return view;
	}
	
	@RequestMapping(value="getPurchase",method=RequestMethod.GET)
	public ModelAndView getPurchase( @RequestParam("tranNo") int tranNo ) throws Exception {
		
		System.out.println("/getPurchase.do");
		//Business Logic
		Purchase purchase = purchaseService.getPurchase(tranNo);
		// Model 과 View 연결
		Product product =productService.getProduct(purchase.getPurchaseProd().getProdNo());
		ModelAndView view = new ModelAndView();
		view.addObject("vo", purchase);
		view.addObject("product",product);
		view.setViewName("forward:/purchase/getPurchaseView.jsp");
		
		return view;
	}
	
	@RequestMapping(value="updatePurchase", method=RequestMethod.GET)
	public ModelAndView updatePurchaseView( @RequestParam("tranNo") int tranNo ) throws Exception{

		System.out.println("/updatePurchaseView.do");
		//Business Logic
		Purchase purchase = purchaseService.getPurchase(tranNo);
		// Model 과 View 연결
		System.out.println(">>>>>>>>>>"+purchase.getPaymentOption()+".>>>>>>>");
		String pay = purchase.getPaymentOption().trim();
		purchase.setPaymentOption(pay);
		ModelAndView view = new ModelAndView();
		view.addObject("vo", purchase);
		view.setViewName("forward:/purchase/updatePurchaseView.jsp");
		
		return view;
	}
	
	@RequestMapping(value="updatePurchase", method=RequestMethod.POST)
	public ModelAndView updatePurchase( @ModelAttribute("purchase")Purchase purchase) throws Exception{

		System.out.println("/updatePurchase.do");
		//Business Logic
		purchaseService.updatePurchase(purchase);
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/purchase/getPurchaseView.jsp");
		Purchase vo = purchaseService.getPurchase(purchase.getTranNo());
		view.addObject("vo",vo );
//		int sessionId=((Purchase)session.getAttribute("purchase")).getProdNo();
//		if(sessionId.equals(purchase.getProdNo())){
//			session.setAttribute("purchase", purchase);
//		}
		
		return view;
	}
	
	@RequestMapping(value="updateTranCodeByProd", method=RequestMethod.GET)
	public ModelAndView updateTranCode( @RequestParam("tranCode")String tranCode,
										@RequestParam("tranNo")int prodNo) throws Exception{

		System.out.println("/updateTranCodeByProd");
		//Business Logic
		Purchase purchase = new Purchase();
		//purchase = purchaseService.getPurchase2(prodNo);
		purchase.setTranNo(prodNo);
		purchase.setTranCode(tranCode);
		System.out.println("111111"+purchase);
		purchaseService.updateTranCode(purchase);
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/product/listProduct?menu=manage");
		Purchase vo = purchaseService.getPurchase(purchase.getTranNo());
		view.addObject("vo",vo );
		System.out.println("vo>>>>>>>>"+vo);
//		int sessionId=((Purchase)session.getAttribute("purchase")).getProdNo();
//		if(sessionId.equals(purchase.getProdNo())){
//			session.setAttribute("purchase", purchase);
//		}
		
		return view;
	}
	
	@RequestMapping(value="updateTranCode", method=RequestMethod.GET)
	public ModelAndView updateTranCode2( @RequestParam("tranCode")String tranCode,
										@RequestParam("tranNo")int tranNo) throws Exception{

		System.out.println("/updatePurchase.do");
		//Business Logic
		Purchase purchase = new Purchase();
		purchase.setTranNo(tranNo);
		purchase.setTranCode(tranCode);
		purchaseService.updateTranCode(purchase);
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/purchase/listPurchase");
		Purchase vo = purchaseService.getPurchase(purchase.getTranNo());
		view.addObject("vo",vo );
//		int sessionId=((Purchase)session.getAttribute("purchase")).getProdNo();
//		if(sessionId.equals(purchase.getProdNo())){
//			session.setAttribute("purchase", purchase);
//		}
		
		return view;
	}



	@RequestMapping(value="listPurchase")
	public ModelAndView listPurchase( @ModelAttribute("search") Search search , Model model , HttpServletRequest request,HttpSession session) throws Exception{
		
		System.out.println("/listPurchase.do");
		ModelAndView view = new ModelAndView();
		
		String keyword = (search.getSearchKeyword()==null)? "":search.getSearchKeyword();
		search.setSearchKeyword(keyword);
		if(search.getCurrentPage() == 0){
			
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		User buyer = (User)session.getAttribute("user");
		
		
		// Business logic 수행
		Map<String , Object> map=purchaseService.getPurchaseList(search,buyer.getUserId());
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println("resultPage>>>>>>>>>>>>>>>>"+resultPage);
		view.addObject("resultPage", resultPage);
		view.addObject("mappurchase", map);
		view.setViewName("forward:/purchase/listPurchase.jsp");

		return view;
	}
}