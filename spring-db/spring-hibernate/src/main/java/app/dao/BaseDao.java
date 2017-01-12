package app.dao;

import java.io.Serializable;
import java.util.List;

import app.models.BaseModel;

@SuppressWarnings("hiding")
public interface BaseDao<T> {

	public <T extends BaseModel> T save(T o);

	public <T extends BaseModel> T saveOrupdate(T o);

	public void delete(T o);

	public <T extends BaseModel> T update(T o);

	public <T extends BaseModel> T find(Class<T> c, Serializable id);

	public <T extends BaseModel> T find(String hql, Object... param);

//	public <T extends BaseModel> T find(String hql, List<Object> param);

	public <T extends BaseModel> List<T> fetch(String hql);
//
	public <T extends BaseModel> List<T> fetch(String hql, Object... param);
//
	public <T extends BaseModel> List<T> fetch(String hql, List<Object> param);
//
//	public <T extends BaseModel> List<T> fetch(String hql, Object[] param,
//                                               Integer page, Integer rows);
//
//	public <T extends BaseModel> List<T> fetch(String hql, List<Object> param,
//                                               Integer page, Integer rows);
//
//	public Long count(String hql);
//
//	public Long count(String hql, Object... param);
//
//	public Long count(String hql, List<Object> param);
//
//	public Integer executeHql(String hql);
//
//	public Integer executeHql(String hql, Object... param);
//
//	public Integer executeHql(String hql, List<Object> param);

}
