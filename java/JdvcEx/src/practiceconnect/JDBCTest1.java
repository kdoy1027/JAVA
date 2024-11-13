// 자바와 데이터베이스 연동

package practiceconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest1 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		// db 접속 위한 정보들 생성
		String url = "jdbc:mysql://localhost:3306/haksa";
		String id = "root";
		String pw = "1234";
		
		//db 접속 단계
		try {
			// (1) 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// (2) url, id, pw 을 사용하여 데이터베이스와 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연동 완료.");
			
		}catch (Exception e) {
			System.out.println("SQLException : " + e.getMessage());
		};

	}

}
