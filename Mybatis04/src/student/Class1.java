package student;

import java.util.List;

public class Class1 {
	private String wname;
	private String chief;
	private List<Student> student;
	public Class1(String wname, String chief) {
		super();
		this.wname = wname;
		this.chief = chief;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Class1 [wname=" + wname + ", chief=" + chief + ", student=" + student + "]";
	}
	public Class1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class1(String wname, String chief, List<Student> student) {
		super();
		this.wname = wname;
		this.chief = chief;
		this.student = student;
	}
	
	
}
