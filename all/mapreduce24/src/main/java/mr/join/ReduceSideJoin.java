package mr.join;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class ReduceSideJoin {
	public static class ReduceSideJoinMapper extends Mapper<LongWritable, Text, Text, JoinBean> {

		private String filename = null;
		JoinBean bean = new JoinBean();
		Text USER_ID = new Text();

		@Override
		protected void setup(Mapper<LongWritable, Text, Text, JoinBean>.Context context)
				throws IOException, InterruptedException {
			// �õ���Ƭ�������ļ���
			FileSplit inputSplit = (FileSplit) context.getInputSplit();
			filename = inputSplit.getPath().getName();
		}

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, JoinBean>.Context context)
				throws IOException, InterruptedException {
			// �����ļ�����д����
			String[] split = value.toString().split(",");
			if (filename.startsWith("order")) {
				bean.set(split[0], split[1], "Null", -1, "Null", "order");
			} else {
				bean.set("Null", split[0], split[1], Integer.parseInt(split[2]), split[3], "user");
			}
			USER_ID.set(bean.getUserId());
			context.write(USER_ID, bean);

		}

	}

	public static class ReduceSideJoinReducer extends Reducer<Text, JoinBean, JoinBean, NullWritable> {
		@Override
		protected void reduce(Text key, Iterable<JoinBean> values,
				Reducer<Text, JoinBean, JoinBean, NullWritable>.Context context)
				throws IOException, InterruptedException {
			ArrayList<JoinBean> orderList = new ArrayList<>();
			JoinBean userBean = null;

			try {

				// ��������
				for (JoinBean bean : values) {
					if ("order".equals(bean.getTableName())) {

						// ����һ���û������ж������
						JoinBean newBean = new JoinBean();
						BeanUtils.copyProperties(newBean, bean);
						orderList.add(newBean);

					} else {
						// ����ʱuser��userID��Ψһ��
						// ����reduce��groupingComparator��userId��ͬ�ķ�Ϊһ��
						// һ��groupֻ����һ��user�����Ϣ
						userBean = new JoinBean();
						BeanUtils.copyProperties(userBean, bean);
					}

				}

				// ƴ�����ݣ������
				for (JoinBean bean : orderList) {
					// // һ��groupֻ����һ��user�����Ϣ�������group����ͬ��userID
					bean.setUserName(userBean.getUserName());
					bean.setUserAge(userBean.getUserAge());
					bean.setUserFriend(userBean.getUserFriend());

					context.write(bean, NullWritable.get());

				}

			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {

		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf);

		job.setJarByClass(ReduceSideJoin.class);

		job.setMapperClass(ReduceSideJoinMapper.class);
		job.setReducerClass(ReduceSideJoinReducer.class);

		job.setNumReduceTasks(2);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(JoinBean.class);

		job.setOutputKeyClass(JoinBean.class);
		job.setOutputValueClass(NullWritable.class);

		FileInputFormat.setInputPaths(job, new Path("D:\\pics2\\input\\join"));
		FileOutputFormat.setOutputPath(job, new Path("D:\\pics2\\output\\join"));

		job.waitForCompletion(true);
	}
}
