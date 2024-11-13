package this_is_java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Comparision {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		// 각 Set에 요소 추가
		for (int i = 5; i > 0; i--) {
		    hashSet.add(i);
		    linkedHashSet.add(i);
		    treeSet.add(i);
		}

		// 출력하여 순서 비교
		System.out.println("HashSet: " + hashSet);
		System.out.println("LinkedHashSet: " + linkedHashSet);
		System.out.println("TreeSet: " + treeSet);

	}

}
