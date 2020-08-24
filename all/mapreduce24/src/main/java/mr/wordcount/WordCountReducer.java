package mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
		int count = 0;
		for (IntWritable value : values) {
			count += value.get();
		}
		context.write(key, new IntWritable(count));

		/*
		 * 
		 * int count = 0;
		 * 
		 * Iterator<IntWritable> iterator = values.iterator();
		 * while(iterator.hasNext()){
		 * 
		 * IntWritable value = iterator.next(); count += value.get(); }
		 */
	}

}
