package cn.itsource.cms.dao.impl;

import cn.itsource.cms.dao.NewsTypeDao;
import cn.itsource.cms.domain.News;
import cn.itsource.cms.domain.NewsType;
import cn.itsource.cms.domain.User;
import cn.itsource.cms.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsTypeDaoImpl implements NewsTypeDao {
    @Override
    public List<NewsType> queryNewsTypeList() {
        String sql = "select * from t_newstype";
        List<NewsType> list = new ArrayList<>();
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
                String name = rs.getString("name");

//                根据type-id查询NewsType对象

                //封装数据
                NewsType newsType = new NewsType();
                newsType.setId(id);
                newsType.setName(name);

                //将NewsType对象封装到List中
                list.add(newsType);

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
    public NewsType queryNewById(Long newsId) {
        return null;

    }

    @Override

    public void insert(NewsType newsType) {

    }

    @Override
    public void delete(Long newsTypeId) {

    }

    @Override
    public void update(NewsType newsType) {

    }
}
