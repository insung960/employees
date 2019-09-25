package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet
{
	EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int fromNo  = Integer.parseInt(request.getParameter("fromNo"));
		int toNo  = Integer.parseInt(request.getParameter("toNo"));
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListBetween(fromNo, toNo);
		
		///////////////////
		System.out.println("-----------------------------");
		System.out.println("서블릿 fromNo :"+fromNo);
		System.out.println("서블릿 toNo :"+toNo);
		/////////////////////
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
		
	}
}
