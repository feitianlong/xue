package wordcount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class HdfsWordcount {
	public static void main(String[] args) throws Exception {

		// 初始化
		Properties props = new Properties();
		
		//1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。 

		//	2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
		props.load(HdfsWordcount.class.getClassLoader().getResourceAsStream("job.properties"));
		Class<?> mapper_class = Class.forName(props.getProperty("MAPPER_CLASS"));
		Mapper mapper = (Mapper) mapper_class.newInstance();
		
		Path input = new Path(props.getProperty("INPUT_PATH"));
		Path output = new Path(props.getProperty("OUTPUT_PATH"));
		
		Context context = new Context();

		/**
		 * 处理数据
		 */
		FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), new Configuration(), "root");

		RemoteIterator<LocatedFileStatus> iter = fs.listFiles(input, false);

		while (iter.hasNext()) {
			LocatedFileStatus file = iter.next();
			FSDataInputStream br = fs.open(file.getPath());
			String line = null;

			// 逐行读取
			while ((line = br.readLine()) != null) {

				// 调用一个方法对每一行进行业务处理
				mapper.map(line, context);

			}
		}

		/**
		 * 输出显示
		 */
		HashMap<Object, Object> contextMap = context.getContextMap();
		
		
		if (fs.exists(output)) {
			throw new RuntimeException("目录已存在，请更换输出目录");
		}

		FSDataOutputStream out = fs.create(new Path(output,new Path("res.dat")));
		Set<Entry<Object, Object>> entrySet = contextMap.entrySet();

		for (Entry<Object, Object> entry : entrySet) {
			out.write((entry.getKey().toString() + "\t" + entry.getValue().toString() + "\n").getBytes());
		}

		out.close();

		fs.close();

		System.out.println("数据统计完成....");

		// 去hdfs中读取文件：一次读一行

		// 对每一行进行业务处理

		// 将这行额处理结果放入缓存

		// 调用一个方法将缓存中的结果数据输出到HDFS结果文件

	}
}
