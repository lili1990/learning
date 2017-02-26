package app.service.base;

import app.models.BaseModel;

import java.util.List;

/**
 * Created by lili19289 on 2016/12/27.
 */
public interface BaseService<T> {


    public void save(String sql, Object... params);

    public void delete(String sql, Object... params);

    public void deleteById(String sql, Long id);

    public void update(String sql, Object... params);

    public <T extends BaseModel> T find(String sql, Class<T> requireType, Object... params);

    public <T extends BaseModel> T find(String sql, Class<T> requireType, List<Object> params);

    public <T extends BaseModel> List<T> fetch(String sql, Class<T> requireType);

    public <T extends BaseModel> List<T> fetch(String sql, Class<T> requireType, Object... param);

    public <T extends BaseModel> List<T> fetch(String sql, Class<T> requireType, List<Object> param);

//    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, Object[] param, Page page);
//
//    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, List<Object> param, Page page);

    public Integer count(String sql);

    public Integer count(String sql, Object... param);

    public void execute(String sql);



}
