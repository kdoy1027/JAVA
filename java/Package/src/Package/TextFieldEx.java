package Package;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame{
	public TextFieldEx() {
		setTitle("텍스트필드 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new Label("이름"));
		c.add(new JTextField(20));
		c.add(new Label("학과"));
		c.add(new JTextField("컴공",20));
		c.add(new Label("주소"));
		c.add(new JTextField("서울시~~~",20));
		
		setSize(300, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new TextFieldEx();

	}

}
