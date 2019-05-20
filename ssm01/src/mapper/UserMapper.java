package mapper;

import java.util.List;

import pojo.UserInfo;

public interface UserMapper {

//	@Select("select * from userinfo")
	List<UserInfo> queryAll();
	
	int delete(int uid);
	
	int insert(UserInfo in);
	
	int update(UserInfo in);
}
