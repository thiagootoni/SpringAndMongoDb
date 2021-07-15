package com.thiago.postsApi.utils;

import java.time.Instant;
import java.time.format.DateTimeParseException;

public class DateConversors {

	public static Instant stringToInstant(String textDate) {
		Instant resultDate = Instant.parse(textDate);
		return resultDate;
	}	
	
	public static Instant stringToInstant(String textDate, Instant defaultResult) {
		try {
			Instant resultDate = Instant.parse(textDate);
			return resultDate;
		} catch (DateTimeParseException e) {
			return defaultResult;
		}		
	}
	
}
