

package ch04;

class Item {
	public int price;
}

class Noodle extends Item {
	public Noodle() {
		price = 2500;
	}
	public String toString() {return "국수";}
}

class Mixnoodle extends Item {
	public Mixnoodle() {
		price = 3000;
	}
	public String toString() {return "비빔국수";}
}

class Wodong extends Item {
	public Wodong () {
		price = 2500;
	}
	public String toString() {return "우동";}
}

class Buyer {
	private int money;
	public Buyer (int money) {
		this.money = money; // 받은 매개변수와 객체변수를 구분하기 위한 this 사용
	}
	public void buy(Item it, int count) {
		System.out.println(it + "을(를) " + count + "개 맛있게 먹었습니다.");
		money = money - it.price * count;
		System.out.println("현재 남은 돈은 " + money + "원 입니다.");
	}
	
	
//	public void buy(Noodle it, int count) {
//		System.out.println(it + "을(를) " + count + "개 맛있게 먹었습니다.");
//		money = money - it.price * count;
//		System.out.println("현재 남은 돈은 " + money + "원 입니다.");
//	}
}

public class PolymorphismTest2 {

	public static void main(String[] args) {
		
		Buyer me = new Buyer(20000);  // 클래스에 접근하기 위해 객체 생성
		me.buy(new Wodong(), 2);
		me.buy(new Mixnoodle(), 2);
		me.buy(new Noodle(), 2);
	}

}
