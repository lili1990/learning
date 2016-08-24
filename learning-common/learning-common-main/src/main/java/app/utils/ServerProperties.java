package app.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lili19289 on 2016/8/6.
 */
public class ServerProperties {

    private static final Logger LOGGER = Logger.getLogger(ServerProperties.class);

    private static final String FILE_NAME = "/conf/server.properties";

    private static Properties prop;

    static {
        init();
    }

    private static void init() {
        prop = PropertiesUtil.getFromFile(FILE_NAME);
    }


    public static String getProperty(String key) {
        if (null != prop) {
            return prop.getProperty(key);
        }
        return null;
    }
}
