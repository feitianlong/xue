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
				// ����������ﲻ���ж�������
				// �����zkʱ��zk��ȥ���ӣ�һ�����ӳɹ����ᴥ�������process,
				// ���������event Ϊnull��

				if (event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeDataChanged) {
					String path = event.getPath();
					EventType type = event.getType();
					System.out.println(path + ":�ڵ����ݷ����ı�" + type);
					// ��������
					try {
						zk.getData("/friends", true, null);
					} catch (KeeperException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeChildrenChanged) {
					System.out.println("�ӽڵ㷢���仯");
				}
			}

		});
	}

	@Test
	public void testWatch() throws KeeperException, InterruptedException, UnsupportedEncodingException {
		// �����ڵ����ݱ仯
		byte[] data = zk.getData("/friends", true, null);
		System.out.println(new String(data, "UTF-8"));

		//�����ڵ���ӽڵ�仯�¼�
		List<String> children = zk.getChildren("/friends", true); 
		
		// �����߳���һ����̨����(deamon)
		Thread.sleep(Long.MAX_VALUE);
	}
}
