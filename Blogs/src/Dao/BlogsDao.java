package Dao;
import model.Blog;

import java.util.List;

/**
 * 博客blogDao接口
 */
public interface BlogsDao {
    /**
     * 添加博客
     * @param blog 博客信息
     * @return 返回添加结果
     * @throws Exception 处理异常
     */
     int addBlogs(Blog blog)throws Exception;

    /**
     * 更新博客
     * @param blog 更新博客信息
     * @return 返回更新结果
     * @throws Exception 处理异常
     */
     int updateBlogs(Blog blog)throws Exception;

    /**
     * 删除博客
     * @param id 删除博客id
     * @return  返回删除结果
     * @throws Exception   处理异常
     */
     int delBlogs(Integer id)throws Exception;



    /**
     * 查询博客
     * @return 返回所有博客集合
     * @throws Exception 处理异常
     */
     List<Blog> queryBlogs()throws Exception;

    /**
     * 模糊查询
     * @param text 查询关键词
     * @return 返回符合要求的博客信息集合
     * @throws Exception 处理异常
     */

     List<Blog> queryBlogs(String text) throws Exception;


    /**
     * 根据id获取博客信息
     * @param id 博客id
     * @return  返回博客信息
     * @throws Exception  处理异常
     */
     Blog queryOne(String id) throws Exception;
}
