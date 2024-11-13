package this_is_java;

import java.util.Scanner;

public class Random_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 100까지의 숫자 중 하나를 입력하세요 : ");//9
        int number = sc.nextInt();

        if (number % 2 == 0) {
            number++;
        }

        int midline = number / 2; 

     
        for (int i = 0; i <= midline; i++) {
            for (int j = 0; j < midline - i; j++) {
                System.out.print(" "); 
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*"); 
            }
            System.out.println(); 
        }
        
        
        
    
        for (int i = midline-1; i >= 0; i--) {
            for (int j = 0; j < midline - i; j++) {
                System.out.print(" "); 
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*"); 
            }
            System.out.println(); 
        }

    }
}
