package ch03;


class Cons1 {
	
	//묵시적 생성자 또는 default 생성자
	public Cons1() {
		System.out.println("생성자입니다잉");  //생성될 때 자동 생성! / 생성된 객체의 초기값이 없다면 없어도 무방.
	}
	
	
	
	public Cons1(String a, int b) {
		
	}
	public int num;
}


public class ConTest1 {

	public static void main(String[] args) {
		
		Cons1 co = new Cons1();
		Cons1 cons = new Cons1("첫 번째" , 5);

	}

}
