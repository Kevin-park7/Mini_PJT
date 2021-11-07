<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<html>
<head>
	<meta charset="EUC-KR">
	
	<!-- 참조 : http://getbootstrap.com/css/   참조 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
   
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
 		body {
            padding-top : 50px;
        }
     </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">
		
function fncAddProduct(){
	//Form 유효성 검증
	//var name = document.detailForm.prodName.value;
	var name = $("input[name='prodName']").val();
	//var detail = document.detailForm.prodDetail.value;
	var detail = $("input[name='prodDetail']").val();
	//var manuDate = document.detailForm.manuDate.value;
	var manuDate = $("input[name='manuDate']").val();
	//var price = document.detailForm.price.value;
	var price = $("input[name='price']").val();
	
	if(name == null || name.length<1){
		alert("상품명은 반드시 입력	하여야 합니다.");
		return;
	}
	if(detail == null || detail.length<1){
		alert("상품상세정보는 반드시 입력하여야 합니다.");
		return;
	}
	if(manuDate == null || manuDate.length<1){
		alert("제조일자는 반드시 입력하셔야 합니다.");
		return;
	}
	if(price == null || price.length<1){
		alert("가격은 반드시 입력하셔야 합니다.");
		return;
	}


$("form").attr("method","POST").attr("action","/product/addProduct").submit();

}

$(function(){
	$("button:contains('등록')").on("click",function(){
		alert("td.btn btn-primary:contains('등록')");
		fncAddProduct();
	});
	
});
$(function() {
	 $( "a:contains('취소')" ).on("click" , function() {
			alert(  $( "td.btn btn-primary:contains('취소')" ).html() );
		
			$("form")[0].reset();
	});
});
</script>
</head>

<body bgcolor="#ffffff" text="#000000">
<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
	<!-- ToolBar End /////////////////////////////////////-->
	<div class="container">

		<div class="page-header">
			<h3 class=" text-info">상 품 등 록</h3>
			<h5 class="text-muted">
				상품을 등록하자 <strong class="text-danger">어떤걸</strong>좋은상품?
			</h5>
		</div>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="prodName" class="col-sm-offset-1 col-sm-3 control-label">상품명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodName"
						name="prodName" placeholder="상품명을 입력하세요" > 
				</div>
			</div>

			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">상품상세정보</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodDetail"
						name="prodDetail" placeholder="상품상세정보">
				</div>
			</div>

			<div class="form-group">
				<label for="manuDate" class="col-sm-offset-1 col-sm-3 control-label">제조일자</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="manuDate"
						name="manuDate" placeholder="제조일자"> 
						<div id="datepicker"></div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="price" class="col-sm-offset-1 col-sm-3 control-label">가격</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="price"
						name="price" placeholder="금액입력"> 
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-sm-offset-1 col-sm-3 control-label">상품수량</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="amount"
						name="amount" placeholder="수량입력"> 
				</div>
			</div>
			
			<div class="form-group">
				<label for="fileName" class="col-sm-offset-1 col-sm-3 control-label">상품이미지</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="fileName"
						name="fileName" placeholder="입력하세요"> 
				</div>
			</div>
			
	 	 <div class="form-group">
		    <div class="col-md-12 text-center ">
		      <button type="button" class="btn btn-primary"  >등록</button>
			  <a class="btn btn-primary" href="#" role="button">취소</a>
		    </div>
		  </div>

  		


		</form>
	</div>




</body>
</html>