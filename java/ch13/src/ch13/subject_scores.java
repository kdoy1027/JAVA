package ch13;

import java.util.Scanner;

public class subject_scores {

	public static void main(String[] args) {
		String course [] = {"java", "C++" , "HTML5", "컴퓨터구조" , "안드로이드"};
		int score [] = {95,88,76,62,55};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수강 과목을 입력하세요 : ");
		String subject = sc.next();
		
		boolean check = false;
		
		for (int i = 0; i<5; i++) {
			if (subject.equals(course[i])) {
				int index = i;
			System.out.println(subject + "의 점수는" + score[index]);
			check = true;
			break;
			}
		
		
		}
		if (check != true) {
			System.out.println("일치하는 과목이 없습니다.");
			}
	}
}
