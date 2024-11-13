package this_is_java;

public class RemoteControlExample {

	public static void main(String[] args) {
	RemoteControl rc = null; // 변수 초기화
	Television tv = new Television();
	rc = tv;
	rc.turnOn();
	
	
//	rc = new Television();

	}

}
