package cn.itsource.cms.dao.impl;

import cn.itsource.cms.dao.NewsDao;
import cn.itsource.cms.domain.News;
import cn.itsource.cms.domain.NewsType;
import cn.itsource.cms.domain.User;
import cn.itsource.cms.utils.JDBCUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    /**
     * 查询所有新闻数据，返回新闻列表数据
     */
    @Override
    public List<News> queryNewsList() {
        String sql = "select * from t_news";
        List<News> list = new ArrayList<>();
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            while (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");//数据字段名（列名）获取数据
                String title = rs.getString("title");
                String context = rs.getString("context");
                Integer viewCount = rs.getInt("viewCount");
                Boolean isRecommend = rs.getBoolean("isRecommend");
                Date inputDate = rs.getDate("inputDate");
                Long type_id = rs.getLong("type_id");
                Long user_id = rs.getLong("user_id");
//                根据type-id查询NewsType对象
                NewsType newsType = queryNewsTypeById(type_id);
//                 根据user_id 查询User对象
                User user = queryUserById(user_id);
                //封装数据
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContext(context);
                news.setViewCount(viewCount);
                news.setIsRecommend(isRecommend);
                news.setInputDate(inputDate);
                news.setNewsType(newsType);
                news.setUser(user);
                //将News对象封装到List中
                list.add(news);

//                System.out.println(id+"     "+title+"       "+context);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }

    @Override
    public News queryNewById(Long newsId) {
        return null;
    }

    /**
     * 根据新闻类型id查询新闻类型对象
     * @param typeid
     * @return
     */
    public NewsType queryNewsTypeById(long typeid) {
        String sql = "select * from t_newstype where id=?";
//        List<News> list = new ArrayList<>();
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            ps.setLong(1, typeid);
            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            NewsType newsType = new NewsType();
            while (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");//数据字段名（列名）获取数据
                String name = rs.getString("name");
                //封装数据
                newsType.setId(id);
                newsType.setName(name);
            }
            return newsType;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }

    /**
     * 根据用户id查询用户对象
     *
     * @param userId
     * @return
     */
    public User queryUserById(Long userId) {
        String sql = "select * from t_user where id=?";
//        List<News> list = new ArrayList<>();
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            User user = new User();
            while (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");//数据字段名（列名）获取数据
                String name = rs.getString("name");
                String password = rs.getString("password");
                Integer type = rs.getInt("type");
                //封装数据
                user.setId(id);
                user.setPassword(password);
                user.setName(name);
                user.setType(type);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }

    public News queryNewsById(Long newsId) {
        String sql = "select * from t_news where id=?";
//        获取工具类
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            System.out.println(newsId);
            ps.setLong(1, newsId);
            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            News news = new News();
            if (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");//数据字段名（列名）获取数据
                String title = rs.getString("title");
                String context = rs.getString("context");
                Integer viewCount = rs.getInt("viewCount");
                Boolean isRecommend = rs.getBoolean("isRecommend");
                Date inputDate = rs.getDate("inputDate");
                Long type_id = rs.getLong("type_id");
                Long user_id = rs.getLong("user_id");
//                根据type-id查询NewsType对象
                NewsType newsType = queryNewsTypeById(type_id);
//                 根据user_id 查询User对象
                User user = queryUserById(user_id);
                //封装数据

                news.setId(id);
                news.setTitle(title);
                news.setContext(context);
                news.setViewCount(viewCount);
                news.setIsRecommend(isRecommend);
                news.setInputDate(inputDate);
                news.setNewsType(newsType);
                news.setUser(user);
                System.out.println(news);

            }
            return news;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }

    @Override
    public void insert(News news) {
        String sql = "insert into t_news(title,context,viewCount,isRecommend,inputDate,type_id,user_id) values(?,?,?,?,?,?,?)";
        System.out.println(sql);
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;

        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContext());
            ps.setInt(3, news.getViewCount());
            ps.setBoolean(4, news.getIsRecommend());
            long currentTimeMillis = System.currentTimeMillis();
            ps.setTimestamp(5, new Timestamp(currentTimeMillis));
            ps.setLong(6, news.getNewsType().getId());
            ps.setLong(7, news.getUser().getId());
//        ps.setLong(7,news.getUser().getId());


            int i = ps.executeUpdate();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            System.out.println(sql);
            System.out.println("受影响的行" + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbc.close(null, ps, conn);
        }


    }

    @Override
    public void delete(Long newsId) {
        String sql = "delete from t_news where id=?";
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;

        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            ps.setLong(1, newsId);
            int i = ps.executeUpdate();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            System.out.println("受影响的行" + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbc.close(null, ps, conn);
        }


    }

    @Override
    public void update(News news) {
        String sql = "update  t_news set title=?,context=?,viewCount=?,isRecommend=?,type_id=?,user_id=? where id=? ";
        System.out.println(sql);
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;

        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContext());
            ps.setInt(3, news.getViewCount());
            ps.setBoolean(4, news.getIsRecommend());
            long currentTimeMillis = System.currentTimeMillis();
            ps.setLong(5, news.getNewsType().getId());
            ps.setLong(6, news.getUser().getId());
            ps.setLong(7, news.getId());

            int i = ps.executeUpdate();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            System.out.println(sql);
            System.out.println("受影响的行" + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            jdbc.close(null, ps, conn);
        }
    }

    public List<News> queryNewsList(String isRecommend, String keyword) {
        String sql = "select * from t_news where (title like ? or context like ?)";
        List<News> list = new ArrayList<>();
        //获取工具对象
//        ArrayList<News> list = new ArrayList<>();
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if(keyword==null || "".equals(keyword)){
                keyword = "%%";

            }else {
                keyword = "%" +keyword +"%";
            }
            if (!"0".equals(isRecommend)) {
                sql = sql+" and isRecommend=?";


            }
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            if (!"0".equals(isRecommend)) {
                Boolean isRc=  Boolean.valueOf(isRecommend);
                ps.setBoolean(3,isRc);

            }

            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            while (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");//数据字段名（列名）获取数据
                String title = rs.getString("title");
                String context = rs.getString("context");
                Integer viewCount = rs.getInt("viewCount");
                Boolean isR = rs.getBoolean("isRecommend");
                Date inputDate = rs.getDate("inputDate");
                Long type_id = rs.getLong("type_id");
                Long user_id = rs.getLong("user_id");
//                根据type-id查询NewsType对象
                NewsType newsType = queryNewsTypeById(type_id);
//                 根据user_id 查询User对象
                User user = queryUserById(user_id);
                //封装数据
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContext(context);
                news.setViewCount(viewCount);
                news.setIsRecommend(isR);
                news.setInputDate(inputDate);
                news.setNewsType(newsType);
                news.setUser(user);
                //将News对象封装到List中
                list.add(news);

//                System.out.println(id+"     "+title+"       "+context);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }
}
