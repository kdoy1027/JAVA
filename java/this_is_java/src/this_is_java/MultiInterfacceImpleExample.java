package this_is_java;

public class MultiInterfacceImpleExample {

	public static void main(String[] args) {
		
		//인터페이스 변수에 구현 객체 대입
		RemoteControl rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		
		Searchable sa = new SmartTelevision();
		String url = "http://localhost:3306";
		sa.search(url);
	}

}
