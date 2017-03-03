package app.service.impl;

import app.service.UserServiceA;
import app.service.UserServiceB;
import app.service.base.AbstractBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sdlili on 17-3-3.
 */
@Service
public class UserServiceImplB extends AbstractBaseService implements UserServiceB {

    @Transactional
    public void updateOne(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.NESTED )
    public void updateMember(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public void updateUser(String name,int age){
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
        throw new RuntimeException();
    }
}
