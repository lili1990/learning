package app.db;

import org.apache.poi.ss.formula.functions.T;

import java.sql.*;

/**
 * Created by sdlili on 17-1-9.
 */
public class JdbCTemplate extends JdbcAccessor implements JdbcOpertions{



    public ResultSet execute(String sql, Object... params) throws SQLException {
        Connection conn=DBConfigure.getConnection(this.getDataSource());
        Statement stmt = null;
        try{
            stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }catch (Exception e){

        }finally {

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
        } finally {
            if (preStmt != null)
                preStmt.close();
            if (conn != null)
                conn.close();
        }
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
                preStmt.setDouble(i, (Long) param);
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
