package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {

	@Test
	public void test(){
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		//方式一：getMapper
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.getUserList();

		for (User user : userList) {
			System.out.println(user);
		}

		//关闭sqlsession
		sqlSession.close();
	}

	@Test
	public void getUserById(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);

		sqlSession.close();
	}

	@Test
	public void addUser(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int res = mapper.addUser(new User(4, "哈哈", "123333"));
		if (res > 0){
			System.out.println("插入成功");
		}
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUser(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		mapper.updateUser(new User(4,"呵呵","123123"));

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteUser(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		mapper.deleteUser(4);
		sqlSession.commit();

		sqlSession.close();
	}
}
