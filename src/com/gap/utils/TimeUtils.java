package com.gap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	public static String getDate(){
		Date day1 = new Date();
		SimpleDateFormat hlg = new SimpleDateFormat("yyyyMMdd_HHmmss");	
		String strtime = hlg.format(day1).toString();
		return strtime;
	}
}
