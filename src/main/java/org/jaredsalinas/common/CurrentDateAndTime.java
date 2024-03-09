package org.jaredsalinas.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CurrentDateAndTime {
    
	public static String customizeDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String customizeFormatDate(String format)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getPastDate(String format, int noOfDays)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDate daysAgo = LocalDate.now().minusDays(noOfDays);
        return dtf.format(daysAgo);
    }

    public static String getCurrentTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getCurrentDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String calculateFutureDate()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yy");
        Calendar next = Calendar.getInstance();
        next.add(Calendar.DAY_OF_MONTH, 31);
        return dtf.format(next.getTime());
    }

    public static String calculateFutureDateFirstDayOfNextMonth()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar next = Calendar.getInstance();
        next.set(Calendar.DAY_OF_MONTH, 1);
        next.set(Calendar.MONTH, next.get(Calendar.MONTH) + 1);
        return dtf.format(next.getTime());
    }

    public static String calculateFutureDateFirstDayOfNextYear()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar next = Calendar.getInstance();
        next.set(Calendar.DAY_OF_YEAR, 1);
        next.set(Calendar.YEAR, next.get(Calendar.YEAR) + 1);
        return dtf.format(next.getTime());
    }
    
    public static String calculateFutureDateOfNextMonth()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 35);
        return dtf.format(c.getTime());        
    }
    
    public static String calculateFutureDateSameMonthNextYear()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("MM/yy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        return dtf.format(c.getTime());        
    }
    
    public static LocalDateTime getCurrentDateTimeInLocalDateTimeFormat()
    {
        LocalDateTime now = LocalDateTime.now();
		return now;
    }
    
    public static String getDifferenceDateTime(LocalDateTime initialDateTime, LocalDateTime finalDateTime, String format)
    {
    	DateTimeFormatter yearsdtf = DateTimeFormatter.ofPattern("yyyy");
    	DateTimeFormatter monthsdtf = DateTimeFormatter.ofPattern("MM");
    	DateTimeFormatter daysdtf = DateTimeFormatter.ofPattern("dd");
    	DateTimeFormatter hoursdtf = DateTimeFormatter.ofPattern("HH");
    	DateTimeFormatter minutesdtf = DateTimeFormatter.ofPattern("mm");
    	DateTimeFormatter secondsdtf = DateTimeFormatter.ofPattern("ss");

    	LocalDateTime differenceDateTime = finalDateTime
        		.minusYears(Long.parseLong(yearsdtf.format(initialDateTime)))
        		.minusMonths(Long.parseLong(monthsdtf.format(initialDateTime)))
        		.minusDays(Long.parseLong(daysdtf.format(initialDateTime)))
        		.minusHours(Long.parseLong(hoursdtf.format(initialDateTime)))
        		.minusMinutes(Long.parseLong(minutesdtf.format(initialDateTime)))
        		.minusSeconds(Long.parseLong(secondsdtf.format(initialDateTime)));
    	
    	switch (format) {
	        case "years":
	        	return yearsdtf.format(differenceDateTime);	        	
	        case "months":
	        	return monthsdtf.format(differenceDateTime);
	        case "days":
	        	return daysdtf.format(differenceDateTime);
	        case "hours":
	        	return hoursdtf.format(differenceDateTime);
	        case "minutes":
	        	return minutesdtf.format(differenceDateTime);
	        case "seconds":
	        	return secondsdtf.format(differenceDateTime);
	        default:
	        	System.out.println("Format invalid - Use 'years', 'months', 'days', 'hours', 'minutes' or 'seconds'.");
	            throw new RuntimeException("Invalid entry.");
    	}
    }
}