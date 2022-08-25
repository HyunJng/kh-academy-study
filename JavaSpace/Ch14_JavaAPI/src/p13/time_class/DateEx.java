package p13.time_class;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date date = new Date();
		
		String strNow = date.toString();
		System.out.println(strNow);
		System.out.println(date);
		
		// yyyy : year 4자리 출력 ...
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = simpleDateFormat.format(date);
		System.out.println(strNow2);
		
	}
}
