<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>


<!--  ///////////////////////// JSTL  ////////////////////////// -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ///////////////////////////// �α��ν� Forward  /////////////////////////////////////// -->
 <c:if test="${ ! empty user }">
 	<jsp:forward page="main.jsp"/>
 </c:if>
 <!-- //////////////////////////////////////////////////////////////////////////////////////////////////// -->


<!DOCTYPE html>

<html lang="ko">
	
<head>
	<meta charset="EUC-KR">
	
	<!-- ���� : http://getbootstrap.com/css/   -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style></style>
   	
   	<!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">
		
		//============= ȸ�������� ȭ���̵� =============
		$( function() {
			//==> �߰��Ⱥκ� : "addUser"  Event ����
			$("a[href='#' ]:contains('ȸ������')").on("click" , function() {
				self.location = "/user/addUser"
			});
		});
		
		//============= �α��� ȭ���̵� =============
		$( function() {
			//==> �߰��Ⱥκ� : "addUser"  Event ����
			$("a[href='#' ]:contains('�� �� ��')").on("click" , function() {
				self.location = "/user/login"
			});
		});
		
		
		
		
	</script>	
	
</head>

<body role= "document">

	<!-- ToolBar Start /////////////////////////////////////-->
	<div class="navbar  navbar-default">
		
        <div class="container">
        
        	<a class="navbar-brand" href="#">Model2 MVC Shop</a>
			
			<!-- toolBar Button Start //////////////////////// -->
			<div class="navbar-header">
			    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#target">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			    </button>
			</div>
			<!-- toolBar Button End //////////////////////// -->
			
			<div class="collapse navbar-collapse"  id="target">
	             <ul class="nav navbar-nav navbar-right">
	                 <li><a href="#">ȸ������</a></li>
	                 <li><a href="#">�� �� ��</a></li>
	           	</ul>
	       </div>
   		
   		</div>
   	</div>
   	<!-- ToolBar End /////////////////////////////////////-->
   	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">
		
		<!-- �ٴܷ��̾ƿ�  Start /////////////////////////////////////-->
		<div class="row">

			<!--  Menu ���� Start /////////////////////////////////////-->
			<div class="col-md-3">

				<!--  ȸ������ ��Ͽ� ���� -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-heart"></i> ȸ������
					</div>
					<!--  ȸ������ ������ -->
					<ul class="list-group">
						<li class="list-group-item"><a href="#">����������ȸ</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
						<li class="list-group-item"><a href="#">ȸ��������ȸ</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
					</ul>
				</div>


				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-briefcase"></i> �ǸŻ�ǰ����
					</div>
					<ul class="list-group">
						<li class="list-group-item"><a href="#">�ǸŻ�ǰ���</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
						<li class="list-group-item"><a href="#">�ǸŻ�ǰ����</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
					</ul>
				</div>


				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-shopping-cart"></i> ��ǰ����
					</div>
					<ul class="list-group">
						<li class="list-group-item"><a href="#">��ǰ�˻�</a></li>
						<li class="list-group-item"><a href="#">�����̷���ȸ</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
						<li class="list-group-item"><a href="#">�ֱٺ���ǰ</a> <i
							class="glyphicon glyphicon-ban-circle"></i></li>
					</ul>
				</div>

			</div>
			<!--  Menu ���� end /////////////////////////////////////-->

			<!--  Main start /////////////////////////////////////-->
			<div class="col-md-9">
				<div class="jumbotron">
					<h1>Model2 MVC Shop</h1>
					<iframe
						src="https://www.youtube.com/embed/a6hQ-kK0_Jw?autoplay=1&mute=1"
						name="iframe2" title="�������� Ŭ����" width="400px" height="300px"></iframe>


					<div class="text-center">
						<a class="btn btn-info btn-lg" href="#" role="button">ȸ������</a> <a
							class="btn btn-info btn-lg" href="#" role="button">�� �� ��</a>
					</div>

				</div>
			</div>
		
	</div>
		
	<!--  ȭ�鱸�� div end /////////////////////////////////////-->
			<!--  Main end /////////////////////////////////////-->
		

			
		
      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          <li data-target="#carousel-example-generic" data-slide-to="3"></li>
          
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="../images/cc.jpg" width="1140" height="500"
								alt="First slide">
						</div>
						<div class="item">
							<img src="../images/zz.jpg" width="1140" height="500"
								alt="Second slide">
						</div>
						<div class="item">
							<img src="../images/aa.gif" width="1140" height="500"
								alt="Third slide">
						</div>
						<div class="item">
            <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTRfMjI3%2FMDAxNjE1NzEyMDY0Mzcz.2rABxhMd5umv91S8TrxkXI2DILnV9seWxGlpFWuFPQgg.xRY_GZYggQSfjPjKMW-oc2YcihZFXDe-12HsIoCTleog.JPEG.116504%2FIMG_4837.JPG&type=sc960_832"
            width="1140"   height="500" alt="Third slide">
          </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
	
</div>

		<!-- �ٴܷ��̾ƿ�  end /////////////////////////////////////-->

</body>

</html>