package ch04;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("입력을 원하는 숫자를 작성하세요(1~9) : ");
		int dan = stdin.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
	}
}
