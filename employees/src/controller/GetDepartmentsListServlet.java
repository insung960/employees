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

@WebServlet("/departments/getDepartmentsList")			//주소 표시
public class GetDepartmentsListServlet extends HttpServlet 
{
	private DepartmentsDao departmentsDao;	//departmentsDao를 프라이빗으로 먼저 만든다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		departmentsDao = new DepartmentsDao();
		//list를 만들어 departmentsDao안의 selectDepartmentsList메서드를 실행시켜 리턴값(리스트)를 받아온다
		List<Departments> list = departmentsDao.selectDepartmentsList();
		
		//attribute에 저장한다 이름"list" 값 list
		request.setAttribute("list",list);
		
		//setAttribute로 저장한 값들을 getRequestDispatcher로 여러 페이지에 넘겨줄수있
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	}
}
