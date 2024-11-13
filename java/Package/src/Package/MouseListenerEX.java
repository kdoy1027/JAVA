package Package;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;

	public class MouseListenerEX extends JFrame {
		private JLabel la =new JLabel("이동할거야");
		
		public MouseListenerEX() {
			setTitle("mouse 이벤트 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.addMouseListener(new MyMouseListener());
			
			c.setLayout(null);
			la.setSize(50,20);
			la.setLocation(30,30);
			c.add(la);
			
			setSize(250,250);
			setVisible(true);
		}
		
		class MyMouseListener implements MouseListener{
				public void mousePressed(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					la.setLocation(x, y);
				}

				public void mouseReleased(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
			}
		
	public static void main(String [] args) {
		new MouseListenerEX();
	}
}

	
	
	
	

	

