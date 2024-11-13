package this_is_java;

public class Television implements RemoteControl{
	
	
	//인터페이스에 선언된 추상메소드들은 모두 빠짐없이 구현 클래스에서 선언되더야 한다. 
	
	
	@Override
	public void turnOn() {
		System.out.println("turn on TV");
		
	}

	
}
