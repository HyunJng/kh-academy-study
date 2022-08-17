package p02.enumtype;

import java.util.Calendar;

public class EnumWeek {
	public static void main(String[] args) {
		// Week : enum type
		Week today = null; 				// 같은 package안의 Week(enum type)인식
		
//		today = 3;						 // enum안의 원소가 아니므로 error
		
		
		Calendar cal = Calendar.getInstance(); // 사용만 하고 설명 없었어용
		int week = cal.get(Calendar.DAY_OF_MONTH);
		
		switch(week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNEDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		System.out.println("오늘 요일 : " + today);
		// 딱 이 코드만 써보고 별 다른 설명 없이 끝.(ppt도 안읽음)
		// Tech Study라는 사이트 들어가서 List of String, List of array 들어가서 각자 실습.
		// https://techstudy.org/java/java-program-examples-with-output/
	}
}
