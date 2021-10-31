package com.model2.mvc.view.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeAction extends Action {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("tranCod>>>>>>>>"+request.getParameter("tranCode"));
		System.out.println("tranNo>>>>>>>>>>"+request.getParameter("tranNo"));
		Search search=new Search();
		Purchase purchase= new Purchase();
		HttpSession session = request.getSession();
		User buyer = (User) session.getAttribute("user");
//		UserVO buyerVO = new UserVO();
//		buyerVO.setUserId(userId);
//		purchaseVO.setBuyer(buyerVO);
		
		purchase.setTranCode(request.getParameter("tranCode"));
		purchase.setTranNo(Integer.parseInt(request.getParameter("tranNo")));
	
		int currentPage=1;
		if(request.getParameter("currentPage") != null && !request.getParameter("currentPage").equals(""))
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("ListPurchaseAction >>> "+ currentPage+"    "+request.getParameter("searchCondition")+"    "+
				request.getParameter("searchKeyword"));
		search.setCurrentPage(currentPage);
		search.setSearchCondition(request.getParameter("searchCondition"));
		String keyword = (request.getParameter("searchKeyword")==null)? "": request.getParameter("searchKeyword");
		search.setSearchKeyword(keyword);
		
		int pageSize=Integer.parseInt( getServletContext().getInitParameter("pageSize"));
		int pageUnit=Integer.parseInt( getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		
		
		PurchaseService service=new PurchaseServiceImpl();
		
		service.updateTranCode(purchase);
		System.out.println("ListProductAction >>> searchCondition: "+search.getSearchCondition()+
				" searchKeyword: "+search.getSearchKeyword()+" page unit: "+search.getPageSize());
		Map<String,Object> map = service.getPurchaseList(search, buyer.getUserId());
		Page p = new Page(currentPage, Integer.parseInt(String.valueOf(map.get("count"))), pageUnit,  pageSize );
		
		System.out.println("map에 저장된 결과"+map);
		request.setAttribute("resultPage", p);
		request.setAttribute("mappurchase", map);
		request.setAttribute("search", search);
		request.setAttribute("pageUnit", pageSize);
		
		
		return "forward:/purchase/listPurchase.jsp";
		}

}
