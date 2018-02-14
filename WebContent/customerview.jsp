<%@page import="vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="style.css" rel="stylesheet" media="all">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
Customer customer = (Customer)session.getAttribute("customer");
%>
</head>
<body>
<form action="customermodify.mall">
	<table>
		<th colspan="2">회원상세정보</th>
		<tr>
			<td><label for="c_email">이메일</label></td>
			<td><input type="text" id="c_email" name="c_email" value=<%=customer.getC_email() %> readonly></td>
		</tr>
		<tr>
			<td><label for="c_name">이름</label></td>
			<td><input type="text" id="c_name" name="c_name" value=<%=customer.getC_name() %> readonly></td>
		</tr>
		<tr>
			<td><label for="c_pw">비밀번호</label></td>
			<td><input type="password" id="c_pw" name="c_pw" value=<%=customer.getC_pw() %>></td>
		</tr>
		
		<tr>
			<td><label for="c_phone">전화번호</label></td>
			<td><input type="text" id="c_phone" name="c_phone" value=<%=customer.getC_phone() %>></td>
			
		</tr>
		<tr>
			<td><label for="c_address">주소</label></td>
			<td><input type="text" id="c_address" name="c_address" value=<%=customer.getC_address() %>></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" onclick="javascript:history.back();" value="돌아가기">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>