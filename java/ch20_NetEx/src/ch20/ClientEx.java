package ch20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx {
	// 통신 전용 소켓 => 상대방의 서버주소(IP)와 포트 번호가 필요하다.
	Socket socket;
	
	//현재 컴퓨터의 ip 주소를 입력(서버와 클라이언트가 동일한 인물 : 나)
	final String IP = "192.168.0.68"; // "locathost";
	final int PORT = 9000; 
	
	//속도 및 서버의 부담을 효율적으로 관리하기 위해 사용
	BufferedReader reader;
	BufferedWriter writer;
	
	public ClientEx () {
		initData();
	}
	
	private void initData() {
		try {
			socket = new Socket(IP, PORT);
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			String input = reader.readLine();
			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			writer.write(input); // 문자열을 서버에 전송
			writer.newLine(); // 문장을 끝을 알려주는 기능
			writer.flush();
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientEx();

	}

}
