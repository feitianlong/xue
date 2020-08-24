package zk.distributesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class Consumer {
	// 定义一个list用于存放最新的在线服务器列表
	private ArrayList<String> list = null;

	// 构造zk连接对象
	ZooKeeper zk = null;

	// 构造zk客户端连接
	public void connectZK() throws IOException {
		zk = new ZooKeeper("hdp-01:2181,hdp-02:2181,hdp-03:2181", 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeChildrenChanged) {
					// 事件回调逻辑
					// 每次服务器列表发生改变，就更新最新的列表
					try {
						getOnlineServers();
					} catch (KeeperException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
	}

	// 查询在线服务器列表
	protected void getOnlineServers() throws KeeperException, InterruptedException {
		List<String> childrens = zk.getChildren("/servers", true);
		ArrayList<String> servers = new ArrayList<>();

		for (String child : childrens) {
			byte[] data = zk.getData("/servers/" + child, false, null);
			// 必须新建String 因为child 每次都是同一个引用
			String serverInfo = new String(data);
			servers.add(serverInfo);
		}
		list = servers;
		System.out.println("服务器节点发生变化" + "重新查询了一次zk，当前在线的服务器有：" + list);
	}

	// 发送时间查询请求
	public void sendRequest() throws InterruptedException, UnknownHostException, IOException {
		Random rand = new Random();
		// 兩秒请求一次
		while (true) {
			// 挑选一台当前在线的服务器
			int ni = rand.nextInt(list.size());
			String server = list.get(ni);

			String[] split = server.split(":");
			String hostname = split[0];
			int port = Integer.parseInt(split[1]);

			System.out.println("当前连接的服务器为： " + server);

			Socket socket = new Socket(hostname, port);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String date = input.readLine();
			System.out.println("服务器响应的时间为：" + date);

			input.close();
			socket.close();

			// Thread.sleep(2000);
		}
	}

	public static void main(String[] args) throws Exception {

		Consumer consumer = new Consumer();
		// 构造zk连接对象
		consumer.connectZK();

		// 查询在线服务器列表
		consumer.getOnlineServers();

		// 处理业务（向一台服务器发送时间查询请求）
		consumer.sendRequest();

	}
}
