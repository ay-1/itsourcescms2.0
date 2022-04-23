package cn.itsource.cms.dao;

import cn.itsource.cms.domain.NewsType;

import java.util.List;

/**
 * NewsTypeType模块的接口
 * @author Administorator
 */
public interface NewsTypeDao {
    /**
     * NewsType模块的接口
     * @return
     */
    public List<NewsType> queryNewsTypeList();

    /**
     * 根据id查询新闻分类数据
     * @param newsTypeId
     * @return
     */
    public NewsType queryNewById(Long newsTypeId);

    /**
     * 根据id插入新闻分类数据
     * @param newsType
     */
    public void insert(NewsType newsType);

    /**
     * 根据id删除新闻分类数据
     * @param newsTypeId
     */
    public void delete(Long newsTypeId);

    /**
     * 根据id更新新闻分类数据
     * @param newsType
     */
    public void update(NewsType newsType);
}
