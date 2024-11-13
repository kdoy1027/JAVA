import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class StudentGradeFrame {

	JFrame frame;
	private JTextArea txtAreaLog_1;
	private static GradeDAO dao;
	private Component currentComponent;
	
	private JTable table;
	private String[] colNames = {"학번", "학년", "이름", "국어", "수학", "영어" , " 평균", "석차"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	
	
	// [JAVA]성적 관리 프로그램 part 4 26일차 Student 
	
	
}
