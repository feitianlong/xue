package zk.distributesystem;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class TimeQueryServer {
	ZooKeeper zk = null;

	// 构建zk客服端连接
	public void connectZK() throws IOException {
		zk = new ZooKeeper("hdp-01:2181,hdp-02:2181,hdp-03:2181", 2000, null);
	}

	// 注册服务器信息
	public void registerServerInfo(String hostname, String port) throws KeeperException, InterruptedException {
		// 先判断注册节点是否存在
		Stat exists = zk.exists("/servers", null);
		if (exists == null) {
			zk.create("/servers", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}

		// 注册服务器信息到zk的约定注册子节点
		String create = zk.create("/servers/server", (hostname + ":" + port).getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname + " 服务器向zk注册信息成功，注册的节点为：" + create);

	}

	public static void main(String[] args) throws Exception {

		TimeQueryServer timeQueryServer = new TimeQueryServer();

		// 构造zk客户端连接
		timeQueryServer.connectZK();

		// 注册服务器信息
		timeQueryServer.registerServerInfo(args[0], args[1]);

		// 启动业务线程开始处理业务(可以换成其他业务)
		new TimeQueryService(Integer.parseInt(args[1])).start();

	}
}
