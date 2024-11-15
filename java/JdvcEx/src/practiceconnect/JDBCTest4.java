// CRUD - Create 기능


package practiceconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest4 {

	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		String url = "jdbc:mysql://localhost:3306/haksa";
		String id = "root";
		String pw = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("db 연동 완료");
			
			stmt = con.createStatement();
			
			stmt.executeUpdate("delete from student where name = '김지원'");
			
			rs = stmt.executeQuery("select * from student");
			
			while(rs.next()) {
				int hakbun = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				int score = rs.getInt("score");
				
				System.out.println("---------------");
				System.out.println("학번 : " + hakbun);
				System.out.println("이름 : " + name);
				System.out.println("학과 : " + dept);
				System.out.println("학점 : " + score);
			}
			
			stmt.close();
			con.close();
		
		}catch (Exception e) {
			System.out.println("SQLException : " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		

	}

}
