package ch17;

import java.util.HashMap;
import java.util.Scanner;



class Student {
	int id;
	String tel;
	
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	
	
	public int getId() {
        return id;
    }
	
	 public String getTel() {
	        return tel;
	    }

}

public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();
		
		map.put("황기태",new Student(1, "010-111-1111"));
		map.put("김기태",new Student(2, "010-222-2222"));
		map.put("이기태",new Student(3, "010-333-3333"));
		map.put("박기태",new Student(4, "010-444-4444"));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String name = sc.nextLine();
			if(name.equals("종료")) {
				break;
			}
			Student student = map.get(name);
			if(student == null) {
				System.out.println(name + "는 없는 사람입니다.");	
			}else System.out.println("id : " + student.getId() + ", 전화" + 
				student.getTel());
		}
		sc.close();

	}

}
