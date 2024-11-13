package this_is_java;
import java.util.Scanner;


class Ramyon {
	String ramyon = "라면";
	String water = "물";
	String onion = "양파";
	void boilwater() {
		System.out.println("라면 조리 시작");
		System.out.println(water + "을 끓인다.");
	}
	void cooking() {
		System.out.println(ramyon + ", " +onion + " 넣고 조리하여 라면 완성!.");
	}
}


class RiceRamyon extends Ramyon {
	String topp="떡";
	void topping() {
		System.out.println(topp + "을 넣는다.");
	}
}


class CheeseRamyon extends Ramyon {
	String topp="치즈";
	void topping() {
		System.out.println(topp + "을(를) 넣는다.");
	}
}


public class Make_raman {

	public static void main(String[] args) {
		int s;
		do {
			System.out.println("만들고 싶은 라면을 입력하세용(1:일반라면 2:떡라면 3:치즈라면 99:종료) : ");
			Scanner stdin = new Scanner(System.in);
			s = stdin.nextInt();
			if (s == 1) {
				Ramyon r = new Ramyon();
				r.boilwater();
				r.cooking();
			} else if (s == 2) {
				RiceRamyon rr = new RiceRamyon();
				rr.boilwater();
				rr.topping();
				rr.cooking();
			
			} else if ( s == 3) {
				CheeseRamyon cr = new CheeseRamyon();
				cr.boilwater();
				cr.topping();
				cr.cooking();
				
			}
		} while (s != 99);
			System.out.print("안녕히 가세요");
		

	}

}
