package Package;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;

public class GridLayoutEX extends JFrame {
	public GridLayoutEX() {
		setTitle("★★★★★GridLayoutEX Sample★★★★★");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(4,2);
		grid.setVgap(5);
		
		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(grid);
		
		c.add(new JLabel("이름")).setForeground(Color.white);
		c.add(new JTextField(""));
		
		c.add(new JLabel("학번")).setForeground(Color.white);
		c.add(new JTextField(""));
		
		c.add(new JLabel("학과")).setForeground(Color.white);
		c.add(new JTextField(""));
		
		c.add(new JLabel("과목")).setForeground(Color.white);
		c.add(new JTextField(""));
	
		
		setSize(300,300);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new GridLayoutEX();

		

		
	}

}
