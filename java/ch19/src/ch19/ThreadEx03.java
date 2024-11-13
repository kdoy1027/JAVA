package ch19;

class BBB implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			System.out.println("재미있는 자바 : " + i);
		}
		
	}
}

public class ThreadEx03 {

	public static void main(String[] args) {
		BBB b = new BBB();
		//인터페이스를 이용하여 스레드 구현할 때는 직접 객체로 만들어 접근하지 못하고,
		// 별도의 클래스 객체를 만든 뒤  => 그 객체를 스레드 객체의 인자로 받아서 접근 가능함.
		Thread t = new Thread(b);
		t.start();

	}

}
