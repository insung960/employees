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
	<table>
		<tr>
			<td>gender</td>
			<td>cnt</td>
		</tr>
		<tr>
			<td>${map.gender}</td>
			<td>${map.cnt}</td>
		</tr>
	</table>
</body>
</html>