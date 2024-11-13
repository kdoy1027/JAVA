package ch04;

abstract class Shape {
	abstract void draw();
	abstract void computeArea(double a, double b);
}

class Rectangle1 extends Shape {

	@Override // "어노테이션" = 오버라이드 주석
	void draw() {
		System.out.println("사각형을 그리는 기능");
		
	}

	@Override
	void computeArea(double h, double v) {
		System.out.println("사각형의 넓이 : " + (h * v));
	}
}

class Triangle1 extends Shape {

	@Override
	void draw() {
		System.out.println("삼각형을 그리는 기능");
		
	}

	@Override
	void computeArea(double a, double h) {
		System.out.println("삼각형의 넓이 : " + (a * h)/2);
	}
	
}

public class AbstractTest1 {

	public static void main(String[] args) {
		System.out.println("=====추상 메소드를 이용한 다형성=====");
		Shape s = new Rectangle1(); // Rectangle1 클래스의 인스턴스를 생성하고, 그 인스턴스를 Shape 타입의 변수 s에 할당
		s.draw();					// 즉, s는 Shape 타입의 참조 변수이지만, 실제로는 Rectangle1 객체를 가리킵니다. 
		s.computeArea(5.0, 10.0);
		s = new Triangle1(); //부모 객체로부터 상속받은 Triangle1 클래스의 메소드를 접근하기 위함.
		s.draw();
		s.computeArea(5.0 , 10.0);

	}

}
