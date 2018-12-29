package app.service.impl;

import app.models.User;
import app.service.UserService;
import app.service.base.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Resource
    private TransactionTemplate transacationTemplate;


    public User get(long userId) {
        return (User) find("select * from user where id = ?",User.class,userId);

    }



    public void create(String name, Integer age) {
            save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
            throw new RuntimeException("事务测试");
    }


    public void add(String name, Integer age) {

        transacationTemplate.execute(new TransactionCallback(){

            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try{
                    save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
                   System.out.print(1/0);
                }catch (Exception e){
                    throw e;
                }

                return true;
            }
        });


    }


}
