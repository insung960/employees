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

@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet 
{
	//Dao들을 사용하기위해  private로 먼저 만듬
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
		
		//dao를 만들고 dao안의 Count 매서드를 불러온다
		//매서드에서 리턴받은 int를 setAttribute로 저장한다 (별명,값)
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
		/////////////////////////////////////////////////////////////////////////////
				
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		//rd.forward(request, response);
		
		//페이지를 넘긴다
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
