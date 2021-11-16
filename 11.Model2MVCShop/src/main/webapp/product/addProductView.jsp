<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>

<html>
<head>
	<meta charset="EUC-KR">
	
<link rel="stylesheet" href="/css/admin.css" type="text/css">

<!-- ���� : http://getbootstrap.com/css/   ���� -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Bootstrap Dropdown Hover CSS -->
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">

<!-- Bootstrap Dropdown Hover JS -->
<script src="/javascript/bootstrap-dropdownhover.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
 		body {
            padding-top : 50px;
        }
     </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">
		
function fncAddProduct(){
	//Form ��ȿ�� ����
	//var name = document.detailForm.prodName.value;
	var name = $("input[name='prodName']").val();
	//var detail = document.detailForm.prodDetail.value;
	var detail = $("input[name='prodDetail']").val();
	//var manuDate = document.detailForm.manuDate.value;
	var manuDate = $("input[name='manuDate']").val();
	//var price = document.detailForm.price.value;
	var price = $("input[name='price']").val();
	
	if(name == null || name.length<1){
		alert("��ǰ���� �ݵ�� �Է�	�Ͽ��� �մϴ�.");
		return;
	}
	if(detail == null || detail.length<1){
		alert("��ǰ�������� �ݵ�� �Է��Ͽ��� �մϴ�.");
		return;
	}
	if(manuDate == null || manuDate.length<1){
		alert("�������ڴ� �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
	if(price == null || price.length<1){
		alert("������ �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}


$("form").attr("method","POST").attr("action","/product/addProduct").attr("enctype","multipart/form-data").submit();

}

$(function(){
	$("button:contains('���')").on("click",function(){
		alert("td.btn btn-primary:contains('���')");
		fncAddProduct();
	});
	
});
$(function() {
	 $( "a:contains('���')" ).on("click" , function() {
			alert(  $( "td.btn btn-primary:contains('���')" ).html() );
		
			$("form")[0].reset();
	});
});
$(function() { 
	  $( "#datepicker" ).datepicker({ 
		  showButtonPanel: true,
		  closeText: "�ݱ�", 
		  currentText: "����", 
		  prevText: '���� ��', 
		  nextText: '���� ��', 
		  yearSuffix: '��', 
		  monthNames: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��'], 
		  monthNamesShort: ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��'], 
		  dayNames: ['��', '��', 'ȭ', '��', '��', '��', '��'], 
		  dayNamesShort: ['��', '��', 'ȭ', '��', '��', '��', '��'], 
		  dayNamesMin: ['��', '��', 'ȭ', '��', '��', '��', '��'], 
		  weekHeader: "��", 
		  dateFormat: 'y/dd/mm'
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
			<h3 class=" text-info">�� ǰ �� ��</h3>
			<h5 class="text-muted">
				��ǰ�� ������� <strong class="text-danger">���</strong>������ǰ?
			</h5>
		</div>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="prodName" class="col-sm-offset-1 col-sm-3 control-label">��ǰ��</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodName"
						name="prodName" placeholder="��ǰ���� �Է��ϼ���" > 
				</div>
			</div>

			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">��ǰ������</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodDetail"
						name="prodDetail" placeholder="��ǰ������">
				</div>
			</div>

			<div class="form-group">
				<label for="manuDate" class="col-sm-offset-1 col-sm-3 control-label">��������</label>
				<div class="col-sm-4">
				<input type="text"
					readonly="readonly" id="datepicker" name="manuDate"
					class="ct_input_g" style="width: 295px; height: 35px"
					maxLength="20" placeholder="��������" />
				<!-- <input type="text" class="form-control" id="manuDate"
						name="manuDate" placeholder="��������"> 
						--><div id="datepicker"></div> 
				</div>
			</div>
			
			<div class="form-group">
				<label for="price" class="col-sm-offset-1 col-sm-3 control-label">����</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="price"
						name="price" placeholder="�ݾ��Է�"> 
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-sm-offset-1 col-sm-3 control-label">��ǰ����</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="amount"
						name="amount" placeholder="�����Է�"> 
				</div>
			</div>
			<div class="form-group">
				<label for="fileName" class="col-sm-offset-1 col-sm-3 control-label"  >��ǰ�̹���</label>
				<div class="col-sm-4">
						<input type="file"  id="fileName1" name="fileName1" />
				</div>
			</div>
			
	 	 <div class="form-group">
		    <div class="col-md-12 text-center ">
		      <button type="button" class="btn btn-primary"  >���</button>
			  <a class="btn btn-primary" href="#" role="button">���</a>
		    </div>
		  </div>

  		


		</form>
	</div>




</body>
</html>