package ch19;

class AA extends Thread {
	public void run() {
		for (int i = 1; i<=10 ; i++) {
			System.out.println("재미있는 자바 : " + i);
		}
	}
}

public class ThreadFromThread {

	public static void main(String[] args) {
		AA a = new AA();
		a.start();
	}

}
// run () 실행하면 위 클래스 내부의 이름이 일치하는 메소드 실행시킴
// start () 는 스레드 클래스가 가지고 있는 메소드 자체를 실행시킴
