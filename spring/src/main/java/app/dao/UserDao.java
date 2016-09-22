package app.dao;

import app.models.User;
import app.mybatis.Page;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lili19289 on 2016/8/4.
 */
public interface UserDao extends DAOBase{

    public User findById(Long userId);

    public User fetchUser(@Param("userId")long userId, Page page);
}
