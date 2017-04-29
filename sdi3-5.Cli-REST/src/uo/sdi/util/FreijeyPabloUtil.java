package uo.sdi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import uo.sdi.client.model.Task;

public class FreijeyPabloUtil {

	public static Date today() {
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

	public static void orderAscending(List<Task> param) {
		Collections.sort(param, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getPlanned() == null)
					return 1;
				if (o2.getPlanned() == null)
					return -1;
				return o1.getPlanned().compareTo(o2.getPlanned());
			}
		});
	}

	public static void orderDescending(List<Task> param) {
		Collections.sort(param, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getPlanned() == null)
					return 1;
				if (o2.getPlanned() == null)
					return -1;
				return o2.getPlanned().compareTo(o1.getPlanned());
			}
		});
	}

	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
