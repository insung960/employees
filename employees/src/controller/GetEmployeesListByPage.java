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

@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPage extends HttpServlet
{
	EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		employeesDao = new EmployeesDao();
		int rowPerPage = 10;
		int currentPage=1;
		
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(request.getParameter("rowPerPage")!=null)
		{
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		
		
		///////페이징//////////
		int cntRow = employeesDao.selectEmployeesCount();
		int lastPage= 0 ;
		
		if(cntRow%rowPerPage==0)
		{
			lastPage = cntRow / rowPerPage;
		}
		else if(cntRow%rowPerPage!=0)
		{
			lastPage = (cntRow / rowPerPage) + 1 ;
		}
		
		
		
		//////////////////////////////////////////////////////////////////
		System.out.println("------------------------------------");
		System.out.println("서블릿 currentPage :"+currentPage);
		System.out.println("서블릿 rowPerPage :"+rowPerPage);
		//////////////////////////////////////////////////////////////////
		
		
		//////jsp로 넘기기//////
		request.setAttribute("list", list);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}
}
