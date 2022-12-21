package user.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;
import user.model.UserVO;

// Database Access Object
public class UserDAO {
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	
	private static final String USER_GET = "select * from users where id = ? and password = ?";
	private static final String USER_GETID = "select * from users where id = ?";
	private static final String USER_UPDATE = "update users set name = ?, password = ?, email = ?, tel = ?, role = ? where id = ?";
	private static final String USER_INSERT = "insert into users(name, password, email, tel, role, id) values(?, ?, ?, ?, ?, ?)";
	
	public static void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getTel());
			stmt.setString(5, vo.getLevel());
			stmt.setString(6, vo.getId());
			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("insertUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	public static void updateUserInfo(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getTel());
			stmt.setString(5, vo.getLevel());
			stmt.setString(6, vo.getId());
			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("updateUserInfo error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
	}
	
	public static String existUserId(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GETID);
			stmt.setString(1, vo.getId());
			
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
	
	public static UserVO getUser(UserVO vo) {
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
				user.setName(rs.getString("NAME"));
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setTel(rs.getString("TEL"));
				user.setLevel(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return user;
	}
}
