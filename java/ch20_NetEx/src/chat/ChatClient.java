package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private Scanner sc;
	
	
	public void go() throws Exception {
		try {
			socket = new Socket("192.168.0.22", 9002);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			sc = new Scanner(System.in);
			
			receiverWoker rw = new receiverWoker();
			Thread th = new Thread(rw);
			th.setDaemon(true); // 요 놈 끝나면 모두 끝
			th.start();
			System.out.println("** ChatClient가 서버에 접속 **");
			while(true) {
				String message = sc.nextLine();
				pw.println(message);
				
				if(message.trim().equals("종료")) {
					System.out.println("** ChatClient 종료합니다이이이이이잉");
					break;
				}
			}
	
			
		}catch(Exception e) {
			
		}finally {
			closeAll();}
	}
	
	
	class receiverWoker implements Runnable {

		@Override
		public void run() {
			try {
				receiveMessage();
			}catch (Exception e) {
				
			}
		}
		
		public void receiveMessage () throws Exception {
			while(true) {
				String message = br.readLine();
				if(message == null) {
					break;
				}
				System.out.println(message);
				System.out.println("서버에서 보내는 메세지 >> ");
			}
			
		}
		
	}
	
	
	

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		try {
			client.go();
		}catch(Exception e) {
			
		}

	}
	
	
	public void closeAll() throws Exception {
		if(pw != null) {
			pw.close();
		}
	}

}
