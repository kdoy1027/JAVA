package ch17;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {

	
	
	public static void main(String[] args) {
		
		HashSet<Integer> odd = new HashSet<Integer>();
		HashSet<Integer> even = new HashSet<Integer>();
		for(int i =1; i<=5;i++) {
			odd.add(i);
			even.add(i+1);
		}
		
		System.out.println(odd);
		System.out.println(even);
		
		System.out.println();
		
		boolean setChanged = odd.add(999);
		System.out.println("odd에 999 추가 성공?? >> " + setChanged);
		System.out.println();
		
		setChanged = even.add(999);
		System.out.println("evend에 999 추가 성공??>>" + setChanged);
		System.out.println();
		
		System.out.println("odd 집합"  + odd);
		System.out.println("even 집함" + even);
		System.out.println();
		
		System.out.println("odd에서 가장 작은 값은 :" + Collections.min(odd));
		System.out.println("even에서 가장 작은 값은 :" + Collections.max(even));
		Iterator<Integer> it = even.iterator();
		int sum=0;
		while(it.hasNext()) {
			sum = sum + it.next();
		}
		System.out.println("even 집합의 합은 : " + sum);

	}

}
