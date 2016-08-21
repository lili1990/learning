package app.curator;

import app.utils.ServerProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lili19289 on 2016/8/19.
 */
public class ZooKeeperClientFactory {

    private static final Logger LOG = LoggerFactory.getLogger(ZooKeeperClientFactory.class);

    public static final String ZOOKEEPER_CONNECTSTRING = "zookeeper.connectString";
    public static final String ZOOKEEPER_BASE_PATH = "zookeeper.basePath";

    public static ZooKeeperClient createZooKeeperClient() {
        String zookeeperConnectString = System.getProperty(ZOOKEEPER_CONNECTSTRING);
        if (StringUtils.isBlank(zookeeperConnectString)) {
            zookeeperConnectString = ServerProperties.getProperty(ZOOKEEPER_CONNECTSTRING);
        }
        String basePath = System.getProperty(ZOOKEEPER_BASE_PATH);
        if (StringUtils.isBlank(basePath)) {
            basePath = ServerProperties.getProperty(ZOOKEEPER_BASE_PATH);
        }
        try {
            if (StringUtils.isNotBlank(zookeeperConnectString)) {
                if (StringUtils.isNotBlank(basePath)) {
                    ZooKeeperClient zkClient = new ZooKeeperClient(zookeeperConnectString);
                    zkClient.start();
                    zkClient.mkdirs(basePath);
                    zkClient.close();
                    // 组装完整的连接串
                    zookeeperConnectString += basePath;
                }
                ZooKeeperClient zkClient = new ZooKeeperClient(zookeeperConnectString);
                LOG.info("create ZooKeeperClient of: " + zookeeperConnectString);
                zkClient.start();
                return zkClient;
            }
        } catch (Exception e) {
            LOG.error(ZOOKEEPER_CONNECTSTRING + " not configured yet, create ZooKeeperClient failed!!!");
        }
        return null;
    }

}
