package this_is_java;

public interface RemoteControl {
	// 추상 메소드 : 현재 인터페이스로 사용 가능한 메소드 등을 표현함
	// 실제 메소드가 사용되는 곳은 구현 클래스임.
	// 인터페이스에서 선언된 모든 추상 메소드는 구현 클래스에서 사용될 때 하나도 빠짐 없이
	// 모두 작성되어야 한다.
	public void turnOn();
	public void turnOff();
	
}
