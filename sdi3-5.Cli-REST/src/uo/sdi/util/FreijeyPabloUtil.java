package uo.sdi.util;

import java.util.Calendar;
import java.util.Date;

public class FreijeyPabloUtil {
	public static Date today(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date today = new Date();
		today.setTime(cal.getTimeInMillis());
		return today;
	}
	
}
