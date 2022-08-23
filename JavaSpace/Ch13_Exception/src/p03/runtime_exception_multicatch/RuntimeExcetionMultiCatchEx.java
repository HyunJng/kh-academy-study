package p03.runtime_exception_multicatch;

// Exception 처리 전체 무넙
// try ~ multi catch ~ finally
// 
public class RuntimeExcetionMultiCatchEx {
	public static void main(String[] args) {

		String data1 = null;
		String data2 = null;

		try {
			data1 = args[0];
			data2 = args[1];

			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			int result = val1 + val2;
			System.out.println(data1 + " + " + data2 + " = " + result);
			Class cls = Class.forName("java.lang.String2");	// compileNoFoundException

		} catch (ArrayIndexOutOfBoundsException e) {	// 덜 넣었을 떄
			System.out.println("실행 매개 변수의 수가 부족합니다.");
			System.out.println("[실행방법]");
			System.out.println("eclipse Run - Run Configuration 메뉴에 들어가서 num1, num2 입력하세요");
		} catch (NumberFormatException e) {	// int로 넣지 않았을 떄
			System.out.println("숫자로 변경할 수 없습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("compile time 관련 Exception 에러 처리");
		} finally {
			System.out.println("숫자 덧셈 연산 처리 프로그램이 종료되었습니다.");
		}

	}
}
