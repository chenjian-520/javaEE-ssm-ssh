package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pojo.Userinfo;

public interface UserInfoMapper {
	
//	@Select("select * from userinfo where uid = #{uid}")
	Userinfo selectById(int uid);
	
//	@Select(" select * from userinfo ")
	List<Userinfo> findAll();
}
