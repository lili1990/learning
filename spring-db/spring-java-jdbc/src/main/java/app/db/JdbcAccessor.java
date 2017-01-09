package app.db;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;

/**
 * Created by sdlili on 17-1-9.
 */
public abstract class JdbcAccessor implements InitializingBean {

    private DataSource dataSource;
    private boolean lazyInit = true;

    public JdbcAccessor() {
    }

    public void afterPropertiesSet() {

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
