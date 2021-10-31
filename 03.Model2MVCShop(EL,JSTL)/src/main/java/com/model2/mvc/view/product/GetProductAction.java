package com.model2.mvc.view.product;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class GetProductAction extends Action {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service=new ProductServiceImpl();
		Product vo=service.getProduct(prodNo);
		System.out.println("getprodNo>>>>>:"+prodNo);
		System.out.println("getprodNo에 vo>>>>>:"+vo);
		request.setAttribute("vo", vo);
		PurchaseService service2 = new PurchaseServiceImpl();
		Purchase purchase=service2.getPurchase2(prodNo);
		String prvHistory = "";
		System.out.println("tranCode 확인 <<<"+purchase);
		// Cookie는 Request, Response를 가지고 불러오기 또는 전달이 이루어진다.
		// 현재 Project에서 사용되는 Cookie의 구조는 Key "history", value: prodNo이면서 각 ProdNo은 , 로 구분 되어있음.
		
		for (Cookie c: request.getCookies()){
			if (c.getName().equals("history")){

				prvHistory=c.getValue();
				System.out.println("getProduct: "+ prvHistory);			
			}
		}
		
		
		System.out.println("getProduct: "+ prvHistory);
		System.out.println("getProduct: "+ prodNo+","+prvHistory);
		Cookie cookie = new Cookie("history", prodNo+","+prvHistory);	// 쿠키 생성
		cookie.setMaxAge(60*60);	// 헌재 Cookie의 유지기간
		response.addCookie(cookie);
		
		HashMap<String,Object> map = new HashMap ();
		map.put("prodNo", request.getParameter("prodNo"));
		map.put("prodName", request.getParameter("prodName"));
		map.put("manuDate", request.getParameter("manuDate"));
		map.put("price", request.getParameter("price"));
		map.put("prodDetail", request.getParameter("prodDetail"));
		map.put("regDate", request.getParameter("regDate"));
		
		HttpSession session=request.getSession();
		map.get("prodName");
		System.out.println("GetProduct  session >>"+map);
		session.setAttribute("product", map);
		request.setAttribute("purchase", purchase);
		
		

		return "forward:/product/getProduct.jsp";
	}
}