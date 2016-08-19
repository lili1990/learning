package app.curator;

import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

/**
 * Created by lili19289 on 2016/8/19.
 * NodeCache主要用来监听节点本身的变化,当节点的状态发生变更后,会回调NodeCachaListener
 */
public class ZooKeeperNodeCacheListener implements NodeCacheListener {

    private NodeCache nodeCache;

    public ZooKeeperNodeCacheListener(NodeCache nodeCache){
        this.nodeCache = nodeCache;
    }

    public void nodeChanged() throws Exception {
        System.out.println("NodeCache changed, data is: " + new String(nodeCache.getCurrentData().getData()));
    }
}
