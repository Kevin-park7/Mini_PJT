<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ko">
	
<head>
	<meta charset="EUC-KR">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--   jQuery , Bootstrap CDN  -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
   
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
	
	<!--  CSS �߰� : ���ٿ� ȭ�� ������ ���� �ذ� :  �ּ�ó�� ��, �� Ȯ��-->
	<style>
        body {
            padding-top : 70px;
        }
   	</style>
   	<script type="text/javascript">
/*   $(function(){
 
  var angle = 0;        // ������ ������ ������ ����
 
  $('#rotateL').click(function() { angle += -90; $("#bigImg").rotate(angle);});
 
  $('#rotateR').click(function() { angle += +90; $("#bigImg").rotate(angle);});
 
	}); */
/* 	function onImageClick( index ) {

	    $( "#bigImg" + index ).rotate( 90 ); // 90���� ȸ��
	    $( "#bigImg" + index ).rotate( 180 ); // 180���� ȸ��
	}
 */
	</script>	
 <style type="text/css">
 .img {animation: rotate_image 6s ease-in-out infinite;transform-origin: 50% 50%;}

 @keyframes rotate_image{
     100% {
         transform: rotate(360deg);
     }
 }
 </style>
   	
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	 	
	
</head>
	
<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->

	<!--  �Ʒ��� ������ http://getbootstrap.com/getting-started/  ���� -->	
   	<div class="container ">
      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Model2MVCShop </h1>
             <div class="row">
        <div class="col-md-6">
        <br><br><br><br>
		 <img src="../images/ee.jpg" class="img">
		 <!-- <img src="https://blog.kakaocdn.net/dn/b5IRmm/btq233fc2DG/fg0WVnV6nVTGJjtKB5ejjk/img.png" class="img"> -->
		 </div>		 
        <div class="col-md-6">
            
		<div>
 	 
     	 <!-- <img id=bigImg onclick="onImageClick( 0 )"  src="../images/ee.jpg" width="500" height="500" class="img-thumbnail" alt="A generic square placeholder image with a white border around it, making it resemble a photograph taken with an old instant camera"> -->
     	</div>
     	</div>
     	</div>
     </div>

    </div>
	<!-- ���� : http://getbootstrap.com/css/   : container part..... -->
	

</body>

</html>