package ch17;


// set   >>> 순서 , 중복 완전 노상관 ㅇㅇ



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("사과");
		set.add("배");
		set.add("키위");
		set.add("사과"); // 배,사과,키위, 3가지만 출력 => 값의 중복을 허용하지 않음
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) { // while 문 사용함. => 범위 정해져있지 않기 때문.
			System.out.print(it.next() + ",");
		}
		
		System.out.println();
		System.out.println("set.toString() >>>" + set.toString());
		System.out.println("set >>>" + set);
		
		//배열에 해당하는 값이 있느지 판단하는 메소드 .contains() 값은 T/F
		System.out.println(".contains()  >>>>>  " + set.contains("사과"));

//		set.clear();
		
		System.out.println("clear()메소드로 내부 요소 삭제 >>>" + set);
		
		// 배열 내부에 값이 있는지 없는지 판단 >> T/F
		System.out.println("set.isEmpty() >>>>" + set.isEmpty());
		System.out.println("set.size() >>>>" + set.size());
	}

}
