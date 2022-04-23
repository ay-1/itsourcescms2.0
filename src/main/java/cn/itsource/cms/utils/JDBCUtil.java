package cn.itsource.cms.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private JDBCUtil(){

    }
    private static JDBCUtil instance = null;
    static Properties p =null;
    static {
        try{
            p = new Properties();
            InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            p.load(is);
            String driver = p.getProperty("driver");
            Class.forName(driver);
            instance = new JDBCUtil();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static JDBCUtil getInstance(){
        return instance;
    }
    public Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (st != null) {
                    st.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if(conn != null){
                        conn.close();
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
public static void main(String[] args) throws SQLException {
    String sql = "select * from t_news";
        JDBCUtil jdbc = JDBCUtil.getInstance();
    Connection conn = jdbc.getConn();
    PreparedStatement ps=conn.prepareStatement(sql);
    ResultSet rs=ps.executeQuery();
    while (rs.next()) {
        String id=rs.getString("id");
       String title= rs.getString("title");
       String context= rs.getString("context");
        System.out.println(id+"     "+title+"       "+context);

    }
    jdbc.close(rs,ps,conn);
}
}
