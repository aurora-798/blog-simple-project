import Dao.BlogsDao;
import Dao.BlogsDaoImpl;
import model.Blog;
import service.BlogService;
import service.BlogServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BlogService service = new BlogServiceImpl();
        List<Blog> blogList = service.queryBlogs();
        System.out.println(blogList);
    }
}
