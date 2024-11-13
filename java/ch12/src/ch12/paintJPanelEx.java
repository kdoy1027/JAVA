package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame{
	public MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {
		setTitle("JPanel의 paintComponent()예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300,300);
		setVisible(true);
	}
	
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			System.out.println("그래픽");
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50,50,50,50);
			g.setColor(Color.magenta);
			g.drawRect(90,90,90,90);
		}
	}
	public static void main(String[] args) {
		new paintJPanelEx();

	}

}
