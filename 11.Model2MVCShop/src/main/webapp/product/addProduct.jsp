<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.model2.mvc.service.domain.*"%>
<%@ page import="java.util.HashMap"%>

<%--
	//ProductVO vo=(ProductVO)request.getAttribute("productVO");
 	//System.out.println(vo);
 	
 		//ProductVO vo=(ProductVO)request.getAttribute("productVO");
	HttpSession sess = request.getSession();
	HashMap<String,Object> vo = (HashMap) sess.getAttribute("product");
	//vo.put("prodName", request.getAttribute("prodName"));
	//HashMap<String,Object> map = (ProductVO)request.getAttribute("productVO");
 	System.out.println("addPord  "+vo);

--%>




<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품등록</title>

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
    $(function() {
		$("button.btn-primary:contains('확인')").click(function() {
			self.location = "/product/listProduct?menu=manage"
		});
	});
	$(function(){
		$("a.btn-primary:contains('추가등록')").click(function(){
			self.location = "/product/addProductView.jsp"
		});
	});
</script>
</head>

<body>
	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
	<!-- ToolBar End /////////////////////////////////////-->
	<div class="container">
		<div class="page-header text-info">
			<h3>상품 등록 결과</h3>
		</div>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="prodName" class="col-sm-offset-1 col-sm-3 control-label">상품명</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.prodName}</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">상품상세정보</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.prodDetail}</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">제조일자</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.manuDate}</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">가격</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.price}</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">상품수량</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.amount}</div>
				</div>
			</div>
			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">상품이미지</label>
				<div class="col-sm-4">
					<div class="well well-sm">${product.fileName}</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-12 text-center ">
					<button type="button" class="btn btn-primary">확인</button>
					<a class="btn btn-primary" href="#" role="button">추가등록</a>
				</div>
			</div>

		</form>
	</div>


</body>
</html>
