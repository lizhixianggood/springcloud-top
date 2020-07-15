package com.test.auth.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtil {

	/**
	 * 获取当前时间的n个小时数
	 * 
	 * @param count
	 * @return
	 */
	public static List<String> getHours(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
			list.add(df.format(calendar.getTime()));
		}
		return list;
	}

}
