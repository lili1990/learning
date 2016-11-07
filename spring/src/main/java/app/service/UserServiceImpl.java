package app.service;

import app.dao.UserDao;
import app.models.User;
import app.mybatis.Page;
import app.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

/**
 * Created by lili19289 on 2016/8/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUser(String username, String password) {
        return null;
    }

    public User getUserById(long userId) {
        return userDao.findById(userId);
    }

    public User fetchUsers(long userId,Page page) {
        return userDao.fetchUser(userId,page);
    }
}
