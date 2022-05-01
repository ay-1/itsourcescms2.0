package cn.itsource.cms.test;

import cn.itsource.cms.dao.impl.NewsDaoImpl;
import cn.itsource.cms.domain.News;
import cn.itsource.cms.domain.NewsType;
import cn.itsource.cms.domain.User;
import org.junit.Test;

import java.util.List;

public class TestNewsDao {
    @Test
    public void testQueryNewsList() {
       NewsDaoImpl newdao = new NewsDaoImpl();
       List<News> list = newdao.queryNewsList();
       System.out.println(list);

    }

        public void testQueryNewsById() {
            NewsDaoImpl newDao = new NewsDaoImpl();
            News news = newDao.queryNewsById(1L);
            System.out.println(news);

        }
    public void testUpdate() {
        NewsDaoImpl newDao = new NewsDaoImpl();
        News news=new News();
        NewsType newsType =new NewsType();
        User user = new User();
        newsType.setId(1L);
        user.setId(0L);
        news.setId(49L);
        news.setViewCount(0);
        news.setTitle("7787");
        news.setContext("555555");
        news.setIsRecommend(true);
        news.setNewsType(newsType);
        news.setUser(user);
        newDao.update(news);
        System.out.println(news);

    }

    @Test
    public void testqueryNewsList() {
        NewsDaoImpl newdao = new NewsDaoImpl();
        List<News> list = newdao.queryNewsList("false", null);
        System.out.println(list);
    }

    @Test
    public void testqueryNewsListBySql() {
        NewsDaoImpl newdao = new NewsDaoImpl();
//         推荐新闻
        String sql1 = "select * from t_news where isRecommend = 1 limit 0,5";
//        最新新闻
        String sql2 = "select * from t_news order by inputDate desc limit 0,5";
//        热门新闻
        String sql3 = "select * from t_news order by viewCount desc limit 0,5";
        List<News> list1 = newdao.queryNewsListBySql(sql1);
        List<News> list2 = newdao.queryNewsListBySql(sql2);
        List<News> list3 = newdao.queryNewsListBySql(sql3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

    @Test
    public void testQueryIndexInfo() {
        NewsDaoImpl newDao = new NewsDaoImpl();
        System.out.println(newDao.queryIndexInfo());

    }
}
