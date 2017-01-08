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

    public List<User> fetchUsers(Integer page, Integer pageSize){
        int start=0,end=0;
        if(page!=null && page >=1){
            start=(page-1)*pageSize;
            end=page*pageSize;
        }
        return  fetch("select * from user limit ?,?",User.class,start,end);
    }

    public void create(String name, Integer age) {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
    }
    public void deleteByName(String name) {
        delete("delete from USER where NAME = ?", name);
    }
    public Integer getAllUsers() {
        return count("select count(1) from USER", Integer.class);
    }
    public void deleteAllUsers() {
        delete("delete from USER");
    }
}
