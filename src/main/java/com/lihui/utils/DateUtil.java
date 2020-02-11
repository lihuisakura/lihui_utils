package com.lihui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 
	 * @Title: getAge 
	 * @Description: 根据生日得到年龄(参数为字符串类型)
	 * @param birthday
	 * @return
	 * @return: int
	 * @throws ParseException 
	 */
	public static int getAgeByString(String birthday) throws ParseException {
		//日期类型转换，由string转换为date
		Date date = simpleDateFormat.parse(birthday);
		return getAgeByDate(date);
	}
	/**
	 * 
	 * @Title: getAgeByDate 
	 * @Description: 根据日期求年龄（参数为date类型）
	 * @param birthday
	 * @return
	 * @throws ParseException
	 * @return: int
	 */
	public static int getAgeByDate(Date birthday) throws ParseException {
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		//求出当前年份
		int year=calendar.get(calendar.YEAR);
		//求出当前月份
		int month=calendar.get(calendar.MONTH);
		//求出当前日期
		int day=calendar.get(calendar.DAY_OF_MONTH);
		//把生日赋值给日历控件
		calendar.setTime(birthday);
		//求出生日年份
		int birYear=calendar.get(calendar.YEAR);
		//求出生日月份
		int birMonth=calendar.get(calendar.MONTH);
		//求出生日几号
		int birDay=calendar.get(calendar.DAY_OF_MONTH);
		//当前年份减生日年份，求出年龄
		int age=year-birYear;
		//当前月份大于生日月份，年龄加一
		if(month>birMonth) {
			age++;
		}
		//当前月份等于生日月份，当前日期大于生日日期，年龄加一
		if(month==birMonth && day>birDay) {
			age++;
		}
		return age;
	}
	
	/**
	 * 
	 * @Title: getDayNum 
	 * @Description: 求两个日期相差的天数(参数为date类型)
	 * @param day01 Date
	 * @param day02 Date
	 * @return
	 * @return: int
	 */
	public static int getDayNumByDate(Date day01,Date day02) {
		Long time=24L*60*60*1000;
		long day1Time = day01.getTime();
		long day2Time = day02.getTime();
		if(day1Time>day2Time) {
			return (int)((day1Time-day2Time)/time);
		}else {
			return (int)((day2Time-day1Time)/time);
		}
	}
	/**
	 * 
	 * @Title: getDayNumByString 
	 * @Description: 求两个日期相差的天数(参数为string类型)
	 * @param day01
	 * @param day02
	 * @return
	 * @throws ParseException
	 * @return: int
	 */
	public static int getDayNumByString(String day01,String day02) throws ParseException {
		Date day1 = simpleDateFormat.parse(day01);
		Date day2 = simpleDateFormat.parse(day02);
		return getDayNumByDate(day1, day2);
	}
	
	/**
	 * 
	 * @Title: getOneDayByDate 
	 * @Description: 根据给定的时间  获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
	 * @param day Date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMouthDayByDate(Date day) {
		//获得日期控件
		Calendar calendar = Calendar.getInstance();
		//将日期重置 获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: getOneDayByString 
	 * @Description: 根据给定的时间  获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
	 * @param day String
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date getInitMouthDayByString(String day) throws ParseException {
		Date date = simpleDateFormat.parse(day);
		return getInitMouthDayByDate(date);
	}
	/**
	 * 
	 * @Title: getEndMouthDayByDate 
	 * @Description: 获得当月的最后一秒
	 * @param day Date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMouthDayByDate(Date day) {
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		//月份加一
		calendar.add(calendar.MONTH, 1);
		//求出月份第一天0时0分0秒
		Date date = getInitMouthDayByDate(calendar.getTime());
		calendar.setTime(date);
		//月份第一天0时0分0秒减一秒，得出当月最后一天最后一秒
		calendar.add(calendar.SECOND, -1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @Title: getEndMouthDayByString 
	 * @Description: 获得当月的最后一秒
	 * @param day String
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date getEndMouthDayByString(String day) throws ParseException {
		Date date = simpleDateFormat.parse(day);
		return getEndMouthDayByDate(date);
	}
	
	
	
}
