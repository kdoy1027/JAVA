package scoreMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

	public void Update() {
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
		System.out.println("수정할 이름을 입력하세요 : >>");
		name = sc.nextLine();
		
		System.out.println("변경할 국어 점수 : >>");
		kuk = sc2.nextInt();
		
		System.out.println("변경할 영어 점수 : >>");
		eng = sc2.nextInt();
		
		System.out.println("변경할 수학 점수 : >>");
		mat = sc2.nextInt();
		
		System.out.println("변경할 기타 점수 : ");
		etc = sc3.nextLine();
//		tot = kuk + eng + mat;
//		avg = tot / 3;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnect.getConnection();
			String sql = " UPDATE sungjuk SET kuk=?, eng=?, mat=?, tot= kuk + eng + mat, avg =(tot/3), etc=?";
			sql = sql + " WHERE name=?";
			
			//쿼리 지정
			
			pstmt = con.prepareStatement(sql);
			

			pstmt.setInt(1, kuk);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setString(4, etc);
			pstmt.setString(1, name);
		
			
			int ret = pstmt.executeUpdate();
			if(ret < 1) {
				System.err.println("수정할 대상이 없습니다.");
			}else {
				System.out.println("레코드" + ret + "개가 수정되었습니다." );
			}
			
		} catch (Exception e) {
			System.out.println("SQLExcepion : " + e.getMessage());
		}finally {
			DBConnect.close(con, pstmt);
		}
		//-------------------------------------------------------------------
	}

	

}
