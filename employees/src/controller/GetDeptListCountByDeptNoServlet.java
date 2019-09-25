package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;


@WebServlet("/departments/getDeptListCountByDeptNoServlet")
public class GetDeptListCountByDeptNoServlet extends HttpServlet 
{
	DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		departmentsDao = new DepartmentsDao();
		List<Map<String,Object>> list = departmentsDao.selectDepartmentListCountByDeptNo();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsListCountByDeptNo.jsp").forward(request, response);
		
	}
}
