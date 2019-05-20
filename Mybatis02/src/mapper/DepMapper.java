package mapper;

import java.util.List;

import pojo.Dept;

public interface DepMapper {
	List<Dept> findDeptAndEmps();
}
