package scoreMangement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SungjukInsert sungjukin = new SungjukInsert();
		Delete del = new Delete();
		SelectList selectlist = new SelectList();
		SelectOne selectone = new SelectOne();
		Update up = new Update();
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		while(true) {
			System.out.println("--------메뉴--------");
			System.out.println("1. 데이터 입력    -----");
			System.out.println("2. 데이터 1건 출력 -----");
			System.out.println("3. 데이터 목록 출력 -----");
			System.out.println("4. 데이터 수정     -----");
			System.out.println("5. 데이터 삭제     -----");
			System.out.println("0. 종료          -----");
			System.out.println("-----------------------");
			System.out.println(">>> 선택 : >>>");
			
			i = sc.nextInt();
			switch (i) {
			case  1 :
				sungjukin.SungjukInsert();
				break;
			case 2 : 
				selectone.SelectOne();
				break;
			case 3 : 
				selectlist.SelectList();
				break;
			case 4 :
				up.Update();
			case 5 :
				del.Delete();
				break;
			}
			if(i==0) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

}
