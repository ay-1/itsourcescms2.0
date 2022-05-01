
package cn.itsource.cms.dao;

import cn.itsource.cms.domain.News;

import java.util.List;
import java.util.Map;

public interface NewsDao {
    /**
     * News模块的接口
     *
     * @return
     */
    List<News> queryNewsList();

    /**
     * 根据查询条件查询新闻列表
     *
     * @param isRecommend
     * @param keyword
     * @return
     */
    List<News> queryNewsList(String isRecommend, String keyword);

    /**
     * 根据id查询新闻数据
     *
     * @param newsId
     * @return
     */
    News queryNewById(Long newsId);

    /**
     * 根据id查询数据
     *
     * @param newsId
     * @return
     */
    News queryNewsById(Long newsId);

    /**
     * 根据id插入新闻数据
     *
     * @param news
     */
    void insert(News news);

    /**
     * 根据id删除新闻数据
     *
     * @param newsId
     */
    void delete(Long newsId);

    /**
     * 根据id更新新闻数据
     *
     * @param news
     */
    void update(News news);

    /**
     * 获取首页新闻数据
     *
     * @return
     */
    Map<String, List<News>> queryIndexInfo();


}
