<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="/guestbook5/guest/add" method="get">
		<table border="1" width="540px">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="72" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="">등록</button></td>
			</tr>
		</table>
	</form>
	<br>

	<c:forEach items="${requestScope.gList }" var="gList" varStatus="status">
	<table border="1" width="540px">
		<tr>
			<td>[${status.count }]</td>
			<td>${gList.name }</td>
			<td>${gList.date }</td>
			<td><a href="/guestbook5/guest/deleteform?no=${gList.no }">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">${gList.content }</td>
		</tr>
	</table>
	<br>
	
	</table>
	</c:forEach>
	<br>
</body>
</html>