package p01_dbquery_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// DB 연결하여 사용하는 coding 순서. - mysql과 다름(mysql jdbc라고 검색)
// 1. Class.forName("") => oracle jdbc driver이 존재하는지 확인. (driver이 사용가능한지 check)
// 2. DriverManager.getConnection(url, userid, pwd)
//	=> DBMS와 자바 코드간의 통신 프로그램 역할을 하는 연결 시킴. (= oracle DBMS와 연결)
// 3. Statement stmt = con.createStatement() 
//	=> SQL문을 실행하기 위해 미리 sql문을 넣을 객체 생성 
// 4. ResultSet rs = stmt.executeQuery(query)
//	=> stmt에 SQL문을 넣어 실행(내부적으로는 Oracle에 SQL명령어를 전송, 오라클에서는 SQL문을 실행하고 결과를 return)
// 5. rs에 있는 행(row)를 읽어 java 코드 내에서 처리(while문에서 rs.next와 rs.getInt등의 메소드를 이용)
public class BookListEx1 {
	Connection con;
	//생성자
	public BookListEx1() { // 프로그램마다 다름
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String pwd = "madang";
		
		try {//파일 찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load failure!");
		}
		
		try {//접속
			System.out.println("before connection");
			// oracle DBMS의 madang 유저와 연결
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			System.out.println("database connection failure");
		}
	}

	private void sqlRun() {
		String query = "SELECT * FROM Book";	// SQL문
		try {
			Statement stmt = con.createStatement();
			// executeQuery : select문 실행
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" BOOK NO\tBOOK NAME\t\tPUBLISHER\tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));	//bookid
				System.out.print("\t" + rs.getString(2));	//bookname
				System.out.print("\t\t" + rs.getString(3));	//publisher
				System.out.print("\t" + rs.getInt(4));	//price
				System.out.println();
			}
			con.close();
		} catch (SQLException e) {
			
		}
		
	}
	
	
	public static void main(String[] args) {
		BookListEx1 so = new BookListEx1();
		
		so.sqlRun();
	}

}
