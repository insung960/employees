<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성별과 해당성별의 직원수</h1>
	<table border="1">
		<tr>
			<td>gender</td>
			<td>cnt</td>
		</tr>
		<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.gender}</td>
			<td>${list.cnt}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>