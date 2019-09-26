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
	public int login(Employees employees)
	{
		int sessionEmpNo = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no FROM employees WHERE emp_no =? AND first_name =? AND last_name =?";
		
		try 
		{	//널값을 다채우고 돌린다
			
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,employees.getEmpNo());
			stmt.setString(2,employees.getFirstName());
			stmt.setString(3,employees.getLastName());
			rs = stmt.executeQuery();
			
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				sessionEmpNo = 1;		
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
				DBHelper.close(rs, stmt, conn);
			}
			catch(Exception e)
			{	//close의 예외용 답는다
				e.printStackTrace();
			}
		}
		
		///////////////////////////////
		System.out.println("____________________EmpDao_____________________");
		System.out.println("firstName : "+employees.getFirstName());
		System.out.println("lastName : "+employees.getLastName());
		System.out.println("empNo : "+employees.getEmpNo());
		System.out.println("sessionEmpNo : "+sessionEmpNo);
		///////////////////////////////
		
		return sessionEmpNo;		//만든 리스트를 Dao를 부른 서블렛에 리턴한다  >>>GetEmployeesListServlet
	}	

	
	//사원 번호 범위를 직접 지정함
	public List<Employees> selectEmployeesListBetween(int fromNo,int toNo)
	{
		System.out.println("DAO fromNo :"+fromNo);
		System.out.println("DAO toNo :"+toNo);
		List<Employees> list  = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employees WHERE emp_no BETWEEN ? AND ?";
		Employees employees = new Employees();
		try 
		{	//널값을 다채우고 돌린다
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,fromNo);
			stmt.setInt(2,toNo);
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
		}
		catch(Exception e)
		{//위의 코드의 예외를 받는다
			e.printStackTrace();
		}
		finally
		{	
			try
			{	//무조건 한번 실행되서 모두닫는다 순서대로 닫아야함
				DBHelper.close(rs, stmt, conn);
			}
			catch(Exception e)
			{	//close의 예외용 답는다
				e.printStackTrace();
			}
		}
		
		return list;		//만든 리스트를 Dao를 부른 서블렛에 리턴한다  >>>GetEmployeesListServlet
	}
	
	
	//페이징된 리스트
	public List<Employees> selectEmployeesListByPage(int currentPage,int rowPerPage)
	{
		System.out.println("매서드 currentPage :"+currentPage);
		System.out.println("매서드 rowPerPage :"+rowPerPage);
		String sql = "SELECT * FROM employees LIMIT ?,?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employees> list = new	ArrayList<Employees>();
		try
		{
			
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			int startRow=0;
			startRow = (currentPage-1)*rowPerPage;
			stmt.setInt(1,startRow );
			stmt.setInt(2,rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		finally
		{
			try 
			{
				DBHelper.close(rs, stmt, conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	
	//그룹 젠더,젠더(인원수)
	public List<Map<String,Object>> selectEmployeesListGroupByGender()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT gender ,COUNT(gender) FROM employees GROUP BY gender";
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try
		{
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("COUNT(gender)"));
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
	
	//////////////////////////////////////////////////////
	//사원 이름 오름 내림 정렬
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
				DBHelper.close(rs, stmt, conn);
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
				DBHelper.close(rs, stmt, conn);
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
				DBHelper.close(rs, stmt, conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return selectEmployeesCount;
	}
}
