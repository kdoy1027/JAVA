package this_is_java;

import java.util.Scanner;

public class counter22 {

	public static void main(String[] args) {
		
		int [] unit = {50000,10000,1000,500,100,50,10,1};
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		for(int i=0; i<unit.length; i++) {
		int remain = number / unit[i];
		
		if (remain >= 0) {
			System.out.println(unit[i] + "원 짜리 : " + remain + "개");
			}
		}
	}
}
