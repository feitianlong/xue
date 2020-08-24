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

		// ��ʼ��
		Properties props = new Properties();
		
		//1. Class.getResourceAsStream(String path) �� path ���ԡ�/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ���ԡ�/'��ͷ���Ǵ�ClassPath���»�ȡ����ֻ��ͨ��path����һ������·�������ջ�����ClassLoader��ȡ��Դ�� 

		//	2. Class.getClassLoader.getResourceAsStream(String path) ��Ĭ�����Ǵ�ClassPath���»�ȡ��path�����ԡ�/'��ͷ����������ClassLoader��ȡ��Դ��
		props.load(HdfsWordcount.class.getClassLoader().getResourceAsStream("job.properties"));
		Class<?> mapper_class = Class.forName(props.getProperty("MAPPER_CLASS"));
		Mapper mapper = (Mapper) mapper_class.newInstance();
		
		Path input = new Path(props.getProperty("INPUT_PATH"));
		Path output = new Path(props.getProperty("OUTPUT_PATH"));
		
		Context context = new Context();

		/**
		 * ��������
		 */
		FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000"), new Configuration(), "root");

		RemoteIterator<LocatedFileStatus> iter = fs.listFiles(input, false);

		while (iter.hasNext()) {
			LocatedFileStatus file = iter.next();
			FSDataInputStream br = fs.open(file.getPath());
			String line = null;

			// ���ж�ȡ
			while ((line = br.readLine()) != null) {

				// ����һ��������ÿһ�н���ҵ����
				mapper.map(line, context);

			}
		}

		/**
		 * �����ʾ
		 */
		HashMap<Object, Object> contextMap = context.getContextMap();
		
		
		if (fs.exists(output)) {
			throw new RuntimeException("Ŀ¼�Ѵ��ڣ���������Ŀ¼");
		}

		FSDataOutputStream out = fs.create(new Path(output,new Path("res.dat")));
		Set<Entry<Object, Object>> entrySet = contextMap.entrySet();

		for (Entry<Object, Object> entry : entrySet) {
			out.write((entry.getKey().toString() + "\t" + entry.getValue().toString() + "\n").getBytes());
		}

		out.close();

		fs.close();

		System.out.println("����ͳ�����....");

		// ȥhdfs�ж�ȡ�ļ���һ�ζ�һ��

		// ��ÿһ�н���ҵ����

		// �����ж�������뻺��

		// ����һ�������������еĽ�����������HDFS����ļ�

	}
}
