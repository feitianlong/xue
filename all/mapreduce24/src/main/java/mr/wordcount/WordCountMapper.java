package mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * KEYIN ����map task��ȡ�������ݵ�key�����ͣ���һ�е���ʼƫ����Long VALUEIN:��map
 * task��ȡ�������ݵ�value�����ͣ���һ�е�����String
 * 
 * KEYOUT�����û����Զ���map����Ҫ���صĽ��kv���ݵ�key�����ͣ���wordcount�߼��У�������Ҫ���ص��ǵ���String
 * VALUEOUT:���û����Զ���map����Ҫ���صĽ��kv���ݵ�value�����ͣ���wordcount�߼��У�������Ҫ���ص�������Integer
 * 
 * 
 * ���ǣ���mapreduce�У�map������������Ҫ�����reduce����Ҫ�������л��ͷ����л�����jdk�е�ԭ�����л����Ʋ������������Ƚ����࣬�ͻᵼ��������mapreduce���й����д���Ч�ʵ���
 * ���ԣ�hadoopר��������Լ������л����ƣ���ô��mapreduce�д�����������;ͱ���ʵ��hadoop�Լ������л��ӿ�
 * 
 * hadoopΪjdk�еĳ��û�������Long String Integer
 * Float���������ͷ�ס���Լ���ʵ����hadoop���л��ӿڵ����ͣ�LongWritable,Text,IntWritable,FloatWritable
 * 
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	// Contextʵ������������ݵ�д��
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] words = line.split(" ");
		for (String word : words) {
			context.write(new Text(word), new IntWritable(1));
		}
	}
}
