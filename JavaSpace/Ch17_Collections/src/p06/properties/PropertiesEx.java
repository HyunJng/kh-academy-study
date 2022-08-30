package p06.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;


//Properties class : Map collection에 속한 class(Map의 특수한 형태)
// -> key, value 모두 String type
// -> Map<String, String>와 동일
// 1. file의 확장자가 properties인 별도 파일로 관리
// 2. file 내에는 [key=value] 형태로 저장
// 3. 사용용도: 프로그램 외부에서 프로그램 내부에 필요한 환경설정 정보를 관리하는 목적
// 	ex) 현재 database.properties의 value는 oracle DBMS 환경 정보를 넣고 있는데
//		mySQL 등 다른 DBMS에 대한 환경정보로 변경할 수 있음
// 		하지만, database.properties의 환경정보만 바뀌면 프로그램 내부에서는 source code 변경 없이
//		Oracle이나 mySQL등 DBMS를 접속하여 사용할 수 있다.
public class PropertiesEx {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String path = PropertiesEx.class.getResource("database.properties").getPath();
		//getPath: 실제 directory를 가져옴
		path = URLDecoder.decode(path, "utf-8");
		System.out.println("path: "+ path);
		properties.load(new FileReader(path));	// path의 파일을 읽어서 힙메모리에 올리라는 뜻
		
		String driver = properties.getProperty("driver"); // driver : key, 
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
	}
}
