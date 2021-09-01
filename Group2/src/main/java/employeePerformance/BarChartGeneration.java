package employeePerformance;

import java.util.HashMap;

import employeePerformance.Interfaces.IBarChartGeneration;

public class BarChartGeneration implements IBarChartGeneration
{
	public String Displaybarchart(HashMap <Integer, Integer> PatternGeneration ) 
	{
	    String string = null;
		String pattern = null;
        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    int length = 0;
	    int i = 0;
	    int j = 0;
	    
	    for(i = 0; i < monthString.length; i++)   
	    {
	      if(PatternGeneration.containsKey(i))	
	      {
	    	  if(PatternGeneration.get(i)>100) 
	    	  {
	    		  length = 10;
	    	  }	
	    	  else
	    	  {
	    		  length = PatternGeneration.get(i)/10;
	    	  } 
	          
		      for(j = 0; j < length; j++) 
		      {
		    	  if(string==null) {
		    		  string = "*";
		    	  }
		    	  else 
		    	  {
		          string += "*";  
		    	  }
		      }
		      if(pattern==null) 
		      {
		    	  pattern = monthString[i];
		      }
		      else 
		      {
		    	  pattern += monthString[i];
		      }
		      pattern += ":";
		      pattern += string;
		      pattern += "\n";

		      string = null;
	      }
	    }
	    return pattern;
	}
}