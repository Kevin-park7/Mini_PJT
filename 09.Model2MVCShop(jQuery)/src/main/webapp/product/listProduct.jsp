<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

// 검색 / page 두가지 경우 모두 Form 전송을 위해 JavaScrpt 이용  
function fncGetUserList(currentPage) {
	//document.getElementById("currentPage").value = currentPage;
   	//document.detailForm.submit();
   	//console.log('이 Function은 프린트 이전에 호출됩니다.',currentPage);
	$("#currentPage").val(currentPage)
	//var menu = $("#menu").val();
	var menu = $("input[name='menu']").val()

	$("form").attr("method","POST").attr("action","/product/listProduct?menu="+menu).submit();
	//$("form").attr("method","POST").attr("action","/product/listProduct/menu=search").submit();
	//console.log(currentPage);
	//console.log($("#menu").val());
	
   
}
$(function(){
	$("td.ct_btn01:contains('검색')").click(function(){
		alert("검색");
		fncGetUserList(1);
	});
	var menu = $("input[name='menu']").val()
	var prodNo = $("#prodNo").val();
	//var pron = $(".ct_list_pop td:nth-child(9)").find("input[name=prodNo]").val();
	
	//console.log(prodn)
	if(menu=="manage"){
		
	$(".ct_list_pop td:nth-child(3)").click(function(){
		//alert($(".ct_list_pop td:nth-child(3)").text());
		//$("form").attr("method","GET").attr("/product/updateProduct?prodNo=10000").submit();
		self.location = "/product/updateProduct?prodNo="+$(this).find("input[name=prodNo]").val();
	});
	}
	if(menu=="search"){
		$(".ct_list_pop td:nth-child(3)").click(function(){	
		//alert("돌아가라")
		self.location = "/product/getProduct?prodNo="+$(this).find("input[name=prodNo]").val();
		});
	}
	$("h7:contains('배송하기')").click(function(){
		
		alert("왜?")
		self.location = "/purchase/updateTranCodeByProd?prodNo="+$(this).find("input[name=prod]").val()+"&tranCode=002";
	});
	
	
	
	
	
	$( ".ct_list_pop td:nth-child(3)" ).css("color" , "red");
	$("h7").css("color" , "red");
	
	$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");
	
});
	


		</script>
</head>

<body bgcolor="#ffffff" text="#000000">

	<div style="width: 98%; margin-left: 10px;">
		<form name="detailForm">
			<!-- <form name="detailForm" action="/product/listProduct?menu=${param.menu}"
			method="post"> -->

			<table width="100%" height="37" border="0" cellpadding="0"
				cellspacing="0">
				<input type="hidden" id="menu" name="menu" value="${param.menu}" />
				<tr>
					<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
						width="15" height="37" /></td>
					<td background="/images/ct_ttl_img02.gif" width="100%"
						style="padding-left: 10px;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<c:if test="${param.menu eq 'manage'}">
									<td width="93%" class="ct_ttl01">상품 관리</td>
								</c:if>
								<c:if test="${param.menu eq 'search' }">
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
				<td align="right"><select name="searchCondition"
					class="ct_input_g" style="width: 80px">



						<option value="0"
							${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품번호</option>
						<option value="1"
							${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>상품명</option>
						<option value="2"
							${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>상품가격</option>
				</select> <input type="text" name="searchKeyword"
					value="${search.searchKeyword}" class="ct_input_g"
					style="width: 200px; height: 19px"></td>

				<td align="right" width="70">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
								width="17" height="23"></td>
							<td background="/images/ct_btnbg02.gif" class="ct_btn01"
								style="padding-top: 3px;">
								<!-- <a href="javascript:fncGetUserList('1');">검색</a> -->검색</td>
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
					<td colspan="11">전체 ${resultPage.totalCount } 건수, 현재
						${resultPage.currentPage} 페이지</td>
				</tr>
				<tr>
					<td class="ct_list_b" width="100">No</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b" width="150">상품명<br>
					<c:if test="${param.menu eq 'manage'}">
					<h7>(상품 click:수정)</h7></td>
					</c:if>
					
					<c:if test="${param.menu eq 'search'}">
					<h7>(상품 click:상세정보)</h7></td>
					</c:if>
					
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
						
						<td align="left">${prod.prodName}
						<input type="hidden" id="prodNo" name="prodNo" value="${prod.prodNo}" />						
						</td>

						<td></td>
						<td align="left">${prod.price}</td>
						<td></td>
						<td align="left">${prod.regDate}</td>
						<td></td>
						<td align="left">		
						<c:if test= "${param.menu eq 'manage'}">
						
				
						<c:if test= "${prod.proTranCode eq '001'}">
							구매완료 감사합니다<%-- <a href="/purchase/updateTranCodeByProd?prodNo=${prod.prodNo}&tranCode=002"> 배송하기</a> --%>
							<br>
							<h7>배송하기<input type="hidden" id="prodNo" name="prod" value="${prod.prodNo}"></h7> 
						</c:if>
						<c:if test= "${prod.proTranCode eq '002'}">
							배송중 조그만 기달력!!
						</c:if>
						<c:if test= "${prod.proTranCode eq '003'}">
							물품도착 리뷰남겨주세요
						</c:if>
						<c:if test="${prod.proTranCode eq null}">
						 	이것좀 사세요!!
						 </c:if>
					</c:if>
					<c:if test= "${param.menu eq 'search' }">
						<c:if test= "${prod.proTranCode eq null}">
							제고있음
						</c:if> 
						<c:if test= "${prod.proTranCode eq '1  '}">
							구매완료
						</c:if>
						<c:if test= "${prod.proTranCode eq '001'}">
							구매완료
						</c:if>
						<c:if test= "${prod.proTranCode eq '002'}">
							배송중
						</c:if>
						<c:if test= "${prod.proTranCode eq '003'}">
							물품도착
						</c:if>
						
						</c:if>

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
					<td align="center"><input type="hidden" id="currentPage"
						name="currentPage" value="" /> <jsp:include
							page="../common/pageNavigator.jsp" /></td>
				</tr>
			</table>
			<!--  페이지 Navigator 끝 -->

		</form>

	</div>
</body>
</html>