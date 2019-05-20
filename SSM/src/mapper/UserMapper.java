package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pojo.UserInfo;

public interface UserMapper {

	@Select("select * from userinfo")
	List<UserInfo> queryAll();
	
}
