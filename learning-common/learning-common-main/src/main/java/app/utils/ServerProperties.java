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
        String filePath =EnvivironmentUtil.getClassPath()+FILE_NAME;
        InputStream ins = null;
        try {
            ins  = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(ins);
        } catch (FileNotFoundException e) {
            LOGGER.error("Can not find server properties, it may result working problem. path: " + filePath, e);
        } catch (Exception e) {
            LOGGER.error("init server properties failed", e);
        } finally {
            IOUtils.closeQuietly(ins);
        }
    }


    public static String getProperty(String key) {
        if (null != prop) {
            return prop.getProperty(key);
        }
        return null;
    }
}
