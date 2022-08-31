package lamda;

import java.util.*;
import java.util.function.*;
/*미완 ... 사용할 일이 없을 것 같아서*/
public class LambdaEx6 {
	public static void main(String[] args) {
		//AFunction타입이므로 입력은 Int, 출력은 generic타입
		IntSupplier s = () -> (int)(Math.random() * 100) + 1;
		IntConsumer c = i -> System.out.print(i + ", ");
		IntPredicate p = i -> i % 2 ==0;
		IntUnaryOperator op = i -> i/10 * 10;
		
		
	}
	
}
	