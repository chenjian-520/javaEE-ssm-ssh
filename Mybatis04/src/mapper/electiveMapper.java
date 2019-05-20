package mapper;

import java.util.List;


import student.Elective;

public interface electiveMapper {
	//查询所有班级信息
	public abstract List<Elective> findAll();
	//id查询
	public abstract Elective findOne(Elective c);
	//修改
	public abstract int update(Elective c);
	//插入信息
	public abstract int insert(Elective c);
	//删除信息
	public abstract int delete(Elective c);
}
