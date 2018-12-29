package app.db;


import org.apache.poi.ss.formula.functions.T;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sdlili on 17-1-9.
 */
public interface JdbcOperCallback<T>  {


    T doInStatement(Statement stmt) throws SQLException;


    String getSql();
}
