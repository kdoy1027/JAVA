package ch19;

class AAA extends Thread {
	
	public AAA(String str) {
		setName(str);
	} 
	
	public void run() {
		for(int i =1 ;i<=10; i++) {
			System.out.println(i + getName());
		}
		System.out.println("끝!" + getName() + "\n");
	}
	
}

public class ThreadEx02 {

	public static void main(String[] args) {
		
		//메소드 자체를 호출 vs 스레드 메소드(.start()) 호출
		
		
		AAA a = new AAA(": 배우기 쉬운 자바!");
		a.start();
		AAA b = new AAA(": 배우기 어려운 자바");
		b.start();
		AAA c = new AAA(": 할만한 자바");
		c.start();
	}

}
