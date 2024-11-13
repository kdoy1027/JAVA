package Package;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;

	public class MouseAdapter1 extends JFrame {
		private JLabel la =new JLabel("이동할거야");
		
		public MouseAdapter1() {
			setTitle("mouse 이벤트 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.addMouseListener(new MyMouseAdapter());
			
			c.setLayout(null);
			la.setSize(50,20);
			la.setLocation(30,30);
			c.add(la);
			
			setSize(250,250);
			setVisible(true);
		}
		
		class MyMouseAdapter extends java.awt.event.MouseAdapter{
				public void mousePressed(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					la.setLocation(x, y);
				}
			}
		
	public static void main(String [] args) {
		new MouseAdapter1();
	}
}

	
	
	
	

	

