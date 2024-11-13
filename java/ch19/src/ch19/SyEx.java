package ch19;

class Counter extends Thread {
	int count = 0;
	
	 public void increment () {
		 count ++;
	 }
	 
	 public void decrement () {
		 count --;
	 }
	 
	 public int getCount () {
		 return count;
	 }
	 
	 public void run() {
		 for(int i=0; i<50; i++) {
			 try {
				 increment();
				 decrement();
				 Thread.sleep(2000);
			 }catch(Exception e) {
			 }
		 System.out.println(getCount());
		 }
	}		 
}
public class SyEx {	
	public static void main(String[] args) {
		
		Counter  cnt1 = new Counter();
		Counter  cnt2 = new Counter();
		Counter  cnt3 = new Counter();
		cnt1.start();
		cnt2.start();
		cnt3.start();

	}

}
