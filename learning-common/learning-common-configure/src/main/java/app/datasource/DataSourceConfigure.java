package app.datasource;

import app.utils.PropertiesUtil;
import app.utils.ValueUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by lili19289 on 2016/8/23.
 */
public class DataSourceConfigure extends BasicDataSource{

    public static final String PROP_KEY_DRIVERCLASSNAME = "driverClassName";

    public static final String PROP_KEY_URL = "url";

    public static final String PROP_KEY_USERNAME = "username";

    public static final String PROP_KEY_PASSWORD = "password";

    public static final String PROP_KEY_MAXACTIVE = "maxActive";

    public static final String PROP_KEY_INITIALSIZE = "initialSize";

    public static final String PROP_KEY_MAXWAIT = "maxWait";

    public static final String PROP_KEY_MAXIDLE = "maxIdle";

    public static final String PROP_KEY_MINIDLE = "minIdle";

    public static final String PROP_KEY_TIMEBETWEENEVICTIONRUNSMILLS = "timeBetweenEvictionRunsMillis";

    public static final String PROP_KEY_MINEVICTABLEIDLETIMEMILLIS = "minEvictableIdleTimeMillis";



    private static final Log LOG = LogFactory.getLog(DataSourceConfigure.class);

    private static Properties prop;

    private  void init() {

    }

    public Connection getConnection() throws SQLException {
        return this.getDataSource().getConnection();
    }

    public DataSource getDataSource (){
        prop = PropertiesUtil.getFromFile("/spring/jdbc.properties");
        this.setDriverClassName(prop.getProperty(PROP_KEY_DRIVERCLASSNAME));
        this.setUrl(prop.getProperty(PROP_KEY_URL));
        this.setUsername(prop.getProperty(PROP_KEY_USERNAME));
        this.setPassword(prop.getProperty(PROP_KEY_PASSWORD));
        int initialSize = ValueUtil.getInt(prop.getProperty(PROP_KEY_INITIALSIZE), -1);
        if (-1 == initialSize) {
            initialSize = this.initialSize;
        }
        this.setInitialSize(initialSize);

        // maxActive
        int maxActive = ValueUtil.getInt(prop.getProperty(PROP_KEY_MAXACTIVE), -1);
        if (-1 == maxActive) {
            maxActive = this.maxActive;
        }
        this.setMaxActive(maxActive);

        // maxIdle
        int maxIdle = ValueUtil.getInt(prop.getProperty(PROP_KEY_MAXIDLE), -1);
        if (-1 == maxIdle) {
            maxIdle = this.maxIdle;
        }
        this.setMaxIdle(maxIdle);

        // minIdle
        int minIdle = ValueUtil.getInt(prop.getProperty(PROP_KEY_MINIDLE), -1);
        if (-1 == minIdle) {
            minIdle = this.minIdle;
        }
        this.setMinIdle(minIdle);

        // maxWait
        long maxWait = ValueUtil.getLong(prop.getProperty(PROP_KEY_MAXWAIT), -1);
        if (-1 == maxWait) {
            maxWait = this.maxWait;
        }
        this.setMaxWait(maxWait);

        // timeBetweenEvictionRunsMillis
        long timeBetweenEvictionRunsMillis = ValueUtil.getLong(prop.getProperty(PROP_KEY_TIMEBETWEENEVICTIONRUNSMILLS),
                -1);
        if (-1 == timeBetweenEvictionRunsMillis) {
            timeBetweenEvictionRunsMillis = this.timeBetweenEvictionRunsMillis;
        }
        this.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        // minEvictableIdleTimeMillis
        long minEvictableIdleTimeMillis = ValueUtil.getLong(prop.getProperty(PROP_KEY_MINEVICTABLEIDLETIMEMILLIS), -1);
        if (-1 == minEvictableIdleTimeMillis) {
            minEvictableIdleTimeMillis = this.minEvictableIdleTimeMillis;
        }
        this.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

        try {
            this.dataSource= this.createDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.dataSource;
    }



    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
