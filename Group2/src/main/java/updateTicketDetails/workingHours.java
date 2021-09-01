package updateTicketDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import updateTicketDetails.interfaces.IworkingHours;


public class workingHours implements IworkingHours 
{
	
	private ResultSet resultset;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  

	public workingHours(ResultSet resultset) {
		this.resultset = resultset;
	}
	
	public double insertTicket(ResultSet resultset) throws SQLException
	{
		String previousDate = null;
		Date todayDate = null;
	    double hours = 0;
		Date formateGetDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();

		while(resultset.next()) 	
    	{
				previousDate = resultset.getString("previousDate");
			    
				try 
				{
					formateGetDate  = sdf.parse(previousDate);
					todayDate = sdf.parse(sdf.format(cal.getTime()));
				}
				catch (ParseException e1) 
				{
					hours=0;
				}
	    	    long dateDifferenceInMinutes = Math.abs(formateGetDate.getTime() - todayDate.getTime());
			    long minutes = TimeUnit.MILLISECONDS.toMinutes(dateDifferenceInMinutes);
			    hours = minutes/(float)60;
    	}
		return hours;
	}
}
