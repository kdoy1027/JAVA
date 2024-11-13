package ch01;

import java.util.Scanner;

public class ReservedWordTest {

	public static void main(String[] args) {
//		byte a = 128;
//		
//		System.out.println("128을 저장한 byte값은 : " + a);
		
		
//		byte a = (byte)128;  // <=   강제형 변환
//		System.out.println("128을 저장한 byte값은 : " + a);
//		byte b = (byte)256;
//		System.out.println("128을 저장한 byte값은 : " + b);
		
		
//		System.out.println('\"');
		
		
//		double f = 3.14d;
//		System.out.println(f);
		
		
		
//		char ch1 = 'A';
//		String name = "홍길동";
//		
//		System.out.printf("%c\n",'A');
//		System.out.printf("%s\n","AB");
//		System.out.printf("%s\n", "AB CCCCC");
//		System.out.printf("%씨 %s\n%s\n",name, "재미있는 자바 언어", "열심히하세요");
//		
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("첫번째 정수를 입력");
//		int first = stdin.nextInt(3);
//		System.out.print("두번째 정수를 입력");
//		int second = stdin.nextInt(6);
//		double avg1 = (first+second);
//		System.out.println("정수 연산: 평균은("+first+"+"+second+")/2 = "+avg1+" 입니다.");
//		double avg2 = (first+second) / 2.0;
//		System.out.println("실수 연산: 평균은("+first+"+"+second+")/2 =  "+avg2+" 입니다.");
		
		
//		int a = 10;
//		System.out.println("a=" + a);
//		
//		a += 4;
//		System.out.println("a += 4의 결과" + a);
//		
//		a %= 4; 
//		System.out.println("a %=4의 결과" + a);
//		
//		a <<= 4;
//		System.out.println("a<<=4의 결과" + a);
//		
//		boolean b = false;
//		
//		b &= a > 2;
//		System.out.println("b &= a > 2의 결과" + b);
//		
//		b |= a>2;
//		System.out.println("b |= a>2의 결과" + b);
//		
		
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("한 개의 숫자를 입력 : ");
		int a = stdin.nextInt(10);
		boolean flag;
		flag = (a%2 == 0) ? true : false;
		System.out.println(a + "이(가) 짝수입니까? : ");
		System.out.println(flag);
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
