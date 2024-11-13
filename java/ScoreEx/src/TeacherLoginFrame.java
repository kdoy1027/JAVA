import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TeacherLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw, txtSubject ;
	private JFrame frame;
	private DefaultTableModel tableModel;
	
	private TeacherDAO dao;
	
	public TeacherLoginFrame () {
		frame = this;
		dao = TeacherDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,297,365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(125, 100, 144, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(125,53,144,33);
		contentPane.add(txtSubject);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12,14,101,24);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(12,53,101,24);
		contentPane.add(lblPw);
		JLabel lblsubject = new JLabel("과목");
		lblsubject.setBounds(12,96,101,24);
		contentPane.add(lblsubject);
		
		JButton btnIogin = new JButton("로그인");
		btnIogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = txtId.getText();
				String pw1 = txtPw.getText();
				String subject1 = txtSubject.getText();
				
				if (id1.isBlank() || pw1.isBlank() || subject1.isBlank()) {
					JOptionPane.showMessageDialog(frame, "ID, PW, 과목을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String id = txtId.getText();
				String pw = txtPw.getText();
				String subject = txtSubject.getText();
				
				TeacherDAO dao = TeacherDAOImple.getInstance();
				boolean loggIn = dao.teacherlogin(id, pw, subject);
				
				if (loggIn) {
					GradeMainFrame gradeMainframe = new GradeMainFrame();
					gradeMainframe.frame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "아이디 또는 비밀번호가 일치하지 않습니다.", "로그인 실패",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIogin.setBounds(12, 271, 119, 45);
		contentPane.add(btnIogin);
		
		JButton btnInsert = new JButton("회원가입");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TeacherinsertFrame teacherinsertFrame = new TeacherinsertFrame();
				teacherinsertFrame.setVisible(true);
			}
		});
		btnInsert.setBounds(150, 271, 119, 45);
		contentPane.add(btnInsert);
		
	}
	
	
}
