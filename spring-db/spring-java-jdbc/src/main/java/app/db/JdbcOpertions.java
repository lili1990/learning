package app.db;

import java.util.Map;

/**
 * Created by sdlili on 17-1-9.
 */
public interface JdbcOpertions {

    <T> T query(String sql, Class<T> requireClass, Object... params);




}
