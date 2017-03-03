package app.service.impl;

import app.models.User;
import app.service.UserService;
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


    public User get(long userId) {
        return (User) find("select * from user where id = ?",User.class,userId);

    }

    @Transactional
    public void save(String name, Integer age) throws Exception {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        updateOne(name+"1111", age);
        throw new Exception();
    }

    @Transactional
    public void updateOne(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
//        System.out.print(1/0);
    }


    @Transactional
    public void create(String name, Integer age) throws Exception {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        updateMember(name+"111", age);
        throw new Exception();
    }

    @Transactional(propagation = Propagation.NESTED )
    public void updateMember(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
//        System.out.print(1/0);
    }

    @Transactional
    public void add(String name, Integer age) throws Exception {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age, "111111");
        updateUser(name+"111",age);
//        System.out.print(1/0);
        throw new Exception();


    }

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public void updateUser(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
//        System.out.print(1/0);
    }




}
