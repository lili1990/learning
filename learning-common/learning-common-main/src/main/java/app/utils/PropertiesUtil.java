package app.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lili19289 on 2016/8/23.
 */
public class PropertiesUtil {

    private static final Logger LOGGER = Logger.getLogger(ServerProperties.class);

    //填写相对路径，class文件下的路径
    public static Properties getFromFile(String filePath) {
        filePath = EnvironmentUtil.getClassPath() + filePath;
        Properties prop = null;
        InputStream ins = null;
        try {
            ins = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(ins);
            return prop;
        } catch (FileNotFoundException e) {
            LOGGER.error("Can not find server properties, it may result working problem. path: " + filePath, e);
        } catch (Exception e) {
            LOGGER.error("init server properties failed", e);
        } finally {
            IOUtils.closeQuietly(ins);
        }
        return null;
    }

    //填写绝对路径，硬盘上的文件
    public static Properties readFromFile(String filePath) {
        File file = new File(filePath);
        if(!file.exists()){
            return null;
        }
        Properties prop = null;
        InputStream ins = null;
        try {
            ins = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(ins);
            return prop;
        } catch (FileNotFoundException e) {
            LOGGER.error("Can not find server properties, it may result working problem. path: " + filePath, e);
        } catch (Exception e) {
            LOGGER.error("init server properties failed", e);
        } finally {
            IOUtils.closeQuietly(ins);
        }
        return null;
    }

}
