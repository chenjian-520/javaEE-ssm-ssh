package dao;

import java.util.List;

import entity.Userinfo;

public interface UserDao {
	public abstract Userinfo login(String username,String password);
	public abstract List<Userinfo> findAll();
	public abstract int insert(String username, String password);
	public abstract int delete(int uid);
}
