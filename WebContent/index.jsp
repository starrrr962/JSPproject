<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="style.css" rel="stylesheet" media="all">
<html>
<head>
<%
	String name = null;

	if (session.getAttribute("name") != null)
		name = String.valueOf(session.getAttribute("name"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="login"> <%
 	if (name == null) {
 %> <a href="joinform.jsp">회원가입</a> &nbsp; <a href="login.jsp">로그인</a> <%
 	} else {
 %> <%=name%>님 환영합니다.&nbsp; <%
 	if (name == "admin" || name.equals("admin")) {
 %> <a href="admin.jsp">관리자페이지</a>&nbsp; <%
 	}
 %><a href="view.mall">정보수정</a>&nbsp;<a href="logout.mall">로그아웃</a> <%
 	}
 %> </section>
	<form id="listForm">
		<c:if test="${productList != null}">
			<table border="0px">
				<th colspan="4">상품목록</th>
				<tr>
					<c:forEach var="product" items="${productList }" varStatus="status">
						<td><a href="productView.mall?id=${product.p_id}"> <img
								src="ProductUpload/${product.p_image}" id="productImage" />
						</a><br>상품명:${product.p_name }<br>가격:${product.p_price }<br>
						재고:${product.p_count}<br>
						</td>
						<c:if test="${((status.index+1) mod 4)==0 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		<c:if test="${productList == null}">
		<script>
		location.href="./productList.mall";
		</script>
			<h1>상품이 없습니다.</h1>
		</c:if>
	</form>
	<form id="todaylist">
		<c:if test="${todayImageList != null}">
			<div id="todayImageList">
				<table>
					<th colspan="2">오늘 본 상품</th>
					<tr>
						<c:forEach var="todayImage" items="${todayImageList }"
							varStatus="status">
							<td><img src="ProductUpload/${todayImage }" id="todayImage" /></td>
							<c:if test="${((status.index+1) mod 4) == 0 }">
					</tr>
					<tr>
						</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</c:if>
	</form>
</body>
</html>