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
	// ����һ��list���ڴ�����µ����߷������б�
	private ArrayList<String> list = null;

	// ����zk���Ӷ���
	ZooKeeper zk = null;

	// ����zk�ͻ�������
	public void connectZK() throws IOException {
		zk = new ZooKeeper("hdp-01:2181,hdp-02:2181,hdp-03:2181", 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected && event.getType() == EventType.NodeChildrenChanged) {
					// �¼��ص��߼�
					// ÿ�η������б����ı䣬�͸������µ��б�
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

	// ��ѯ���߷������б�
	protected void getOnlineServers() throws KeeperException, InterruptedException {
		List<String> childrens = zk.getChildren("/servers", true);
		ArrayList<String> servers = new ArrayList<>();

		for (String child : childrens) {
			byte[] data = zk.getData("/servers/" + child, false, null);
			// �����½�String ��Ϊchild ÿ�ζ���ͬһ������
			String serverInfo = new String(data);
			servers.add(serverInfo);
		}
		list = servers;
		System.out.println("�������ڵ㷢���仯" + "���²�ѯ��һ��zk����ǰ���ߵķ������У�" + list);
	}

	// ����ʱ���ѯ����
	public void sendRequest() throws InterruptedException, UnknownHostException, IOException {
		Random rand = new Random();
		// ��������һ��
		while (true) {
			// ��ѡһ̨��ǰ���ߵķ�����
			int ni = rand.nextInt(list.size());
			String server = list.get(ni);

			String[] split = server.split(":");
			String hostname = split[0];
			int port = Integer.parseInt(split[1]);

			System.out.println("��ǰ���ӵķ�����Ϊ�� " + server);

			Socket socket = new Socket(hostname, port);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String date = input.readLine();
			System.out.println("��������Ӧ��ʱ��Ϊ��" + date);

			input.close();
			socket.close();

			// Thread.sleep(2000);
		}
	}

	public static void main(String[] args) throws Exception {

		Consumer consumer = new Consumer();
		// ����zk���Ӷ���
		consumer.connectZK();

		// ��ѯ���߷������б�
		consumer.getOnlineServers();

		// ����ҵ����һ̨����������ʱ���ѯ����
		consumer.sendRequest();

	}
}
