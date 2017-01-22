package app.db;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sdlili on 17-1-9.
 */
public class JdbcTemplate extends JdbcAccessor implements JdbcOpertions{



    public  <T> T query(String sql, Class<T> requireClass, Object... params){
        try {
            ResultSet rs = execute(sql,params);
            return JdbcResultExtract.extractBean(rs,requireClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public  ResultSet execute(String sql, Object... params) throws SQLException {
        Connection conn=DBConfigure.getConnection(this.getDataSource());
        PreparedStatement stmt = null;
        try{
            stmt=conn.prepareStatement(sql);
            setParams(stmt, params);
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            stmt.close();
            DBConfigure.releaseConnection(conn);
        }finally {
            stmt.close();
            DBConfigure.releaseConnection(conn);
        }
        return null;
    }



    //带参数执行SQL，返回影响的行数 异常处理
    public  int update(String sql, Object... params)
            throws SQLException {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = DBConfigure.getConnection(this.getDataSource());
            preStmt = conn.prepareStatement(sql);
            setParams(preStmt, params);
            int rows = preStmt.executeUpdate(); //执行SQL操作
            return Integer.valueOf(rows);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preStmt != null)
                preStmt.close();
            if (conn != null)
                conn.close();
        }
        return -1;
    }

    public static void setParams(PreparedStatement preStmt, Object... params)
            throws SQLException {
        if (params == null || params.length == 0)
            return;
        for (int i = 1; i <= params.length; i++) {
            Object param = params[i - 1];
            if (param == null) {
                preStmt.setNull(i, Types.NULL);
            } else if (param instanceof Integer) {
                preStmt.setInt(i, (Integer) param);
            } else if (param instanceof String) {
                preStmt.setString(i, (String) param);
            } else if (param instanceof Double) {
                preStmt.setDouble(i, (Double) param);
            } else if (param instanceof Long) {
                preStmt.setLong(i, (Long) param);
            } else if (param instanceof Timestamp) {
                preStmt.setTimestamp(i, (Timestamp) param);
            } else if (param instanceof Boolean) {
                preStmt.setBoolean(i, (Boolean) param);
            } else if (param instanceof Date) {
                preStmt.setDate(i, (Date) param);
            }
        }
    }

}
