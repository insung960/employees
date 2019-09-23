package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalariesDao 
{
	public int selectSalariesCount()
	{
		int selectSalariesCount = 0;
		final String sql = "SELECT COUNT(*)FROM salaries";
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
				selectSalariesCount = rs.getInt("COUNT(*)");
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
		return selectSalariesCount;
	}
}
