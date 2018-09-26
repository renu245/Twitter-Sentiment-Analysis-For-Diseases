import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DiseasesAnalysisDriver extends Configured implements Tool
{
	@Override
	public int run(String[] args) throws Exception
	{
		if (args.length != 2)
		{
			System.out.printf(
					"Usage: %s [generic options] <input dir> <output dir>\n", getClass()
					.getSimpleName());
      
			ToolRunner.printGenericCommandUsage(System.out);
      
			return -1;
		}
    
		Job job = Job.getInstance(getConf());
    
		job.setJarByClass(DiseasesAnalysisDriver.class);
		job.setJobName(this.getClass().getName());
    
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(DiseasesAnalysisMapper.class);
		job.setReducerClass(DiseasesAnalysisReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
    
		job.setNumReduceTasks(1);

		if (job.waitForCompletion(true))
		{
			return 0;
		}
		
		return 1;
    }
	
	public static void main(String[] args) throws Exception
	{
		int exitCode = ToolRunner.run(new DiseasesAnalysisDriver(), args);
		System.exit(exitCode);
	}
}