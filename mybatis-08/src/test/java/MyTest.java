import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Blog;
import utils.IDutils;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

	@Test
	public void addBlogTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setId(IDutils.getId());
		blog.setTitle("Mybatis");
		blog.setAuthor("狂神说");
		blog.setCreateTime(new Date());
		blog.setViews(9999);

		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Java");
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Spring");
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("微服务");
		mapper.addBlog(blog);

		sqlSession.close();
	}

	@Test
	public void queryBlogIF(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
//		map.put("title","Java2");
		map.put("author","狂神说2");

		List<Blog> blogs = mapper.queryBlogIF(map);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}

//		map.put("views",9999);
//		List<Blog> blogs = mapper.queryBlogChoose(map);
//		for (Blog blog : blogs) {
//			System.out.println(blog);
//		}

//		map.put("id","22fb386840cc47d98ab68c46465713c8");
//		mapper.updateBlog(map);

		sqlSession.close();
	}

	@Test
	public void queryBlogForeach(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
		ArrayList<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);

		map.put("ids",ids);
		List<Blog> blogs = mapper.queryBlogForeach(map);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}


		sqlSession.close();
	}
}
