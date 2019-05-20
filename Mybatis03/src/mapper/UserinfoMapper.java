package mapper;

import org.apache.ibatis.annotations.Select;

import pojo.Userinfo;

public interface UserinfoMapper {
	//@Select("select * from userinfo where uid = #{uid}")
	public abstract Userinfo select(int uid);
	//@Select("update  userinfo set uname = #{uname} ,password = #{password} where uid = #{uid} ")
	public abstract int update(Userinfo user);
}
