package ch13;

public class zzakc369 {

	//10보다 작을 경우 일의 자리 비교해서 3,6,9 포함되면 프린트
	//10 < n < 100 일의 자리 비교 , 십의 자리 비교해서 " 포함되면 프린트
	
	
	public static void main(String[] args) {
		for(int i =1; i < 100; i ++) {
			String number = Integer.toString(i);
			if(number.contains("3") || number.contains("6") || number.contains("9"))
			{
				System.out.println( number + "짝!!!");
			}
		
		}

	}

}
