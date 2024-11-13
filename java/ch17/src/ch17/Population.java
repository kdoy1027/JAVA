package ch17;
import java.util.HashMap;
import java.util.Scanner;

public class Population {

	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		

		while(true) {
			System.out.println("인구 검색 (나라 이름, 인구수) >>>>");
			
			String nation = sc.next();
			if(nation.equals("그만")) {
				break;
			}
			int population = sc.nextInt();
			
		}
		
		while(true) {
			System.out.print("인구 검색할 나라는 >>>");
			String nation = sc.next();
			if(nation.equals("그만")) {
				break;
			}
			Integer n = nations.get(nation);
			if(n == null) {
				System.out.println(nation + " 은 찾을 수 없는 나라입니다.");
			} else {System.out.println(nation + " 의 인구수는 " + n);}
		}
			
			
			
			
			
			
			
		
			
			
		}
		
	}


