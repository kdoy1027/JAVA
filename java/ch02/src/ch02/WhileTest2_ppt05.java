package ch02;
import java.util.Scanner;
public class WhileTest2_ppt05 {

	public static void main(String[] args) 
	{
//		int hap = 0, count = 1;
//		while (count <= 10);
//		{
//			hap = hap + count;
//			count = count + 1;
//		
//		}
//		
//		System.out.println("1부터 10 까지의 합은 " + hap + "입니다.");
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("원하는 단을 입력하세요 : ");
//		int dan = sc.nextInt();
//		int x = 1;
//		while (x<=dan);
//			{
//				System.out.println(dan + "*" + x + "=" + dan*x);
//				x++;
//			}
		
//		int hap = 0, count = 1;
//		do 
//		{
//			hap = hap + count;
//			count = count + 1;
//		} while (count <= 10);
//		System.out.println("1부터 10까지의 합은 " +hap +"입니다.");
		
		
		
		
//		Scanner stdin = new Scanner(System.in);
//		int month;
//		do {
//			System.out.println("월을 입력하세요(끝 : 0) ");
//			month = stdin.nextInt();
//			if(3<=month && month <=5)
//				System.out.println("봄 입니다.");
//			else if(6<=month && month <=8)
//				System.out.println("여름 입니다.");
//			else if(9<=month && month <=11)
//				System.out.println("가을 입니다.");
//			else if(1 ==month || 2 == month || 12 == month)
//				System.out.println("겨울 입니다.");
//			else if(month !=0)
//				System.out.println("잘못된 입력 : 해당하는 계절이 없습니다.");
//		} while (month != 0);
//		System.out.println("감사합니당.");
		
		
		
		//FOR문 - 1~10합
//		int i, sum=0;
//		for(i=1; i<=10;i++)
//		{
//			sum = sum+i;
//		}
//		System.out.println("1부터 10까지의 합은" + sum + "입니다.");
		
		
		
		// FOR문 - 입력한 값의 약수 구하는 법
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int num = stdin.nextInt();
//		System.out.print( num +"의 약수 : ");
//		for (int i=1; i<=num ; i++)
//		{
//			if(num %i ==0)
//				System.out.print(i+ ",");
//		}
		
		
		
		
		//1~9단 구구단 출력 (for + while)
//		int i = 2;
//		while (i <= 9)
//		{
//			System.out.println("*** " + i + "단 ***");
//			for (int j = 1; j <=9; j++)
//			{
//				System.out.println((i+ "*"+j+"=" +i*j));
//				
//			}
//			System.out.println();
//			i++;
//		}
//		
		
		
		
		//별짓기 (WHILE문)
//	Scanner stdin = new Scanner(System.in);
//	System.out.print("원하는 숫자를 입력하세요 : ");
//		int num = stdin.nextInt();
//		int i=1;
//		while(i <= num)
//		{
//			int j =1;
//			while (j <=i)
//			{
//			System.out.print("*");
//				j++;
//			}
//		System.out.print("\n");
//		i++;
//		}
		
		
		//별짓기(WHILE문+FOR문)
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("원하는 숫자를 입력하세요 : ");
//			int num = stdin.nextInt();
//			int i=1;
//			while(i <= num)
//			{
//				
//				for (int j = 1; j <= i; j++)
//				{
//				System.out.print("*");
//				}
//			System.out.print("\n");
//			i++;
//			}
			
			
		//별짓기(FOR문)
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("원하는 숫자를 입력하세요 : ");
//			int num = stdin.nextInt();
//			
//			for(int i =1; i<=num; i++)
//			{		
//				for (int j = 1; j <= i; j++)
//				{
//				System.out.print("*");
//				}
//			System.out.print("\n");
//		}	
		
	

	// 입력받은 숫자까지의 합 구하기
//	Scanner stdin = new Scanner(System.in);
//	System.out.print("합계를 원하는 정수를 입력하세요 : ");
//	int num = stdin.nextInt();
//	int sum = 0, i = 1;
//	while (true) {
//		sum = sum + i;
//		if (i==num) break;
//		i++;
//	}
//	System.out.println(num +"까지의 합계는 =" + sum);
		
		
		
		
	//특정 숫자를 넘어가면...별짓기 패턴 stop
//	int i,j;
//	for(i=1; i<10; i++)
//	{
//		for(j=1; j<i; j++)
//		{
//			if(j>3)break;
//			System.out.print("*");
//		}
//		System.out.println();
//	}

	
		// continue문 (입력한 정수까지 숫자들 중 짝수의 합 구하기)
//	Scanner stdin = new Scanner(System.in);
//	System.out.print("원하는 정수 입력 (짝수의 합) : ");
//	int num = stdin.nextInt();
//	int i , sum = 0;
//	for (i=1; i<=num;i++) {
//		if(i%2 ==1) continue;
//		sum = sum + i;
//	}
//	System.out.println("1부터" + num + "까지 합수의 합 =" + sum);
	

	
		
	
	
	}

}
