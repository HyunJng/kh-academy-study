package p03_plsql;
import java.sql.*;

public class PlSqlEx {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","madang","madang");
			 String sql = "{call sel_empno(?, ?, ?, ?)}"; // sel_empno : procedure만들어 둔 것
			 // stored procedure 메모리에 load
			 CallableStatement cs = con.prepareCall(sql);
			 // 첫번째 값 설정
			 cs.setInt(1, 7844);
			 // 2, 3, 4 번째 output parameter 값 설정 
			 cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			 cs.registerOutParameter(3, oracle.jdbc.OracleTypes.INTEGER);
			 cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			 // 실행
			 cs.execute();
			 System.out.println("name : " + cs.getString(2) + 
					 "  sal : " + cs.getInt(3) + "  job : " + 
					 cs.getString(4));
//			 ResultSet rs = (ResultSet)cs.getObject(1);
//			 while(rs.next()) {
//				 System.out.print(rs.getString(1) + "    ");
//	  	         System.out.print(rs.getInt(2) + "    ");
//	             System.out.print(rs.getString(3) + " \n");
//			 }
//			 rs.close();
			 cs.close();
			 con.close();
		 } catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
