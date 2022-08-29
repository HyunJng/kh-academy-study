package q2.lendable_polymorphism;

public class InterfacePoly {
	public static void main(String[] args) {
		//배열의 다형성을 다룰 것
		Lendable[] arr = {
				new SeperateVolume("푸코의 진자"),
				new SeperateVolume("서양의 미술사"),
				new SeperateVolume("Spring3.0")
		};
		checkoutAll(arr, "김내리", "20140709");
	}
	
	// 메서드 사용(interface 파라미터 사용)
	public static void checkoutAll(Lendable[] arr, String borrower, String date) {
		for(int i = 0; i<arr.length; i++) {
			arr[i].checkOut(borrower, date);
		}
	}
}
