<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>부서</td>
			<td>현재 인원</td>
		</tr>
		<c:forEach	items="${list}" var="list">
			<tr>
				<td>${list.deptName}</td>
				<td>${list.cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>