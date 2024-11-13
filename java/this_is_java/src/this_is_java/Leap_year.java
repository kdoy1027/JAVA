package this_is_java;
import java.util.Scanner;
public class Leap_year {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("연도를 입력하시오  :  ");
		int year = stdin.nextInt();
		if(year % 4 == 0 && (year % 100) >= 1 || (year % 400) ==0) {
			System.out.println("윤년입니다. : 0");
		}else System.out.println("윤년이 아닙니다.");
	}

}
