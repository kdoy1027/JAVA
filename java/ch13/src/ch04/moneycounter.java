package ch04;


import java.util.Scanner;



public class moneycounter {
   public static void main(String[] args) {
      int [] unit = {50000, 10000, 5000, 1000, 5000, 1000, 50,10, 1};
      Scanner sc = new Scanner(System.in);
      System.out.println("금액을 입력 하세요 >> ");
      int money = sc.nextInt();
      
      for(int i=0; i< unit.length; i++) {
         int res = money / unit[i];
         if(res > 0) {
            System.out.println(unit[i]+"원 짜리 : " + res + "개");
            money = money%unit[i];
         }
      }
   }

}
