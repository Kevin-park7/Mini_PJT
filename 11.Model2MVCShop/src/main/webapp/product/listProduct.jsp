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

<meta charset="EUC-KR">
	
	<!-- 참조 : http://getbootstrap.com/css/   참조 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
   
   
   <!-- jQuery UI toolTip 사용 CSS-->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI toolTip 사용 JS-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
	  body {
            padding-top : 50px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
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
	//self.location ="/product/listProduct?menu="+menu.text().trim();
	
   
}
$(function(){
	$("button:contains('검색')").click(function(){
		fncGetUserList(1);
	});
	var menu = $("input[name='menu']").val()
	var prodNo = $("#prodNo").val();
	console.log(prodNo)
	if(menu=="manage"){
		
	$(".ct_list_pop td:nth-child(3)").click(function(){
		//alert($(".ct_list_pop td:nth-child(3)").text());
		//$("form").attr("method","GET").attr("/product/updateProduct?prodNo=10000").submit();
		//self.location = "/product/updateProduct?prodNo="+$(this).find("input[name=prodNo]").val();
		window.open("/product/updateProduct?prodNo="+$(this).find("input[name=prodNo]").val(),
				"popWin", 
				"left=2=300,top=200,width=300,height=300,marginwidth=0,marginheight=0,"+
				"scrollbars=no,scrolling=no,menubar=no,resizable=no");

	});
	}
	if(menu=="search"){
		$(".ct_list_pop td:nth-child(3)").click(function(){	
		//self.location = "/product/getProduct?prodNo="+$(this).find("input[name=prodNo]").val();
		window.open("/product/getProduct?prodNo="+$(this).find("input[name=prodNo]").val(),
				"popWin", 
				"left=2=300,top=200,width=300,height=300,marginwidth=0,marginheight=0,"+
				"scrollbars=no,scrolling=no,menubar=no,resizable=no");

		
		
		});
	}
	

	$( ".ct_list_pop td:nth-child(13)" ).on("click" , function() {
		//Debug..
		//alert(  $( this ).text().trim() );
		
		//////////////////////////// 추가 , 변경된 부분 ///////////////////////////////////
		//self.location ="/user/getUser?userId="+$(this).text().trim();
		////////////////////////////////////////////////////////////////////////////////////////////
		var prodN = $(this).find("input[name=prodNo]").val();
		$.ajax( 
				{
					url : "/product/json/getProduct/"+prodN ,
					method : "GET" ,
					dataType : "json" ,
					headers : {
						"Accept" : "application/json",
						"Content-Type" : "application/json"
					},
					success : function(JSONData , status) {

						//Debug...
						//alert(status);
						//Debug...
						//alert("JSONData : \n"+JSONData);
						
						var displayValue = "<h5>"
													+"상품번호   	 : "+JSONData.prodNo+"<br/>"
													+"상품명    	 : "+JSONData.prodName+"<br/>"
													+"상품이미지	 : <br/>"
													+"<img src='/images/uploadFiles/"+JSONData.fileName+"' /> "
													+"상품상세정보 	 : "+JSONData.prodDetail+"<br/>"
													+"제조일자 	 : "+JSONData.manuDate+"<br/>"
													+"가격  		 : "+JSONData.price+"<br/>"
													+"상품수량   	 : "+JSONData.amount+"<br/>"
													+"등록일자 	 : "+JSONData.regDate+"<br/>"
													+"<a href=\"/purchase/addPurchase?prodNo="+prodNo+"\">[구매]</a>"
													+"</h5>";
						//Debug...									
						//alert(displayValue);
						$("h5").remove();
						$( "#"+prodN+"" ).html(displayValue);
					}
			});
			////////////////////////////////////////////////////////////////////////////////////////////
		
	});
	$(".ct_list_pop td:nth-child(11):contains('배송하기')").click(function(){
		console.log($(this).parent().next().html());
		
		var prodNo = $(this).find("input[name=prod]").val();
		
		$.ajax( 
				{
					url : "/purchase/json/getProdNo/"+prodNo ,
					method : "GET" ,
					dataType : "json" ,
					headers : {
						"Accept" : "application/json",
						"Content-Type" : "application/json"
					},
					success : function(JSONData , status) {

						//Debug...
						//alert(status);
						//Debug...
						//alert("JSONData : \n"+JSONData);
						//console.log(JSONData.list);
						//console.log((JSONData.list)[0]);
					// 	for(var i=0 in JSONData.list){
						var displayValue = "<h5>";
						for( var i=0; i<JSONData.list.length; i++){
									displayValue += "<td>상품번호   	 : "+JSONData.list[i].purchaseProd.prodNo+"</td>"
													+"<td>상품등록번호 	 : "+JSONData.list[i].tranNo+"<br/>"
													+"<td>배송하기</td>"	
													+"<td><input type='hidden' id='tranNo' name='tranNo' value="+JSONData.list[i].tranNo+"></td>"
													+"<a href=\"/purchase/updateTranCodeByProd?tranNo="+JSONData.list[i].tranNo+"&tranCode=002\">[배송하기]</a>"
		/* 				$.each(JSONData, function(i,item){
							let tr = $("<tr></tr>");
							console.log(item)
							$.each(item, function(key,value){
								$("<td></td>").html(value).appendTo(tr);
							});
							$("h7").append(tr);
						}); */
						
						}
						displayValue +="</h5>"; 
		/* 	  		$("contains('배송하기')").click(function(){
							self.location = "/purchase/updateTranCodeByProd?prodNo="+JSONData.list[i].tranNo+"&tranCode=002";
						});  */
						//Debug...									
						//alert(displayValue);
				 		$("h5").remove();
				 		console.log(displayValue);
				 	    //$(this).parent().next().chiled().html(displayValue); 
				 		//$("#"+prodNo+"").html(displayValue); 
						//$(this).closest('body').find("#txt").html(displayValue);
						$("#txt").html(displayValue);
					}	
				});
		////////////////////////////////////////////////////////////////////////////////////////////
	
});
	
	
 	$(".ct_list_pop td:nth-child(4):contains('배송하기')").click(function(){
		
		self.location = "/purchase/updateTranCodeByProd?prodNo="+$(this).find("input[name=tranNo]").val()+"&tranCode=002";
	});
 	
	 
	
	
	
	$( ".ct_list_pop td:nth-child(3)" ).css("color" , "red");
	$("h7").css("color" , "red");
	
	$(".ct_list_pop:nth-child(4n+3)" ).css("background-color" , "whitesmoke");
	
});
	


		</script>
</head>

<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	<input type="hidden" id="menu" name="menu" value="${param.menu}" />						
						
	<!--  화면구성 div Start /////////////////////////////////////-->
	<div class="container">
		<div class="page-header text-info">
	       		<c:if test="${param.menu eq 'manage'}">
						<h3>상품관리</h3>
				</c:if>
				<c:if test="${param.menu eq 'search' }">
						<h3>상품목록</h3>
				</c:if>
	    </div>
	<div class="row">
	    
		    <div class="col-md-6 text-left">
		    	<p class="text-primary">
		    		전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage}  페이지
		    	</p>
		    </div>
	
	 <div class="col-md-6 text-right">
			    <form class="form-inline" name="detailForm">
			    
				  <div class="form-group">
	<select class="form-control" name="searchCondition" >
	<option value="0"
							${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품번호</option>
						<option value="1"
							${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>상품명</option>
						<option value="2"
							${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>상품가격</option>
	</select>
				</div>
	 
				  <div class="form-group">
				    <label class="sr-only" for="searchKeyword">검색어</label>
				    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"  placeholder="검색어"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
				  </div>
				  				  <button type="button" class="btn btn-default">검색</button>
	<input type="hidden" id="currentPage" name="currentPage" value=""/>
	</form>
	</div>
	</div>
	 <table class="table table-hover table-striped" >

	<thead>
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
					<td class="ct_list_b">상품수량</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">등록일</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">현재상태</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">정보보기</td>
				</tr>
				</thead>
				<tbody>



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
						<td align="left">총${prod.total}/남은수량${prod.amount}</td>
						<td></td>
						<td align="left">${prod.regDate}</td>
						<td></td>
						<td align="left">
						<c:if test= "${param.menu eq 'manage'}">
							<c:if test= "${prod.proTranCode eq '001'}">
									구매완료 감사합니다<%-- <a href="/purchase/updateTranCodeByProd?prodNo=${prod.prodNo}&tranCode=002"> 배송하기</a> --%>
									<br>
									<h7>배송하기<input type="hidden" id="prod" name="prod" value="${prod.prodNo}"></h7> 
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
							<c:if test= "${prod.amount != 0}">
								제고있음
							</c:if> 
							<c:if test= "${prod.amount == 0}">
								제고없음
							</c:if>
				
							
							</c:if>
						</td>
						<td></td>
						<td align="left" >	
						<i class="glyphicon glyphicon-ok" id= "${prod.prodNo}"></i>
						<input type="hidden" name="prodNo" value="${prod.prodNo}">
						</td>
					</tr>
					<tr id="txt"><%-- <td><input type="hidden" name="pro" value="${prod.prodNo}"></td> --%></tr>
				</c:forEach>
				</tbody>

			</table>
</div>

		 	
 	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp"/>
	<!-- PageNavigation End... -->
	
			<!--  페이지 Navigator 끝 -->

	
</body>
</html>