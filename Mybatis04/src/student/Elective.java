package student;

public class Elective {
	private int cid ;
	private int sid ;
	private int report;
	private Student student;
	private Course course;
	
	public Elective(int cid, int sid) {
		super();
		this.cid = cid;
		this.sid = sid;
	}
	public Elective(int cid, int sid, int report) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.report = report;
	}
	@Override
	public String toString() {
		return "Elective [cid=" + cid + ", sid=" + sid + ", report=" + report + ", student=" + student + ", course="
				+ course + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Elective(int cid, int sid, int report, Student student, Course course) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.report = report;
		this.student = student;
		this.course = course;
	}
	public Elective() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
