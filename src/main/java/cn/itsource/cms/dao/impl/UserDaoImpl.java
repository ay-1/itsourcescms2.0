package cn.itsource.cms.dao.impl;

import cn.itsource.cms.dao.UserDao;
import cn.itsource.cms.domain.User;
import cn.itsource.cms.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(String username, String password) {
        String sql = "select * from t_user where name=? and password=?";
//        获取工具类
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;//声明Connection数据库连接对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbc.getConn();//获取Connection(数据库连接)对象
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();//执行SQL语句,将SQL语句发送到数据库，执行SQL，返回执行结果
            User user = null;
            if (rs.next()) {//判断是否存在返回的数据列
                Long id = rs.getLong("id");
                String name = rs.getString("name");//数据字段名（列名）获取数据
                String pw = rs.getString("password");
                Integer type = rs.getInt("type");

                user=new User();
                user.setId(id);
                user.setName(name);
                user.setPassword(pw);
                user.setType(type);

                System.out.println(user);

            }
            return user;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close(rs, ps, conn);
        }
        return null;
    }
}
