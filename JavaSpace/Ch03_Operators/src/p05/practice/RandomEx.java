package p05.practice;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		
		// 1.long System.currentTimeMillis()이용
		long currentTimeMillise = System.currentTimeMillis();
		int num1 = (int)(currentTimeMillise % 10 + 1);
		
		// 2. Random 클래스 이용
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis());	// seed값 설정 가능
		int randomInt2 = rd.nextInt();
		int randomInt1 = rd.nextInt(10);	// 0 ~ 매개변수까지의 난수
		double randomDouble = rd.nextDouble();
		boolean randomBoolean = rd.nextBoolean();
		double Guassian = rd.nextGaussian();

		// 3. Math 클래스 이용
		System.out.println(Math.random()
				);
		int r = (int)(Math.random() * 10 % 10);
		System.out.println(r);
		
		
	}
}
