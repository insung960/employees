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
			<td>emp</td>
			<td>${employeesRowCount}</td>
		</tr>
		<tr>
			<td>dept</td>
			<td>${selectDepartmentsCount}</td>
		</tr>
		<tr>
			<td>dept_emp</td>
			<td>${selectDeptEmpCount}</td>
		</tr>
		<tr>
			<td>dept_manager</td>
			<td>${selectDeptManagerCount}</td>
		</tr>
		<tr>
			<td>titles</td>
			<td>${selectTitlesCount}</td>
		</tr>
		<tr>
			<td>salaries</td>
			<td>${selectSalariesCount}</td>
		</tr>
	</table>
</body>
</html>