package ch19;

public class ThreadSyncEx {

	public static void main(String[] args) {
			Runnable thread = new CreateThread();
			Thread t1 = new Thread(thread);
			Thread t2 = new Thread(thread);
			t1.setName("스레드 1");
			t2.setName("스레드 2");
			t1.start();
			t2.start();
	}
}

class Money {
	// 현재 가지고 있는 금액
	private int MyMoney = 10000;
	public int getMyMoney () {
		return MyMoney;
	}
	
	public synchronized boolean withdraw (int money) {
		if(MyMoney >= money) {
			
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				System.out.println(e);
			}
			//출금
			MyMoney -= money;
			return true;
		} 
		return false;
	}
}

class CreateThread implements Runnable {
	Money myMoney = new Money();
	
	@Override
	public void run() {
		while(myMoney.getMyMoney() > 0) {
			//천원에서 오천원 사이 값을 출금
			int money = (int)(Math.random() * 5 + 1) * 1000;
			
			
			// 출금 실행코드 실패하면 true 반환
			boolean denied = !myMoney.withdraw(money);
			
			//출금 과정 출력
			if(denied) {
				System.out.println("출금 거부");
			}else {
				System.out.printf("스레드 : %s 출금 : %d원 남은 금액 : %d원 \n" ,
						Thread.currentThread().getName(), money, myMoney.getMyMoney());
			}
		}
		
	}
	
	
	
}









