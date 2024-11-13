package ch12;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MouseDragEx extends JFrame {

	public MouseDragEx() {
		setTitle("마우스 이미지 드래그 연습");
		//super("마우스 이미지 드래그 연습");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		setContentPane(new MyPanel());
		//제일 아래에 두기
		setVisible(true);
	}
	
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/dogi.jpg");
		private Image img = icon.getImage();
		

		
		private ImageIcon icon1 = new ImageIcon("images/apple1.jpg");
		private Image img1 = icon1.getImage();
		private int ovalX = 100, ovalY = 100;
		private final int RADUIS = 80;
		
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				
			
				@Override
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint();
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
			g.setColor(Color.GREEN);
			g.drawImage(img1, ovalX, ovalY, RADUIS, RADUIS, this);
		}
	}
	
	
	
	public static void main(String[] args) {
		new MouseDragEx();

	}

}
