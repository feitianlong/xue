package zk.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZookeeperClientDemo {

	ZooKeeper zk = null;

	// junit5 中@BeforeEach 和@AfterEach替代junit4中的@Before 和@After
	@BeforeEach
	public void init() throws IOException, NullPointerException {
		zk = new ZooKeeper("hdp-01:2181,hdp-02:2181,hdp-03:2181", 2000, null);
	}

	@Test
	public void testCreate() throws KeeperException, InterruptedException, IOException {

		String create = zk.create("/eclipsexx", "Hello eclipse".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(create);
		zk.close();
	}
	// 点击方法右键执行
	@Test
	public void testUpdate() throws KeeperException, InterruptedException {
		zk.setData("/eclipsexx", "hulahula".getBytes(), -1);
		zk.close();
	}

	@Test
	public void testGet() throws KeeperException, InterruptedException, UnsupportedEncodingException {
		byte[] data = zk.getData("/eclipsexx", false, null);
		System.out.println(new String(data,"UTF-8"));
		zk.close();
	}

	@Test
	public void testListChildren() throws KeeperException, InterruptedException {
		List<String> children = zk.getChildren("/aa", false);
		for (String c : children) {
			System.out.println(c);
		}
		zk.close();
	}

	@Test
	public void testDelete() throws InterruptedException, KeeperException {
		zk.delete("/eclipsexx", -1);
		zk.close();
	}

}
