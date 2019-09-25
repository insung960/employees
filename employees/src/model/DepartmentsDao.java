package model;

import java.sql.*;
import java.util.*;

import db.DBHelper;
import vo.Departments;
import vo.Employees;

public class DepartmentsDao 
{
	public List<Map<String,Object>> selectDepartmentListCountByDeptNo()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(de.dept_no) ,d.dept_name FROM dept_emp de INNER JOIN departments d ON de.dept_no = d.dept_no WHERE de.to_date = '9999-01-01' GROUP BY de.dept_no";
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try
		{
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("deptName", rs.getString("d.dept_name"));
				map.put("cnt", rs.getInt("COUNT(de.dept_no)"));
				list.add(map);
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			DBHelper.close(rs, stmt, conn);
		}
		return list;		
	}
	
	/////
	public List<Departments> selectDepartmentsListOrderBy(String order)
	{
		List<Departments> list  = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Departments departments = new Departments();
		String sql = null;
		if(order.equals("asc"))
		{
			sql ="SELECT * FROM departments ORDER BY dept_name asc";
		}
		else if(order.equals("desc"))
		{
			sql ="SELECT * FROM departments ORDER BY dept_name desc";
		}
		System.out.println(order);
		System.out.println(sql);
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				departments = new Departments();
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);				
			}
			System.out.println("departmentsDao의 While문 다음");
			for(Departments d : list)
			{
				System.out.println(d.getDeptName());
			}
		}
		catch(Exception e)
		{//위의 코드의 예외를 받는다
			e.printStackTrace();
		}
		finally
		{	
			try
			{	//무조건 한번 실행되서 모두닫는다 순서대로 닫아야함
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{	//close의 예외용 답는다
				e.printStackTrace();
			}
		}
		
		return list;		//만든 리스트를 Dao를 부른 서블렛에 리턴한다  >>>GetEmployeesListServlet
	}
	
	
	public List<Departments> selectDepartmentsList()
	{
		List<Departments> list  = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_name,dept_no FROM departments ORDER BY dept_no";
		Departments department = new Departments();
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);
			}
			System.out.println("departmentsDao의 While문 다음");
			for(Departments d : list)
			{
				System.out.println(d.getDeptName());
			}
		}
		catch(Exception e)
		{//위의 코드의 예외를 받는다
			e.printStackTrace();
		}
		finally
		{	
			try
			{	//무조건 한번 실행되서 모두닫는다 순서대로 닫아야함
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{	//close의 예외용 답는다
				e.printStackTrace();
			}
		}
		
		return list;		//만든 리스트를 Dao를 부른 서블렛에 리턴한다  >>>GetDepartmentsListServlet
	}
	
	public int selectDepartmentsCount()
	{
		int selectDepartmentsCount = 0;
		final String sql = "SELECT COUNT(*)FROM departments";
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				selectDepartmentsCount = rs.getInt("COUNT(*)");
			}
		}
		catch(Exception e)			//자바의 변수 생명주기는 {}
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return selectDepartmentsCount;
	}
}
