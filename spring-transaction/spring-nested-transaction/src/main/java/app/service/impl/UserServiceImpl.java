package app.service.impl;

import app.models.User;
import app.service.UserService;
import app.service.UserServiceA;
import app.service.base.AbstractBaseService;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserServiceA userServiceA;


    public User get(long userId) {
        return (User) find("select * from user where id = ?",User.class,userId);

    }

    @Transactional
    public void saveA(String name, Integer age) throws Exception {
        userServiceA.updateOne(name+"1111", age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }


    @Transactional
    public void createA(String name, Integer age) throws Exception {
        userServiceA.updateMember(name+"111", age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }



    @Transactional
    public void addA(String name, Integer age) throws Exception {
        userServiceA.updateUser(name+"111",age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age, "111111");
        throw new RuntimeException();


    }

    @Transactional
    public void saveB(String name, Integer age) throws Exception {
        userServiceA.updateOne(name+"1111", age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }


    @Transactional
    public void createB(String name, Integer age) throws Exception {
        userServiceA.updateMember(name+"111", age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
    }



    @Transactional
    public void addB(String name, Integer age) throws Exception {
        userServiceA.updateUser(name+"111",age);
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age, "111111");

    }





}
