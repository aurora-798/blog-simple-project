package controller;

import com.alibaba.fastjson.JSONObject;
import model.Blog;
import service.BlogService;
import service.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * 添加博客Controller
 */

@WebServlet("/blog/add")
public class BlogAddController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    public BlogAddController() throws Exception {
    }

    /**
     * 添加博客
     * @param request 前端请求对象
     * @param response 前端响应对象
     * @throws ServletException 处理异常
     * @throws IOException 处理异常
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置请求响应格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        //2.获取数据封装到Blog对象中
        String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Blog blog = JSONObject.parseObject(collect, Blog.class);


        PrintWriter writer = response.getWriter();
            try {
                //3.获取执行结果
                String info = blogService.addBlogs(blog);
                //4.返回执行结果信息
                writer.write(info);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
