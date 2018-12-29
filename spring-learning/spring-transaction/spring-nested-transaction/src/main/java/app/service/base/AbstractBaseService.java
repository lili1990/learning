package app.service.base;


import app.models.BaseModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lili19289 on 2016/12/27.
 */
public  abstract class AbstractBaseService<T extends BaseModel> implements BaseService<T>{


    @Resource
    protected JdbcTemplate jdbcTemplate;


    public void save(String sql, Object... params) {
         jdbcTemplate.update(sql,params);
    }

    public void delete(String sql, Object... params) {
        jdbcTemplate.update(sql,params);
    }

    public void deleteById(String sql, Long id) {
        jdbcTemplate.update(sql,id);
    }


    public void execute(String sql) {
         jdbcTemplate.execute(sql);
    }

    public Integer count(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public Integer count(String sql, Object... params) {
        return jdbcTemplate.queryForObject(sql,params,Integer.class);
    }

    public <T extends BaseModel> T find(String sql,Class<T> requireType, List<Object> param) {
        return (T)jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<T>(requireType),param);
    }

    public <T extends BaseModel> T find(String sql, Class<T> requireType,Object... param) {
        RowMapper<T> rowMapper=new BeanPropertyRowMapper<T>(requireType);
        return (T)jdbcTemplate.queryForObject(sql,rowMapper,param);
    }

    public void update(String sql, Object... params) {
         jdbcTemplate.update(sql,params);
    }


    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType) {
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<T>(requireType));
    }

    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, Object... params) {
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<T>(requireType),params);
    }

    public  <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, List<Object> params) {
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<T>(requireType),params);
    }



}
