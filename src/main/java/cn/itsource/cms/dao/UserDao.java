package cn.itsource.cms.dao;

import cn.itsource.cms.domain.User;

public interface UserDao {
    /**
     * 检查用户是否存在
     * @param usernaem
     * @param password
     * @return
     */
    public User checkUser(String usernaem,String password);
}
