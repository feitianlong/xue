package mr.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class JobSubmitterLinuxToYarn {
	public static void main(String[] args) throws Exception {

		// 在代码中设置JVM系统参数，用于给job对象来获取访问HDFS的用户身份
		System.setProperty("HADOOP_USER_NAME", "root");

		// 1. 设置job要运行的默认文件系统
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://hdp-01:9000");
		// 2. 设置 job要提交运行的目的地
		conf.set("mapreduce.framework.name", "yarn");
		conf.set("yarn.resourcemanager.hostname", "hdp-01");
		// 3、如果要从windows系统上运行这个job提交客户端程序，则需要加这个跨平台提交的参数
		conf.set("mapreduce.app-submission.cross-platform", "true");

		// 指定对象运行的规范
		Job job = Job.getInstance(conf);

		// 传递类来指定索要提交的jar所在的类
		job.setJar("D:\\appdev\\BigData\\mapreduce24\\target\\mapreduce24-0.0.1-SNAPSHOT.jar");
		job.setJarByClass(JobSubmitterLinuxToYarn.class);

		// 指定本次job索要调用的Mapper和Reducer的实现类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		// 本次job的Mapper和Reducer实现类的输出数据的key ，value的类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// 默认情况下，map函数的输出类型和reduce函数相同
		// 因此如果mapper产生出和reducer相同的类型时，可以不需要单独设置
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		// 指定本次job要处理的输入数据集所在路径、最终结果的输出路径
		FileInputFormat.setInputPaths(job, new Path("/wordcount/input"));
		FileOutputFormat.setOutputPath(job, new Path("/wordcount/output"));

		job.setNumReduceTasks(3);
		
		// 提交job给yarn,并等待执行完成
		boolean res = job.waitForCompletion(true);
		// 运行成功时，作业会把其进度信息写道控制台
		System.exit(res ? 0 : 1);

	}
	

}
