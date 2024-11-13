package Package;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon; // ImageIcon import 추가
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {
    public CheckBoxEx() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout()); // 괄호 수정

        ImageIcon cherryIcon = new ImageIcon("images/selectedCherry.jpg");

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        JCheckBox cherry = new JCheckBox("체리", cherryIcon);
        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(cherryIcon); // selectedCherryIcon 대신 cherryIcon 사용

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxEx();
    }
}
