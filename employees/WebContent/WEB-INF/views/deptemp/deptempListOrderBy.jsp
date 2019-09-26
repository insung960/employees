<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action ="${pageContext.request.contextPath}/deptemp/getDeptEmpListOrderBy" method = "get">
			
			<select name="rowPerPage">
				<option value = "10">10</option>
				<option value = "20">20</option>
				<option value = "30">30</option>
				<option value = "40">40</option>
				<option value = "50">50</option>
			</select>개씩보기
			<input type ="hidden" name="order" value ="${order}">
			
			<button type = "submit">정렬</button>
	</form>

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
					<td>${list.departments.deptName}</td>
					<td>${list.employees.firstName}</td>
					<td>${list.employees.lastName}</td>
					<td>${list.fromDate}</td>
					<td>${list.toDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/deptemp/getDeptEmpListOrderBy?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&order=${order}">
			이전
		</a>
	</c:if>

	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/deptemp/getDeptEmpListOrderBy?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&order=${order}">
			다음
		</a>
	</c:if>
</body>
</html>