package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {

	@Test
	public void getUserLike(){
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		//方式一：getMapper
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);


		System.out.println(user);

		//关闭sqlsession
		sqlSession.close();
	}

}
