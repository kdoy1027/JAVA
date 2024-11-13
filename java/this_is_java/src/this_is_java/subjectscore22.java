package this_is_java;

import java.util.Scanner;

public class subjectscore22 {

	public static void main(String[] args) {
		String course[] = {"java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score [] = {95,88,76,62,55};
		Scanner sc = new Scanner(System.in);
		System.out.println("과목 이름 ('그만' 입력 시 종료) >>>");
		
		while (true) {
            String subject = sc.next(); 
            if (subject.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean arrcheck = false; 


            for (int i = 0; i < course.length; i++) {
                if (subject.equals(course[i])) {
                	int index = i;
                    System.out.println(subject + "의 점수는 " + score[index]);
                    arrcheck = true;  ;
                    break;  
                }
            }

            // 과목이 없으면 해당 과목이 없다는 메시지 출력
            if (arrcheck == false) {
                System.out.println("해당 과목이 존재하지 않습니다.");
            }
        }

        sc.close();  // Scanner 객체 닫기
    }
}
