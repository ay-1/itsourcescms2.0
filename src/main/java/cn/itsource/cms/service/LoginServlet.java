package cn.itsource.cms.service;

import cn.itsource.cms.dao.UserDao;
import cn.itsource.cms.dao.impl.UserDaoImpl;
import cn.itsource.cms.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    //    UserDao userDao = new UserDaoImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到LoginServlet进行操作");
        String cmd = request.getParameter("cmd");
        if ("logout".equals(cmd)) {
//            退出操作
            System.out.println("LoginServlet登录为logout");
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("USER_IN_SESSION");
            System.out.println(u.getName() + "退出系统……");
            //删除session的用户信息
            session.removeAttribute("USER_IN_SESSION");
            response.sendRedirect("login.jsp");
        } else if ("login".equals(cmd)) {

//          登录
//        1.获取请求参数
            System.out.println("LoginServlet 登录为login");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDao userDao = new UserDaoImpl();
            User user = userDao.checkUser(username, password);

            System.out.println(user);
//        2.使用请求参数（用户名和密码）作为条件查询数据库
            /*
             * 1.存在用户，等牢固成功
             * 2.用户不存在，登录失败，重定向到登录页面
             */
            if (user != null) {
                System.out.println("LoginServlet user不为空"+user);
                HttpSession session = request.getSession();
                session.setAttribute("USER_IN_SESSION", user);
                User u = (User) session.getAttribute("USER_IN_SESSION");
                session.getAttribute(u.getName() + "登录系统…");
                request.getRequestDispatcher("./WEB-INF/web/system/manage.jsp").forward(request, response);
            } else {
                System.out.println("LoginServlet user为空"+user);
                request.setAttribute("errorMsg", "您的账号或者密码不正确，请重新登录！");
                request.getRequestDispatcher("./login.jsp").forward(request, response);
            }


//        3、将用户信息保存在session中

//        4.跳转到manage.jsp页面中
        }
    }

}