// CRUD - Read 기능


package practiceconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest2 {

	public static void main(String[] args) {
		// 1. java 와  db 연결하기 
		//db 연동하기 위해 필요한 객체 생성
		Connection con = null;
		Statement stmt;
		ResultSet rs;
		
		
		// db 접속 시 필요한 정보 생성
		String url = "jdbc:mysql://localhost:3306/haksa";
		String id = "root";
		String pw = "1234";
		
		try {
		// (1-1) 드라이버 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// (1-2) url, id, pw 정보를 사용하여 DB 접속
		con = DriverManager.getConnection(url, id, pw);
		System.out.println("DB 연결 완료");
		
		// 2. db 내부의 데이터 가져오기
		//(2-1) statement()를 통해 데이터들을 담을 공간 만들기
		stmt = con.createStatement(); // 
		//(2-2) resultset 객체에 테이블 내용 담기 (= 테이블 값들을 rs에 반환) 
		rs = stmt.executeQuery("select * from student");
		
		//(2-3). rs에 반홚나 값들을 필드에 맞게 정렬
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
		}
		
		

	}

}
