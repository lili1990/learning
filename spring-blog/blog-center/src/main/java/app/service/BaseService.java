package app.service;

import app.dao.BaseDao;
import app.models.BaseModel;
import app.mybatis.Page;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface BaseService<T extends BaseModel> {

    public BaseDao getDao();

    public Long  save(T o);

    public void  saveOrUpdate(T o);

    public Long  batchSave(List<T> list);

    public void delete(Long id);

    public void delete(T o);

    public void update(T o);

    public <T extends BaseModel> T findById(Long id);

    public <T extends BaseModel> T find(Object... param);

    public <T extends BaseModel> List<T> fetch(Object... param);

    public <T extends BaseModel> List<T> fetch(List<Object> param);

    public <T extends BaseModel> List<T> fetch(List<Object> param, Page page);

    public <T extends BaseModel> List<T> fetch(Object[] param, Page page);


}
