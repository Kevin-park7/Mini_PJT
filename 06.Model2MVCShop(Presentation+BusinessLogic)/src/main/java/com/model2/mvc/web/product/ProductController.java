package com.model2.mvc.web.product;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;



//==> 회원관리 Controller
@Controller
public class ProductController {
	
	///Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	//setter Method 구현 않음
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
		
	public ProductController(){
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
	
	
	@RequestMapping("/addProductView.do")
	public String addProductView() throws Exception {

		System.out.println("/addProductView.do");
		
		return "redirect:/product/addProductView.jsp";
	}
	
	@RequestMapping("/addProduct.do")
	public String addProduct( @ModelAttribute("product") Product product ) throws Exception {

		System.out.println("/addProduct.do");
		//Business Logic
		//productService.addProduct();
		String manuDate = product.getManuDate().replace("-", "");
		product.setManuDate(manuDate);
		System.out.println(product);
//		manuDate
//		String manuDate = request.getParameter("manuDate").replace("-", "");
		productService.addProduct(product);
		
		return "forward:/product/addProduct.jsp";
	}
	
	@RequestMapping("/getProduct.do")
	public String getProduct(@CookieValue(value="history", required = false) Cookie cookie, @RequestParam("prodNo") int prodNo , Model model,HttpServletResponse response ) throws Exception {
		
		System.out.println("/getProduct.do");
		//Business Logic
		Product product = productService.getProduct(prodNo);
		// Model 과 View 연결
		Purchase purchase = purchaseService.getPurchase2(prodNo);
		
		String prvHistory = "";
		// Cookie는 Request, Response를 가지고 불러오기 또는 전달이 이루어진다.
		// 현재 Project에서 사용되는 Cookie의 구조는 Key "history", value: prodNo이면서 각 ProdNo은 , 로 구분 되어있음.
		
		
		
		System.out.println("getProduct Cookie 1: "+ prvHistory);			
		//Cookie cookie = new Cookie();
		
		if(cookie !=null) {
			prvHistory=cookie.getValue();
		}
		System.out.println("getProduct Cookie 2: "+ prvHistory);
		System.out.println("getProduct Cookie 3저장: "+ prodNo+","+prvHistory);
		cookie = new Cookie("history", prodNo+","+prvHistory);	// 쿠키 생성
		
		cookie.setMaxAge(60*60);	// 헌재 Cookie의 유지기간
		cookie.setPath("/");
		response.addCookie(cookie);
		model.addAttribute("purchase", purchase);
		model.addAttribute("vo", product);
		
		return "forward:/product/getProduct.jsp";
	}
	
	@RequestMapping("/updateProductView.do")
	public String updateProductView( @RequestParam("prodNo") int prodNo , Model model ) throws Exception{

		System.out.println("/updateProductView.do");
		//Business Logic
		Product product = productService.getProduct(prodNo);
		// Model 과 View 연결
		model.addAttribute("prod", product);
		
		return "forward:/product/updateProductView.jsp";
	}
	
	@RequestMapping("/updateProduct.do")
	public String updateProduct( @ModelAttribute("product") Product product , Model model , HttpSession session) throws Exception{

		System.out.println("/updateProduct.do");
		//Business Logic
		String manuDate = product.getManuDate().replace("-", "");
		product.setManuDate(manuDate);
		productService.updateProduct(product);
		
//		int sessionId=((Product)session.getAttribute("product")).getProdNo();
//		if(sessionId.equals(product.getProdNo())){
//			session.setAttribute("product", product);
//		}
		
		return "redirect:/getProduct.do?prodNo="+product.getProdNo();
	}
//	
//	@RequestMapping("/loginView.do")
//	public String loginView() throws Exception{
//		
//		System.out.println("/loginView.do");
//
//		return "redirect:/product/loginView.jsp";
//	}
//	
//	@RequestMapping("/login.do")
//	public String login(@ModelAttribute("product") Product product , HttpSession session ) throws Exception{
//		
//		System.out.println("/login.do");
//		//Business Logic
//		Product dbProduct=productService.getProduct(product.getProductId());
//		
//		if( product.getPassword().equals(dbProduct.getPassword())){
//			session.setAttribute("product", dbProduct);
//		}
//		
//		return "redirect:/index.jsp";
//	}
//	
//	@RequestMapping("/logout.do")
//	public String logout(HttpSession session ) throws Exception{
//		
//		System.out.println("/logout.do");
//		
//		session.invalidate();
//		
//		return "redirect:/index.jsp";
//	}
//	
//	@RequestMapping("/checkDuplication.do")
//	public String checkDuplication( @RequestParam("productId") String productId , Model model ) throws Exception{
//		
//		System.out.println("/checkDuplication.do");
//		//Business Logic
//		boolean result=productService.checkDuplication(productId);
//		// Model 과 View 연결
//		model.addAttribute("result", new Boolean(result));
//		model.addAttribute("productId", productId);
//
//		return "forward:/product/checkDuplication.jsp";
//	}
//	
	@RequestMapping("/listProduct.do")
	public String listProduct( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/listProduct.do");
		String keyword = (search.getSearchKeyword()==null)? "":search.getSearchKeyword();
		search.setSearchKeyword(keyword);
		if(search.getCurrentPage() == null || search.getCurrentPage().equals("")){
			
			search.setCurrentPage("1");
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/product/listProduct.jsp";
	}
}