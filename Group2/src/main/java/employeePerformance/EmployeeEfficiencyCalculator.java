package employeePerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;

public class EmployeeEfficiencyCalculator implements IEmployeeEfficiencyCalculator
{
	ResultSet resultSetEfficiency = null;
	ResultSet resultSetProductivity = null;

	public EmployeeEfficiencyCalculator(ResultSet resultSet) 
	{
		this.resultSetEfficiency = resultSet;
		this.resultSetProductivity = resultSet;
	}
 
	public HashMap<Integer,Integer> calculateEmployeeEfficiency() throws SQLException, ParseException
	{ 
		WorkWeights myVar = null; 
		LocalDate startDate = null;
		LocalDate expectedendDate = null;
		LocalDate endDate = null;
		long durationTaken = 0;
		long durationGiven = 0;
		int efficiency = 0;
		int avg_efficiency = 0;
		int count = 0;
		int countMonth = 0;
		int avgEfficiency = 0;
		int month = 0;
		int year = 0;
		HashMap<Integer,Integer> EfficiencyHashMap=new HashMap<Integer,Integer>();//Creating HashMap    
		 
		while(resultSetEfficiency.next()) 
    	{
        	
            startDate = LocalDate.parse(resultSetProductivity.getString("startDate"));
    	    expectedendDate = LocalDate.parse(resultSetProductivity.getString("endDate"));   	       	    
    	    durationGiven = ChronoUnit.DAYS.between(startDate,expectedendDate);

    	    endDate = LocalDate.parse(resultSetEfficiency.getString("endDate"));
    	    durationTaken = ChronoUnit.DAYS.between(startDate,endDate);
    	    
    	    durationTaken++;
    	    durationGiven++;
    	    
	    	if(durationTaken < ((int) durationGiven/2)) 
	    	{
    	    	if(durationGiven>10) 
    	    	{
    	    		myVar = WorkWeights.HIGH;
    	    	} 	
    	    	else if(durationGiven>5 && durationGiven<11) 
    	    	{
    	    		myVar =  WorkWeights.MEDIUM; 
    	    	}	
    	    	else 
    	    	{
    	    		myVar = WorkWeights.LOW; 
    	    	}
	    		efficiency= (int) ((durationTaken*100*myVar.getWorkWeights())/durationGiven);
	    	}
	    	else 
	    	{
	    		efficiency= (int) ((durationTaken*100)/durationGiven);
	    	} 
	    	avg_efficiency +=efficiency; 
	    	count++;
	    	
	    	if(startDate.getDayOfMonth() == (month) || count==1)
	    	{
	    	    avgEfficiency +=efficiency;
		    	countMonth++;
	    	}
	    	else
    	    {
    	    	avgEfficiency = avgEfficiency/countMonth;	
     	    	EfficiencyHashMap.put(month, avgEfficiency);
    			avgEfficiency = 0;
    			countMonth = 0;
	    		avgEfficiency += efficiency;
	    		countMonth++;
    	    }
	    	month = startDate.getDayOfMonth();
    	}
		
		year = startDate.getYear();
		avg_efficiency = avg_efficiency/count;
		EfficiencyHashMap.put(year, avg_efficiency);
		EfficiencyHashMap.put(month, avgEfficiency);
	
		return EfficiencyHashMap;
	}
}