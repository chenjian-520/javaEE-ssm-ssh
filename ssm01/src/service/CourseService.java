package service;

import java.util.List;

import pojo.Course;

public interface CourseService {
	//��ѯ���а༶��Ϣ
	public abstract List<Course> findAll();
	//��id��ѯ
	public abstract Course findOne(int cid);
	//�޸�
	public abstract int update(Course c);
	//������Ϣ
	public abstract int insert(Course c);
	//ɾ����Ϣ
	public abstract int delete(int c);
}
