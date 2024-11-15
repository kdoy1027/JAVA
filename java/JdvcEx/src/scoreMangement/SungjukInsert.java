package scoreMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class SungjukInsert {

	public void  SungjukInsert() 
	{
		
		String name = "";
		int kuk = 0;
		int eng = 0;
		int mat = 0;
		int tot = 0;
		int avg = 0;
		String etc = "";
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3= new Scanner(System.in);
		
		
		//=========================================================
		System.out.println("이름을 입력하세요 : >>");
		name = sc.nextLine();
		
		System.out.println("국어 점수를 입력하세요 : >>");
		kuk = sc2.nextInt();
		
		System.out.println("영어 점수를 입력하세요 : >>");
		eng = sc2.nextInt();
		
		System.out.println("수학 점수를 입력하세요 : >>");
		mat = sc2.nextInt();
		
		System.out.println("기타 : ");
		etc = sc3.nextLine();
//		tot = kuk + eng + mat;
//		avg = tot / 3;
		
		//==========================================================
		
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		
		try {
			// DB 연동
			con = DBConnect.getConnection();
			String sql = "INSERT INTO sungjuk ";
			sql = sql + " VALUES(?,?,?,?, kuk + eng + mat, (tot)/3, ?)";
			
			// 쿼리 지정
			pstmt = con.prepareStatement(sql);
			
			// (물음표의 순번 , 적용할 값) 설정 
			pstmt.setString(1, name);
			pstmt.setInt(2, kuk);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setString(5, etc);
			//pstmt.setInt(4, tot);
			//pstmt.setInt(5, avg);
			
			// 레코드 추가 후 1을 ret에 저장
			int ret = pstmt.executeUpdate();
			if(ret < 1) {
				System.out.println("추가되지 않았습니다.");
			} else {
				System.out.println("레코드" + ret + "개가 추가되었습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("SQLException" + e.getMessage());
		}finally {
			DBConnect.close(con, pstmt);
		};
		//====================================================================
	}

	
	//========================================================================
	
	
}
