package app.service.impl;

import app.models.User;
import app.service.UserService;
import app.service.base.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User get(long userId) {
        return (User) find("select * from user where id = ?",User.class,userId);

    }



    public void create(String name, Integer age) {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException("事务测试");
    }


}
