package Dao;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 定义了需要操作数据库的配置
 */
public class Dao {
    public static String dburl = "jdbc:mysql://localhost:3306/blogs";
    public static String username ="root";
    public static String password ="123456";
    public Connection getConnection()throws Exception{
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建连接对象
        Connection conn = DriverManager.getConnection(dburl, username, password);
        return conn;
    }
}
