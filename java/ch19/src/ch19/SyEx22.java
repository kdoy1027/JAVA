package ch19;

class Counter2 {
	private int value = 0;
	public  synchronized void increment() {
		value++;
	}
	public synchronized void decrement() {
		value--;
	} 
	public synchronized void printCounter() {
		System.out.println(value);
	}
}


class MyThread02 extends Thread{
	Counter2 c2;
	
	public MyThread02 (Counter2 c) {
		this.c2 = c;
	}
	
	public void run() {
		int i =0;
		while (i <2000) {
			c2.increment();
			c2.decrement();
			if(i % 40 == 0) {
				c2.printCounter();
			}
			try {
				Thread.sleep((int)(Math.random()*2 ));
			}catch (Exception e ) {
			}
			i++;
		}
	}
}



public class SyEx22 {

	public static void main(String[] args) {
		Counter2 c= new Counter2();
		MyThread02 a1 = new MyThread02(c);
		MyThread02 a2 = new MyThread02(c);
		MyThread02 a3 = new MyThread02(c);
		MyThread02 a4 = new MyThread02(c);
		
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}

}
