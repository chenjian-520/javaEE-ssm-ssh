package service;

import java.util.List;

import pojo.Student;

public interface StudentService {
	//��ѯ���а༶��Ϣ
	public abstract List<Student> findAll();
	//���༶����ѯ
	public abstract Student findOne(int c);
	//�޸�
	public abstract int update(Student c);
	//������Ϣ
	public abstract int insert(Student c);
	//ɾ����Ϣ
	public abstract int delete(int c);
	//��ѯѧ����������Ϣ
	public abstract List<Student> class22();
}
