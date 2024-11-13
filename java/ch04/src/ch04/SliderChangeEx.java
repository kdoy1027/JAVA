package ch04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame {
	private JLabel colorLabels;
	private JSlider [] sl = new JSlider[3];
	public SliderChangeEx() {
		setTitle("슬라이더와 change event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		colorLabels = new JLabel ("SLIDER EXAMPLE");
		for(int i=0; i<sl.length; i++) {
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener (new MyChangeListener());
			c.add(sl[i]);
		}
		
		sl[0].setForeground(Color.red);
		sl[1].setForeground(Color.green);
		sl[2].setForeground(Color.blue);
		
		int r = sl[0].getValue(); 
		int g = sl[1].getValue(); 
		int b = sl[2].getValue(); 

		colorLabels.setOpaque(true); 
		colorLabels.setBackground(new Color(r,g,b));
		c.add(colorLabels);
		setSize(300,230);
		setVisible(true);
		
	}
	
	class MyChangeListener  implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabels.setBackground(new Color(r,g,b));
		}
	}
	
	
	public static void main(String[] args) {
		new SliderChangeEx();

	}

}
