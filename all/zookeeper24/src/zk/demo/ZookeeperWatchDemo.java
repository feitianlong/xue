package zk.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZookeeperWatchDemo {

	ZooKeeper zk = null;

	@BeforeEach
	public void init() throws IOException {
		zk = new ZooKeeper("hdp-01:2181,hdp-02:2181,hdp-03:2181", 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// 如果放在这里不加判断条件，
				// 构造的zk时候，zk会去连接，一旦连接成功，会触发这里的process,
				// 但是这里的event 为null，

				if (event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeDataChanged) {
					String path = event.getPath();
					EventType type = event.getType();
					System.out.println(path + ":节点数据发生改变" + type);
					// 反复监听
					try {
						zk.getData("/friends", true, null);
					} catch (KeeperException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeChildrenChanged) {
					System.out.println("子节点发生变化");
				}
			}

		});
	}

	@Test
	public void testWatch() throws KeeperException, InterruptedException, UnsupportedEncodingException {
		// 监听节点数据变化
		byte[] data = zk.getData("/friends", true, null);
		System.out.println(new String(data, "UTF-8"));

		//监听节点的子节点变化事件
		List<String> children = zk.getChildren("/friends", true); 
		
		// 监听线程是一个后台进程(deamon)
		Thread.sleep(Long.MAX_VALUE);
	}
}
