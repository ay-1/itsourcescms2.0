package cn.itsource.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Long id;             //bigint(20) NOT NULL AUTO_INCREMENT,  新闻id
    private String title;          //varchar(100) DEFAULT NULL,         新闻标题
    private String context;        //longtext                           新闻内容
    private String imgUrl;         //varchar(200) DEFAULT NULL,         新闻图片路径
    private Integer viewCount;      //int(11) DEFAULT NULL,             点击量（浏览量）
    private Boolean isRecommend;    //bit(1) DEFAULT NULL,              是否推荐
    private Date inputDate;      //datetime DEFAULT NULL,               录入日期
    private Long type_id;        //bigint(20) DEFAULT NULL,             新闻类型id
    private NewsType newsType;
    private User user;
    private String imgSmallUrl;   //varchar(255) DEFAULT NULL,          小图片路径

    public News() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isrecommend) {
        isRecommend = isrecommend;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImgSmallUrl() {
        return imgSmallUrl;
    }

    public void setImgSmallUrl(String imgSmallUrl) {
        this.imgSmallUrl = imgSmallUrl;
    }

    public News(Long id, String title, String context, String imgUrl, Integer viewCount, Boolean isRecommend, Date inputDate, Long type_id, NewsType newsType, User user, String imgSmallUrl) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.imgUrl = imgUrl;
        this.viewCount = viewCount;
        this.isRecommend = isRecommend;
        this.inputDate = inputDate;
        this.type_id = type_id;
        this.newsType = newsType;
        this.user = user;
        this.imgSmallUrl = imgSmallUrl;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", viewCount=" + viewCount +
                ", isRecommend=" + isRecommend +
                ", inputDate=" + inputDate +
                ", type_id=" + type_id +
                ", newsType=" + newsType +
                ", user=" + user +
                ", imgSmallUrl='" + imgSmallUrl + '\'' +
                '}';
    }


}
