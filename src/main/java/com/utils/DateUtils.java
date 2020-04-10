package com.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils extends org.apache.commons.lang.time.DateUtils {

	
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	public static final String yyyy_MM = "yyyy-MM";
	public static final String MM_DD = "MM-dd";
	public static final String yyyy = "yyyy";
	public static final String MM = "MM";
	public static final String dd = "dd";
	public static final String HH_mm_ss = "HH:mm:ss";
	public static final String HH_mm = "HH:mm";
	public static final String mm_ss = "mm:ss";
	public static final String yyyyMMddHHmmssS = "yyyyMMddHHmmssS";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String yyMMddHHmmss = "yyMMddHHmmss";
	public static final String yyyyMMdd = "yyyyMMdd";
	public static final String MMddHHmmssS = "MMddHHmmssS";
	public static final String MMddHHmmss = "MMddHHmmss";
	public static final String HHmmssS = "HHmmssS";
	public static final String HHmmss = "HHmmss";
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" };

	                                        /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	                                    /**
     * 得到当前日期的前一天
     */
	public static String getPreDate(String pattern) {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // 得到前一天
		Date date = calendar.getTime();
		return DateFormatUtils.format(date, pattern);
	}

	                                        /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	                                        /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	                                        /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	                                        /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	                                        /**
     * 得到当前年份字符串 格式（yyyy）
     */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	                                        /**
     * 得到当前月份字符串 格式（MM）
     */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	                                        /**
     * 得到当天字符串 格式（dd）
     */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	                                        /**
     * 得到当前星期字符串 格式（E）星期几
     */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	                                        /**
     * 日期型字符串转化为日期 格式（"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ）
     */
	public static Date parseDate(String str) {
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	                                        /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	                                        /**
     * 得到时间戳的数字ID
     *
     * @return
     */
	public static String getDateOfNum(){
		String dateNum = "";
		dateNum = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
		return dateNum;
	}

    /**
     * 得到时间戳的数字ID
     *
     * @return
     */
    public static String getDateOfNum(String formartstr) {
        String dateNum = "";
        dateNum = DateFormatUtils.format(new Date(), formartstr);
        return dateNum;
    }

    /**
     * 日期型字符串转化为日期 格式（"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ）
     */
	public static Date formatDateYearMonth(String str) {
		try {
			return parseDate(str, new String[]{"yyyy-MM"});
		} catch (ParseException e) {
			return null;
		}
	}

	                                        /**
     * 取得几个月前距现在的日期格式(年月)
     *
     * @param num
     * @return
     */
	public static List<String> monthOperation(int num){
		List<String> strList = new ArrayList<String>();
		int j = num;
		for(int i = 0;i< Math.abs(num);i++){
            Date date = new Date();// 当前日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");// 格式化对象
            Calendar calendar = Calendar.getInstance();// 日历对象
            calendar.setTime(date);// 设置当前日期
            calendar.add(Calendar.MONTH, j);// 月份减一
            String dateStr = format.format(calendar.getTime());// 输出格式化的日期
			j++;
			strList.add(dateStr);
		}
		return strList;
	}

	                                        /**
     * 取得几个月前距现在的日期格式(年月)
     *
     * @param num
     * @return
     */
	public static List<String> monthOperParams(String date,int num){
		List<String> strList = new ArrayList<String>();
		int j = num;
		for(int i = 0;i< Math.abs(num);i++){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");// 格式化对象
            Calendar calendar = Calendar.getInstance();// 日历对象
			try {
				calendar.setTime(format.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
            calendar.add(Calendar.MONTH, j);// 月份减一
            String dateStr = format.format(calendar.getTime());// 输出格式化的日期
			j++;
			strList.add(dateStr);
		}
		return strList;
	}

	                                        /**
     * 测试两个时间的相差月份
     *
     * @param date1
     * @param date2
     * @return
     */
	public static int getMonthSpace(String start,String end){
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		    Calendar startCalendar = Calendar.getInstance();
		    Calendar endCalendar = Calendar.getInstance();
		    Calendar temp = Calendar.getInstance();
	        try {
				startCalendar.setTime(sdf.parse(start));
				endCalendar.setTime(sdf.parse(end));
		        temp.setTime(sdf.parse(end));
		        temp.add(Calendar.DATE, 1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        int year = endCalendar.get(Calendar.YEAR)
	                - startCalendar.get(Calendar.YEAR);
	        int month = endCalendar.get(Calendar.MONTH)
	                - startCalendar.get(Calendar.MONTH);

	        if ((startCalendar.get(Calendar.DATE) == 1)
	                && (temp.get(Calendar.DATE) == 1)) {
	            return year * 12 + month + 1;
	        } else if ((startCalendar.get(Calendar.DATE) != 1)
	                && (temp.get(Calendar.DATE) == 1)) {
	            return year * 12 + month;
	        } else if ((startCalendar.get(Calendar.DATE) == 1)
	                && (temp.get(Calendar.DATE) != 1)) {
	            return year * 12 + month;
	        } else {
	            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
	        }
	}

	                                    /**
     * 返回时间工单串
     * 日期型字符串转化为日期 格式（"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ）
     */
	public static String orderFormatDateYearMonth(String type,String orderId) {
			String dateYYMMDD = getDate("yyyyMMdd");
//			String orderRandom = "";
//			for(int i = 0;i<2;i++){
//				int n = (int)Math.floor(Math.random()*10);
//				orderRandom +=n+"";
//			}
			String temp = "";
			
			int count = orderId.length();
			if(count<6){
				for(int i =0;i<(6-count);i++){
					temp +=0;
				}
				orderId = temp+orderId; 	
			}else{
				orderId = orderId.substring(count-6, count);
			}
			
        StringBuilder sb = new StringBuilder();
        return sb.append(type + dateYYMMDD + orderId).toString();

	}

    /**
     * 月份加减
     *
     * @param datestr
     * @param i
     *            可以是正数或者负数
     * @return
     */
    public static String monthAdd(String datestr, int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar startCalendar = Calendar.getInstance();
        try {
            startCalendar.setTime(sdf.parse(datestr));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        startCalendar.add(Calendar.MONTH, i);
        return sdf.format(startCalendar.getTime());
    }

    
	/**
	 * 得到当前星期字符串 int星期几
     */
	public static int getDayOfWeek(Date date) {
		if(date==null){
			return -1;
		}
		Calendar calendar = Calendar.getInstance();
		boolean isFirstSunday = (calendar.getFirstDayOfWeek() == Calendar.SUNDAY);
		calendar.setTime(date);
		int weekNum = calendar.get(Calendar.DAY_OF_WEEK);
		if(isFirstSunday){
			weekNum = weekNum - 1;
			  if(weekNum == 0){
				  weekNum = 7;
			  }
			}
		return weekNum;
	}
	
	public static Date parseDate(String str,String pattern){
		if(StringUtils.isBlank(str)){
			return null;
		}
		if(StringUtils.isBlank(pattern)){
			pattern="yyyy-MM-dd";
		}
		SimpleDateFormat sdb = new SimpleDateFormat(pattern);
		try {
			Date date = sdb.parse(str);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	 public static int getSecondsToDawn() {
        Calendar curDate = Calendar.getInstance();
        Calendar nextDayDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE)+1, 0, 0, 0);
        return (int)((nextDayDate.getTimeInMillis() - curDate.getTimeInMillis())/1000);
    }
	
}
