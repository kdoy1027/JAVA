package ch17;

import java.util.HashMap;
import java.util.Scanner;

class Phone {
	private String name;
	private String number;

	public Phone(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

public class PhoneBook {

	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone> dept = new HashMap<String, Phone>();

	public void read() {
		System.out.println("저장할 이름과 전화번호를 입력하세요 ");
		for (int i = 0; i < 3; i++) {
			System.out.print("입력란  >>>");
			String name = sc.next();
			String number = sc.next();

			Phone phone = new Phone(name, number);
			dept.put(name, phone);
		}
		System.out.println("저장되었습니다...");
	}

	private void requestP() {
		while (true) {
			System.out.println("이름 >>>");
			String name = sc.next();
			Phone phone = dept.get(name);
			if (phone == null) {
				System.out.println(name + " 학생은 없습니다");
			} else if (phone.getName().equals(name)) {
				System.out.print(phone.getName() + " , ");
				System.out.print(phone.getNumber() + " , ");
				break;
			}
		}
	}

	public void run() {
		read();
		requestP();
	}

	public static void main(String[] args) {

		PhoneBook pb = new PhoneBook();
		pb.run();

	}

}
