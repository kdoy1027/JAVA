import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Server_GUI {

	public static void main(String[] args) {
		new ManagerLogin();
	}
}

class ManagerLogin extends JFrame implements ActionListener, KeyListener { 
	// 로그인 창
	Server_ChatGUI Server_chat = null;
	JPanel Port_Log = new JPanel();
	JLabel Port_Label = new JLabel("입력을 허용할 포트 번호를 입력하세요.");
	JLabel Port_Warning = new JLabel("(단, 포트 번호는 0 ~ 65535까지)");
	JTextField Port_Text = new JTextField(20);
	JButton Port_Enter = new JButton("접속!");

	public ManagerLogin() {
		setTitle("서버 메니저 창");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫았을 때 메모리에서 제거되도록 설정합니다.
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
		Port_Enter.addActionListener(this);
		Port_Text.addKeyListener(this);
		Port_Log.add(Port_Label);
		Port_Log.add(Port_Warning);
		Port_Log.add(Port_Text);
		Port_Log.add(Port_Enter);
		add(Port_Log);
	}

	public void actionPerformed(ActionEvent e) { 
		// "접속!" 버튼을 누르면 작동이 됩니다.
		try {
			int Port = Integer.parseInt(Port_Text.getText().trim());
			//
			if (e.getSource() == Port_Enter) {
				Server_chat = new Server_ChatGUI(Port);
				setVisible(false);
			}
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력입니다!");
		}
	}

	public void keyPressed(KeyEvent e) { 
		// 텍스트필드에 값을 입력한 후 엔터키를 누르면 작동이 됩니다.
		try {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				int Port = Integer.parseInt(Port_Text.getText().trim());
				Server_chat = new Server_ChatGUI(Port);
				setVisible(false);
			}
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력입니다!");
		}

	}

	public void keyTyped(KeyEvent e) { // 불필요
	}

	public void keyReleased(KeyEvent e) { // 불필요
	}

}

class Server_ChatGUI extends JFrame implements ActionListener, KeyListener {
	// 서버용 채팅창
	JPanel ServerGUI_Panel = new JPanel();
	JLabel ServerLabel = new JLabel("Main Server");
	JLabel UserLabel = new JLabel("유저 목록");
	
	//보낼 메세지 작성란
	JTextField Chat = new JTextField(45);
	JButton Enter = new JButton("전송");
	
	//채팅 내역 보이는 영역
	TextArea ServerChatList = new TextArea(30, 50);
	TextArea UserList = new TextArea(30, 15);
	Server_Back SB = new Server_Back();

	
	public Server_ChatGUI(int Port) {
		
		setTitle("메인 서버");
		setVisible(true);
		
		//"메인서버"화면을 중앙에 배치하도록 하는 코드
		setLocationRelativeTo(null);
		setSize(750, 520);
		
		// 창의 크기 조절할 수 없도록 설정
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫았을 때 메모리에서 제거되도록 설정합니다.

		//체팅 메세지를 표시하는 ServerChatList 영역을 수정할 수 없도록 함.
		ServerChatList.setEditable(false);
		// 위와 동일한 기능
		UserList.setEditable(false);
		
		// 채팅 입력란 -이벤트
		Chat.addKeyListener(this);
		// 채팅 입력란 옆 전송 버튼 - 이벤트
		Enter.addActionListener(this);

		// ServerGUI_Panel('메인서버")에 위 작성한 요소들 추가
		ServerGUI_Panel.add(ServerLabel);
		ServerGUI_Panel.add(ServerChatList);
		ServerGUI_Panel.add(UserLabel);
		ServerGUI_Panel.add(UserList);
		ServerGUI_Panel.add(Chat);
		ServerGUI_Panel.add(Enter);
		add(ServerGUI_Panel);

		// 실행과 동시에 서버주인(Admin)을 유저목록에 추가
		UserList.append("Admin\n"); 
		
		//SB(Server_Back 객체에 Server_GUI 객체 전달)
		SB.setGUI(this);
		
		SB.Start_Server(Port);
		SB.start(); // 서버 채팅창이 켜짐과 동시에 서버소켓도 함께 켜집니다.
	}

	// Enter("전송" 버튼) - 이벤트 설정
	public void actionPerformed(ActionEvent e) { // 전송 버튼을 누르고, 입력값이 1이상일때만 전송되도록 합니다.
		String Message = Chat.getText().trim();
		if (e.getSource() == Enter && Message.length() > 0) {
			AppendMessage("서버 : " + Message + "\n");
			
			// SB(Server_Back 객체)에서 Transmitall 메소드 실행 - 모든 클라이언트에게 메세지 전송
			SB.Transmitall("서버 : " + Message + "\n");
			// 채팅창 입력값을 초기화
			
			Chat.setText(null);
		}
	}

	// Chat (채팅 입력란) - 엔터키 입력했을 때 이벤트
	public void keyPressed(KeyEvent e) { // 키보드 엔터키를 누르고, 입력값이 1이상일때만 전송되도록 합니다.
		String Message = Chat.getText().trim();
		if (e.getKeyCode() == KeyEvent.VK_ENTER && Message.length() > 0) {
			//채팅내역란에 입력한 메세지 전송
			AppendMessage("서버 : " + Message + "\n");
			
			// SB(Server_Back 객체)에서 Transmitall 메소드 실행 - 모든 클라이언트에게 메세지 전송
			SB.Transmitall("서버 : " + Message + "\n");
			
			//채팅창 입력값을 초기화
			Chat.setText(null); // 채팅창 입력값을 초기화
		}
	}

	public void AppendMessage(String Message) {
		ServerChatList.append(Message);
	}

	public void AppendUserList(ArrayList NickName) {
		String name;
		for (int i = 0; i < NickName.size(); i++) {
			name = (String) NickName.get(i);
			UserList.append(name + "\n");
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}