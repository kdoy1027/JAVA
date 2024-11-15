// 데이터베이스와 연동하는 클래스
package scoreMangement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {

	// Connection 메소드 만들기
	public static Connection getConnection () {
			Connection con = null;
			ResultSet rs;
			PreparedStatement pstmt;
			
			
			String url = "jdbc:mysql://localhost:3306/haksa";
			String id = "root";
			String pw = "1234";
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, id, pw);
				System.out.println("DB 접속 성공!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("서버 연동 오류 발생 : " + e);
			} finally {
				
			}
			return con;
			
	}
			
	// update, delete, read 메소드 한 번에 닫기??
	public static void close (Connection con ,PreparedStatement pstmt) {
		try {
			if (pstmt != null) {pstmt.close();}
		}catch (Exception e ) {};
			
		try {
			if (con != null) {con.close();}
		}catch (Exception e ) {};
		
		}	

	// insert()
	public static void close (Connection con , PreparedStatement pstmt, ResultSet rs) {
		try {
			if (pstmt != null) {pstmt.close();}
		}catch (Exception e ) {};
			
		try {
			if (con != null) {con.close();}
		}catch (Exception e ) {};
		
		try {
			if (rs != null) {rs.close();}
		}catch (Exception e ) {};
		
		}	
	}


