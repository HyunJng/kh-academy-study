package p01.coupling;

/*
 * 개발자 관점에서 볼 때
 * - 큰 문제 : Samsung TV를 사용하여 코딩하다 LgTV로 변경하여 사용할 경우 재코딩.
 * =>SamsungTV와 LGTV를  TVUser에서 사용할 때, 해당 클래스와 coupling(결합도)가 매우 높음
 * 
*/
public class TVUser {
	// 삼성 TV, LgTV 를 사용할 수 있다.
	public static void main(String[] args) {
		SamsungTV sansybgTV = new SamsungTV();

		LgTV lgTV = new LgTV();
		lgTV.powerOn();
		lgTV.volumeUp();
		lgTV.powerOff();

		sansybgTV.powerOn();
		sansybgTV.volumeUp();
		sansybgTV.powerOff();
	}
}
