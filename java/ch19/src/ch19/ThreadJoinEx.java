package ch19;


class MyThread2 extends Thread {
	public void run() {
		for(int i = 0 ; i<5; i++ ) {
			System.out.println("MyThread2 : " + i);
			try {
				Thread.sleep(1000);
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadJoinEx {

	public static void main(String[] args) {
		MyThread2 t2 = new MyThread2();
		t2.start();
		System.out.println("thread 종료까지 대기");
		try {
			t2.join();
		}catch (Exception e){
			
		}
		System.out.println("thread 종료");

	}
}
