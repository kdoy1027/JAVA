
public class StudentVO {

	private String id; // 학생 id
	private String pw; // 학생 pw
	private String name; // 학생 이름
	private int classyear; // 학년
	private String email; // 이메일
	
	public StudentVO() {
		
	}
	
	public StudentVO(String id, String pw, String name, int classyear, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.classyear = classyear;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassyear() {
		return classyear;
	}

	public void setClassyear(int classyear) {
		this.classyear = classyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", " + "pw=" + pw + ", " + "name=" + name + ", " + "classyear=" + classyear + ","
				+ " email=" + email + "]";
	}
	
}
