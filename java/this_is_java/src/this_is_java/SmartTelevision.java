package this_is_java;

public class SmartTelevision implements Searchable , RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("tv on");
		
		
	}

	@Override
	public void turnOff() {
		System.out.println("tv off");
		
	}

	@Override
	public void search(String url) {
		System.out.println( url + "검색 중");
		
	}

}
