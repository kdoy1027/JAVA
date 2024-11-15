package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	// 클라이언트로 연결 받는 소켓
	ServerSocket serverSocket;
	
	//실제 통신을 담당하는 소켓
	Socket socket;
	
	
	public ServerEx() {
		initData();
	}
	
	private void initData() {
		try {
			// 서버 포트를 9000으로 열었음
			serverSocket = new ServerSocket(9000);
			
			// 클라이언트 접속 대기 중...
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(reader.readLine() + "\n");
			
		}catch(Exception e) {}
		
	}
	
	public static void main(String[] args) {
		
		// 객체 따로 만들지 않고 생성자를 통해 실행하겠다.
		new ServerEx(); 
		// 생성자를 통해 initData()메소드 실행

	}

}
