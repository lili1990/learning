package app.service;

import app.models.User;

/**
 * Created by lili19289 on 2016/12/26.
 */
public interface UserService {

    User get(long id);

    public void save(String name, Integer age) throws Exception;

    void create(String name, Integer age) throws Exception;

    public void add(String name, Integer age) throws Exception;

}
