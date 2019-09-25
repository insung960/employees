<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ="1">
		<thead>
			<tr>
				<th>부서</th>
				<th>성</th>
				<th>이름</th>
				<th>들어온날</th>
				<th>나간날</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.deptName}</td>
					<td>${list.firstName}</td>
					<td>${list.lastName}</td>
					<td>${list.fromDate}</td>
					<td>${list.toDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>