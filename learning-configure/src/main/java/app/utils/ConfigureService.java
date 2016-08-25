package app.utils;

import app.context.RuntimeContext;
import app.curator.ZooKeeperClient;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lili19289 on 2016/8/24.
 */

public class ConfigureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureService.class);

    public static final String CONFIGURE_PATH="/configure";

    private static ZooKeeperClient client;

    public ConfigureService(){}

    public void initConfgure(){
        ZooKeeperClient zkClient = RuntimeContext.getBean(ZooKeeperClient.class);
//        File rootFile = new File(EnvivironmentUtil.getClassPath()+CONFIGURE_PATH);
//        for(File file : rootFile.listFiles(new FileFilter() {
//            public boolean accept(File pathname) {
//                return pathname.getName().contains(".properties");
//            }
//        })){
//            String fileName = file.getName();
//            String path = fileName.replace(".properties","");
//            Properties properties = PropertiesUtil.getFromFile(CONFIGURE_PATH+"/"+file.getName());
//            zkClient.setData(CONFIGURE_PATH+"/"+path,properties.toString());
//        }
    }

    public ConfigureService(ZooKeeperClient client){
        this.client=client;
    }


    public String getData(String path){
        return client.getStringData(path);
    }

    public void getData(String path,String data){
        client.setData(path,data);
    }


    public static Map<Object, Object> getConfigDataFromZooKeeper(String category) {
        Map<Object, Object> map = null;
        if (null != client) {
            if (StringUtils.isNotBlank(category)) {
                map = JackSonUtil.fromJson(client.getStringData(CONFIGURE_PATH+"/"+category),Map.class);
            }
        } else {
            LOGGER.warn("no ZooKeeperClient exists, will not get data  from  zookeeper");
        }
       if(map==null){
           map= Collections.emptyMap();
       }
        return map;
    }

    public static void setConfigDataFromZooKeeper(String category,String data) {
        if (null != client) {
            if (StringUtils.isNotBlank(category)) {
                client.setData(CONFIGURE_PATH+"/"+category,data);
            }
        } else {
            LOGGER.warn("no ZooKeeperClient exists, will not write to zookeeper");
        }
    }



}
