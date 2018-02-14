<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href="style.css" rel="stylesheet" media="all">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function upClick() {
	var n = document.getElementById("p_count").value;
	document.getElementById("p_count").value = (n*1)+1;
}
function downClick() {
	var n = document.getElementById("p_count").value;
	if(n!=0){
	document.getElementById("p_count").value = (n*1)-1;
	}
}
</script>
</head>
<body>
	<form action="pinsert.mall" method="post" name="writeForm" enctype="multipart/form-data">
		<table>
			<th colspan="2">
				상품 정보등록
			</th>
			<tr>
				<td><label for="p_id">제품번호</label></td>
				<td><input type="text" name="p_id" id="p_id" required></td>
			</tr>
			<tr>
				<td><label for="p_name">제품명</label></td>
				<td><input type="text" name="p_name" id="p_name" required /></td>
			</tr>
			<tr>
				<td><label for="p_price">가격</label></td>
				<td><input type="text" name="p_price" id="p_price" required /></td>
			</tr>
			<tr>
				<td><label for="p_count">수량</label></td>
				<td>
				<input type="text" name="p_count" value="1" id="p_count"/>
				<input type="button" value="▲" id="bt_up" name="bt_up" onclick="upClick()" class="count"/>
				<input type="button" value="▼" id="bt_down" name="bt_down" onclick="downClick()" class="count"/>
				</td>
			</tr>
			<tr>
				<td><label for="p_image">상품이미지 : </label></td>
				<td><input type="file" name="p_image" id="p_image" /></td>
			</tr>
			<tr>
				<td colspan="2" id="commandCell">
					<input type="submit" value="상품등록" /> 
					<input type="reset" value="다시작성" /> 
					<input type="button" value="관리자페이지" onclick="window.location.href='admin.jsp'" />
					</td>
			</tr>
		</table>
	</form>
</body>
</html>