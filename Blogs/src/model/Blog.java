package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;

/**
 * Blog 实体类
 */
public class Blog {

    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;


    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 收藏数量
     */
    private Integer favours;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    public Blog() {}
    public Blog(Integer id, String title, Integer likes, Integer favours, String createTime, String updateTime) {
        this.id = id;
        this.title = title;
        this.likes = likes;
        this.favours = favours;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getFavours() {
        return favours;
    }

    public void setFavours(Integer favours) {
        this.favours = favours;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }




    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", likes=" + likes +
                ", favours=" + favours +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
