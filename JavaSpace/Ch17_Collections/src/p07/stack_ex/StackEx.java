package p07.stack_ex;

import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		for(Coin coin : coinBox) {	// 단순 조회
			System.out.println("꺼내온 동전: "+ coin.getValue() + "원");
		}
		
		System.out.println();
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전: "+ coin.getValue() + "원");
		}
		
	}
}
