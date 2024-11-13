package ch12;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDrawEx extends JFrame{
	//생성자 만들고 ImageDrawEx 클래스의 기본 구성 만듦.
	public ImageDrawEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		// ImageDrawEx 클래스 내부에 보여질 내용인 MyPanel 클래스 생성하고 붙임?
		setContentPane(new MyPanel());
		setVisible(true);

	}
	
	
	class MyPanel extends JPanel {

		//필드 생성(즉 ImageDrawEx 클래스 창 켰을 때 보여질 내용들을 정의)
		private ImageIcon icon = new ImageIcon("images/java_penguin.jpg");
		private Image img = icon.getImage();
		private JButton button = new JButton("ON/OFF");
		private boolean showFlag = true;
		
		public MyPanel() {
			setLayout(new FlowLayout());
			add(button);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag = !showFlag;
					MyPanel.this.repaint();
				}
			});
		}
		
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(showFlag) {
			g.drawImage(img,0,0,this.getWidth(), this.getHeight(),this);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ImageDrawEx();

	}

}
