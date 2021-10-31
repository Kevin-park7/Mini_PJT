<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<%@ page import="java.util.*"  %>
<%@page import="com.model2.mvc.common.util.CommonUtil"%>
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ page import="com.model2.mvc.common.Search" %>
<%@ page import="com.model2.mvc.common.*" %>


	request.setCharacterEncoding("UTF-8"); //받아올 데이터의 인코딩
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	Search search=(Search)request.getAttribute("search");
	
	List<User> list= (List<User>)request.getAttribute("list");
	Page resultPage=(Page)request.getAttribute("resultPage");
	
	Search search = (Search)request.getAttribute("search");
	//==> null 을 ""(nullString)으로 변경
	String searchCondition = CommonUtil.null2str(search.getSearchCondition());
	String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
	
	String curPageStr = (String) request.getParameter("page");
	int curPage = 1;
	if (curPageStr != null)
		curPage = Integer.parseInt(curPageStr);
	
	String menu = (String) request.getParameter("menu");
	System.out.println(">>>>>>> "+ menu+"    "+ curPage);
	System.out.println("page 확인 >>>>>>>"+(curPage-1)/5);
	//int i = Integer.parseInt( request.getParameter("page"));
	//System.out.println("page 확인 >>>>>>>"+(( Integer.parseInt( request.getParameter("page"))-1)%5));
	// Page's Menu--> manage, search / page --> # / 
	if(menu.equals("manage")){
		pageContext.forward("updateTranCodeByProd.jsp");
		--%>
		
		<%--
		List<Product> list= (List<Product>)request.getAttribute("list");
		Page resultPage=(Page)request.getAttribute("resultPage");
		
		Search search = (Search)request.getAttribute("search");
		//==> null 을 ""(nullString)으로 변경
		String searchCondition = CommonUtil.null2str(search.getSearchCondition());
		String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
		
		String curPageStr = (String) request.getParameter("page");
		int curPage = 1;
		if (curPageStr != null)
			curPage = Integer.parseInt(curPageStr);
		
		System.out.println(resultPage +"    "+ resultPage.getTotalCount());
		
		String menu = (String) request.getParameter("menu");
		System.out.println(">>>>>>> "+ menu+"    "+ curPage);
		System.out.println("page 확인 >>>>>>>"+(curPage-1)/5);
		//int i = Integer.parseInt( request.getParameter("page"));
		//System.out.println("page 확인 >>>>>>>"+(( Integer.parseInt( request.getParameter("page"))-1)%5));
		// Page's Menu--> manage, search / page --> # / 
		if(menu.equals("manage")){			
		--%>

<html>
<head>
<title>상품 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">

// 검색 / page 두가지 경우 모두 Form 전송을 위해 JavaScrpt 이용  
function fncGetUserList(currentPage) {
	document.getElementById("currentPage").value = currentPage;
   	document.detailForm.submit();
   	console.log('이 Function은 프린트 이전에 호출됩니다.',currentPage);

   
}

		</script>
</head>

<body bgcolor="#ffffff" text="#000000">

	<div style="width: 98%; margin-left: 10px;">

		<form name="detailForm" action="/product/listProduct?menu=${param.menu}"
			method="post">

			<table width="100%" height="37" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
						width="15" height="37" /></td>
					<td background="/images/ct_ttl_img02.gif" width="100%"
						style="padding-left: 10px;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<c:if test= "${param.menu eq 'manage'}">
								<td width="93%" class="ct_ttl01">상품 관리</td>
								</c:if>
								<c:if test= "${param.menu eq 'search' }">
								<td width="93%" class="ct_ttl01">상품 목록</td>
								</c:if>
								
								
							</tr>
						</table>
					</td>
					<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
						width="12" height="37" /></td>
				</tr>
			</table>


			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<td align="right">
						<select name="searchCondition" class="ct_input_g" style="width:80px">
				
			
								
							<option value="0" ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품번호</option>
							<option value="1" ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>상품명</option>
							<option value="2" ${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>상품가격</option>						
				</select>
				 <input type="text" name="searchKeyword" value="${search.searchKeyword}" class="ct_input_g"
					style="width: 200px; height: 19px"></td>
			
				<td align="right" width="70">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
								width="17" height="23"></td>
							<td background="/images/ct_btnbg02.gif" class="ct_btn01"
								style="padding-top: 3px;"><a
								href="javascript:fncGetUserList('1');">검색</a></td>
							<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
								width="14" height="23"></td>
						</tr>
					</table>
				</td>
				</tr>
			</table>


			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr>
					<td colspan="11">전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage}  페이지
		</td>
				</tr>
				<tr>
					<td class="ct_list_b" width="100">No</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b" width="150">상품명</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b" width="150">가격</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">등록일</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">현재상태</td>
				</tr>
				<tr>
					<td colspan="11" bgcolor="808285" height="1"></td>
				</tr>
				
					
		
				<c:set var="i" value="0" /> 
				<%--i에 0값을 넣고 prod에서 list사이즈까지 돈다
				도는데 i에 값을 1씩 추가 한다.  --%>
		<c:forEach var="prod" items="${list}">
		<c:set var="i" value="${ i+1 }" />
		<tr class="ct_list_pop">
			<td align="center">${ i }</td>
					<td></td>
								<c:if test= "${param.menu eq 'manage'}">
								<td align="left"><a
						href="/product/updateProduct?prodNo=${prod.prodNo}">${prod.prodName}</a></td>
								</c:if>
								<c:if test= "${param.menu eq 'search' }">
										<td align="left"><a
						href="/product/getProduct?prodNo=${prod.prodNo}">${prod.prodName}</a></td>
								</c:if>
					

					<td></td>
					<td align="left">${prod.price}</td>
					<td></td>
					<td align="left">${prod.regDate}</td>
					<td></td>
					<td align="left">재고 없음 <a
						href="/product/updateTranCodeByProd?prodNo=10002&tranCode=2">재고 없음</a>

					</td>
				</tr>
				<tr>
					<td colspan="11" bgcolor="D6D7D6" height="1"></td>
				</tr>
		</c:forEach>

			</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr>
					<td align="center">
						   <input type="hidden" id="currentPage" name="currentPage" value=""/>

	   					<jsp:include page="../common/pageNavigator.jsp"/>	
					</td>
				</tr>
			</table>
			<!--  페이지 Navigator 끝 -->

		</form>

	</div>
</body>
</html>