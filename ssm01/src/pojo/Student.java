package pojo;

import java.util.List;

public class Student {
	private int sid;
	private String sname;
	private String sex;
	private int age;
	private String wname;
	private Class1 cls;
	private List<Elective> elective;
	
	public Student(int sid, String sname, String sex, int age, String wname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.wname = wname;
	}
	public List<Elective> getCourse() {
		return elective;
	}
	public void setCourse(List<Elective> elective) {
		this.elective = elective;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Class1 getCls() {
		return cls;
	}
	public void setCls(Class1 cls) {
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", age=" + age + ", wname=" + wname
				+ ", cls=" + cls + ", elective=" + elective + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, String sex, int age, String wname, Class1 cls, List<Course> course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.wname = wname;
		this.cls = cls;
		this.elective = elective;
	}

}
