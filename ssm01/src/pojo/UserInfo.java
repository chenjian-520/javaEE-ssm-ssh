package pojo;

public class UserInfo {
	private int uid;
	private String uname;
	private String password;

	public UserInfo(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
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
	public UserInfo(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	
}
