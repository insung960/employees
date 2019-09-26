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
		
		
		int rowPerPage=15;
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(request.getParameter("rowPerPage")!=null)
		{
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		int lastPage =1;
		int cnt = deptempDao.selectDeptEmpCount();
		
		if(cnt%rowPerPage==0)
		{
			lastPage = cnt/rowPerPage;
		}
		else if(cnt%rowPerPage!=0)
		{
			lastPage = (cnt/rowPerPage) +1;
		}
		
		String order = request.getParameter("order");
		
		/////////////////////////
		System.out.println("______________Servlet_______________");
		System.out.println("order : "+order);
		System.out.println("lastPage : "+lastPage);
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage :"+rowPerPage);
		/////////////////////////
		
		List<DeptEmp> list = deptempDao.selectDeptEmpListOrderBy(order,rowPerPage,currentPage);
		
		request.setAttribute("lastPage",lastPage);
		request.setAttribute("rowPerPage",rowPerPage);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("list",list);
		request.setAttribute("order",order);
		request.getRequestDispatcher("/WEB-INF/views/deptemp/deptempListOrderBy.jsp").forward(request, response);	
	}
}
