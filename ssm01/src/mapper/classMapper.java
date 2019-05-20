package mapper;

import java.util.List;

import pojo.Class1;

public interface classMapper {
	//查询所有班级信息
	public abstract List<Class1> findAll();
	//按班级名查询
	public abstract Class1 findOne(String name);
	//修改
	public abstract int update(Class1 c);
	//插入信息
	public abstract int insert(Class1 c);
	//删除信息
	public abstract int delete(Class1 c);
	//每个班的人数
	public abstract List<Class1> selectAll();
}
