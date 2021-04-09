import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Teacher;
import utils.MybatisUtils;

public class MyTest {

	@Test
	public void test(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher);

		sqlSession.close();
	}

	@Test
	public void test2(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher2(1);
		System.out.println(teacher);

		sqlSession.close();
	}
}
