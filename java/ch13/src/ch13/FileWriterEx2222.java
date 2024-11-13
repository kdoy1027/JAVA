package ch13;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileWriterEx2222 {

	public static void main(String[] args) {
		Scanner stdin =new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("C:\\Temp\\test.txt");
			while(true) {
				String line = stdin.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line,0, line.length());
				fout.write("\r\n, 0, 2");
			}	
			fout.close();
		}catch (IOException e) {
			System.out.println("입출력 오류");
		}
		stdin.close();
	}
}
