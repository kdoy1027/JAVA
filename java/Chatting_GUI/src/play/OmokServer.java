package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class OmokServer {
    private static final int PORT = 12345;  // 서버 포트 번호
    private static ServerSocket serverSocket;
    private static Socket player1Socket;
    private static Socket player2Socket;
    private static PrintWriter out1, out2;
    private static BufferedReader in1, in2;
    private static boolean player1Turn = true;  // X가 먼저

    public static void main(String[] args) {
    	
    	
        try {
            // 서버 소켓 생성 (내 IP 주소 사용)
            String serverIP = "192.168.0.68";  // 서버의 내 IP 주소 입력
            serverSocket = new ServerSocket(PORT, 50, InetAddress.getByName(serverIP));

            System.out.println("서버가 시작되었습니다. 클라이언트를 기다리는 중...");
            
            // 두 클라이언트 연결 대기
            player1Socket = serverSocket.accept();
            System.out.println("Player 1 연결됨: " + player1Socket.getInetAddress());
            out1 = new PrintWriter(player1Socket.getOutputStream(), true);
            in1 = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
            
            player2Socket = serverSocket.accept();
            System.out.println("Player 2 연결됨: " + player2Socket.getInetAddress());
            out2 = new PrintWriter(player2Socket.getOutputStream(), true);
            in2 = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));
            
            // 플레이어에게 마크 할당
            out1.println("X");
            out2.println("O");

            // 게임 턴 시작
            out1.println("YOUR_TURN");
            out2.println("WAIT");

            // 게임 로직 처리
            while (true) {
                if (player1Turn) {
                    // Player 1이 돌을 놓을 차례
                    String move = in1.readLine();
                    System.out.println("Player 1의 이동: " + move);
                    out2.println("OPPONENT_MOVE," + move);
                    out1.println("YOUR_TURN");
                    out2.println("WAIT");
                } else {
                    // Player 2가 돌을 놓을 차례
                    String move = in2.readLine();
                    System.out.println("Player 2의 이동: " + move);
                    out1.println("OPPONENT_MOVE," + move);
                    out2.println("YOUR_TURN");
                    out1.println("WAIT");
                }

                player1Turn = !player1Turn;  // 턴을 바꿈
            }
            
            
            
        } catch (IOException e) {
            System.out.println("서버 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
