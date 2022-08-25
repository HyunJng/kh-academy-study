package p13.time_class;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar nowCalendar = Calendar.getInstance();
		int year = nowCalendar.get(Calendar.YEAR);
		int month = nowCalendar.get(Calendar.MONTH);
		int day = nowCalendar.get(Calendar.DATE);
		int week = nowCalendar.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		
		switch (week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.FRIDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
//		case Calendar.FRIDAY:
//			strWeek = "금";			
//			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		case Calendar.SUNDAY:
			strWeek = "일";
			break;
		}
		
		System.out.println(year + "년 " + month + "월 " + day + "일 " + strWeek + "요일");
		
		int hour = nowCalendar.get(Calendar.HOUR);
		int minute = nowCalendar.get(Calendar.MINUTE);
		int second = nowCalendar.get(Calendar.SECOND);
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
	}
}
