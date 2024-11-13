package ch13;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutputStreamEX11 {

	public static void main(String[] args) {
		
		byte b[] = {7,51,3,4,-1,24};
		try {
			FileOutputStream fout = 
					new FileOutputStream("FileOutputStreamEX11.txt");
			for(int i = 0; i < b.length;i++) {
				fout.write(b[i]);
				fout.close();}
			}catch(IOException e) {
				System.out.println("파일을 저장할 수 없었습니다. 경로를 확인하세요.");
				return;
			}
			System.out.println("FileOutputStreamEX11.txt을 저장하였습니다.");
		}
	}

