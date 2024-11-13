package ch04;


//overriding =>> inheritance 관계에서만 해당함.

class OIaa {
	public void show (String str) {
		System.out.println("상위 클래스의 메소드 show(String str) 수행 =>>>" +" "+ str);
	}
}

class OIbb extends OIaa {
	public void show(String s) {
		System.out.println("하위 클래스의 메소드 show() 수행 ===> " + " " + s);
	}
}

public class OverridingTest2 {

	public static void main(String[] args) {
		OIbb oibb = new OIbb();
		oibb.show("so easy JAVA Programing!!!");

	}

}
