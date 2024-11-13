package ch04;

class Rectangle5 {
	public int width;
	public int height;
	public Rectangle5(int w, int h) {
		width = w;
		height = h;
	}
	public int computeRectangleAarea() {
		return width * height;
	}
		
}

class Cube5 extends Rectangle5 {
	public int depth;
	public Cube5(int w, int h, int d) {
		super(w,h);
		depth = d;
	}
	public int computeCubeArea() {
		return super.computeRectangleAarea() * depth;
	}
}


public class CastTest2 {

	public static void main(String[] args) {
		Rectangle5 r = new Cube5(10,20,30);
		System.out.println("정사각형의 넓이는 : " + r.computeRectangleAarea());
		
//		System.out.println("직육면체의 부피는 : " + c.computeCubeArea());
		// 상위 객체 내부에 Cube5를 복제한 객체 r를 생성했기 때문에 Cube5 객체 내 메소드에 직접적으로 접근할 수 없음.  
		Cube5 c = (Cube5) r;
		System.out.println("직육면체의 부피는 : " + c.computeCubeArea());
		
		
		

	}

}
