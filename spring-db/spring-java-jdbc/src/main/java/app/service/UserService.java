package app.service;

import app.models.User;

import java.util.List;

/**
 * Created by lili19289 on 2016/12/26.
 */
public interface UserService {

    /**
     * 查询user
     *
     * @param id
     * @return
     */
    User get(long id);


}