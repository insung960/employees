package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import model.EmployeesDao;
import vo.Departments;
import vo.Employees;

@WebServlet("/employees/getEmployeesListServlet")
public class GetEmployeesListServlet extends HttpServlet 
{
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		employeesDao = new EmployeesDao();
		//list를 만들어 departmentsDao안의 selectDepartmentsList메서드를 실행시켜 리턴값(리스트)를 받아온다
		List<Employees> list = employeesDao.selectEmployeesList();
		
		//attribute에 저장한다 이름"list" 값 list
		request.setAttribute("list",list);
		
		//setAttribute로 저장한 값들을 getRequestDispatcher로 여러 페이지에 넘겨줄수있다
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}
}
