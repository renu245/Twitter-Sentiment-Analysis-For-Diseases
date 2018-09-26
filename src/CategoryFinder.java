public class CategoryFinder
{
	public String diseaseFinder(String token)
	{
		if(token.equalsIgnoreCase("malaria"))
		{
			return "MALARIA";
		}
		else if(token.equalsIgnoreCase("typhoid"))
		{
			return "TYPHOID";
		}
		else if(token.equalsIgnoreCase("ebola"))
		{
			return "EBOLA";
		}
		
		else if(token.equalsIgnoreCase("dengue"))
		{
			return "DENGUE";
		}
		else if(token.equalsIgnoreCase("cancer"))
		{
			return "CANCER";
		}
		
		else if(token.equalsIgnoreCase("cholera"))
		{
			return "CHOLERA";
		}
		return null;
	}
	
	public String locFinder(String loc)
	{
		loc = loc.toLowerCase();
		
		if((loc.contains("hyderabad")))
	    {
	    	return "HYDERABAD";
	    }
	    
	    if((loc.contains("bengalore")))
	    {
	    	return "BENGALORE";
	    }
	    
	    if((loc.contains("chennai")))
	    {
	    	return "CHENNAI";
	    }
	    if((loc.contains("mumbai")))
	    {
	    	return "MUMBAI";
	    }
	    
	    if((loc.contains("delhi")))
	    {
	    	return "DELHI";
	    }
		
	    if((loc.contains("kolkata")))
	    {
	    	return "KOLKATA";
	    }
		return null;
	}
	
	/*
	public String locFinder(String loc)
	{
		
		loc = loc.toLowerCase();
		
		if((loc.contains("usa")) || (loc.contains("united states of america")) 
				|| (loc.contains("united states")) || (loc.contains("america")) 
				|| (loc.contains("new york")) || (loc.contains("california")) 
				|| (loc.contains("new jersy")) || (loc.contains("texas"))
				|| (loc.contains("dallas")) || (loc.contains("canada"))
				|| (loc.contains("mexico")) || (loc.equalsIgnoreCase("san francisco"))
				|| (loc.contains("south wales")))
	    {
	    	return "USA";
	    }
	    
	    if((loc.contains("india")) || (loc.contains("delhi")) || (loc.contains("mumbai"))
	    		|| (loc.contains("kolkata")) || (loc.contains("chennai")) || (loc.contains("hyderabad"))
	    		|| (loc.contains("bengalore")) || (loc.contains("pune")) || (loc.contains("karnataka"))
	    		|| (loc.contains("ahmedabad")) || (loc.contains("gujarat")))
	    {
	    	return "INDIA";
	    }
	    
	    if((loc.contains("brazil")) || (loc.contains("ghana")) || (loc.contains("nigeria"))
	    		|| (loc.contains("africa")) || (loc.contains("south africa"))
	    		|| (loc.contains("brazil")) || (loc.contains("johannesburg"))
	    		|| (loc.contains("jamaica"))|| (loc.contains("kenya")))
	    {
	    	return "AFRICA";
	    }
	    if((loc.contains("united kingdom")) || (loc.contains("london"))
	    		|| (loc.contains("uk")) || (loc.contains("italy"))
	    		|| (loc.contains("north wales")))
	    {
	    	return "UK";
	    }
	    
	    if((loc.contains("brisbane")) || (loc.contains("australia"))
	    		|| (loc.contains("melbourne")) || (loc.contains("sydney")))
	    {
	    	return "AUSTRALIA";
	    }
	    return loc;
	}
	*/
}
