package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {

	//查询全部用户
	List<User> getUserList();

	//根据id查询用户
	User getUserById(int id);

	//insert 一个用户
	int addUser(User user);

	//修改用户
	int updateUser(User user);

	//删除用户
	int deleteUser(int id);
}
