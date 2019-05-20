package service;

import java.util.List;

import pojo.Course;

public interface CourseService {
	//查询所有班级信息
	public abstract List<Course> findAll();
	//按id查询
	public abstract Course findOne(int cid);
	//修改
	public abstract int update(Course c);
	//插入信息
	public abstract int insert(Course c);
	//删除信息
	public abstract int delete(int c);
}
