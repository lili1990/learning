package app.service;

import app.models.User;
import app.mybatis.Page;

/**
 * Created by lili19289 on 2016/8/4.
 */
public interface UserService {

    public User getUserById(long userId);

    public User fetchUsers(long userId,Page page);
}
