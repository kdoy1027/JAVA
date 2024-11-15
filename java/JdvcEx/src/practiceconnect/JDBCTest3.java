// CRUD - Create 기능


package practiceconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest3 {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		String url = "jdbc:mysql://localhost:3306/haksa";
		String id = "root";
		String pw = "1234";
		
		try {
			//드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// db 접속
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("db 연동 완료");
			
			
			// 데이터 베이스에서 가져올 데이터 담을 공간 만들기
			stmt = con.createStatement();
			
			//update = insert update delete 모두 사용!!!!!
			// 데이터 베이스에 데이터 추가하기.
			stmt.executeUpdate("insert into student values(202411111, '김도윤', 'nursing', 4)");
			stmt.executeUpdate("insert into student values(202422222, '김자바', 'software', 4)");
			stmt.executeUpdate("insert into student values(202433333, '김지원', 'nursing', 4)");
			
			
			
			// stmt 의 담겨진 db의 데이터를 rs 로 반환
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
			
			
		}catch (Exception e) {
			System.out.println("SQLException : " + e.getMessage());
		};

	}

}
