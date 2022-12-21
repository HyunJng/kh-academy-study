package p011.coupling.polymorphism;

/*
 * Polymorphism에 의해서 class를 변경할 경우 재코딩 하는 양이 획기적으로 절감.
 * -> 새로운 class로 객체 생성만 해주면 된다.
 * => coupling(결합응집도)가 낮아짐
 * 단점: class를 교체할 때 소스코드를 수정하긴 해야함.
*/
public class TVUser {
	// 삼성 TV, LgTV 를 사용할 수 있다.
	public static void main(String[] args) {
		TV tv;

		//tv = new LgTV(); //promotion
		tv = new SamsungTV();
		tv.powerOn();	// polymorphism
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
