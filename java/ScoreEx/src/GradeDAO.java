//인터페이스의 틀 만들기

// * 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성



import java.util.ArrayList;
public interface GradeDAO {

	public abstract int insert(GradeVO vo);
	
	public abstract ArrayList<GradeVO> select();
	
	public abstract GradeVO select(int studentId);
	
	public abstract int update(int studentId, GradeVO vo);
	
	public abstract int delete(int studentId);
	
}
