package com.sandbox.util;

import java.sql.Date;
import java.util.Calendar;

public class DateUtilities {
	
	public static java.sql.Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
	}	

}
