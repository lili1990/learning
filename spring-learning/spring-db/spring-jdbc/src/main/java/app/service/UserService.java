package app.service;

import app.models.User;

import java.util.List;

/**
 * Created by lili19289 on 2016/12/26.
 */
public interface UserService {

    /**
     * 查询user
     * @param id
     * @return
     */
    User get(long id);

    List<User> fetchUsers(Integer page, Integer pageSize);

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);
    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);
    /**
     * 获取用户总量
     */
    Integer getAllUsers();
    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
