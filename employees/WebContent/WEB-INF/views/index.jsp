<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Index</h1>
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
		</tr>
		<tr>
			<td>emp</td>
			<td>${employeesRowCount}</td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListServlet">목록</a></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">이름순</a></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">이름역순</a></td>
		</tr>
		<tr>
			<td>dept</td>
			<td>${selectDepartmentsCount}</td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">목록</a></td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsListOrderBy?order=asc">이름순</a></td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsListOrderBy?order=desc">이름역순</a></td>
		</tr>
		<tr>
			<td>dept_emp</td>
			<td>${selectDeptEmpCount}</td>
			<td></td>
		</tr>
		<tr>
			<td>dept_manager</td>
			<td>${selectDeptManagerCount}</td>
			<td></td>
		</tr>
		<tr>
			<td>titles</td>
			<td>${selectTitlesCount}</td>
			<td></td>
		</tr>
		<tr>
			<td>salaries</td>
			<td>${selectSalariesCount}</td>
			<td></td>
		</tr>
	</table>
</body>
</html>