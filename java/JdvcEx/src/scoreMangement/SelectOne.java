package scoreMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectOne {
	
	public void SelectOne () {
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		System.out.println("이름을 입력하세요 : >>");
		name = sc.nextLine();
		//-------------------------------------------------------
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			// 커넥션 연결
			con = DBConnect.getConnection();
			String sql = "SELECT * FROM sungjuk where name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			//(물음표의 순번, 적용할 값)
			rs = pstmt.executeQuery();
			//하나의 레코드 출력
			
			//여러개의 레코드 출력 
			if(rs.next()) {
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("국어 : " + rs.getInt("kuk") );
				System.out.println("영어 : " + rs.getInt("eng") );
				System.out.println("수학 : " + rs.getInt("mat") );
				System.out.println("총점 : " + rs.getInt("tot") );
				System.out.println("평균 : " + rs.getInt("avg") );
				System.out.println("etc : " + rs.getString("etc") );
				System.out.println("------------------------------------------------");
			}else {
				System.out.println("대상이 없습니다.");
			}
		}catch (Exception e ) {
			System.out.println("SQLException : " + e.getMessage());
		}finally {
			DBConnect.close(con, pstmt);
		}
		//----------------------------------------------------------------------------
	}
	
	
	
	
	
}
