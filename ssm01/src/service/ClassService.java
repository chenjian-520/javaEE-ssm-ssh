package service;

import java.util.List;

import pojo.Class1;

public interface ClassService {
	//��ѯ���а༶��Ϣ
	public abstract List<Class1> findAll();
	//���༶����ѯ
	public abstract Class1 findOne(String name);
	//�޸�
	public abstract int update(Class1 c);
	//������Ϣ
	public abstract int insert(Class1 c);
	//ɾ����Ϣ
	public abstract int delete(Class1 c);
	//ÿ���������
	public abstract List<Class1> selectAll();
}
