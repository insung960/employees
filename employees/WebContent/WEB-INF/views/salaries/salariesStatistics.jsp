<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통계</h1>
	<table border="1">
		<tr>
			<td>카운트</td>
			<td>합</td>
			<td>최댓값</td>
			<td>최솟값</td>
			<td>평균</td>
			<td>표준편차</td>
		</tr>
			<tr>
				<td>${map.count}</td>
				<td>${map.sum}</td>
				<td>${map.max}</td>
				<td>${map.min}</td>
				<td>${map.avg}</td>
				<td>${map.std}</td>
			</tr>
	</table>
</body>
</html>