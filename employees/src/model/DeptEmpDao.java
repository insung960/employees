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
import vo.Departments;
import vo.DeptEmp;
import vo.Employees;

public class DeptEmpDao 
{
	public List<DeptEmp> selectDeptEmpListOrderBy(String order,int rowPerPage,int currentPage)
	{
		List<DeptEmp> list  = new ArrayList<DeptEmp>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		if(order.equals("empName"))
		{
			sql ="SELECT de.from_date , de.to_date	, d.dept_name , e.first_name , e.last_name FROM  dept_emp de INNER JOIN  employees e  INNER JOIN  departments d ON de.dept_no = d.dept_no AND de.emp_no =e.emp_no ORDER BY first_name asc,last_name asc LIMIT ?,?";
		}
		else if(order.equals("deptName"))
		{
			sql ="SELECT de.from_date , de.to_date	, d.dept_name , e.first_name , e.last_name FROM  dept_emp de INNER JOIN  employees e  INNER JOIN  departments d ON de.dept_no = d.dept_no AND de.emp_no =e.emp_no ORDER BY dept_name asc LIMIT ?,?";
		}
		
		int StartRow = (currentPage-1)*rowPerPage;
		
		/////////////////////////
		System.out.println("______________Dao_______________");
		System.out.println("order : "+order);
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage :"+rowPerPage);
		System.out.println("StartRow :"+StartRow);
		/////////////////////////
		
		try 
		{	//널값을 다채우고 돌린다
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, StartRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				DeptEmp deptEmp = new DeptEmp();
				deptEmp.setDepartments(new Departments());
				deptEmp.setEmployees(new Employees());
				deptEmp.getDepartments().setDeptName(rs.getString("d.dept_name"));
				deptEmp.getEmployees().setFirstName(rs.getString("e.first_name"));
				deptEmp.getEmployees().setLastName(rs.getString("e.last_name"));
				deptEmp.setFromDate(rs.getString("de.from_date"));
				deptEmp.setToDate(rs.getString("de.to_date"));
				list.add(deptEmp);
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
		return list;
	}
	
	///////////////////////////////
	
	public int selectDeptEmpCount()
	{
		int selectDeptEmpCount = 0;
		final String sql = "SELECT COUNT(*)FROM dept_emp";
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
				selectDeptEmpCount = rs.getInt("COUNT(*)");
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
		return selectDeptEmpCount;
	}
}
