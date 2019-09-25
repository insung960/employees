<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	table{
			
			margin: auto;
			text-align: center;	
		}
</style>
</head>
<body>

<div class="container"  style="display: inline-block;text-align: center;">
	<h1>Index</h1>
	<form action="${pageContext.request.contextPath}/employees/getEmployeesListBetween" type="post">
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>
		<tr>
			<td>emp</td>
			<td>${employeesRowCount}</td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListServlet">목록</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">이름순</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">목록페이징</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListGroupByGender">성별당 사원수</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">이름역순</a></td>
		</tr>
		<tr>
			<td><input type="text" name="fromNo" value="0번부터" class="form-control"></td>
			<td><input type="text" name="toNo" value="0번까지" class="form-control"></td>
			<td><button type="submit">검색</button></td>
		</tr>
	</table>
	<br>
		
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>
		<tr>
			<td>dept</td>
			<td>${selectDepartmentsCount}</td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">목록</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsListOrderBy?order=asc">이름순</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsListOrderBy?order=desc">이름역순</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/departments/getDeptListCountByDeptNoServlet">부서현재인원수</a></td>
		</tr>
	</table>
	<br>	
		
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>	
		<tr>
			<td>dept_emp</td>
			<td>${selectDeptEmpCount}</td>
			<td><a href="${pageContext.request.contextPath}/deptemp/getDeptEmpListOrderBy?order=empName">이름순</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="${pageContext.request.contextPath}/deptemp/getDeptEmpListOrderBy?order=deptName">부서순</a></td>
		</tr>
	</table>
	<br>
		
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>
		<tr>
			<td>dept_manager</td>
			<td>${selectDeptManagerCount}</td>
			<td></td>
		</tr>
	</table>
	<br>
		
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>
		<tr>
			<td>titles</td>
			<td>${selectTitlesCount}</td>
			<td><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinctServlet">중복제거</a></td>
		</tr>
	</table>
	<br>
		
	<table border = "1">
		<tr>
			<td>테이블명</td>
			<td>테이블의 행수</td>
			<td></td>
		</tr>
		<tr>
			<td>salaries</td>
			<td>${selectSalariesCount}</td>
			<td><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">통계</a></td>
		</tr>
	</table>
	<br>
	</form>
	</div>
</body>
</html>