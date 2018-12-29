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

//    private static Gson gson =new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
//            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
//            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
//            .setPrettyPrinting() //对json结果格式化.
//            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
//            //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
//            //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
//            .create();


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


//    @Override
//    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, List<Object> param, Page page) {
//        if(page!=null ){
//            sql+=" limit ?,?";
//            param.add(page.getStart_index());
//            param.add(page.getEnd_index());
//        }
//        return jdbcTemplate.queryForList(sql,requireType,param);
//    }
//
//    @Override
//    public <T extends BaseModel> List<T> fetch(String sql,Class<T> requireType, Object[] param, Page page) {
//        if(page!=null ){
//            sql+=" limit ?,?";
//            return jdbcTemplate.queryForList(sql,requireType,param,page.getStart_index(),page.getEnd_index());
//        }
//        return jdbcTemplate.queryForList(sql,requireType,param);
//    }

}
