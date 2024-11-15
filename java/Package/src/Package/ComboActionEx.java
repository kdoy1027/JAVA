package Package;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame{
	private String[] fruits = {"apple", "kiwi", "mango"};
	private ImageIcon[] images = 
		{new ImageIcon("images/apple.jpg"),
		new ImageIcon("images/kiwi.jpg"),
		new ImageIcon("images/mango.jpg")};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	public ComboActionEx () {
		setTitle("콤보박스 활용 예쩨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(imgLabel);

		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		setSize(300,250);
		setVisible(true);
	}
	public static void main(String [] args) {
		new ComboActionEx();
	}
}
