package cn.itsource.cms.service;


import cn.itsource.cms.dao.NewsDao;
import cn.itsource.cms.dao.impl.NewsDaoImpl;
import cn.itsource.cms.domain.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    NewsDao newsDao = new NewsDaoImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("IndexService.service");
        String cmd = request.getParameter("cmd");

        if ("details".equals(cmd)) {
//            获取newsId
            String newsId = request.getParameter("newsId");
//            强转
            Long id = Long.valueOf(newsId);
//      根据新闻id增加浏览量
            viewCountiIncreasing(id);
//            根据id查询新闻信息
            News news = newsDao.queryNewsById(id);
            //将新闻数据封装到request对象中
            request.setAttribute("news", news);
            //跳转，转发
            Map<String, List<News>> map = newsDao.queryIndexInfo();

            //将列表数据封装到request对象中
            request.setAttribute("recommendList", map.get("recommendList"));
            request.setAttribute("recentList", map.get("recentList"));
            request.setAttribute("hotNewsList", map.get("hotNewsList"));
            request.getRequestDispatcher("./WEB-INF/web/html/details.jsp").forward(request, response);
//            newsDao.queryNewsById(newsId);

//            将新闻数据封装到request对象中
        } else {

//获取首页新闻数据
            Map<String, List<News>> map = newsDao.queryIndexInfo();

            //将列表数据封装到request对象中
            request.setAttribute("recommendList", map.get("recommendList"));
            request.setAttribute("recentList", map.get("recentList"));
            request.setAttribute("hotNewsList", map.get("hotNewsList"));

//        跳转到前台首页
            request.getRequestDispatcher("/WEB-INF/web/html/index.jsp").forward(request, response);

        }

    }

    /**
     * @param id 根据id增加浏览量
     */
    private void viewCountiIncreasing(Long id) {

//    查询数据
        News news = newsDao.queryNewsById(id);
        //修改News中的viewCount
//    Integer vc = news.getViewCount();
//    news.setViewCount(vc+1);
        news.setViewCount(news.getViewCount() + 1);
        newsDao.update(news);
    }

}
