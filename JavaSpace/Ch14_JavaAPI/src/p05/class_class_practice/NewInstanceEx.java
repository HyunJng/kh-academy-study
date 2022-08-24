package p05.class_class_practice;

// Class class 의 newInstance() 메서드
// 1. 힙메모리에 인스턴스를 만드려면 new를 사용하는 것이 원칙이나, newInstance() 메서드를 사용해도 힙메모리에 인스턴스 생성 가능
//	 - new SendsAction();
// 2. new를 사용한 것과 newInstance() method 사용한 것의 차이점
//	 - new			 : source코드에서 instance를 만들 class가 이미 결정
//	 - newInstance() : 프로그램 내부에서 동적으로(가변적으로) 인스턴스를 만들 class를 변경 가능
//					 -> 소비자의 행동에 따라 다루는 class나 instance를 바꾸면서 작동하도록 만들 수 있다.(send버튼, recv버튼) 
//					 -> Spring framework(매우 큰 library)
// 3. newInstance() method사용하면서 처리해야하는 Exception
//	 1) InstantiationException : abstract class 이거나 interface인 경우 Exception 
//	 2) IllegalAccessException : 만드려는 class가 private constructor 등 접근이 불가능한 경우 Exception
public class NewInstanceEx {
	
	public static void main(String[] args) {
		Action action;
		String sendName = "p05.class_class_practice.SendAction";
		String recvName = "p05.class_class_practice.RecieveAction";
		String name;
		
		try {
//			name = sendName;
			name = recvName;
			Class cls = Class.forName(name);
			action = (Action) cls.newInstance();	// action = new ReceiveAction();	
			action.execute();
		} catch (ClassNotFoundException e) {
			System.out.println("해당하는 class이르믕ㄹ 찾을 수가 없습니다.");
		} catch (InstantiationException e) {// compile - time exception
			System.out.println("new 인스턴스 만드는 것이 실패하였습니다.");
		} catch (IllegalAccessException e) {
			System.out.println("new 인스턴스 생성할 수 없습니다.");
		}
		
	}
}
