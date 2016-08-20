package app.curator;

import app.context.RuntimeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lili19289 on 2016/8/19.
 */
public class ZooKeeperLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ZooKeeperLoader.class);

    ZooKeeperClient zooKeeperClient;
    public void init(){
        try {
            zooKeeperClient =  RuntimeContext.getBean(ZooKeeperClient.class);
            zooKeeperClient.addNodeCacheListener("/learning",ZooKeeperNodeCacheListener.class);
            zooKeeperClient.addPathChildrenListener("/learning",new ZooKeeperPathChildrenCacheListener());
//            zooKeeperClient.addNodeCacheListener("/learning");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
