package com.lawencon.parkiran;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formatDate(Date date) {
        SimpleDateFormat dateGenerate = new SimpleDateFormat("hh:mm a yyyy-MM-dd");
        return dateGenerate.format(date);
    }
	
	public static String day() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
}
