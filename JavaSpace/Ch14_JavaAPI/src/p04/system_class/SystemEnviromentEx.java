package p04.system_class;


// System.getenv : PC의 시스템 환경에 설정된 값들을 읽어오는 메서드
public class SystemEnviromentEx {
	public static void main(String[] args) {
		String javaHome = System.getenv("JAVA_HOME");
		
		System.out.println("JAVA_HOME : "+ javaHome);
	}
}
