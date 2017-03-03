package app.service;

import app.models.User;

/**
 * Created by lili19289 on 2016/12/26.
 */
public interface UserService {

    User get(long id);

    public void saveA(String name, Integer age) throws Exception;

    void createA(String name, Integer age) throws Exception;

    public void addA(String name, Integer age) throws Exception;

    public void saveB(String name, Integer age) throws Exception;

    void createB(String name, Integer age) throws Exception;

    public void addB(String name, Integer age) throws Exception;

}
