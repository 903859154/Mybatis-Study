package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.MybatisUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

	static Logger logger = Logger.getLogger(UserMapperTest.class);

	@Test
	public void getUserByLimit(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("startIndex",0);
		map.put("pageSize",2);

		List<User> userList = mapper.getUserList(map);
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void getUserLike(){
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		logger.info("测试，进入getUserLike方法成功");

		//方式一：getMapper
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);

		System.out.println(user);

		//关闭sqlsession
		sqlSession.close();
	}

	@Test
	public void testLog4j(){
		logger.info("info:进入了testLog4j");
		logger.debug("debug:进入了testLog4j");
		logger.error("error:进入了testLog4j");
	}

}
