package ch20;

import java.net.InetAddress;

public class AddressTest1 {

	public static void main(String[] args) throws Exception {
//		InetAddress ia = InetAddress.getLocalHost();
		
//		System.out.println("로컬 컴퓨터의 이름 : " + ia.getHostName());
//		
//		System.out.println("로컬 컴퓨터의 IP 주소 : " + ia.getHostAddress());
//		
//		System.out.println("로컬 컴퓨터의 IP 주소 : " + ia.getHostAddress());
		
		
		InetAddress ib[] = InetAddress.getAllByName("www.naver.com");
		for(int i = 0 ; i < ib.length; i ++) {
			System.out.println("네이버의 공공 ip 주소는  " + ib[i]);
		}
		

	}

}