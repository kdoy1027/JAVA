package ch20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx2 {

	ServerSocket serverSocekt;
	Socket socket;
	
	BufferedReader reader;  //입력스트림
	BufferedWriter writer;  // 출력 스트림

	BufferedReader keyboardReader; // 키보드에 대한 입력 데이터 담당
	
	// 생성자
	public ServerEx2 () {
		initData();
	}
	
	//메소드
	private void initData() {
		try {
			//서버 소켓 생성
			serverSocekt = new ServerSocket(9001);
			System.out.println("포드 열고 대기 중");
			
			socket = serverSocekt.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			
			//클라이언트에서 보낸 메세지를 읽어드림
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 키보드에 연결 스트림 준비  // 서버에서 키보드를 통해 입력을 받음.
			keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		}catch(Exception e) {
			
		}
	}
	
	
	//내부 클래스
	class WriterThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				try {
					String serverMsg = "서버 : " + keyboardReader.readLine();
					System.out.println("서버가 작성한 문구 확인 : " + serverMsg);
					
					writer.write(serverMsg + "\n");
					writer.flush();
					
					WriterThread person = new WriterThread();
					Thread th = new Thread(person);
					th.start(); // run()스레드 메소드 호출

					while(true) {
						String msg = "클라이언트 >> " + reader.readLine()  + "\n";
						System.out.println(msg);
					}
				}catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						reader.close();
						writer.close();
						keyboardReader.close();
					}catch(Exception e) {}
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new ServerEx2();

	}

}
