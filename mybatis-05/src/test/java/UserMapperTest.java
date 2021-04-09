import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {

	@Test
	public void test(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		/*List<User> users = mapper.getUsers();
		for (User user : users) {
			System.out.println(user);
		}

		User userByID = mapper.getUserByID(1);
		System.out.println(userByID);
		mapper.addUser(new User(4,"hello","1234567"));

		mapper.updateUser(new User(4,"to","234546"));
		*/

		mapper.deleteUser(4);

		sqlSession.close();
	}
}
