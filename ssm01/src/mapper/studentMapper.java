package mapper;

import java.util.List;

import pojo.Student;

public interface studentMapper {
	//查询所有班级信息
	public abstract List<Student> findAll();
	//按班级名查询
	public abstract Student findOne(int c);
	//修改
	public abstract int update(Student c);
	//插入信息
	public abstract int insert(Student c);
	//删除信息
	public abstract int delete(int c);
	//查询学生班主任信息
	public abstract List<Student> class22();
}
