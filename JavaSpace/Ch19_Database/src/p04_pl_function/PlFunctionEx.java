package p04_pl_function;
import java.sql.*;
import oracle.jdbc.*;

public class PlFunctionEx {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","madang","madang");
			 String sql = "{? = call cal_bonus(?)}";
			 // stored function 메모리에 load
			 CallableStatement cs = con.prepareCall(sql);
			 // 1, 2번째 parameter에 값 설정
			 cs.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
			 cs.setInt(2, 7369);
			 // 실행
			 cs.execute();
			 System.out.println("bonus = " + cs.getInt(1));
			 cs.close();
			 con.close();
		 } catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
