// JAVA와 데이터 베이스 연동하기


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// 커넥션 객체 만들기
		Connection conn;
		// CRUD 작업을 위한 객체 만들기
		Statement stmt;
		//CRUD 중 select 기능
		ResultSet rs;
		
		
		// url, id, pw 만들기 (나중에 DB 접속할 때 ()내 입력해도 상관 없음.)
		String url = "jdbc:mysql://localhost:3306/Haksa";
		String id = "root";
		String pw = "1234";
		
		
		try {
			
			//(1) 사용할 드라이버 불러오기 ("드라이버명 외우기")
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//(2) url, id, pw 사용하여 db 접속 ("드라이버명 외우기")
			// 상단에 변수로 만들지 않았다면 ()내부에 직접 입력하기
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 접속 완료!");
			
			
			// (3) CRUD 작업하기
			// stmt 객체 생성
			stmt = conn.createStatement();
			
			// CRUD - create 기능 (table 내부에 data 추가하기)
//			stmt.executeUpdate("insert into student values (202451111, '블랙핑크', 'music',100)");
			// CRUD - delete 기능 (table 내부의 data 삭제하기)
//			stmt.executeUpdate("delete from student where name='bts'");
			
			
			// stmt 통해 mysql 의 data 를 rs 객체에 담아줌. (sql 실행 => 데이터 결과를 rs 객체에 반환)
			// CRUD - read 기능
			rs = stmt.executeQuery("select * from student"); 
			//next() => rs 데이터 중 다음 행으로 이동 기능
			while(rs.next()) {
				int hakbun = rs.getInt(1); // database 필드명과 같아야 함.
				String name = rs.getString("name"); // 또는 1,2,3, 등으로 작성
				String dept = rs.getString(3);
				int score = rs.getInt("score");
				System.out.println(hakbun + " " + name + " " + dept + " " + score);
			}
			

			
			
		}catch (Exception e) {
			System.out.println("DB 접속 오류 : " + e);
		};

	}

}
