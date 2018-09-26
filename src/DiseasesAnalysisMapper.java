import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DiseasesAnalysisMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
	@Override
	public void map(LongWritable key, Text value, Context context)
	    throws IOException, InterruptedException
	{
		String s = value.toString().toLowerCase();
	    String text_start_tag ="\"text\"";
	    String text_end_tag = ",\"contributors\"";
	    String location_startTag = "\"location\"";
	    String location_endTag = "\",\"";
	    String null_location_tag = "\"location\":\"\"";
	  	  	  
	    int null_location_tag_Index = s.indexOf(null_location_tag);
	  
	    if(null_location_tag_Index < 0)
	    {
	    	
	    	
	    	
	    	
	    	int startIndex = s.indexOf(text_start_tag);
	    	int endIndex = s.indexOf(text_end_tag, startIndex);
		  
	    	int loc_StartIndex = s.indexOf(location_startTag);
	    	int loc_EndIndex = s.indexOf(location_endTag, loc_StartIndex);
		  
	    	if((startIndex > 0) && (endIndex > 0) && (loc_StartIndex > 0) && (loc_EndIndex > 0))
	    	{
	    		String[] elements = s.substring(startIndex,endIndex-1).split("\":\"");
		    	String b;
			  
		    	String loc[] = s.substring(loc_StartIndex, loc_EndIndex).split("\":\"");
		    	
		    	String location = loc[1].replaceAll("[^a-zA-Z ]", "").trim();
		    	
		    	String testStopWord = null;
		    	PorterStemming pr = new PorterStemming();
		    	StopWords stp = new StopWords();
		    	CategoryFinder cf = new CategoryFinder();
		    	
		    	if(!location.isEmpty())
		    	{
		    		StringTokenizer st = new StringTokenizer(elements[1],"://. {}[],	#?_~`!@$%^&*()-+=\"\\|'");
			  
		    		int n = st.countTokens();	 
			  
		    		String words[] = new String[n];
		    		IntWritable I = new IntWritable(1);
		    		Text text;
		    		int length = words.length;
		    		for(int k =0 ; st.hasMoreTokens() && k < length ; k++)
		    		{
		    			b = st.nextToken().toString();
		    			testStopWord = stp.checkStopwords(b);
		    			if(testStopWord != null)
		    			{
		    				words[k] = pr.stripAffixes(b);
		    				if(words[k] != "")
		    				{
		    					location = location.toLowerCase();
		    					String test = words[k];
		    					
		    					String s1 = cf.diseaseFinder(test);
		    					String s2 = cf.locFinder(location);
		    					if(s1 != null && s2 != null)
		    					{
		    						text = new Text(s1 + "\t" + s2);
		    						context.write(text, I);
		    					}
		    				}
		    			}
		    		}
		    	}
	    	}
	    }
	}
}