package app.config;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by sdlili on 17-3-19.
 */
public class SessionConfig {

    private JedisConnectionFactory jedisConnectionFactory;

    public JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }
}
