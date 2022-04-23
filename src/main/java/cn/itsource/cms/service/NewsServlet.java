package cn.itsource.cms.service;

import cn.itsource.cms.dao.NewsTypeDao;
import cn.itsource.cms.dao.impl.NewsDaoImpl;
import cn.itsource.cms.dao.impl.NewsTypeDaoImpl;
import cn.itsource.cms.domain.News;
import cn.itsource.cms.domain.NewsType;
import cn.itsource.cms.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    NewsDaoImpl newsDao = new NewsDaoImpl();
    NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("NewsServlet.service()");
        //1.获取客户端提交过来的参数
        String cmd = request.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(request, response);
        } else if ("add".equals(cmd)) {
            add(request, response);


        } else if ("input".equals(cmd)) {
            input(request, response);

        } else {
            list(request, response);
        }
    }

    /**
     * 输出数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        收集表单参数
        String isRecommend = request.getParameter("isRecommend");
        String keyword = request.getParameter("keyword");
//在获取请求参数时，如果不存在获取key，name获取到的值是null，所以需要判断
        if(isRecommend==null || "".equals(isRecommend)){
            isRecommend ="0";
        }
        if(keyword==null){
            keyword="";
        }

        //            查询数据库
        List<News> newsList = newsDao.queryNewsList(isRecommend,keyword);

        //2.将新闻列表数据封装到request对象
        request.setAttribute("newsList", newsList);
        //获取RequestDispatcher,并设置跳转（转发）路径
        RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/web/system/news/newsList.jsp");
//        RequestDispatcher rd = request.getRequestDispatcher("./newsList.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/web/system/news/newsEdit.jsp");

        // 触发跳转
        rd.forward(request, response);
    }

    /**
     * 编辑数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*  //          查询新闻类型数据
                List<NewsType> newsTypeList=newsTypeDao.queryNewsTypeList();
                request.setAttribute("newsTypeList",newsTypeList);

                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/web/system/news/newsEdit.jsp");
                rd.forward(request, response);*/
        String newsId = request.getParameter("newsId");
        //判断请求参数中是否有newsId
        if (newsId != null && !"".equals(newsId)) {
            //强转
            Long id = Long.valueOf(newsId);
            //根据newsId查询新闻数据

            News news = newsDao.queryNewsById(id);
            //将新闻数据封装到request对象中
            System.out.println(newsId);
            request.setAttribute("news", news);
        }
        //          查询新闻类型数据

        List<NewsType> newsTypeList = newsTypeDao.queryNewsTypeList();
        request.setAttribute("newsTypeList", newsTypeList);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/web/system/news/newsEdit.jsp");
        rd.forward(request, response);
    }

    /**
     * 添加数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //            跳转（转发）到添加页面newsEdit.jsp
        //收集新闻数据
        String newsId = request.getParameter("newsId");
        String title = request.getParameter("title");
        String isRecommend = request.getParameter("isRecommend");
        String newsType = request.getParameter("newsType");
        String context = request.getParameter("context");
        Long typeId = Long.valueOf(newsType);
        System.out.println(typeId);

        Boolean isR = Boolean.valueOf(isRecommend);
//            封装参数到News对象中
        News news = new News();
        NewsType nt = new NewsType();
        User user = new User();

        nt.setId(typeId);
        news.setTitle(title);
        news.setNewsType(nt);
        news.setIsRecommend(isR);
        news.setContext(context);
        news.setViewCount(0);
        user.setId(1L);
        news.setUser(user);
        if (newsId != null && !"".equals(newsId)) {
            //强转
            Long id = Long.valueOf(newsId);
            //封装id
            news.setId(id);

            //编辑
            newsDao.update(news);
        } else {
            //3、新增调用dao层的添加方法，完成添加
            newsDao.insert(news);
        }
        System.out.println(news);
        //调用dao层的添加方法，完成添加
//            newsDao.insert(news);
        //重定向到列表页面
        response.sendRedirect("./news");
    }

    /**
     * 根据id删除新闻数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newsId = request.getParameter("newsId");
        Long id = Long.valueOf(newsId);

//            调用dao代码，删除数据
        newsDao.delete(id);
//            跳转；重定向（刷新数据）
        response.sendRedirect("./news");
    }

}
