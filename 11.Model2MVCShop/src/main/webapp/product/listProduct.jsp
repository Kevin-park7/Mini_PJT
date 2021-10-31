<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
<%@ page import="java.util.*"  %>
<%@page import="com.model2.mvc.common.util.CommonUtil"%>
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ page import="com.model2.mvc.common.Search" %>
<%@ page import="com.model2.mvc.common.*" %>


	request.setCharacterEncoding("UTF-8"); //�޾ƿ� �������� ���ڵ�
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	Search search=(Search)request.getAttribute("search");
	
	List<User> list= (List<User>)request.getAttribute("list");
	Page resultPage=(Page)request.getAttribute("resultPage");
	
	Search search = (Search)request.getAttribute("search");
	//==> null �� ""(nullString)���� ����
	String searchCondition = CommonUtil.null2str(search.getSearchCondition());
	String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
	
	String curPageStr = (String) request.getParameter("page");
	int curPage = 1;
	if (curPageStr != null)
		curPage = Integer.parseInt(curPageStr);
	
	String menu = (String) request.getParameter("menu");
	System.out.println(">>>>>>> "+ menu+"    "+ curPage);
	System.out.println("page Ȯ�� >>>>>>>"+(curPage-1)/5);
	//int i = Integer.parseInt( request.getParameter("page"));
	//System.out.println("page Ȯ�� >>>>>>>"+(( Integer.parseInt( request.getParameter("page"))-1)%5));
	// Page's Menu--> manage, search / page --> # / 
	if(menu.equals("manage")){
		pageContext.forward("updateTranCodeByProd.jsp");
		--%>

<%--
		List<Product> list= (List<Product>)request.getAttribute("list");
		Page resultPage=(Page)request.getAttribute("resultPage");
		
		Search search = (Search)request.getAttribute("search");
		//==> null �� ""(nullString)���� ����
		String searchCondition = CommonUtil.null2str(search.getSearchCondition());
		String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
		
		String curPageStr = (String) request.getParameter("page");
		int curPage = 1;
		if (curPageStr != null)
			curPage = Integer.parseInt(curPageStr);
		
		System.out.println(resultPage +"    "+ resultPage.getTotalCount());
		
		String menu = (String) request.getParameter("menu");
		System.out.println(">>>>>>> "+ menu+"    "+ curPage);
		System.out.println("page Ȯ�� >>>>>>>"+(curPage-1)/5);
		//int i = Integer.parseInt( request.getParameter("page"));
		//System.out.println("page Ȯ�� >>>>>>>"+(( Integer.parseInt( request.getParameter("page"))-1)%5));
		// Page's Menu--> manage, search / page --> # / 
		if(menu.equals("manage")){			
		--%>

<html>
<head>
<title>��ǰ �����ȸ</title>

<meta charset="EUC-KR">
	
	<!-- ���� : http://getbootstrap.com/css/   ���� -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
   
   
   <!-- jQuery UI toolTip ��� CSS-->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI toolTip ��� JS-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
	  body {
            padding-top : 50px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
	<script type="text/javascript">

// �˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�  
function fncGetUserList(currentPage) {
	//document.getElementById("currentPage").value = currentPage;
   	//document.detailForm.submit();
   	//console.log('�� Function�� ����Ʈ ������ ȣ��˴ϴ�.',currentPage);
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
	$("button:contains('�˻�')").click(function(){
		alert("�˻�");
		fncGetUserList(1);
	});
	var menu = $("input[name='menu']").val()
	var prodNo = $("#prodNo").val();
	console.log(prodNo)
	if(menu=="manage"){
		
	$(".ct_list_pop td:nth-child(3)").click(function(){
		alert($(".ct_list_pop td:nth-child(3)").text());
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
		alert("���ư���")
		//self.location = "/product/getProduct?prodNo="+$(this).find("input[name=prodNo]").val();
		window.open("/product/getProduct?prodNo="+$(this).find("input[name=prodNo]").val(),
				"popWin", 
				"left=2=300,top=200,width=300,height=300,marginwidth=0,marginheight=0,"+
				"scrollbars=no,scrolling=no,menubar=no,resizable=no");

		
		
		});
	}
	

	$( ".ct_list_pop td:nth-child(11)" ).on("click" , function() {
		//Debug..
		//alert(  $( this ).text().trim() );
		
		//////////////////////////// �߰� , ����� �κ� ///////////////////////////////////
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
													+"��ǰ��ȣ   	 : "+JSONData.prodNo+"<br/>"
													+"��ǰ��    	 : "+JSONData.prodName+"<br/>"
													+"��ǰ�̹���	 : "+JSONData.fileName+"<br/>"
													+"��ǰ������ 	 : "+JSONData.prodDetail+"<br/>"
													+"�������� 	 : "+JSONData.manuDate+"<br/>"
													+"����  		 : "+JSONData.price+"<br/>"
													+"������� 	 : "+JSONData.regDate+"<br/>"
													+"</h5>";
						//Debug...									
						//alert(displayValue);
						$("h5").remove();
						$( "#"+prodN+"" ).html(displayValue);
					}
			});
			////////////////////////////////////////////////////////////////////////////////////////////
		
	});
	
	
	
	
	$( ".ct_list_pop td:nth-child(3)" ).css("color" , "red");
	$("h7").css("color" , "red");
	
	$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");
	
});
	


		</script>
</head>

<body>

	<!-- ToolBar Start /////////////////////////////////////-->
	<jsp:include page="/layout/toolbar.jsp" />
   	<!-- ToolBar End /////////////////////////////////////-->
	<input type="hidden" id="menu" name="menu" value="${param.menu}" />						
						
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">
		<div class="page-header text-info">
	       		<c:if test="${param.menu eq 'manage'}">
						<h3>��ǰ����</h3>
				</c:if>
				<c:if test="${param.menu eq 'search' }">
						<h3>��ǰ���</h3>
				</c:if>
	    </div>
	<div class="row">
	    
		    <div class="col-md-6 text-left">
		    	<p class="text-primary">
		    		��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
		    	</p>
		    </div>
	
	 <div class="col-md-6 text-right">
			    <form class="form-inline" name="detailForm">
			    
				  <div class="form-group">
	<select class="form-control" name="searchCondition" >
	<option value="0"
							${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>��ǰ��ȣ</option>
						<option value="1"
							${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>��ǰ��</option>
						<option value="2"
							${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>��ǰ����</option>
	</select>
				</div>
	 
				  <div class="form-group">
				    <label class="sr-only" for="searchKeyword">�˻���</label>
				    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"  placeholder="�˻���"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
				  </div>
				  				  <button type="button" class="btn btn-default">�˻�</button>
	<input type="hidden" id="currentPage" name="currentPage" value=""/>
	</form>
	</div>
	</div>
	 <table class="table table-hover table-striped" >

	<thead>
				<tr>
					<td class="ct_list_b" width="100">No</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b" width="150">��ǰ��<br>
					<c:if test="${param.menu eq 'manage'}">
					<h7>(��ǰ click:����)</h7></td>
					</c:if>
					
					<c:if test="${param.menu eq 'search'}">
					<h7>(��ǰ click:������)</h7></td>
					</c:if>
					
					<td class="ct_line02"></td>
					<td class="ct_list_b" width="150">����</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">�����</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">�������</td>
					<td class="ct_line02"></td>
					<td class="ct_list_b">��������</td>
				</tr>
				</thead>
				<tbody>



				<c:set var="i" value="0" />
				<%--i�� 0���� �ְ� prod���� list��������� ����
				���µ� i�� ���� 1�� �߰� �Ѵ�.  --%>
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
						<td align="left">��� ���� <a
							href="/product/updateTranCodeByProd?prodNo=10002&tranCode=2">���
								����</a></td>
						<td></td>
						<td align="left" >	
						<i class="glyphicon glyphicon-ok" id= "${prod.prodNo}"></i>
						<input type="hidden" name="prodNo" value="${prod.prodNo}">
						</td>
					</tr>
				</c:forEach>
				</tbody>

			</table>
</div>

		 	
 	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp"/>
	<!-- PageNavigation End... -->
	
			<!--  ������ Navigator �� -->

	
</body>
</html>