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
 * 更新博客Controller
 */

@WebServlet("/blog/update")
public class BlogUpdateController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();
    public BlogUpdateController() throws Exception {
    }


    /**
     * 更新博客
     * @param request 前端请求对象
     * @param response 前端响应对象
     * @throws IOException 处理异常
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //1.设置请求响应格式
//        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        //2.获取数据
        String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Blog blog = JSONObject.parseObject(collect, Blog.class);

        try {
            PrintWriter writer = response.getWriter();
            //3.更新数据
            String info = blogService.updateBlogs(blog);
            //4.返回执行结果
            writer.write(info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
