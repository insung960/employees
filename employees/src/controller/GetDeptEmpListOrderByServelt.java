package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptEmpDao;
import vo.DeptEmp;

@WebServlet("/deptemp/getDeptEmpListOrderBy")
public class GetDeptEmpListOrderByServelt extends HttpServlet 
{
	private DeptEmpDao deptempDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		deptempDao = new DeptEmpDao();
		String order = request.getParameter("order");
		List<Map<String,Object>> list = deptempDao.selectDeptEmpListOrderBy(order);
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/views/deptemp/deptempListOrderBy.jsp").forward(request, response);	
	}
}
