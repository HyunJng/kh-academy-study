package USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;



public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String INSERT_USER = "insert into UserInfo(seq,id,name,password,email,tel,adr,role) values( (SELECT NVL(MAX(seq), 0) + 1 FROM UserInfo),?,?,?,?,?,?,?)";
	private final String USER_GET = "select * from UserInfo where id = ? and password = ?";
	private final String USER_GETID = "select * from UserInfo where id = ?";
	private final String UPDATE_USER = "update userinfo set password = ?, email = ? , tel = ?, adr = ? where id = ?";
public String existUserId(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GETID);
			stmt.setString(1, vo.getId());
			System.out.println("error1");
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("ID");
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return null;
	}
	
	public void insertUser(UserVO vo) {
		System.out.println("---> JDBC insertBoard() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_USER);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getPassword());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getTel());
			stmt.setString(6, vo.getAdr());
			stmt.setString(7, vo.getRole());
			System.out.println("error1");
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertUser error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateUser(UserVO vo) {
		System.out.println("---> JDBC updateUser() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_USER);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getTel());
			stmt.setString(4, vo.getAdr());
			stmt.setString(5, vo.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateUser error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		System.out.println("---> JDBC getUser() start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setTel(rs.getString("TEL"));
				user.setAdr(rs.getString("ADR"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return user;
	}
	
	public UserVO getUserInfo(UserVO vo) {
		UserVO user = null;
		
		System.out.println("---> JDBC getUserInfo() start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GETID);
			stmt.setString(1, vo.getId());
			
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setTel(rs.getString("TEL"));
				user.setAdr(rs.getString("ADR"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			System.out.println("getUserInfo error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return user;
	}
	
	  public int getNext() { // 다음 글 가지고 오기.
		  conn = JDBCUtil.getConnection();
		  	String SQL = "SELECT seq FROM UserInfo ORDER BY seq DESC";
		  	try {
		  		PreparedStatement pstmt = conn.prepareStatement(SQL);
		  		rs = pstmt.executeQuery();
		  		if (rs.next()) {
		  			return rs.getInt(1) + 1;
		  		}
		  		return 1; // 첫 번째 게시물인 경우
		  	} catch(Exception e) {
		  		e.printStackTrace();
		  	}
		  	return -1; // 데이터베이스 오류
		  }
}
