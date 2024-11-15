
package ch17;

import java.util.Scanner;
import java.util.Vector;


//입력한 숫자 확인
//입력받은 모든 숫자 출력
//숫자 합계 구하기
//평균 구하기

public class PrecipitationManagement {
	Vector<Integer> v = new Vector<Integer>();
	Scanner sc = new Scanner(System.in);

	// 강수량 입력받고, Precipitation 클래스에 저장 및 v 엥 저장하는 메소드
	public void read() {
	    
	    while (true) {

	        System.out.println("강수량 입력(0 입력 시 종료합니다) >>> ");
	        int water = sc.nextInt();
	
	        if (water == 0) {
	            break;
	        } else if (water > 0) {
	 
	            System.out.println("입력한 강수량 : " + water);
	            v.add(water); 
	            
	            for (int i =0; i<v.size(); i++) {
	                System.out.println("현재까지 v에 저장된 값들 : " + v.get(i));
	            }
	            int sum =+ water;
	            System.out.println("지금까지 내린 강수량의 합계는 : "+ sum);
	             int avg = (int) sum / v.size();  
	             System.out.println("현재까지의 평균 강수량: " + avg );
	            
	             
	            
	        }
	    }
	}


	// 동작 명령 메소드
	public void run() {
		read();
	}

	public static void main(String[] args) {
		PrecipitationManagement ob = new PrecipitationManagement();
		ob.run();
	
	}

}
