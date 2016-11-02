package app.dao;

import app.models.BaseModel;
import app.mybatis.Page;

import java.util.List;

/**
 * Created by lili19289 on 2016/8/5.
 */
public interface BaseDao<T extends BaseModel> {

    public Long  save(T o);

    public Long  batchSave(List<T> list);

    public void delete(T o);

    public void delete(Long id);

    public void update(T o);

    public <T extends BaseModel> T findById(Long id);

    public <T extends BaseModel> T find(Object... param);

    public <T extends BaseModel> List<T> fetch(Object... param);

    public <T extends BaseModel> List<T> fetch(List<Object> param);

    public <T extends BaseModel> List<T> fetch(Object[] param, Page page);

}
