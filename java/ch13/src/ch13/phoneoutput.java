package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class phoneoutput {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("C:/temp/phone.txt");
			in = new InputStreamReader(fin, "utf-8");
			int c;
			
			System.out.println("C:/temp/phone.txt를 출력합니다." + in.getEncoding());
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
