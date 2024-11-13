package ch12;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GraphicsDrawImageEx2 extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsDrawImageEx2() {
	setTitle("패널의 크기에 맞추어 이미지 그리기");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setContentPane(panel);
	setSize(200, 300);
	setVisible(true);
}
	
	
	class MyPanel extends JPanel {
	private ImageIcon icon = new ImageIcon("images/dogi.jpg");
	private Image img = icon.getImage(); // 이미지 객체
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setClip(50,50,300,300);
	g.drawImage(img,0,0,getWidth(), getHeight(),this);
	g.setColor(Color.DARK_GRAY);
	g.setFont(new Font("Arial", Font.ITALIC,20));
	g.drawString("Let's go MARS!!!!!!", 10, 150);
	}
}
	
	
	public static void main(String [] args) {
		new GraphicsDrawImageEx2();
	}
}
