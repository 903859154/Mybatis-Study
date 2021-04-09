package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface UserMapper {


	@Select("select * from mybatis.user")
	List<User> getUsers();

	//方法存在多个参数时，所有的参数前面必须加上@param("")注解
	@Select("select * from user where id = #{id}")
	User getUserByID(@Param("id") int id);

	@Insert("insert into user(id,name,pwd) values (#{id}, #{name}, #{password})")
	int addUser(User user);

	@Update("update user set name = #{name}, pwd=#{password} where id = #{id}")
	int updateUser(User user);

	@Delete("delete from user where id = #{uid}")
	int deleteUser(@Param("uid") int id);
}