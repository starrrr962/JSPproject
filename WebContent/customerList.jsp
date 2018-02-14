<%@page import="java.util.ArrayList"%>
<%@page import="vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="style.css" rel="stylesheet" media="all">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<table>
<tr>
	<td colspan="2"><h2>회원목록</h2></td>
</tr>
<c:forEach var="customer" items="${customerList }">
<tr>
	<td><a href="view.mall?email=${customer.c_email }">${customer.c_email }</a></td>
	<td><a href="delete.mall?email=${customer.c_email }">삭제</a></td>
</tr>	
</c:forEach>
</table>
</form>>
</body>
</html>