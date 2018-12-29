package app.service.impl;

import app.models.User;
import app.service.UserService;
import app.service.base.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {



    public User get(long userId) {
        return (User) find(" select * from user where id = ? ",User.class,userId);

    }


    @Override
    public void update(String sql, Object... params) {

    }
}
