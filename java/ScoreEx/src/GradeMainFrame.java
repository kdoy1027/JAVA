// 외관 구현하는 클래스 (JFRAME 사용)

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class GradeMainFrame {

	JFrame frame;
	private JTextField textstudentid, textstudentname, textclassyear, textkorean, textenglish, textmath;
	private JTextArea txtAreaLog_1;
	private static GradeDAO dao;
	private Component currentComponent;
	
	private JTable table;
	private String[] colNames = { "학번", "학년", "이름", "국어", "수학", "영어", "평균", "석차" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	
	
	public static void main(String[] args) {
		
		try {
			dao = GradeDAOImple.getInstance();
		}catch (Exception e1) {
			e.printStackTrace();
		};
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginframe loginFrame = new Loginframe();
					loginFrame.frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				};
			}
		});
	}
	
	public GradeMainframe() {
		initialize();
	};
	
	private void initialize () {
		frame = new JFrame();
		frame.setBounds(100,100,820,409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblstudentid = new JLabel("학번");
		lblstudentid.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid.setBounds(12,10,38,34);
		frame.getContentPane().add(lblstudentid);
		
		JLabel lblstudentname = new JLabel("이름");
		lblstudentname.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentname.setBounds(12,96,38,34);
		frame.getContentPane().add(lblstudentname);
		
		JLabel lblkorean = new JLabel ("국어");
		lblkorean.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblkorean.setBounds(12, 140, 38, 34);
		frame.getContentPane().add(lblkorean);
		
		JLabel lblenglish = new JLabel("영어");
		lblenglish.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblenglish.setBounds(12,184,38,34);
		frame.getContentPane().add(lblenglish);
		
		JLabel lblmath = new JLabel("수학");
		lblmath.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblmath.setBounds(12,228,383,34);
		frame.getContentPane().add(lblmath);
		
		
		textstudentid = new JTextField();
		textstudentid.setFont(new Font("굴림", Font.PLAIN, 18));
		textstudentid.setColumns(10);
		textstudentid.setBounds(73,10,217,34);
		frame.getContentPane().add(textstudentid);
		
		textclassyear = new JTextField();
		textclassyear.setFont(new Font("굴림", Font.PLAIN, 18));
		textclassyear.setColumns(10);
		textclassyear.setBounds(73,54,217,34);
		frame.getContentPane().add(textclassyear);
		
		textstudentname = new JTextField();
		textstudentname.setFont(new Font("굴림", Font.PLAIN, 18));	
		textstudentname.setColumns(10);
		textstudentname.setBounds(93,98,217,34);
		frame.getContentPane().add(textstudentname);
		
		textkorean = new JTextField();
		textkorean.setFont(new Font("굴림", Font.PLAIN, 18));
		textkorean.setColumns(10);
		textkorean.setBounds(73,142,217,34);
		frame.getContentPane().add(textkorean);
		
		textenglish = new JTextField();
		textenglish.setFont(new Font("굴림", Font.PLAIN, 18));
		textenglish.setColumns(10);
		textenglish.setBounds(73,186,217,34);
		frame.getContentPane().add(textenglish);
		
		textmath = new JTextField();
		textmath.setFont(new Font("굴림", Font.PLAIN, 18));
		textmath.setColumns(10);
		textmath.setBounds(73,230,217,34);
		frame.getContentPane().add(textmath);
		
		
		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertGrade();
				selectAllGradeTable();
				textstudentid.setText("");
				textclassyear.setText("");
				textstudentname.setText("");
				textkorean.setText("");
				textenglish.setText("");
				textmath.setText("");
			}
		});
		
		btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnInsert.setBounds(0,336,100,34);
		frame.getContentPane().add(btnInsert);
		
		JButton btnselect = new JButton("전체 검색");
		btnselect.setBounds(111,336,110,34);
		frame.getContentPane().add(btnselect);
		
		JButton btnselectstudentid = new JButton("학번 검색");
		btnselectstudentid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String studentid = txtAreaLog_1.getText();
				int Studentid = Integer.parseInt(studentid);
				ArrayList<GradeVO> list = dao.select();
				
				if(list.isEmpty()) {
					System.out.println("학생 정보가 없습니다.");
					tableModel.setRowCount(0);
				} else {
					System.out.println("학생 정보가 있습니다.");
					selectGradeTable(studentid);
				}
				
			}
		});
		
		btnselectstudentid.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnselectstudentid.setBounds(220,336,110,34);
		frame.getContentPane().add(btnselectstudentid);
		
		JButton btnupdate = new JButton("수정");
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateGrade();
				textclassyear.setText("");
				textstudentname.setText("");
				textkorean.setText("");
				textenglish.setText("");
				textmath.setText("");
			}
		});
		
		btnupdate.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnupdate.setBounds(331,336,110,34);
		frame.getContentPane().add(btnupdate);
		
		JButton btndelete = new JButton("삭제");
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			deleteGrade();
			txtAreaLog_1.setText("");
			}
		});
		
		btndelete.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btndelete.setBounds(331,336,110,34);
		frame.getContentPane().add(btndelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302,10,490,312);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblclassyear = new JLabel("학년");
		lblclassyear.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblclassyear.setBounds(12,52,38,34);
		frame.getContentPane().add(lblclassyear);
		
		// 테이블 초기화
		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int colums) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			Object value = table.getValueAt(row, col);
			System.out.println(value);
		} 
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		
		scrollPane.setViewportView(table);
		
		JLabel lblstudentid_1 = new JLabel("학번검색");
		lblstudentid_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid_1.setBounds(12,288,76,34);
		frame.getContentPane().add(lblstudentid_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 288, 180, 34);
		frame.getContentPane().add(scrollPane_1);
		
				txtAreaLog_1 = new JTextArea();
				scrollPane_1.setViewportView(txtAreaLog_1);
				txtAreaLog_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtAreaLog_1.setText(""); // 텍스트 설정
					}
				});	
					
				
					txtAreaLog_1.setText("학번입력");
					txtAreaLog_1.setFont(new Font("굴림", Font.PLAIN, 17));
					txtAreaLog_1.setColumns(5);
					
					
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
							
				Loginframe loginFrame = new Loginframe();
				loginFrame.frame.setVisible(true);

							
				frame.setVisible(false);
			}
		});
		btnLogout.setBounds(685, 336, 107, 23);
		frame.getContentPane().add(btnLogout);

		}			
	
	
		protected void insertGrade() {
			int studentid = Integer.parseInt(textstudentid.getText());
			int classYear = Integer.parseInt(textclassyear.getText());
			String studentName = textstudentname.getText();
			int kor = Integer.parseInt(textkorean.getText());
			int eng = Integer.parseInt(textenglish.getText());
			int math = Integer.parseInt(textmath.getText());
			
			GradeVO vo = new GradeVO();
			vo.setStudentId(studentid);
			vo.setClassYear(classYear);
			vo.setStudentName(studentName);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			
			dao.insert(vo);
			
		}
		
		protected void selectGradeTable(int studentid) {
			
			ArrayList<GradeVO> list = dao.select();
			list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());
			
			 int studentRank = -1;
			 
			 int rank = 1;
			 
			 for (GradeVO vo : list) {
				 vo.setRank(rank++);
				 if(vo.getStudentId() == studentid) {
					 studentRank = vo.getRank();
					 break;
				 }
			 }
			 
			 if(studentRank != -1 ) {
				 tableModel.setRowCount(0);
				 for(GradeVO vo : list) {
					 if(vo.getStudentId() == studentid) {
						 	records[0] = vo.getStudentId();
			                records[1] = vo.getClassYear();
			                records[2] = vo.getStudentName();
			                records[3] = vo.getKor();
			                records[4] = vo.getEng();
			                records[5] = vo.getMath();
			                records[6] = vo.getAvg();
			                records[7] = vo.getRank();
			                tableModel.addRow(records);
					 }
				 }
			 } else {
				 tableModel.setRowCount(0);
				 JOption.Pane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
			 }
		
		}
		
		protected void updateGrade() {
			int studentnumber = Integer.parseInt(txtAreaLog_1.getText());

			String studentname = textstudentname.getText();
			int classyear = Integer.parseInt(textclassyear.getText());
			int kor = Integer.parseInt(textkorean.getText());
			int eng = Integer.parseInt(textenglish.getText());
			int math = Integer.parseInt(textmath.getText());

			GradeVO vo = new GradeVO(0, studentname, classyear, kor, eng, math);

			int result = dao.update(studentnumber, vo);

			if (result == 1) {
				JOptionPane.showMessageDialog(frame, "학생 정보가 성공적으로 수정되었습니다.");
			} else if (result == 0) {
				JOptionPane.showMessageDialog(frame, "학생 정보 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				// 필요한 경우 실패에 대한 처리 수행

			} else {
				JOptionPane.showMessageDialog(frame, "학번이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);

			}
			
			
		}
		
		protected void deleteGrade() {
			int index = Integer.parseInt(txtAreaLog_1.getText());

			int result = dao.delete(index);
			if (result == 1) {
				JOptionPane.showMessageDialog(frame, "학생 성적 삭제 완료!");
			} else if (result == 0) {
				JOptionPane.showMessageDialog(frame, "학생 성적 삭제에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				// 필요한 경우 실패에 대한 처리 수행

			} else {
				JOptionPane.showMessageDialog(frame, "학번이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			}

		}
		
		
		protected void selectAllGradeTable() {
			ArrayList<GradeVO> list = dao.select();
			
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
				tableModel.setRowCount(0); // 테이블 초기화
			} else {
				System.out.println("학생 정보가 있습니다.");

				list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());

		
				int rank = 1;
				for (GradeVO vo : list) {
					vo.setRank(rank++);
				}

				tableModel.setRowCount(0);

				
				for (int i = 0; i < list.size(); i++) {
					GradeVO vo = list.get(i);
					records[0] = vo.getStudentId();
					records[1] = vo.getClassYear();
					records[2] = vo.getStudentName();
					records[3] = vo.getKor();
					records[4] = vo.getEng();
					records[5] = vo.getMath();
					records[6] = vo.getAvg();
					records[7] = vo.getRank(); 
					tableModel.addRow(records);
				}

			}
			
			
		};
		
		
	} // end GradeMainframe
	


