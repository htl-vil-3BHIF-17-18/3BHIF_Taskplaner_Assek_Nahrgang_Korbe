package dal;


import java.sql.*;
import java.util.ArrayList;

import bll.*;

public class OracleHelper {
	
	
	
	public static ArrayList<Task> getListFromDB()
	{
		Connection con = null;
		Statement stmt_Select = null;
		ResultSet rs = null;
		
		Task t = null;
		ArrayList<Task> tasks =new ArrayList<Task>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			stmt_Select = con.createStatement();
			rs = stmt_Select.executeQuery("SELECT * FROM tasks");
			
			while(rs.next()) {			
				tasks.add(new Task(rs.getString(1),rs.getString(2), rs.getDate(3), Task.getTypFromString(rs.getString(4))));			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				rs.close();
				stmt_Select.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return tasks;
		
	}
	
	public static void addTaskToDB(Task t)
	{
		Connection con = null;
		PreparedStatement pstmt_Insert = null;

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			pstmt_Insert = con.prepareStatement("INSERT into tasks (fach,text,datum,typ) values(?,?,?,?)");
			
			pstmt_Insert.setString(1, t.getSubject());
			pstmt_Insert.setString(2, t.getText());
			pstmt_Insert.setDate(3, t.getDatumSQL());
			pstmt_Insert.setString(4, t.getTyp().toString());
					
			pstmt_Insert.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {

				pstmt_Insert.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
