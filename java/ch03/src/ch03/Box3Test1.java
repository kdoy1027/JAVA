package ch03;




class Box3 {
	int width;
	int height;    
	int depth;
	long idNum;
	static long boxID = 0;  // static으로 설정한 속성(클래스 변수)은 객체를 복사할 때 다른 속성들과 함께 복사되는 것이 아니라
	public Box3() {         // 별도의 주소로 구별되어 복사한 객체들의 속성이 변화할 때마다 해당 주소의 값이 변화함.
		idNum = ++boxID;
	}
}


// 예를 들어 Box3 복사되면 idNum를 제외한 속성들은 모두 복사되어 새로운 객체 mybox1로 새롭게 만들어지지만,
// '생성자 메소드'인 static long boxID = 0; 으로 설정한 idNum은 복사되지 않고 
//  자신의 고유한 주소를 가진 채로 새로운 객체가 복사되어 생성될 때 메소드에 의해 값만 변화함. 

public class Box3Test1 {

	public static void main(String[] args) {
	
		Box3 mybox1 = new Box3();
		Box3 mybox2 = new Box3();
		Box3 mybox3 = new Box3();
		Box3 mybox4 = new Box3();
		
		System.out.println("mybox1의 id 번호 : " + mybox1.idNum);
		System.out.println("mybox2의 id 번호 : " + mybox2.idNum);
		System.out.println("mybox3의 id 번호 : " + mybox3.idNum);
		System.out.println("mybox4의 id 번호 : " + mybox4.idNum);
		System.out.println("마지막 생성된 박스 번호는 : " + Box3.boxID + "번입니다");
		
		
	
	}

}
