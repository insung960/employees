<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<table border ="1">
		<thead>
			<tr>
				<th>emp_no</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>birth_date</th>
				<th>gender</th>
				<th>hire_date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list}">
				<tr>
					<td>${e.empNo}</td>
					<td>${e.firstName}</td>
					<td>${e.lastName}</td>
					<td>${e.birthDate}</td>
					<td>${e.gender}</td>
					<td>${e.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>