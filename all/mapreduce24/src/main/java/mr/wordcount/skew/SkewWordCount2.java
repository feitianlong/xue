package mr.wordcount.skew;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import mr.wordcount.skew.SkewWordCount.SkewWordCountMapper;
import mr.wordcount.skew.SkewWordCount.SkewWordCountReducer;

public class SkewWordCount2 {

	public static class SkewWordCount2Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
		private IntWritable v = new IntWritable();
		private Text k = new Text();

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			String[] split = value.toString().split("\t");
			v.set(Integer.parseInt(split[1]));
			String[] ks = split[0].split("\001");
			k.set(ks[0]);

			context.write(k, v);

		}

	}

	public static class SkewWordCount2Reducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		IntWritable v = new IntWritable();

		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			int count = 0;
			for (IntWritable value : values) {
				count += value.get();
			}
			v.set(count);
			context.write(key, v);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf);

		// û������yarn��Դ����ϵͳ����ômaoreduce�����ڱ������У��������У�
		// �������mapreduce.framework.hostnameΪyarn����ô����ʹ��yarn����α�ֲ�ģʽ����
		// mapreduce.framework.hostname��Ĭ�ϲ���Ϊlocal������������

		job.setJarByClass(SkewWordCount2.class);

		job.setMapperClass(SkewWordCount2Mapper.class);
		job.setReducerClass(SkewWordCount2Reducer.class);

		

		// Ĭ������£�map������������ͺ�reduce������ͬ
		// ������mapper��������reducer��ͬ������ʱ�����Բ���Ҫ��������
		// ������reducer���������
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.setInputPaths(job, new Path("D:\\pics2\\output\\wordcount_skew"));
		FileOutputFormat.setOutputPath(job, new Path("D:\\pics2\\output\\wordcount_skew_2"));

		
		job.setNumReduceTasks(3);
		boolean res = job.waitForCompletion(true);
		// �����˳�
		// statusΪ0ʱΪ�����˳�����Ҳ���ǽ�����ǰ���������е�java�������

		// �������˳�
		// statusΪ��0����������������������һ����1����-1������ʾ�������˳���ǰ����
		System.exit(res ? 0 : 1);
	}
}
