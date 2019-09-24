package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;
import vo.Titles;

public class TitlesDao 
{
	public List<Titles> selectTitlesListDistinct()
	{
		List<Titles> list  = new ArrayList<Titles>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Titles titles = new Titles();
		String sql = "SELECT DISTINCT title FROM titles";
		try 
		{	//널값을 다채우고 돌린다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{//rs로 반복돌려서 리스트 애드한다
				titles = new Titles();
				titles.setTitle(rs.getString("title"));
				list.add(titles);				
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
	
	public int selectTitlesCount()
	{
		int selectTitlesCount = 0;
		final String sql = "SELECT COUNT(*)FROM titles";
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
				selectTitlesCount = rs.getInt("COUNT(*)");
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
		return selectTitlesCount;
	}
}
