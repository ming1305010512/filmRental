package com.learn.bigData.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/11/7
 * @Time:14:33
 * @Description:包含客户端的创建、创建子节点、获取子节点监听节点变化、判断zNode是否存在
 */
public class ZookeeperBaseApi {
    private static String connectString =
            "192.168.227.129:2181,192.168.227.130:2181,192.168.227.131:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    /**
     * 客户端创建
     * @throws Exception
     */
    @Before
    public void init() throws Exception {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            @Override
            public void process(WatchedEvent event) {

                // 收到事件通知后的回调函数（用户的业务逻辑）
                System.out.println(event.getType() + "--" + event.getPath());
                System.out.println("这是怎么回事");

                // 再次启动监听
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 创建子节点
    @Test
    public void create() throws Exception {

        // 参数1：要创建的节点的路径； 参数2：节点数据 ； 参数3：节点权限 ；参数4：节点的类型
        String nodeCreated = zkClient.create("/alsa", "jinlian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(nodeCreated);
    }

    // 获取子节点
    @Test
    public void getChildren() throws Exception {

        List<String> children = zkClient.getChildren("/alsa", true);

        for (String child : children) {
            System.out.println(child);
        }

        // 延时阻塞
        Thread.sleep(Long.MAX_VALUE);
    }

    // 判断znode是否存在
    @Test
    public void exist() throws Exception {

        Stat stat = zkClient.exists("/alsa", false);

        System.out.println(stat == null ? "not exist" : "exist");
    }
}
