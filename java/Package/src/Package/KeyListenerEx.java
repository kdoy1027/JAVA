package Package;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyListenerEx extends JFrame{

	private JLabel[] keyMessage;
	
	public KeyListenerEx() {
		setTitle("keylistener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		c.addKeyListener(new MyKeyListner());
		
		keyMessage = new JLabel [3];
		keyMessage[0] = new JLabel("getKeyCode()");
		keyMessage[1] = new JLabel("getKeyCode()");
		keyMessage[2] = new JLabel("getKeyCode()");
		
		for(int i =0; i<keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListner extends KeyAdapter {
		public void keyPress(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			
			keyMessage[0].setText(Integer.toString(KeyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(e.getKeyText(KeyCode));
		}
	}
	
	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
