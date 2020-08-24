package mr.wordcount.skew;

import java.io.IOException;
import java.util.Random;

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


public class SkewWordCount {
	public static class SkewWordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		Random random = new Random();
		private Text k = new Text();
		IntWritable v = new IntWritable(1);
		int numReduceTasks = 0;

		@Override
		protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			numReduceTasks = context.getNumReduceTasks();
		}

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			//
			String[] split = value.toString().split(" ");
			for (String w : split) {
				k.set(w + "\001" + random.nextInt(numReduceTasks));
				context.write(k, v);
			}

		}
	}

	public static class SkewWordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		
		IntWritable v = new IntWritable();
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
			
			int count = 0;
			
			for (IntWritable v : values) {
				count += v.get();
			}
			v.set(count);
			context.write(key, v);
			
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf);

		// û������yarn��Դ����ϵͳ����ômaoreduce�����ڱ������У��������У�
		// �������mapreduce.framework.hostnameΪyarn����ô����ʹ��yarn����α�ֲ�ģʽ����
		// mapreduce.framework.hostname��Ĭ�ϲ���Ϊlocal������������

		job.setJarByClass(SkewWordCount.class);

		job.setMapperClass(SkewWordCountMapper.class);
		job.setReducerClass(SkewWordCountReducer.class);

		

		// Ĭ������£�map������������ͺ�reduce������ͬ
		// ������mapper��������reducer��ͬ������ʱ�����Բ���Ҫ��������
		// ������reducer���������
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.setInputPaths(job, new Path("D:\\pics2\\input\\wordcount"));
		FileOutputFormat.setOutputPath(job, new Path("D:\\pics2\\output\\wordcount_skew"));

		
		job.setNumReduceTasks(3);
		boolean res = job.waitForCompletion(true);
		// �����˳�
		// statusΪ0ʱΪ�����˳�����Ҳ���ǽ�����ǰ���������е�java�������

		// �������˳�
		// statusΪ��0����������������������һ����1����-1������ʾ�������˳���ǰ����
		System.exit(res ? 0 : 1);
	}
}
