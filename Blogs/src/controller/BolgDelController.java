package controller;

import service.BlogService;
import service.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 删除博客Controller
 */
@WebServlet("/blog/del")
public class BolgDelController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    public BolgDelController() throws Exception {
    }

    /**
     * 删除博客
     * @param request 前端请求对象
     * @param response 前端响应对象
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {
        //1.设置请求响应格式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取数据
        String queryString = request.getQueryString();
        String[] ops = queryString.split("=");
        String id = ops[1];
        try
        {
            //3.删除博客信息
            PrintWriter writer = response.getWriter();
            String info = blogService.delBlogs(Integer.parseInt(id));
            //4.返回结果
            writer.write(info);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
