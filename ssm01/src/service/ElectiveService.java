package service;

import java.util.List;

import pojo.Elective;




public interface ElectiveService {
	//��ѯ���а༶��Ϣ
	public abstract List<Elective> findAll();
	//id��ѯ
	public abstract Elective findOne(Elective c);
	//�޸�
	public abstract int update(Elective c);
	//������Ϣ
	public abstract int insert(Elective c);
	//ɾ����Ϣ
	public abstract int delete(Elective c);
}
