package Package;
import javax.swing.*;
import java.awt.*;
public class NullContainerEx extends JFrame {
	public NullContainerEx() {
	setTitle("Null Container Sample");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	Container c = getContentPane();
	c.setLayout(null);
	
	JLabel la = new JLabel("Hello, Press Buttons!");
	la.setLocation(130, 50);
	la.setSize(200, 20);
	c.add(la);
	
	for(int i=1; i<=9; i++) {
		JButton b = new JButton(Integer.toString(i));
		b.setLocation(i*20, i*20);
		b.setSize(50, 20);
		c.add(b);
		}
	
	for (int j = 1; j <= 8; j++) {
        JButton f = new JButton(Integer.toString(j));
        int startpoint =(9 * 20);
        f.setLocation((j * 20)+200, startpoint - (j * 20));
        f.setSize(50, 20);
        c.add(f);
    }
		
	setSize(500, 500);
	setVisible(true);
	}
		
	public static void main(String[] args) {
	new NullContainerEx();
	}
}
