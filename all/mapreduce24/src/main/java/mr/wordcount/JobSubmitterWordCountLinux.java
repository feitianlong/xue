package mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobSubmitterWordCountLinux {

	public static void main(String[] args)
			throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf);

		// û������yarn��Դ����ϵͳ����ômaoreduce�����ڱ������У��������У�
		// �������mapreduce.framework.hostnameΪyarn����ô����ʹ��yarn����α�ֲ�ģʽ����
		// mapreduce.framework.hostname��Ĭ�ϲ���Ϊlocal������������

		job.setJarByClass(JobSubmitterWordCountLinux.class);

		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		job.setCombinerClass(WordcountCombiner.class);

		// Ĭ������£�map������������ͺ�reduce������ͬ
		// ������mapper��������reducer��ͬ������ʱ�����Բ���Ҫ��������
		// ������reducer���������
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setNumReduceTasks(Integer.parseInt(args[2]));

		boolean res = job.waitForCompletion(true);
		// �����˳�
		// statusΪ0ʱΪ�����˳�����Ҳ���ǽ�����ǰ���������е�java�������

		// �������˳�
		// statusΪ��0����������������������һ����1����-1������ʾ�������˳���ǰ����
		System.exit(res ? 0 : 1);
	}
}
