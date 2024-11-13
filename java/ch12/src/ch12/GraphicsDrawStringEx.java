package ch12;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsDrawStringEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	
	public GraphicsDrawStringEx () {
		setTitle("drawStirng 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250,250);
		setVisible(true);
	}
	
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재미있다.~~~~~~~",30,30);
			g.drawString("얼마나 ? 하늘만큼 땅만큼은 좀;;", 60,60);
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();

	}

}
