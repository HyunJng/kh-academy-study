package p04.system_class;


public class GetPropertyEx {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getenv("user.home");
		
		System.out.println("운영체계 이름: "+ osName);
		System.out.println("사용자 이름: "+ userName);
		System.out.println("사용자 홈디렉토리: "+ userHome);
		
	}
}
