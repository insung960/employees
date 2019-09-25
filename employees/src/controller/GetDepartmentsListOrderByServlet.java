package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Departments;

@WebServlet("/departments/getDepartmentsListOrderBy")
public class GetDepartmentsListOrderByServlet extends HttpServlet 
{	
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		departmentsDao = new DepartmentsDao();
		String order = request.getParameter("order");
		List<Departments> list = departmentsDao.selectDepartmentsListOrderBy(order);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsListOrderBy.jsp").forward(request, response);
	}
}
