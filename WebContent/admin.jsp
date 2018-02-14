<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="style.css" rel="stylesheet" media="all">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% String name = (String)session.getAttribute("name");%>
</head>
<body>
	<form>
		<table>
			<th>관리자페이지</th>
			<tr>
				<td><a href="customerList.mall?name=<%=name %>">회원목록</a></td>
			</tr>
			<tr>
				<td><a href="productInsert.jsp">상품등록</a></td>
			</tr>
		</table>
	</form>
</body>
</html>