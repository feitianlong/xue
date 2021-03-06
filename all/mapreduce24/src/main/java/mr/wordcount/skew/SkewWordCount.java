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

		// 没有设置yarn资源管理系统，那么maoreduce任务将在本机运行（单机运行）
		// 如果设置mapreduce.framework.hostname为yarn，那么将会使用yarn采用伪分布模式运行
		// mapreduce.framework.hostname的默认参数为local，即单机运行

		job.setJarByClass(SkewWordCount.class);

		job.setMapperClass(SkewWordCountMapper.class);
		job.setReducerClass(SkewWordCountReducer.class);

		

		// 默认情况下，map函数的输出类型和reduce函数相同
		// 因此如果mapper产生出和reducer相同的类型时，可以不需要单独设置
		// 下面是reducer的输出类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.setInputPaths(job, new Path("D:\\pics2\\input\\wordcount"));
		FileOutputFormat.setOutputPath(job, new Path("D:\\pics2\\output\\wordcount_skew"));

		
		job.setNumReduceTasks(3);
		boolean res = job.waitForCompletion(true);
		// 正常退出
		// status为0时为正常退出程序，也就是结束当前正在运行中的java虚拟机。

		// 非正常退出
		// status为非0的其他整数（包括负数，一般是1或者-1），表示非正常退出当前程序。
		System.exit(res ? 0 : 1);
	}
}
