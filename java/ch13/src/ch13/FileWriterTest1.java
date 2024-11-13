package ch13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 {

	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(System.in);
		String source = "문자스트림으오 입출력할 파일입니다 \n 제대로 \n 작동해라";
		System.out.println("저장할 파일명을 입력해주세요. :  ");
		String in = stdin.next();
		FileWriter fw = new FileWriter(in);
		fw.write(source);
		fw.close();
		System.out.println(in + "파일이 생성되었습니다!");
	}

}
