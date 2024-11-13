package ch04;

class C1 {
	private static int x = 100;
	public static int y = x;
	static int z=x;
	public static int cc() {return x;}
}

class C2 extends C1 {
	public static String x;
	static int y;
}


public class InheritanceTest3 {

	public static void main(String[] args) {
		System.out.println("클래스 메소드 C1.cc()의 값은 : " + C1.cc());
		System.out.println("클래스 변수 C1.y의 값은 : " + C1.y);
		System.out.println("클래스 변수 C1.z의 값은 : " + C1.z);
		System.out.println("클래스 변수 C2.x의 값은 : " + C2.x);
		System.out.println("클래스 변수 C2.y의 값은 : " + C2.y);
		System.out.println("클래스 변수 C2.z의 값은 : " + C2.z);
		System.out.println("클래스 메소드 C2.cc()의 값은 : " + C2.cc());
		C2.x = "처음 시작하는 자바";
		C2.y = 200;
		C1.z = 300;
		System.out.println("클래스 변수 C2.x의 값은 : " + C2.x);
		System.out.println("클래스 변수 C2.y의 값은 : " + C2.y);
		System.out.println("클래스 변수 C2.z의 값은 : " + C2.z);
		
	}

}
