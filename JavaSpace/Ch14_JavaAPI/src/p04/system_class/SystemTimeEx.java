package p04.system_class;

// System.nanoTime()
// - 현재 시간을 nano(10**-9) second 단위로 환산한 정수값
// - 1970년 1월 1일 0시 0분 0초 기준으로 계산된 정수값
// - 사용 용도: 프러그램의 소요시간 측정

// System.currentTimeMillies()
// - 현재시간을 mili second 단위로 환산한 정수값
public class SystemTimeEx {
	public static void main(String[] args) {
		long startTime1 = System.nanoTime();
		long startTime2 = System.currentTimeMillis();
		
		int sum = 0;
		
		for(int i = 0; i <1000000; i++)
			sum += i;
		
		long endTime1 = System.nanoTime();
		long endTime2 = System.currentTimeMillis();
		
		System.out.println("sum = " + sum);
		System.out.println("sum(1,1000000)의 소요시간 : "+ (endTime1 - startTime1) + " ns");
		System.out.println("sum(1,1000000)의 소요시간 : "+ (endTime2 - startTime2) + " ms");
	}
}
