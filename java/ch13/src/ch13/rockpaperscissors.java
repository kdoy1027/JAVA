package ch13;

import java.util.Scanner;

public class rockpaperscissors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위바위보 게임이니다. 가위, 바위, 보 중에서 입력하세요.");
		System.out.print("철수는");
		String chulsu = scanner.next();
		System.out.print("영희는");
		String younghyee = scanner.next();
		
		
		// [가위, 바위, 보]  
		// 문자열 비교애서 같으면 draw , 
		// 다른 경우 : 묵 > 가위 , 묵 < 보 / 가위 > 보 , 가위 < 묵, 보 > 묵 , 보 < 가위
		if (chulsu.equals("가위")) {
			if(younghyee.equals("가위")) {
				System.out.println("비겼습니다");}
			else if (younghyee.equals("보")) { 
				System.out.println("철수 승");}
			else if (younghyee.equals("바위")) { 
				System.out.println("영희 승");}
			}
		else if (chulsu.equals("바위")) {
			
		}
			
	}
}
			


