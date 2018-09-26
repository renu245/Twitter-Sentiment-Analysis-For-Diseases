import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DiseasesAnalysisReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException
	{
		
		int wordCount = 0;
	    for (IntWritable value : values)
	    {
	    	wordCount += value.get();
	    }
	    
	    context.write(new Text(key),new IntWritable(wordCount));
	    
	  }
}