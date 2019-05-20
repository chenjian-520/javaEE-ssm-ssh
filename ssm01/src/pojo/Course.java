package pojo;

import java.util.List;

public class Course {
	private int cid;
	private String cname;
	private int credit;
	private List<Elective> elective;
	public Course(int cid, String cname, int credit) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.credit = credit;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public List<Elective> getElective() {
		return elective;
	}
	public void setElective(List<Elective> elective) {
		this.elective = elective;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", credit=" + credit + ", elective=" + elective + "]";
	}
	public Course(int cid, String cname, int credit, List<Elective> elective) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.credit = credit;
		this.elective = elective;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
