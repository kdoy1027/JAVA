package scoreMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectList {

	
	public void SelectList () {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// 커넥션 연결
			con = DBConnect.getConnection();
			String sql = " SELECT * FROM sungjuk order by name ASC";
			
			
			//쿼리 지정
			pstmt = con.prepareStatement(sql);
			
			//물음표의 순번, 적용할 값 
			//문자열 지정 pstmt.setString(...)
			//첫 번째 ? 에 값을 1 지정
			//pstmt.setInt(1,1);
			rs = pstmt.executeQuery();
			
			// 하나의 레코드 출력
			// if(re.next() == true) {
//			System.out.println("출력 결과 ------------");}
			
			//여러개의 레코드 출력
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("국어 : " + rs.getInt("kuk") );
				System.out.println("영어 : " + rs.getInt("eng") );
				System.out.println("수학 : " + rs.getInt("mat") );
				System.out.println("총점 : " + rs.getInt("tot") );
				System.out.println("평균 : " + rs.getInt("avg") );
				System.out.println("etc : " + rs.getInt("etc") );
				System.out.println("------------------------------------------------");
			}
			
			
		}catch (Exception e) {
			System.out.println("SQLException : " + e.getMessage());
		}finally {
			DBConnect.close(con, pstmt);
		}
		
	};
	
	
}
