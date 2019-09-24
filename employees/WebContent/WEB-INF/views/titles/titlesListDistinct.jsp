<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>타이틀 항목의 중복 제거</h1>
	
	<table border="1">
		<tr>
			<td>titles/title</td>
		</tr>
		<c:forEach var="T" items="${list}">
			<tr>
				<td>${T.title}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>