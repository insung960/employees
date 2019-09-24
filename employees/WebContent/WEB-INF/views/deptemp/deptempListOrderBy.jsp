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
			<c:forEach items="${Department}" var="de">
				<c:forEach items="${Department}" var="e">
					<td>${de.e.firstName}</td>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>