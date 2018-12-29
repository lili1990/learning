package app.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by sdlili on 17-1-9.
 */
public class DBConfigure {

    private static final Log logger = LogFactory.getLog(DBConfigure.class);


    public static Connection getConnection(DataSource dataSource) throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException var1) {
            throw new SQLException("Could not get JDBC Connection", var1);
        }
    }


    public static void releaseConnection(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
