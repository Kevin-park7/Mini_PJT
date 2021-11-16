<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page import="java.util.*"%>
<%@ page import="com.model2.mvc.service.domain.*"%>
<%@ page import="com.model2.mvc.common.*"%>

<%--
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	Search search=(Search)request.getAttribute("searchVO");
	
	int total=0;
	ArrayList<Purchase> list=null;
	if(map != null){
		total=((Integer)map.get("count")).intValue();
		list=(ArrayList<Purchase>)map.get("list");
	}
	
	int currentPage=search.getCurrentPage();
	
	int totalPage=0;
	if(total > 0) {
		totalPage= total / search.getPageSize() ;
		if(total%search.getPageSize() >0)
			totalPage += 1;
	}
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
	//if(menu.equals("manage")){
		//pageContext.forward("updateTranCodeByProd.jsp");
--%>



<html>
<head>
<title>구매 목록조회</title>

<meta charset="EUC-KR">

<!-- 참조 : http://getbootstrap.com/css/   참조 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
<!-- Bootstrap Dropdown Hover JS -->
<script src="/javascript/bootstrap-dropdownhover.min.js"></script>


<!-- jQuery UI toolTip 사용 CSS-->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- jQuery UI toolTip 사용 JS-->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--  ///////////////////////// CSS ////////////////////////// -->
<style>
body {
	padding-top: 50px;
}
</style>
<script type="text/javascript">
	//검색 / page 두가지 경우 모두 Form 전송을 위해 JavaScrpt 이용  
	function fncGetUserList(currentPage) {
		document.getElementById("currentPage").value = currentPage;
		document.detailForm.submit();
		console.log('이 Function은 프린트 이전에 호출됩니다.', currentPage);
	}

	$(function() {

		$(".ct_list_pop td:nth-child(1)").click(
				function() {
					self.location = "/purchase/getPurchase?tranNo="
							+ $(this).find("input[name=tranNo]").val();

				});

		$(".ct_list_pop td:nth-child(3)").click(function() {
			self.location = "/user/getUser?userId=" + $(this).text().trim();
		});

		$(".ct_list_pop td:nth-child(15)")
				.on(
						"click",
						function() {
							//Debug..

							//////////////////////////// 추가 , 변경된 부분 ///////////////////////////////////
							//self.location ="/user/getUser?userId="+$(this).text().trim();
							////////////////////////////////////////////////////////////////////////////////////////////
							var tranNo = $(this).find("input[name=tranNo]")
									.val();
							$
									.ajax({
										url : "/purchase/json/getPurchase/"
												+ tranNo,
										method : "GET",
										dataType : "json",
										headers : {
											"Accept" : "application/json",
											"Content-Type" : "application/json"
										},
										success : function(JSONData, status) {

											//Debug...
											//alert(status);
											//Debug...
											//alert("JSONData : \n"+JSONData);

											var displayValue = "<h5>"
													+ "물품번호   	 : "
													+ JSONData.tranNo
													+ "<br/>"
													+ "구매자아이디   : "
													+ JSONData.divyAddr
													+ "<br/>"
													+ "구매뱅법 	 : "
													+ JSONData.divyDate
													+ "<br/>"
													+ "구매자이름 	 : "
													+ JSONData.divyRequest
													+ "<br/>"
													+ "구매자연락처	 : "
													+ JSONData.orderDate
													+ "<br/>"
													+ "구매자주소  	 : "
													+ JSONData.receiverName
													+ "<br/>"
													+ "구매요청사항 	 : "
													+ JSONData.receiverPhone
													+ "<br/>"
													+ "배송희망일 	 : "
													+ JSONData.receiverPhone
													+ "<br/>"
													+ "주문일  	 : "
													+ JSONData.receiverPhone
													+ "<br/>"
													+ "<span class='glyphicon glyphicon-thumbs-up' id=tranNo name="+JSONData.tranNo+"></span>"
													+ "</h5>";
											//Debug...			

											//alert(displayValue);
											$("h5").remove();
											$("span[id=tranNo]").click(
													function() {
														alert("ddd");
													});

											$("#" + tranNo + "").html(
													displayValue);
										}
									});
							////////////////////////////////////////////////////////////////////////////////////////////

						});

		$("h7:contains('상품도착')").click(
				function() {
					self.location = "/purchase/updateTranCode?tranNo="
							+ $(this).find("input[name=tranNo]").val()
							+ "&tranCode=003";
				});
		$(".ct_list_pop td:nth-child(1)").css("color", "red");
		$(".ct_list_pop td:nth-child(3)").css("color", "red");
		$($("h7")[0]).css("color", "red");
		$($("h7")[1]).css("color", "red");

		$(".ct_list_pop:nth-child(4n+6)").css("background-color", "whitesmoke");

	});
</script>
</head>

<body>


	<form name="detailForm" action="/purchase/listPurchase" method="post">
		<!-- ToolBar Start /////////////////////////////////////-->
		<jsp:include page="/layout/toolbar.jsp" />
		<!-- ToolBar End /////////////////////////////////////-->
		<div class="container">
			<div class="page-header text-info">
				<h3>구매 목록조회</h3>
			</div>

			<div class="row">

				<div class="col-md-6 text-left">
					<p class="text-primary">전체 ${resultPage.totalCount } 건수, 현재
						${resultPage.currentPage} 페이지</p>
				</div>
			</div>
			<table class="table table-hover table-striped">

				<thead>
					<tr>
						<td class="ct_list_b" width="100">No<br> <h7>(상세정보)</h7></td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">회원ID<br> <h7>(회원정보)</h7></td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">회원명</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">전화번호</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">구매수량</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">배송현황</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">정보수정</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">정보보기</td>
					</tr>
				</thead>

				<c:set var="i" value="0" />
				<c:forEach var="purchase" items="${mappurchase.list}">
					<c:set var="i" value="${ i+1 }" />

					<tr class="ct_list_pop">
						<td align="center">
							<%-- <a href="/purchase/getPurchase?tranNo=${purchase.tranNo}">${ i }</a></td> --%>
							${ i } <input type="hidden" id="tranNo" name="tranNo"
							value="${purchase.tranNo}">
						<td></td>
						<td align="left">
							<%-- <a href="/user/getUser?userId=${purchase.buyer.userId}">${purchase.buyer.userId}</a> --%>
							${purchase.buyer.userId}
						</td>
						<td></td>
						<td align="left">${purchase.receiverName}</td>
						<td></td>
						<td align="left">${purchase.receiverPhone}</td>
						<td></td>
						<td align="left">${purchase.quantity}</td>
						<td></td>
						<td align="left">현재 <c:if
								test="${purchase.tranCode eq '1  ' }">구매완료</c:if> <c:if
								test="${purchase.tranCode eq '001' }">구매완료</c:if> <c:if
								test="${purchase.tranCode eq '002' }">판매중</c:if> <c:if
								test="${purchase.tranCode eq '003' }">물품도착</c:if> 상태 입니다.
						</td>

						<td></td>
						<td align="left"><c:if test="${purchase.tranCode eq '002' }">
								<%-- <a href="/purchase/updateTranCode?tranNo=${purchase.tranNo}&tranCode=003">상품도착</a> --%>
								<h7>상품도착 <input type="hidden" id="tranNo" name="tranNo"
									value="${purchase.tranNo}"> <input type="hidden"
									id="tranCode" name="tranCode" value="${purchase.tranCode}">
								</h7>
							</c:if></td>

						<td></td>
						<td align="left"><input type="hidden" name="tranNo"
							value="${purchase.tranNo}"> <i
							class="glyphicon glyphicon-star" id="${purchase.tranNo}"></i></td>

					</tr>

				</c:forEach>

			</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr>
					<td align="center"><input type="hidden" id="currentPage"
						name="currentPage" value="" /></td>
				</tr>
			</table>

		</div>
		<!--  페이지 Navigator 끝 -->
	</form>


	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp" />
	<!-- PageNavigation End... -->

</body>
</html>