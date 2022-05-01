package cn.itsource.cms.Filter;

import cn.itsource.cms.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//, urlPatterns = "/*"
@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("loginFilter.doFilter()");
//        强转request.response对象
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        获取访问的资源名称
        String resourcePath = httpRequest.getRequestURI();
        System.out.println(resourcePath);

//        if ("/cms/login.jsp".equals(resourcePath) || "/cms/login".equals(resourcePath)) {
        if (resourcePath != null && (
                resourcePath.contains("/cms/login")
                        || resourcePath.contains("/cms/LoginServlet")
                        || resourcePath.contains("/cms/index")
                        || resourcePath.contains("/index")
                        || resourcePath.contains("index")

                        || resourcePath.endsWith(".css")
                        || resourcePath.endsWith(".png")
                        || resourcePath.endsWith(".ico")
                        || resourcePath.endsWith(".jpg")
        )) {
            //        放行的目标资源
            System.out.println("第一不为空");
            chain.doFilter(request, response);
        } else {
//            从session中获取用户信息

            HttpSession session = httpRequest.getSession();
            User user = (User) session.getAttribute("USER_IN_SESSION");
//            判断是否登录；
            System.out.println("LoginFiter user为:" + user);
            if (user != null) {
                //            判断是否登录，从session获取登录信息，如果不为空，这放行到目标地址a
                System.out.println("登录判断不为空");
                chain.doFilter(request, response);
            } else {
                //            如果为空，则跳转到登录页面
                System.out.println("登录为空");
                httpResponse.sendRedirect("./login.jsp");

            }


        }
    }
}
