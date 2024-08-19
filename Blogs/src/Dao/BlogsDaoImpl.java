package Dao;



import model.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogsDaoImpl extends Dao implements BlogsDao {


    //要加一个static,否则爆出栈空间异常,导致整个项目无法正常运行
    private static final BlogsDao blogsDao = new BlogsDaoImpl();

    /**
     * 添加博客信息
     * @param blog
     * @return
     * @throws Exception
     */
    @Override
    public int addBlogs(Blog blog) throws Exception {
        //1.获取数据库连接对象
        Connection connection = getConnection();
        //2.check是否满足添加条件
        Integer id = blog.getId();
        //添加一条博客信息
        //3.编写sql语句
        String sql = "insert into blogs(title,likes,favours,createTime,updateTime) values(?,?,?,?,?)";
        //4.获取数据库操作对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,blog.getTitle());
        statement.setInt(2,blog.getLikes());
        statement.setInt(3,blog.getFavours());
        statement.setString(4,blog.getCreateTime());
        statement.setString(5,blog.getUpdateTime());
        //5.执行sql语句
        int count = statement.executeUpdate();
        //6.关闭资源
        statement.close();
        connection.close();
        return count;
    }

    /**
     * 更新博客信息
     * @param blog
     * @return
     * @throws Exception
     */
    @Override
    public int updateBlogs(Blog blog) throws Exception {
        //1.获取数据库连接对象
        Connection connection = getConnection();
        //2.check是否满足更新条件
        if(check(String.valueOf(blog.getId()))) return 0;
        //3.执行sql语句
        String sql = "update blogs set title=?, likes=?,favours=?,createTime=?,updateTime=? " +
                "where id = ?";
        //4.获取数据库操作对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,blog.getTitle());
        statement.setInt(2,blog.getLikes());
        statement.setInt(3,blog.getFavours());
        statement.setString(4,blog.getCreateTime());
        statement.setString(5,blog.getUpdateTime());
        statement.setInt(6,blog.getId());
        //5.执行sql语句
        int count = statement.executeUpdate();
        //6.释放资源
        statement.close();
        connection.close();
        return count;
    }


    /**
     * 删除博客信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int delBlogs(Integer id) throws Exception {
        //1.获取数据库连接对象
        Connection connection = getConnection();
        //2.判断是否满足删除条件
        if(check(String.valueOf(id)))  return 0;
        //3.编写sql语句
        String sql = "delete from blogs where id = ?";
        //4.获取数据库操作对象
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,id);
        //5.执行sql语句,返回运行结果
        int count = statement.executeUpdate();
        //6.关闭资源
        statement.close();
        connection.close();
        return count;
    }

    /**
     * 查询所有的博客信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Blog> queryBlogs() throws Exception {

        //1.获取数据库操作对象
        Connection conn = getConnection();

        //2.编写sql语句
        String sql = "select * from blogs";
        //3.获取数据库操作对象
        PreparedStatement ps = conn.prepareStatement(sql);

        //4.执行SQL语句
        ResultSet rs = ps.executeQuery();


        //5.获取查询结果集
        List<Blog> list =new ArrayList<Blog>();
        while (rs.next()){
            Blog blogs =new Blog();
            String favour = rs.getString("favours");
            String likes = rs.getString("likes");
            blogs.setId(rs.getInt("id"));
            blogs.setTitle(rs.getString("title"));
            blogs.setFavours(Integer.parseInt(favour));
            blogs.setLikes(Integer.parseInt(likes));
            blogs.setCreateTime(rs.getString("createTime"));
            blogs.setUpdateTime(rs.getString("updateTime"));
            list.add(blogs);
        }
        //6.关闭连接，释放资源
        rs.close();
        ps.close();
        conn.close();
        return list;
    }


    /**
     * 模糊查询
     * @param text
     * @return
     * @throws Exception
     */
    @Override
    public List<Blog> queryBlogs(String text) throws Exception {

        //1.获取数据库操作对象
        Connection connection = getConnection();
        //2.执行sql语句
        String sql = "select * from blogs where title like ?";
        //3.获取数据库操作对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //模糊查询
        statement.setString(1,("%" + text + "%"));
        //4.执行sql语句
        ResultSet resultSet = statement.executeQuery();

        //5.处理查询结果集
        List<Blog> blogList = new ArrayList<>();
        while (resultSet.next())
        {
            int likes = resultSet.getInt("likes");
            int favours = resultSet.getInt("favours");
            String title = resultSet.getString("title");
            String updateTime = resultSet.getString("updateTime");
            int id = resultSet.getInt("id");
            String createTime = resultSet.getString("createTime");
            Blog blog = new Blog(id,title,likes,favours,createTime,updateTime);
            blogList.add(blog);
        }
        //6.关闭连接，释放资源
        resultSet.close();
        statement.close();
        connection.close();
        return blogList;
    }


    /**
     * 查询单条博客信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Blog queryOne(String id) throws Exception {
        //1.获取数据库操作对象
        Connection connection = getConnection();
        //2.编写sql语句
        String sql = "select * from blogs where id = ?";
        //3.获取数据库操作对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(id));
        //4.执行sql语句
        ResultSet resultSet = statement.executeQuery();
        //5.处理查询结果集
        Blog blog = null;
        while(resultSet.next()) {
            int Id = resultSet.getInt(1);
            String title = resultSet.getString("title");
            int likes = resultSet.getInt("likes");
            int favours = resultSet.getInt("favours");
            String createTime = resultSet.getString("createTime");
            String updateTime = resultSet.getString("updateTime");
            blog = new Blog(Integer.valueOf(id),title,likes,favours,createTime,updateTime);
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
        return blog;
    }

    /**
     * 用于检测是否满足添加要求和删除要求
     * @param id
     * @return
     * @throws Exception
     */
    public boolean check(String id) throws Exception {
        Blog res = blogsDao.queryOne(id);
        if(res != null)
            return false;
        return true;
    }
}
