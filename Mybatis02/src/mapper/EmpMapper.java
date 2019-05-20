package mapper;

import java.util.List;

import pojo.Emp;

public interface EmpMapper {
	List<Emp> findDeptAndEmps();
}
