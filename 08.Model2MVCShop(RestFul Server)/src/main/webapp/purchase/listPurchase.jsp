<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ page import="com.model2.mvc.common.*" %>

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
	System.out.println("page Ȯ�� >>>>>>>"+(curPage-1)/5);
	//int i = Integer.parseInt( request.getParameter("page"));
	//System.out.println("page Ȯ�� >>>>>>>"+(( Integer.parseInt( request.getParameter("page"))-1)%5));
	// Page's Menu--> manage, search / page --> # / 
	//if(menu.equals("manage")){
		//pageContext.forward("updateTranCodeByProd.jsp");
--%>



<html>
<head>
<title>���� �����ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
//�˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�  
function fncGetUserList(currentPage) {
	document.getElementById("currentPage").value = currentPage;
   	document.detailForm.submit();
   	console.log('�� Function�� ����Ʈ ������ ȣ��˴ϴ�.',currentPage);

   
}
</script>
</head>

<body bgcolor="#ffffff" text="#000000">
<div style="width: 98%; margin-left: 10px;">

<form name="detailForm" action="/purchase/listPurchase" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">���� �����ȸ</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td colspan="11">��ü ${resultPage.totalCount} �Ǽ�, ���� ${resultPage.currentPage} ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ��ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��ȭ��ȣ</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����Ȳ</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��������</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<c:set var="i" value="0" />
	<c:forEach var="purchase" items="${mappurchase.list}">
	<c:set var="i" value="${ i+1 }"/>		

	<tr class="ct_list_pop">
		<td align="center">
		<a href="/purchase/getPurchase?tranNo=${purchase.tranNo}">${ i }</a></td>
		
			
	
		<td></td>
		<td align="left">
			<a href="/user/getUser?userId=${purchase.buyer.userId}">${purchase.buyer.userId}</a>
		</td>
		<td></td>
		<td align="left">${purchase.receiverName}</td>
		<td></td>
		<td align="left">${purchase.receiverPhone}</td>
		<td></td>
		<td align="left">����
			<c:if test="${purchase.tranCode eq '1  ' }">���ſϷ�</c:if>
			<c:if test="${purchase.tranCode eq '001' }">���ſϷ�</c:if>
			<c:if test="${purchase.tranCode eq '002' }">�Ǹ���</c:if>
			<c:if test="${purchase.tranCode eq '003' }">��ǰ����</c:if>
				���� �Դϴ�.</td>
				
		<td>
		 
		 </td>
		<td align="left">
			<c:if test="${purchase.tranCode eq '002' }">
			<a href="/purchase/updateTranCode?tranNo=${purchase.tranNo}&tranCode=003">��ǰ����
			</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
</c:forEach>

</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td align="center">
		  <input type="hidden" id="currentPage" name="currentPage" value=""/>

	   		<jsp:include page="../common/pageNavigator.jsp"/>	
					
		</td>
	</tr>
</table>

<!--  ������ Navigator �� -->
</form>

</div>

</body>
</html>