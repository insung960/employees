package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Employees;

public class EmployeesDao
{							
	public Map<String,Object> selectEmployeesListGroupByGender()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT gender ,COUNT(gender) FROM employees GROUP BY gender";
		Map<String, Object> map = new HashMap<String,Object>();
		try
		{
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("COUNT(gender)"));
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
		return map;		
	}
	
	//////////////////////////////////////////////////////
	
	public List<Employees> selectEmployeesListOrderBy(String order)
	{
		List<Employees> list  = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Employees employees = new Employees();
		String sql = null;
		if(order.equals("asc"))
		{
			sql ="SELECT * FROM employees ORDER BY first_name asc,last_name asc LIMIT 50";
		}
		else if(order.equals("desc"))
		{
			sql ="SELECT * FROM employees ORDER BY first_name desc,last_name desc LIMIT 50";
		}
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);				
			}
			System.out.println("departmentsDao의 While문 다음");
			for(Employees e : list)
			{
				System.out.println(e.getEmpNo());
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
	
	////////////////////
	
	public List<Employees> selectEmployeesList()
	{
		List<Employees> list  = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no,first_name,last_name,birth_date,hire_date,gender FROM employees";
		Employees employees = new Employees();
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);				
			}
			System.out.println("departmentsDao의 While문 다음");
			for(Employees e : list)
			{
				System.out.println(e.getEmpNo());
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
	public int selectEmployeesCount()
	{
		int selectEmployeesCount = 0;
		final String sql = "SELECT COUNT(*)FROM employees";
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
				selectEmployeesCount = rs.getInt("COUNT(*)");
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
		return selectEmployeesCount;
	}
}
