package pojo;

import java.util.List;
import java.util.Map;

public class User {
	private String uname;
	private String password;
	private List list;
	private Map map;
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

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", list=" + list + ", map=" + map + "]";
	}
	public User(String uname, String password, List list, Map map) {
		super();
		this.uname = uname;
		this.password = password;
		this.list = list;
		this.map = map;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}	
