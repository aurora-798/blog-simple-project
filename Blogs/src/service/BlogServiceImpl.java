package service;

import Dao.BlogsDao;
import Dao.BlogsDaoImpl;
import model.Blog;

import java.util.List;

/**
 * blogService实现类
 */
public class BlogServiceImpl implements BlogService{
    BlogsDao blogsDao = new BlogsDaoImpl();

    public BlogServiceImpl() throws Exception {
    }

    /**
     * 添加博客
     * @param blogs 博客信息
     * @return 返回添加结果
     * @throws Exception 处理异常
     */
    @Override
    public String addBlogs(Blog blogs) throws Exception {
        int count = blogsDao.addBlogs(blogs);
        if(count > 0) return "添加成功";
        return "添加失败";
    }

    /**
     * 更新博客
     * @param blogs 更新博客信息
     * @return 返回更新结果
     * @throws Exception 处理异常
     */
    @Override
    public String updateBlogs(Blog blogs) throws Exception {
        int count = blogsDao.updateBlogs(blogs);
        if(count > 0) return "更新成功";
        return "删除失败";
    }

    /**
     * 删除博客
     * @param id 删除博客id
     * @return  返回删除结果
     * @throws Exception   处理异常
     */
    @Override
    public String delBlogs(Integer id) throws Exception {
        int count = blogsDao.delBlogs(id);
        if(count > 0) return "删除成功";
        return "删除失败";
    }

    /**
     * 查询博客
     * @return 返回所有博客信息
     * @throws Exception 处理异常
     */
    @Override
    public List<Blog> queryBlogs() throws Exception {
        List<Blog> blogs = blogsDao.queryBlogs();
        return blogs;
    }

    /**
     * 模糊查询
     * @param text 查询关键词
     * @return 返回符合要求的博客信息集合
     * @throws Exception 处理异常
     */
    @Override
    public List<Blog> queryBlogs(String text) throws Exception {
        List<Blog> blogList = blogsDao.queryBlogs(text);
        return blogList;
    }


    /**
     * 根据id获取博客信息
     * @param id 博客id
     * @return  返回博客信息
     * @throws Exception  处理异常
     */
    @Override
    public Blog getOneBlog(String id) throws Exception {
        Blog blog = blogsDao.queryOne(id);
        return blog;
    }
}
