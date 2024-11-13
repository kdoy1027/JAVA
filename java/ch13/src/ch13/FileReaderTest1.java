package ch13;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderTest1 {

	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(System.in);
		System.out.println("읽어낼 파일명을 입력하세용 : ");
		String g = stdin.next();
		FileReader fr = new FileReader(g);
		int i;
		
		while ((i = fr.read()) != -1) {
			System.out.print((char)i);
		}
		
		fr.close();
	}

}
