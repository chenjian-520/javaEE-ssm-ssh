package dao.impl;

import org.springframework.stereotype.Component;

import dao.UserDao;

//��дĬ��Ϊ����
@Component("userdao")
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("����û�");
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("ɾ���û�");
	}

}
