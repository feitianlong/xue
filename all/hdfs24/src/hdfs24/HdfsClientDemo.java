package hdfs24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HdfsClientDemo {
	public static void main(String[] args) throws Exception {
		/**
		 * Configuration��������Ļ��ƣ� ����ʱ�ȷ���jar����Ĭ������xx-default.xml �ټ���
		 * �û�����xx-site.xml(�û��Լ���src�ϴ���������) ���������ļ�
		 * 
		 * �������֮�󣬻�����conf.set("p","v"),���ٴθ����û��������ļ�
		 */

		// new Configuration()�����Ŀ��classpath�м���core-default.xml hdfs-default
		// core-site.xml hdfs-site.xml
		Configuration conf = new Configuration();

		// ָ�����ͻ��˵��ϴ��ļ���hdfsʱ��Ҫ����ĸ���������Ϊ��3
		conf.set("dfs.repulication", "3");
		// ָ�����ͻ����ϴ��ļ���hdfsʱ�п�Ĺ���С��64m
		conf.set("dfs.blocksize", "64m");

		// ����һ������ָ��HDFSϵͳ�Ŀͻ��˶��󣺲���1������HDFSϵͳ��URI������2:�����ͻ�����������ò������󣬲���3���ͻ��˵����
		// uri��ǰ׺������hdfs(?)
		FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), conf, "root");

		// �ϴ�һ���ļ���HDFS�� 
		// fs.copyFromLocalFile(new
		// Path("D:\\appdev\\xiti\\Alogrithm\\src\\ArrayQuestion\\RepetedNumber.java"),new
		// Path("/"));

		fs.close();
	}

	FileSystem fs = null;

	@Before
	public void init() throws Exception {
		Configuration conf = new Configuration();

		conf.set("dfs.repulication", "3");

		conf.set("dfs.blocksize", "64m");

		fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), conf, "root");

	}

	/**
	 * ��HDFS�������ļ������ش���
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testGet() throws IllegalArgumentException, IOException {
		fs.copyToLocalFile(new Path("/a.txt"), new Path("D:\\pics2"));
		fs.close();
	}

	/**
	 * ���������Լ��ƶ�·����
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRename() throws Exception {
		fs.rename(new Path("/slaves"), new Path("/aaa/slaves.bak"));
		fs.close();
	}

	/**
	 * �����༶Ŀ¼
	 */
	@Test
	public void testMkDirs() throws Exception {
		fs.mkdirs(new Path("/xx/yy/zz"));
		fs.close();
	}

	/**
	 * ɾ��Ŀ¼
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		fs.delete(new Path("/x"), true);
		fs.close();
	}

	@Test
	public void testLs() throws Exception {
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
		while (listFiles.hasNext()) {
			LocatedFileStatus next = listFiles.next();
			System.out.println("�ļ�·����Ϊ��" + next.getPath());
			System.out.println("�����СΪ��" + next.getBlockSize());
			System.out.println("����Ⱥ��Ϊ��" + next.getGroup());

			System.out.println("����������" + next.getReplication());

			System.out.println("------------------------");
		}
		fs.close();
	}

	@Test
	public void testLs2() throws Exception {
		FileStatus[] listStatus = fs.listStatus(new Path("/"));
		for (FileStatus status : listStatus) {
			System.out.println("�ļ�·����Ϊ��" + status.getPath());
			System.out.println(status.isDirectory() ? "����Ŀ¼" : "�����ļ���");
			System.out.println("�����СΪ��" + status.getBlockSize());
			System.out.println("����Ⱥ��Ϊ��" + status.getGroup());

			System.out.println("����������" + status.getReplication());

			System.out.println("------------------------");
		}
		fs.close();
	}

	/**
	 * ��ȡhdfs�е�����
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testReadData() throws IllegalArgumentException, IOException {
		FSDataInputStream in = fs.open(new Path("/xx.dat"));

		// ָ����ȡ����ʼλ��
		in.seek(7);

		byte[] b = new byte[1024];
		in.read(b);

		System.out.println(new String(b));

		in.close();
		fs.close();

	}

	/**
	 * ��hdfsд����
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void tesWriteData() throws IllegalArgumentException, IOException {
		FSDataOutputStream out = fs.create(new Path("/tupian.jpg"), false);
		
		FileInputStream in = new FileInputStream("D:\\pics2\\dua.jpg");

		byte[] b = new byte[1024];
		int r = 0;
		while ((r = in.read(b)) != -1) {
			out.write(b, 0, r);
		}

		fs.close();
		out.close();

	}

}
