package ch19;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelEx extends JLabel implements Runnable {
    private long delay;

    // 생성자 이름을 올바르게 수정
    public FlickeringLabelEx(String text, long delay) {
        super(text);
        this.delay = delay;
        setOpaque(true);
        Thread th = new Thread(this);
        th.start();
    }

    public void run() {
        int n = 0;
        while(true) {
            if(n == 0) {
                setBackground(Color.DARK_GRAY);
            } else {
                setBackground(Color.CYAN);
            }
            if (n == 0) n = 1;
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}

class FlickeringLabelExFrame extends JFrame {  // JFrame을 위한 새로운 클래스
    public FlickeringLabelExFrame() {
        setTitle("FlickeringLabelEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // FlickeringLabelEx 인스턴스 생성
        FlickeringLabelEx fLabel = new FlickeringLabelEx("깜빡", 500);
        JLabel label = new JLabel("안깜빡");
        FlickeringLabelEx fLabel2 = new FlickeringLabelEx("여기도 깜빡", 300);

        c.add(fLabel);
        c.add(label);
        c.add(fLabel2);

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        // FlickeringLabelExFrame 객체 생성 및 실행
        new FlickeringLabelExFrame();
    }
}
