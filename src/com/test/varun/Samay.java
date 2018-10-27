package com.test.varun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Samay {

	static boolean isNowBetweenDateTime(final Date s, final Date e)
	{
	    final Date now = new Date();
	    return now.after(s) && now.before(e);
	}
	private static Date dateFromHourMin(final String hhmm)
	{
	    if (hhmm.matches("^[0-2][0-9]:[0-5][0-9]$"))
	    {
	        final String[] hm = hhmm.split(":");
	        final GregorianCalendar gc = new GregorianCalendar();
	        gc.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hm[0]));
	        gc.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
	        gc.set(Calendar.SECOND, 0);
	        gc.set(Calendar.MILLISECOND, 0);
	        return gc.getTime();
	    }
	    else
	    {
	        throw new IllegalArgumentException(hhmm + " is not a valid time, expecting HH:MM:SS format");
	    }
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		boolean timeCheck=true;
		
		Date now = new Date();
		System.out.println("Now:::"+now);
		
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		
		String windowStartTime="20:00";
		String windowEndTime="01:00";
		
		Date dateFrom=dateFromHourMin(windowStartTime);
		Date dateTo=dateFromHourMin(windowEndTime);
		
		System.out.println("dateFrom:::"+dateFrom);
		System.out.println("dateTo:::"+dateTo);
		
		if (dateTo.before(dateFrom)){
			
			System.out.println("Updating windowEndTime as it is on next date...");
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(dateTo);
			cal.add(Calendar.DATE, 1);
		
			dateTo=cal.getTime();
			
			System.out.println("dateToUpdated:::"+dateTo);
		}
		
		if (timeCheck){
			if (isNowBetweenDateTime(dateFrom,dateTo)){
				System.out.println("Allowed to Run");
			}
			else {
				System.out.println("Not Allowed to Run");
			}
		}
		
	}
		
		
		
}
