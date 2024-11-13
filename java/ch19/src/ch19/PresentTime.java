package ch19;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PresentTime extends JPanel implements Runnable {

	private int x = 0; int y = 0;
	private final int Diameter = 50;
	private boolean running = false;
	
	public PresentTime () {
		  addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (!running) {
	                    running = true;
	                    new Thread(PresentTime.this).start();
	                }
	            }
	        });

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.magenta);
		g.drawOval(x, y, Diameter,Diameter);
	}
	
	@Override
	public void run() {
		Random random = new Random();
        while (running) {
            x = random.nextInt(getWidth() - Diameter);
            y = random.nextInt(getHeight() - Diameter);
            repaint();
            try {
                Thread.sleep(500); // 0.5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

		
	}


	public static void main(String[] args) {
		   JFrame frame = new JFrame("Random Circle");
		   PresentTime panel = new PresentTime();
	        frame.add(panel);
	        frame.setSize(400, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);

		
		
	}

}