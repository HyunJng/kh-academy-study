package p05.practice;

public class ShowCurrentFile {

	public static void main(String[] args) {
		long totalMilliSeconds = System.currentTimeMillis();
		System.out.println("totalMilliSeconds = " + totalMilliSeconds);

		long totalSeconds = totalMilliSeconds / 1000;
		System.out.println("totalSeconds = " + totalSeconds);

		long currentSecond = totalSeconds % 60;
		System.out.println("currentSecond = " + currentSecond);

		long totalMinutes = totalSeconds / 60;
		System.out.println("totalMinutes = " + totalMinutes);

		long currentMinute = totalMinutes % 60;
		System.out.println("currentMinute = " + currentMinute);

		long totalHours = totalMinutes / 60;
		System.out.println("totalHours = " + totalHours);

		long currentHour = totalHours % 24;

		System.out.println("표준시 기준 현재 시간은 " + currentHour + "시 " + 
				currentMinute + "분 " + currentSecond + "초 입니다.");
		
	}
}
