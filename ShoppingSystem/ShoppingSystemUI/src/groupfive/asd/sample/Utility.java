package groupfive.asd.sample;

import shoppingsystem.framework.logger.AbstractLogger;
import shoppingsystem.framework.logger.LoggerBuilder;

import java.util.Calendar;
import java.util.Date;

public class Utility {
	public static AbstractLogger logger = LoggerBuilder.getLogger();

	public static void printLine() {
		System.out.println("=======================================");
	}

	public static void printInlineMessage(String message) {
		System.out.print(message);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static Date getCardExpiryDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2015, Calendar.JANUARY, 21);
		return cal.getTime();
	}
}
