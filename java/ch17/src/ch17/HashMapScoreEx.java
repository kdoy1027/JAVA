package ch17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {

	public static void main(String[] args) {
		HashMap<String, Integer> javaScore = new HashMap<String, Integer>();
		
		javaScore.put("김성동", 97);
		javaScore.put("이성동", 80);
		javaScore.put("최성동", 85);
		javaScore.put("박성동", 92);
		javaScore.put("남궁성동", 54);
		
		
		System.out.println("HashMap의 요소 개수 :" + javaScore.size());
		System.out.println();
		System.out.println(javaScore);
		System.out.println();
		
		Set<String> keys =  javaScore.keySet();
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			int score = javaScore.get(name);
			System.out.println(name + ":" + score);
		}

	}

}
