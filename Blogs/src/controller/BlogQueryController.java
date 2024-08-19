package controller;

import com.alibaba.fastjson.JSONArray;
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
import java.net.URLDecoder;
import java.util.List;

/**
 * 查询博客Controller
 */

@WebServlet("/blog/query")
public class BlogQueryController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    public BlogQueryController() throws Exception {
    }


    /**
     * 添加博客
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    /**
     * 查询博客(查询所有、模糊查询、id查询)
     * @param request 前端请求对象
     * @param response 前端响应对象
     * @throws ServletException 处理异常
     * @throws IOException 处理异常
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置请求响应格式
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //2.获取操作类型
        String ops = request.getParameter("ops");

        PrintWriter writer = response.getWriter();

        //3.根据操作类型来执行不同的操作
        /**
         * 查询所有博客信息
         */
        if("query".equals(ops))
        {
            try {
                JSONArray jsonArray = new JSONArray();
                List<Blog> blogs = blogService.queryBlogs();
                for(int i=0;i<blogs.size();i++)
                {
                    jsonArray.add(blogs.get(i));
                }
                writer.write(jsonArray.toJSONString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        /**
         * 指定id查询
         */
        else if("one".equals(ops))
        {
            String id = request.getParameter("queryone");
            try {
                Blog blog = blogService.getOneBlog(id);
                writer.write(JSONObject.toJSONString(blog));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        /**
         * 模糊查询
         */
        else if("find".equals(ops))
        {
            try {
                String text = request.getParameter("text");
                List<Blog> blogList = blogService.queryBlogs(text);
                JSONArray jsonArray = new JSONArray();
                for(int i=0;i<blogList.size();i++)
                {
                    jsonArray.add(blogList.get(i));
                }
                writer.write(jsonArray.toJSONString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
