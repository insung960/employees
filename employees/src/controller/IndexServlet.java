package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import model.DeptEmpDao;
import model.DeptManagerDao;
import model.EmployeesDao;
import model.SalariesDao;
import model.TitlesDao;

@WebServlet("/index")
public class IndexServlet extends HttpServlet 
{
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptEmpDao deptempDao;
	private DeptManagerDao deptmanagerDao;
	private TitlesDao titlesDao;
	private SalariesDao salariesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("/index URL 요청");
		//EmployeesDap employeesDao = new EmployeesDao();
		
		employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		departmentsDao = new DepartmentsDao();
		int selectDepartmentsCount = departmentsDao.selectDepartmentsCount();
		request.setAttribute("selectDepartmentsCount", selectDepartmentsCount);
		
		deptempDao = new DeptEmpDao();
		int selectDeptEmpCount = deptempDao.selectDeptEmpCount();
		request.setAttribute("selectDeptEmpCount", selectDeptEmpCount);
		
		deptmanagerDao = new DeptManagerDao();
		int selectDeptManagerCount = deptmanagerDao.selectDeptManagerCount();
		request.setAttribute("selectDeptManagerCount", selectDeptManagerCount);
		
		titlesDao = new TitlesDao();
		int selectTitlesCount = titlesDao.selectTitlesCount();
		request.setAttribute("selectTitlesCount", selectTitlesCount);
		
		salariesDao = new SalariesDao();
		int selectSalariesCount =salariesDao.selectSalariesCount() ;
		request.setAttribute("selectSalariesCount", selectSalariesCount);
				
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		//rd.forward(request, response);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
