package app.db;


import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lili19289 on 2017/1/10.
 */
public class JdbcResultExtract {


    public Map<String, Object> extractMap(ResultSet rs, int rowNum) throws SQLException {
        if(rs==null){
            return (Map<String, Object>) Collections.emptyList();
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Map resultMap = new HashMap<>(rowNum);
        for(int i = 1; i <= columnCount; ++i) {
            String key =rsmd.getColumnLabel(i);
            Object obj = rs.getObject(key);
            resultMap.put(key, obj);
        }
        return resultMap;
    }


    public static  <T> T extractBean(ResultSet rs, Class<T> requireClass) throws SQLException {
        if(rs==null){
            return null;
        }
        Object mappedObject = BeanUtils.instantiate(requireClass);
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        for(int i = 1; i <= columnCount; ++i) {
            String key =rsmd.getColumnLabel(i);
            Object obj = rs.getObject(key);
            bw.setPropertyValue(key, obj);
        }

        return (T) mappedObject;
    }



}
