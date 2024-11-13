package ch04;


//얘는 엄밀히 말하자면 오버라이딩이 아니라 오버로딩 (show()메소드 안에 인자의 개수와 타입이 다르기 때문.)
class OIa {
	public void show (String str) {
		System.out.println("상위 클래스의 메소드 show(String str) 수행 =>>>" +" "+ str);
	}
}

class OIb extends OIa {
	public void show() {
		System.out.println("하위 클래스의 메소드 show() 수행");
	}
}


public class OverridingTest1 {

	public static void main(String[] args) {
		OIb oib =new OIb();
		oib.show("처음 시작하는 자바");
		oib.show();
	}
}


