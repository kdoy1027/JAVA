package this_is_java;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("1~100까지의 숫자 중 아무 숫자나 입력하세요");
		int N = stdin.nextInt();
		if(N <= 0 || N > 100) {
			System.out.println("1~100까지의 숫자만 입력하세요.");
			return;
		}
		for(int i = 1; i < N; i++) {
			for(int j = 1; j <= (N - i)-1; j++) {
				System.out.print(" ");}
			
			//13579
			for(int k = 1; k <= ((2 * i) - 1); k++) {
				System.out.print("*");
			}
			
			System.out.println("\n");
		} 
	}
}
