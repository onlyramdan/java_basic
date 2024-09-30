package com.lawencon.BookStore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
	public String getTime() {
		LocalDateTime localTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm:ss");
		String time = localTime.format(formatter);
		return time;
	}
}
