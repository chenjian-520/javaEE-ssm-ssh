package dao.proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class PeoxyUserDao implements UserDao {
	
	UserDao dao ;
	
	
	public PeoxyUserDao(UserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void addUser() {
		System.out.println("��������");
		dao.addUser();
		System.out.println("�ύ����");
	}

	@Override
	public void deleteUser() {
		System.out.println("��������");
		dao.deleteUser();
		System.out.println("�ύ����");
	}

}
