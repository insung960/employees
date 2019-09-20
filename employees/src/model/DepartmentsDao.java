package model;

import java.sql.*;
import java.util.*;
import vo.Departments;

public class DepartmentsDao 
{
	public List<Departments> selectDepartmentsList()
	{
		List<Departments> list  = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_name,dept_no FROM departments";
		Departments department = new Departments();
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java123");
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
}