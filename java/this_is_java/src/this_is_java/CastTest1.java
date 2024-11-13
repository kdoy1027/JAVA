package this_is_java;

class Rectangle4 {
	public int width;
	public int height;
	public Rectangle4(int w, int h) {
		width = w;
		height = h;
	}
	
	public int computeRectangleAarea() {
		return width * height;
	}
}


class Cube4 extends Rectangle4 {
	public int depth;
	public Cube4(int w, int h, int d) {
		super(w,h);
		depth = d;
	}
	public int computeCubeArea() {
		return super.computeRectangleAarea() * depth;
	}
}

public class CastTest1 {

	public static void main(String[] args) {
		Rectangle4 r = new Cube4(10,20,30);
		System.out.println("넓이는 :" + r.computeRectangleAarea());
		

	}

}
