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
		 * Configuration參數對象的机制： 加载时先访问jar包的默认配置xx-default.xml 再加载
		 * 用户配置xx-site.xml(用户自己在src上创建并配置) 覆盖配置文件
		 * 
		 * 构造完成之后，还可以conf.set("p","v"),会再次覆盖用户的配置文件
		 */

		// new Configuration()会从项目的classpath中加载core-default.xml hdfs-default
		// core-site.xml hdfs-site.xml
		Configuration conf = new Configuration();

		// 指定本客户端的上传文件到hdfs时需要保存的副本数量数为：3
		conf.set("dfs.repulication", "3");
		// 指定本客户端上传文件到hdfs时切块的规格大小：64m
		conf.set("dfs.blocksize", "64m");

		// 构造一个访问指定HDFS系统的客户端对象：参数1：——HDFS系统的URI，参数2:——客户端所需的配置参数对象，参数3：客户端的身份
		// uri的前缀必须是hdfs(?)
		FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), conf, "root");

		// 上传一个文件到HDFS中 
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
	 * 从HDFS中下载文件到本地磁盘
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
	 * 更改名字以及移动路径，
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRename() throws Exception {
		fs.rename(new Path("/slaves"), new Path("/aaa/slaves.bak"));
		fs.close();
	}

	/**
	 * 创建多级目录
	 */
	@Test
	public void testMkDirs() throws Exception {
		fs.mkdirs(new Path("/xx/yy/zz"));
		fs.close();
	}

	/**
	 * 删除目录
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
			System.out.println("文件路径名为：" + next.getPath());
			System.out.println("区块大小为：" + next.getBlockSize());
			System.out.println("所属群组为：" + next.getGroup());

			System.out.println("副本数量：" + next.getReplication());

			System.out.println("------------------------");
		}
		fs.close();
	}

	@Test
	public void testLs2() throws Exception {
		FileStatus[] listStatus = fs.listStatus(new Path("/"));
		for (FileStatus status : listStatus) {
			System.out.println("文件路径名为：" + status.getPath());
			System.out.println(status.isDirectory() ? "这是目录" : "这是文件夹");
			System.out.println("区块大小为：" + status.getBlockSize());
			System.out.println("所属群组为：" + status.getGroup());

			System.out.println("副本数量：" + status.getReplication());

			System.out.println("------------------------");
		}
		fs.close();
	}

	/**
	 * 读取hdfs中的内容
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testReadData() throws IllegalArgumentException, IOException {
		FSDataInputStream in = fs.open(new Path("/xx.dat"));

		// 指定读取的起始位置
		in.seek(7);

		byte[] b = new byte[1024];
		in.read(b);

		System.out.println(new String(b));

		in.close();
		fs.close();

	}

	/**
	 * 向hdfs写数据
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
