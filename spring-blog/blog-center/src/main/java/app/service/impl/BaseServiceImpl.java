package app.service.impl;

import app.dao.BaseDao;
import app.models.BaseModel;
import app.mybatis.Page;
import app.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {


    abstract public BaseDao getDao();

    public Long  save(T o){
       return getDao().save(o);
    }

    public void  saveOrUpdate(T o){
         getDao().saveOrUpdate(o);
    }

    public Long  batchSave(List<T> list){
        return getDao().batchSave(list);
    }

    public void delete(Long id){
        getDao().delete(id);
    }

    public void delete(T o){
        getDao().delete(o);
    }

    public void update(T o){
        getDao().update(o);
    }

    public <T extends BaseModel> T findById(Long id){
        return (T) getDao().findById(id);
    }

    public <T extends BaseModel> T find(Object... param){
        return (T) getDao().find(param);
    }

    public <T extends BaseModel> List<T> fetch(Object... param){
        return getDao().fetch(param);
    }

    public <T extends BaseModel> List<T> fetch(List<Object> param){
        return getDao().fetch(param);
    }

    public <T extends BaseModel> List<T> fetch(List<Object> param, Page page){
        return getDao().fetch(param,page);
    }

    public <T extends BaseModel> List<T> fetch(Object[] param, Page page){
        return getDao().fetch(param,page);
    }


}
