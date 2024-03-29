package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;


@WebServlet("/employees/getEmployeesListGroupByGender")
public class GetEmployeesListGroupByGenderServlet extends HttpServlet 
{
	EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		employeesDao = new EmployeesDao();
		List<Map<String,Object>> list = employeesDao.selectEmployeesListGroupByGender();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListGroupByGender.jsp").forward(request, response);
	}
}
