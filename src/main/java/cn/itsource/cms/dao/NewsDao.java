
package cn.itsource.cms.dao;

import cn.itsource.cms.domain.News;

import java.util.List;

public interface NewsDao {
    /**
     * News模块的接口
     * @return
     */
    public List<News> queryNewsList();

    /**
     *根据查询条件查询新闻列表
     *
     * @param isRecommend
     * @param keyword
     * @return
     */
    public List<News> queryNewsList(String isRecommend, String keyword);

    /**
     * 根据id查询新闻数据
     * @param newsId
     * @return
     */
    public News queryNewById(Long newsId);

    /**
     * 根据id插入新闻数据
     * @param news
     */
    public void insert(News news);

    /**
     * 根据id删除新闻数据
     * @param newsId
     */
    public void delete(Long newsId);

    /**
     * 根据id更新新闻数据
     * @param news
     */
    public void update(News news);
}
