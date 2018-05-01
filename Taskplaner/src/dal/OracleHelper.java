package dal;


import java.sql.*;
import java.util.ArrayList;

import bll.*;

public class OracleHelper {
	
	
	@SuppressWarnings("resource")
	public static ArrayList<Task> getListFromDB()
	{
		Connection con = null;
		Statement stmt_Select = null;
		ResultSet rs = null;
		Task t = null;
		ArrayList<Task> tasks =new ArrayList<Task>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			}
			catch(Exception ex)
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@212.152.179.117:1521:ora11g");
			}
			stmt_Select = con.createStatement();
			rs = stmt_Select.executeQuery("SELECT * FROM tasks");
			while(rs.next()) {			
				tasks.add(new Task(Task.getSubjectFromString(rs.getString(1)),rs.getString(2), rs.getDate(3), Task.getTypFromString(rs.getString(4))));			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt_Select.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tasks;
	}
	
	@SuppressWarnings("resource")
	public static void addTaskToDB(Task t)
	{
		Connection con = null;
		PreparedStatement pstmt_Insert = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			}
			catch(Exception ex)
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@212.152.179.117:1521:ora11g");
			}
			
			pstmt_Insert = con.prepareStatement("INSERT into tasks (fach,text,datum,typ) values(?,?,?,?)");
			pstmt_Insert.setString(1, t.getSubject().toString());
			pstmt_Insert.setString(2, t.getText());
			pstmt_Insert.setDate(3, t.getDatumSQL());
			pstmt_Insert.setString(4, t.getTyp().toString());		
			pstmt_Insert.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			if(t.getText().length() > 50)
			{
				System.out.println("Text is too long (max length: 50) your length: "+t.getText().length());
			}
			else {
				System.out.println("can't insert null");
			}
		}
		finally {
			try {
				pstmt_Insert.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void deleteTaskAtDB(Task t)
	{
		Connection con = null;
		PreparedStatement pstmt_Delete = null;
		System.out.println(t);
	
		try {
			String sqlDate = t.getDatumSQL().toString();
			sqlDate = sqlDate.substring(8, 10)+"."+sqlDate.substring(5, 7)+"."+sqlDate.substring(2, 4) ;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			}
			catch(Exception ex)
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@212.152.179.117:1521:ora11g");
			}
			pstmt_Delete = con.prepareStatement("DELETE tasks WHERE fach LIKE ? AND text LIKE ?" +
					" AND datum LIKE ? AND typ LIKE ? ");
			
			pstmt_Delete.setString(1, t.getSubject().toString());
			pstmt_Delete.setString(2, t.getText());
			pstmt_Delete.setDate(3, t.getDatumSQL());
			pstmt_Delete.setString(4, t.getTyp().toString());
			
			pstmt_Delete.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("cant delete if nothing is selected");
		}
		finally {
			try {
				pstmt_Delete.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void updateTaskInDB(Task oldt, Task newt)
	{
		
		Connection con = null;
		PreparedStatement pstmt_Delete = null;
	
	
		try {
			String sqlDate = oldt.getDatumSQL().toString();
			sqlDate = sqlDate.substring(8, 10)+"."+sqlDate.substring(5, 7)+"."+sqlDate.substring(2, 4) ;
			String sqlDate2 = newt.getDatumSQL().toString();
			sqlDate2 = sqlDate2.substring(8, 10)+"."+sqlDate2.substring(5, 7)+"."+sqlDate2.substring(2, 4) ;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@192.168.128.152:1521:ora11g");
			}
			catch(Exception ex)
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:d3b09/d3b@212.152.179.117:1521:ora11g");
			}
			
			pstmt_Delete = con.prepareStatement("UPDATE tasks SET fach = ?, text = ?, datum = ?, typ = ? "+
					"WHERE fach LIKE ? AND text LIKE ? AND datum LIKE ? AND typ LIKE ?");
			
			pstmt_Delete.setString(1, newt.getSubject().toString());
			pstmt_Delete.setString(2, newt.getText());
			pstmt_Delete.setString(3, sqlDate2);
			pstmt_Delete.setString(4, newt.getTyp().toString());
			pstmt_Delete.setString(5, oldt.getSubject().toString());
			pstmt_Delete.setString(6, oldt.getText());
			pstmt_Delete.setString(7, sqlDate);
			pstmt_Delete.setString(8, oldt.getTyp().toString());
			
			pstmt_Delete.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			if(newt.getText().length() > 50)
			{
				System.out.println("Text is too long (max length: 50) your length: "+newt.getText().length());
			}
			else {
				System.out.println("can't update to null");
			}
		}
		finally {
			try {
				pstmt_Delete.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}