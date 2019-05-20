package pojo;

public class Userinfo {
	private int uid;
	private String uname;
	private String password;
	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userinfo(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}
	public Userinfo(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	
}
