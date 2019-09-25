<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${currentpage}</div>
	
	<form action ="<%=request.getContextPath()%>/employees/getEmployeesListByPage" method = "get">
			<select name="rowPerPage">
				
				<option value = "10">10</option>
				<option value = "20">20</option>
				<option value = "30">30</option>
				<option value = "40">40</option>
				<option value = "50">50</option>
			
			</select>개씩보기
			
			<button type = "submit">정렬</button>
	</form>
	<table>
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
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.empNo}</td>
					<td>${list.firstName}</td>
					<td>${list.lastName}</td>
					<td>${list.birthDate}</td>
					<td>${list.gender}</td>
					<td>${list.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">
			이전
		</a>
	</c:if>

	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">
			다음
		</a>
	</c:if>
</body>
</html>