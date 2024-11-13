package ch19;


class AutoSaveThraed extends Thread {
	public void save () {
		System.out.println("작업 내용을 저장합니다.");
	}
	
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
			save();
		}
	};
}



public class DaemonEx {

	public static void main(String[] args) {
		AutoSaveThraed a =new AutoSaveThraed();
		a.setDaemon(true);
		a.start();
		
		try {
			Thread.sleep(3000);
		}catch ( Exception e ) {
			
		}
		System.out.println("메인 스레드 종료");

	}

}
