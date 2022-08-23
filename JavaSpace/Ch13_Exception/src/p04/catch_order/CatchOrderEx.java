package p04.catch_order;

/*
 * Exception multi catch 처리 방법
 * 1. catch 순서가 매우 중요
 * 	- catch 에서 최상위 부모 class인 Exception이 맨 처음에 나오면 뒤의 catch문의 Excpeiotn들은 처리가 되지 않는다.
 * 2. 최상위 부모 클래스인 Exception은 multi-catch block 의 맨 마지막에 넣는 것이 원칙
 * 	- 앞 부분에 나타난 특정 Excepiton 클래스들을 처리하고 맨 마지막에 나머지 모든 Exception을 처리
 */
public class CatchOrderEx {
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
			Class cls = Class.forName("java.lang.String2");	

		} 
//		catch(Exception e) {	// Exception class는 모든 RuntimeException, Compile간련 Exception모두의 부모
//			// -> 모든 Exception들이 promotion됨
//		}
		catch (ArrayIndexOutOfBoundsException e) {	// deadCoding
			System.out.println("실행 매개 변수의 수가 부족합니다.");
			System.out.println("[실행방법]");
			System.out.println("eclipse Run - Run Configuration 메뉴에 들어가서 num1, num2 입력하세요");
		} catch (NumberFormatException e) {	// deadCoding
			System.out.println("숫자로 변경할 수 없습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("compile time 관련 Exception 에러 처리");
		} catch(Exception e) {// 최후의 보루
			System.out.println("위에 언급한 Exception 이외의 Exception 이 발생되었습니다.");
		}
		
		finally {
			System.out.println("숫자 덧셈 연산 처리 프로그램이 종료되었습니다.");
		}

	}
}
