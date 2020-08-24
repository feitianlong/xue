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

		// �ڴ���������JVMϵͳ���������ڸ�job��������ȡ����HDFS���û����
		System.setProperty("HADOOP_USER_NAME", "root");

		// 1. ����jobҪ���е�Ĭ���ļ�ϵͳ
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://hdp-01:9000");
		// 2. ���� jobҪ�ύ���е�Ŀ�ĵ�
		conf.set("mapreduce.framework.name", "yarn");
		conf.set("yarn.resourcemanager.hostname", "hdp-01");
		// 3�����Ҫ��windowsϵͳ���������job�ύ�ͻ��˳�������Ҫ�������ƽ̨�ύ�Ĳ���
		conf.set("mapreduce.app-submission.cross-platform", "true");

		// ָ���������еĹ淶
		Job job = Job.getInstance(conf);

		// ��������ָ����Ҫ�ύ��jar���ڵ���
		job.setJar("D:\\appdev\\BigData\\mapreduce24\\target\\mapreduce24-0.0.1-SNAPSHOT.jar");
		job.setJarByClass(JobSubmitterLinuxToYarn.class);

		// ָ������job��Ҫ���õ�Mapper��Reducer��ʵ����
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		// ����job��Mapper��Reducerʵ�����������ݵ�key ��value������
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// Ĭ������£�map������������ͺ�reduce������ͬ
		// ������mapper��������reducer��ͬ������ʱ�����Բ���Ҫ��������
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		// ָ������jobҪ������������ݼ�����·�������ս�������·��
		FileInputFormat.setInputPaths(job, new Path("/wordcount/input"));
		FileOutputFormat.setOutputPath(job, new Path("/wordcount/output"));

		job.setNumReduceTasks(3);
		
		// �ύjob��yarn,���ȴ�ִ�����
		boolean res = job.waitForCompletion(true);
		// ���гɹ�ʱ����ҵ����������Ϣд������̨
		System.exit(res ? 0 : 1);

	}
	

}
